package br.com.caelum.contas.exceptions;

public class SaldoInsuficienteException extends RuntimeException{

    public SaldoInsuficienteException(String message) {
        super(message);
    }

    public SaldoInsuficienteException(double valor) {
        super("SALDO INSUFICIENTE PARA SACAR O VALOR DE: " + valor);
    }
}
