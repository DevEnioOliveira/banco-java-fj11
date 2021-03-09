package br.com.caelum.contas.modelo;

import br.com.caelum.contas.exceptions.SaldoInsuficienteException;

public abstract class Conta implements Comparable<Conta>{

    private String titular;
    private int numero;
    private String agencia;
    private String dataAbertura;
    protected double saldo;

    public Conta() {

    }


    public Conta(String titular, int numero, String agencia, double saldo) {
        this.setTitular(titular);
        this.setNumero(numero);
        this.setAgencia(agencia);
        this.setSaldo(saldo);
    }

    public String getTitular() {
        return this.titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getDataAbertura() {
        return this.dataAbertura;
    }

    private void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double calculaRendimento() {
        return this.getSaldo() * 0.01;
    }

    public void deposita(double valor) {
        if(valor <= 0) {
            throw  new IllegalArgumentException("Não foi possível depositar! Valores Negativos não são permitidos");
        } else {
            this.saldo += valor;
        }
    }

    public void saca(double valor) {
        if(valor > this.getSaldo()){
            throw new SaldoInsuficienteException("Saldo insuficiente");
        } else {
            this.saldo -= valor;
        }

    }

    public void transfere(double valor, Conta conta) {
        this.saca(valor);
        conta.deposita(valor);
    }

    public String recuperaDadosParaImpressao() {
        String dados = "\nTITULAR: " + this.getTitular();
        dados += "\nNÚMERO: " + this.getNumero();
        dados += "\nAGÊNCIA: " + this.getAgencia();
//        dados += "\nDATA DE ABERTURA: " + this.getDataAbertura();
        dados += "\nSALDO DISPONÍVEL: R$ " + this.getSaldo();
        dados += "\nTIPO: " + this.getTipo();
        return dados;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return "[titular=" + titular.toUpperCase() + ", numero=" + numero + ", agencia=" + agencia + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        Conta outraConta = (Conta) obj;
        return this.numero == outraConta.numero && this.agencia.equals(outraConta.agencia);
    }

    @Override
    public int compareTo(Conta outraConta) {
        return this.titular.compareTo(outraConta.titular);
    }
}
