package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReajusteServiceTest {

    private Funcionario funcionario;

    private ReajusteService servicoDeReajuste;

    @BeforeEach
    void setup() {
        funcionario = new Funcionario("Fulano", "12345678910", Cargo.ANALISTA, new BigDecimal("2000.00"));
        servicoDeReajuste = new ReajusteService();
    }

    @Test @DisplayName("Deve reajustar o salário com sucesso")
    void reajusteSalarioDoFuncionario1() {
        // Recebe uma cópia do salário atual antes da alteração
        BigDecimal salarioAtual = new BigDecimal( funcionario.getSalario().toString() );
        BigDecimal aumento = new BigDecimal("800.00");

        servicoDeReajuste.reajusteSalarioDoFuncionario(funcionario, aumento);

        assertEquals( salarioAtual.add(aumento), funcionario.getSalario());
        assertEquals(LocalDate.now(), funcionario.getDataUltimoReajuste());
    }

    @Test @DisplayName("Deve exibir que reajuste não pode ser superior a 40%")
    void reajusteSalarioDoFuncionario2() {
        // Recebe uma cópia do salário atual antes da alteração
        BigDecimal salarioAtual = new BigDecimal( funcionario.getSalario().toString() );
        // Um centavo a mais do que passaria dos 40%
        BigDecimal aumento = new BigDecimal("800.01");

        try {
            servicoDeReajuste.reajusteSalarioDoFuncionario(funcionario, aumento);
            fail("Não exibiu exceção que o reajuste foi acima de 40%");
        } catch (ValidacaoException e) {
            assertEquals(e.getMessage(), "Reajuste nao pode ser superior a 40% do salario!");
        }

        // Não teve reajuste então os dados do funcionário não podem ter alteração
        assertEquals( salarioAtual, funcionario.getSalario());
        assertNull(funcionario.getDataUltimoReajuste());
    }

}