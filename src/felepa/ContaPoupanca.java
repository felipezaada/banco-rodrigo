package felepa;

public class ContaPoupanca extends ContaBancaria {
	
	double taxaRendimento = 0.10;
	double saldoRendimento = 0.0;
	
	public ContaPoupanca(String numeroConta, double saldo) {
		super(numeroConta, saldo);
	}
	
	public double calcularRendimento() {
		if(saldo <= 0.0) {
			return saldoRendimento;
		}else {
			saldoRendimento = saldo * this.taxaRendimento;
			return saldoRendimento;
		}
	}
	
	public String imRendimento() {
		return "Em 1 mês " + saldo + " vai render: " + saldoRendimento;
	}
	
}
