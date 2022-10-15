package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReajusteServiceTest {

    private Funcionario funcionario;

    private ReajusteService servicoDeReajuste;

    @BeforeEach
    void setup() {
        funcionario = new Funcionario("Fulano", "12345678910", Cargo.ANALISTA, new BigDecimal("2000.00"));
        servicoDeReajuste = new ReajusteService( this.geraValidacoes() );
    }

    @Test @DisplayName("Deve reajustar o salário com menos de 40%")
    void cenario1() {
        // Recebe uma cópia do salário atual antes da alteração
        BigDecimal salarioAtual = new BigDecimal( funcionario.getSalario().toString() );
        BigDecimal aumento = new BigDecimal("800.00");

        servicoDeReajuste.reajusteSalarioDoFuncionario(funcionario, aumento);

        assertEquals( salarioAtual.add(aumento), funcionario.getSalario());
        assertEquals(LocalDate.now(), funcionario.getDataUltimoReajuste());
    }

    @Test @DisplayName("Deve exibir que reajuste não pode ser superior a 40%")
    void cenario2() {
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

    @Test @DisplayName("Deve reajustar o salário com mais de 6 meses a partir do último reajuste")
    void cenario3() {
        // Recebe uma cópia do salário atual antes da alteração
        funcionario.setDataUltimoReajuste( LocalDate.now().minusMonths(6) );
        LocalDate ultimoReajuste = LocalDate.now().minusMonths(6);
        BigDecimal salarioAtual = new BigDecimal( funcionario.getSalario().toString() );
        BigDecimal aumento = new BigDecimal("800.00");

        try {
            servicoDeReajuste.reajusteSalarioDoFuncionario(funcionario, aumento);
        } catch (ValidacaoException e) {
            fail("Não deve exibir exceção porque o reajuste foi menos depois de 6 meses");
        }

        // Não teve reajuste então os dados do funcionário não podem ter alteração
        assertEquals( salarioAtual.add(aumento), funcionario.getSalario());
        assertEquals( LocalDate.now(), funcionario.getDataUltimoReajuste());
    }

    @Test @DisplayName("Deve exibir que reajuste não pode ser realizado em menos de 6 meses")
    void cenario4() {
        // Recebe uma cópia do salário atual antes da alteração
        funcionario.setDataUltimoReajuste( LocalDate.now().minusMonths(5) );
        LocalDate ultimoReajuste = LocalDate.now().minusMonths(5);
        BigDecimal salarioAtual = new BigDecimal( funcionario.getSalario().toString() );
        BigDecimal aumento = new BigDecimal("800.00");

        try {
            servicoDeReajuste.reajusteSalarioDoFuncionario(funcionario, aumento);
            fail("Não exibiu exceção que o reajuste foi feito em menos de 6 meses");
        } catch (ValidacaoException e) {
            assertEquals(e.getMessage(), "Intervalo entre reajutes o ultimo reajuste o atual deve ser de no mínimo 6 meses");
        }

        // Não teve reajuste então os dados do funcionário não podem ter alteração
        assertEquals( salarioAtual, funcionario.getSalario());
        assertEquals( ultimoReajuste, funcionario.getDataUltimoReajuste());
    }

    private List<ValidacaoReajuste> geraValidacoes() {
        return Arrays.asList(new ValidacaoPercentualReajuste(), new ValidacaoPeriodicidadeEntreReajustes());
    }

}