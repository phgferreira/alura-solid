package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodicidadeEntreReajustes implements  ValidacaoReajuste {

    public void validar(Funcionario funcionario, BigDecimal aumento) {
        // Se for a primeira vez que o funcionário recebe um reajuste então não executa essa validação
        if (funcionario.getDataUltimoReajuste() == null) {
            return;
        }

        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long mesesDesdeUltimoReajutes = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
        if (mesesDesdeUltimoReajutes < 6) {
            throw new ValidacaoException("Intervalo entre reajutes o ultimo reajuste o atual deve ser de no mínimo 6 meses");
        }
    }
}
