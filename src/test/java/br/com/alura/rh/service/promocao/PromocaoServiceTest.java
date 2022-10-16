package br.com.alura.rh.service.promocao;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PromocaoServiceTest {

    @Test @DisplayName("Deve promover de Assistente para Analista com sucesso")
    void cenario1() {
        Funcionario funcionario = new Funcionario("Fulano de Tal", "12345678910", Cargo.ASSISTENTE, new BigDecimal("1500.00"));

        PromocaoService servicoPromocao = new PromocaoService();
        servicoPromocao.promover(funcionario,true);

        assertEquals(Cargo.ANALISTA, funcionario.getCargo());
        // Intuitivamente também deveríamos verificar se houve aumento de salário mas como não faz parte do código no momento então não vou validar isso
    }

    @Test @DisplayName("Deve promover de Analista para Especialista com sucesso")
    void cenario2() {
        Funcionario funcionario = new Funcionario("Fulano de Tal", "12345678910", Cargo.ANALISTA, new BigDecimal("2500.00"));

        PromocaoService servicoPromocao = new PromocaoService();
        servicoPromocao.promover(funcionario,true);

        assertEquals(Cargo.ESPECIALISTA, funcionario.getCargo());
        // Intuitivamente também deveríamos verificar se houve aumento de salário mas como não faz parte do código no momento então não vou validar isso
    }

    @Test @DisplayName("Deve promover de Especialista para Gerente com sucesso")
    void cenario3() {
        Funcionario funcionario = new Funcionario("Fulano de Tal", "12345678910", Cargo.ESPECIALISTA, new BigDecimal("3500.00"));

        PromocaoService servicoPromocao = new PromocaoService();
        servicoPromocao.promover(funcionario,true);

        assertEquals(Cargo.GERENTE, funcionario.getCargo());
        // Intuitivamente também deveríamos verificar se houve aumento de salário mas como não faz parte do código no momento então não vou validar isso
    }

    @Test @DisplayName("Deve exibir que Gerentes não podem ser promovidos")
    void cenario4() {
        Funcionario funcionario = new Funcionario("Fulano de Tal", "12345678910", Cargo.GERENTE, new BigDecimal("5000.00"));

        PromocaoService servicoPromocao = new PromocaoService();
        try {
            servicoPromocao.promover(funcionario, true);
            fail("Não exibiu mensagem de que Gerentes não podem ser promovidos");
        } catch (ValidacaoException e) {
            assertEquals("Gerentes não podem ser promovidos", e.getMessage());
        }

        // O funcionário Gerente precisa continuar sendo Gerente
        assertEquals(Cargo.GERENTE, funcionario.getCargo());
    }

    @Test @DisplayName("Deve exibir que Assistente não pode ser promovido porque não atingiu a meta")
    void cenario5() {
        Funcionario funcionario = new Funcionario("Fulano de Tal", "12345678910", Cargo.ASSISTENTE, new BigDecimal("1500.00"));

        PromocaoService servicoPromocao = new PromocaoService();
        try {
            servicoPromocao.promover(funcionario, false);
            fail("Não exibiu mensagem Assistente não pode ser promovido porque não atingiu a meta");
        } catch (ValidacaoException e) {
            assertEquals("Funcionário não bateu a meta", e.getMessage());
        }

        // Como a meta não foi atingida então a promoção não deve ocorrer e o cargo permanece o mesmo
        assertEquals(Cargo.ASSISTENTE, funcionario.getCargo());
    }

    @Test @DisplayName("Deve exibir que Analista não pode ser promovido porque não atingiu a meta")
    void cenario6() {
        Funcionario funcionario = new Funcionario("Fulano de Tal", "12345678910", Cargo.ANALISTA, new BigDecimal("2500.00"));

        PromocaoService servicoPromocao = new PromocaoService();
        try {
            servicoPromocao.promover(funcionario, false);
            fail("Não exibiu mensagem Analista não pode ser promovido porque não atingiu a meta");
        } catch (ValidacaoException e) {
            assertEquals("Funcionário não bateu a meta", e.getMessage());
        }

        // Como a meta não foi atingida então a promoção não deve ocorrer e o cargo permanece o mesmo
        assertEquals(Cargo.ANALISTA, funcionario.getCargo());
    }

    @Test @DisplayName("Deve exibir que Especialista não pode ser promovido porque não atingiu a meta")
    void cenario7() {
        Funcionario funcionario = new Funcionario("Fulano de Tal", "12345678910", Cargo.ESPECIALISTA, new BigDecimal("3500.00"));

        PromocaoService servicoPromocao = new PromocaoService();
        try {
            servicoPromocao.promover(funcionario, false);
            fail("Não exibiu mensagem Especialista não pode ser promovido porque não atingiu a meta");
        } catch (ValidacaoException e) {
            assertEquals("Funcionário não bateu a meta", e.getMessage());
        }

        // Como a meta não foi atingida então a promoção não deve ocorrer e o cargo permanece o mesmo
        assertEquals(Cargo.ESPECIALISTA, funcionario.getCargo());
    }

    @Test @DisplayName("Indepentende da meta deve exibir primeiro que Gerentes não podem ser promovidos")
    void cenario8() {
        Funcionario funcionario = new Funcionario("Fulano de Tal", "12345678910", Cargo.GERENTE, new BigDecimal("5000.00"));

        PromocaoService servicoPromocao = new PromocaoService();
        try {
            servicoPromocao.promover(funcionario, false);
            fail("Não exibiu primeito a mensagem de que Gerentes não podem ser promovidos");
        } catch (ValidacaoException e) {
            assertEquals("Gerentes não podem ser promovidos", e.getMessage());
        }

        // O funcionário Gerente precisa continuar sendo Gerente
        assertEquals(Cargo.GERENTE, funcionario.getCargo());
    }

}