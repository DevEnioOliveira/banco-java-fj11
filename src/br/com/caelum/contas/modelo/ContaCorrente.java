package br.com.caelum.contas.modelo;

import br.com.caelum.contas.exceptions.SaldoInsuficienteException;

public class ContaCorrente extends Conta implements Tributavel{

    @Override
    public void saca(double valor) {
        if(valor <= 0) {
            throw new IllegalArgumentException("NÃO FOI POSSÍVEL SACAR! VALORES NEGATIVOS OU 0 NÃO SÃO PERMITIDOS");
        }

        if(this.saldo < valor) {
            throw new SaldoInsuficienteException(valor);
        }

        this.saldo -= (valor + 0.10);
    }

    @Override
    public String getTipo() {
        return "Conta Corrente";
    }

    @Override
    public double getValorImposto() {
        return this.getSaldo() + 0.01;
    }


}
