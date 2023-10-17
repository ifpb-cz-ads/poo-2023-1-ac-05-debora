package model;

import java.time.LocalDate;

public class ContaCorrente extends Conta{

    private double taxaManutencao;

    public ContaCorrente(int agencia, int numero, double saldo, LocalDate dataAbertura, Cliente cliente, double taxaManutencao) {
        super(agencia, numero, saldo, dataAbertura, cliente);
        this.taxaManutencao = taxaManutencao;
    }

    @Override
    public boolean sacar(double valor){
        if(valor <= saldo+getCliente().getLimiteCredito()){
            setSaldo(getSaldo() - valor);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void transferir(Conta contaparaDeposito, double valor) {
        if (valor > 0 && valor <= saldo+getCliente().getLimiteCredito()) {
            setSaldo(getSaldo() - valor);
            contaparaDeposito.saldo = contaparaDeposito.getSaldo() + valor;
            System.out.println("TRANSFERÊNCIA REALIZADA");
        } else {
            System.out.println("NAO FOI POSSÍVEL TRANSFERIR");
        }
    }


    public boolean aplicarTaxa(){
        saldo -= taxaManutencao;
        return true;
    }

    public double getTaxaManutencao() {
        return taxaManutencao;
    }

    public void setTaxaManutencao(double taxaManutencao) {
        this.taxaManutencao = taxaManutencao;
    }
}