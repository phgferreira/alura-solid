package br.com.alura.rh.service.reajuste;

import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteService {

    private List<ValidacaoReajuste> validacoes;

    public ReajusteService(List<ValidacaoReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    public void reajusteSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
        // Executa todas as validações necessárias
        this.validacoes.forEach(validacao -> validacao.validar(funcionario, aumento));

        BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
        funcionario.atualizaSalario(salarioReajustado);
    }

}
