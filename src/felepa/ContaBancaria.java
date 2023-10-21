package felepa;

public class ContaBancaria {
	
	String numeroConta;
	String resposta;
	double saldo;
	
	public ContaBancaria (String numeroConta, double saldo) {
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}
	
	public double Sacar(double valor) {
		if(valor <= 0.0 || valor > saldo) {
			return saldo;
		}else {
			this.saldo = this.saldo - valor;
			return saldo;
		}
	}
	
	public double Depositar(double valor) {
		if(valor <= 0.0) {
			return saldo;
		}else {
			this.saldo = this.saldo + valor;
			return saldo;
		}
	}
	
	public String exibirSaldo() {
		return "seu saldo é de: " + saldo;
	}
	
}
