package felepa;

public class ContaCorrente extends ContaBancaria {
	
	double chequeEspecial;

	public ContaCorrente(String numeroConta, double saldo) {
		super(numeroConta, saldo);
	}
	
	public double usarChequeEspecial(double valor) {
		saldo = saldo - valor;
		return saldo;
	}
	
	public String imUsarChequeEspecial() {
		if(saldo < 0.0 || saldo == 0.0) {
			return "você fez um saque, saldo atual " + saldo;
		}else {
			return "você fez um cheque especial no valor de: " + saldo;
		}
	}
}
