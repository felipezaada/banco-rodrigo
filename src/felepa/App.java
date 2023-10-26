package felepa;

import javax.swing.JOptionPane;

public class App {
	public static void main(String[] args) {

		String valor1;
		String senha;
		int escolha;
		int escolha1;
		double valor;

		ContaCorrente cc = new ContaCorrente("242424", "11", 0);
		ContaPoupanca cp = new ContaPoupanca("101010", "22", 0);

		do {
			String[] opcoes = { "Conta Corrente", "Poupança", "Cancelar" };
			escolha = JOptionPane.showOptionDialog(null, 
					"Escolha qual você quer cadastrar",
					"O que você quer cadastrar?", 
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null,
					opcoes, 
					opcoes[0]);
			if (escolha == 2 || escolha == JOptionPane.CLOSED_OPTION) {
				break;
			} else if (escolha == 0) {
				do {
					senha = JOptionPane.showInputDialog("conta: " + cc.numeroConta + "\nDigite sua senha!");
					if(senha == null) {
						break;
					}
					else if (senha.equals(cc.senha)) {
						String[] opcoes1 = { "Saque", "Depósito", "Saldo", "Cheque Especial", "Cancelar" };
						escolha1 = JOptionPane.showOptionDialog(null, "Qual opcão deseja?", "Escolha",
								JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes1, opcoes1[0]);
						if (escolha1 == 4 || escolha1 == JOptionPane.CLOSED_OPTION) {
							break;
						}
						switch (escolha1) {
						case 0:
							valor1 = JOptionPane.showInputDialog("Digite quanto quer sacar");
							if (valor1 == null || valor1.isEmpty()) {
								break;
							}
							valor = Double.parseDouble(valor1);
							if (valor <= 0 || valor > cc.saldo) {
								JOptionPane.showMessageDialog(null, "Digite um valor maior que 0, menor ou igual seu saldo!", "ERRO!", JOptionPane.INFORMATION_MESSAGE);
								break;
							}
							cc.Sacar(valor);
							JOptionPane.showMessageDialog(null, cc.exibirSaldo(), "Confirmação", JOptionPane.INFORMATION_MESSAGE);
							break;
						case 1:
							valor1 = JOptionPane.showInputDialog("Digite quanto quer depositar");
							if (valor1 == null || valor1.isEmpty()) {
								break;
							}
							valor = Double.parseDouble(valor1);
							if (valor <= 0) {
								JOptionPane.showMessageDialog(null, "Digite um valor maior que 0!", "ERRO!", JOptionPane.INFORMATION_MESSAGE);
								break;
							}
							cc.Depositar(valor);
							JOptionPane.showMessageDialog(null, cc.exibirSaldo(), "Confirmação", JOptionPane.INFORMATION_MESSAGE);
							break;
						case 2:
							JOptionPane.showMessageDialog(null, cc.exibirSaldo(), "Confirmação", JOptionPane.INFORMATION_MESSAGE);
							break;
						case 3:
							valor1 = JOptionPane.showInputDialog("Digite quanto quer tirar de cheque especial");
							if (valor1 == null || valor1.isEmpty()) {
								break;
							}
							valor = Double.parseDouble(valor1);
							if (valor <= 0 || valor <= cc.saldo) {
								JOptionPane.showMessageDialog(null, "Você não precisa de cheque especial, " + cc.exibirSaldo(), "ERRO!", JOptionPane.INFORMATION_MESSAGE);
								break;
							}
							cc.usarChequeEspecial(valor);
							JOptionPane.showMessageDialog(null, cc.exibirSaldo(), "Confirmação", JOptionPane.INFORMATION_MESSAGE);
							break;
						}
					} else {
						JOptionPane.showMessageDialog(null, "SENHA INCORRETA!", "ERRO!", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
				} while (escolha1 != JOptionPane.CLOSED_OPTION && escolha1 != 4);
			} else if (escolha == 1) {
				do {
					senha = JOptionPane.showInputDialog("conta: " + cp.numeroConta + "\nDigite sua senha!");
					if(senha == null) {
						break;
					}
					else if(senha.equals(cp.senha)) {
						String[] opcoes1 = { "Saque", "Depósito", "Saldo", "Rendimento", "Cancelar" };
						escolha1 = JOptionPane.showOptionDialog(null, 
								"Qual opcão deseja?", 
								"Escolha",
								JOptionPane.DEFAULT_OPTION, 
								JOptionPane.QUESTION_MESSAGE, 
								null, 
								opcoes1, 
								opcoes1[0]);
						if (escolha1 == 4 || escolha1 == JOptionPane.CLOSED_OPTION) {
							break;
						}
						switch (escolha1) {
						case 0:
							valor1 = JOptionPane.showInputDialog("Digite quanto quer sacar");
							if (valor1 == null || valor1.isEmpty()) {
								break;
							}
							valor = Double.parseDouble(valor1);
							if (valor <= 0 || valor > cp.saldo) {
								JOptionPane.showMessageDialog(null, "Digite um valor maior que 0, menor ou igual seu saldo!", "ERRO!", JOptionPane.INFORMATION_MESSAGE);
								break;
							}
							cp.Sacar(valor);
							JOptionPane.showMessageDialog(null, cp.exibirSaldo(), "Confirmação", JOptionPane.INFORMATION_MESSAGE);
							break;
						case 1:
							valor1 = JOptionPane.showInputDialog("Digite quanto quer depositar");
							if (valor1 == null || valor1.isEmpty()) {
								break;
							}
							valor = Double.parseDouble(valor1);
							if (valor <= 0) {
								JOptionPane.showMessageDialog(null, "Digite um valor maior que 0!", "ERRO!", JOptionPane.INFORMATION_MESSAGE);
								break;
							}
							cp.Depositar(valor);
							JOptionPane.showMessageDialog(null, cp.exibirSaldo(), "Confirmação", JOptionPane.INFORMATION_MESSAGE);
							break;
						case 2:
							JOptionPane.showMessageDialog(null, cp.exibirSaldo(), "Confirmação", JOptionPane.INFORMATION_MESSAGE);
							break;
						case 3:
							cp.calcularRendimento();
							JOptionPane.showMessageDialog(null, cp.imRendimento(), "Confirmação", JOptionPane.INFORMATION_MESSAGE);
							break;
						}
					} else {
						JOptionPane.showMessageDialog(null, "SENHA INCORRETA!", "ERRO!", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
				} while (escolha1 != JOptionPane.CLOSED_OPTION && escolha1 != 4);
			}
		} while (escolha != JOptionPane.CLOSED_OPTION && escolha != 2);

	}
}