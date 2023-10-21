package felepa;

import javax.swing.JOptionPane;

public class App {
	public static void main(String[] args) {
		
	String valor1;
	int escolha;
	int escolha1;
	double valor;
	
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
	if(escolha == 2 || escolha == JOptionPane.CLOSED_OPTION) {
		break;
	}else if(escolha == 0){
		ContaCorrente cc = new ContaCorrente("242424", 100);
		do {
			String[] opcoes1 = { "Saque", "Deposito", "Saldo", "Cheque Especial", "Cancelar" };
			escolha1 = JOptionPane.showOptionDialog(null,
					"Qual opcão deseja?",
					"Escolha",
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					opcoes1,
					opcoes1[0]);
			if(escolha1 == 4 || escolha1 == JOptionPane.CLOSED_OPTION) {
				break;
			}
				switch(escolha1) {
					case 0:
						valor1 = JOptionPane.showInputDialog("Digite quanto quer sacar");
						valor = Double.parseDouble(valor1);
						while(valor <= 0 || valor > cc.saldo) {
							valor1 = JOptionPane.showInputDialog("DIGITE UM VALOR MAIOR QUE 0 E MENOR QUE SEU SALDO!");
							valor = Double.parseDouble(valor1);
						}
						cc.Sacar(valor);
						JOptionPane.showMessageDialog(null, cc.exibirSaldo(), "Confirmação", JOptionPane.INFORMATION_MESSAGE);
						break;
					case 1:
						valor1 = JOptionPane.showInputDialog("Digite quanto quer depositar");
						valor = Double.parseDouble(valor1);
						while(valor <= 0) {
							valor1 = JOptionPane.showInputDialog("DIGITE UM VALOR MAIOR QUE 0!");
							valor = Double.parseDouble(valor1);
						}
						cc.Depositar(valor);
						JOptionPane.showMessageDialog(null, cc.exibirSaldo(), "Confirmação", JOptionPane.INFORMATION_MESSAGE);
						break;
					case 2:
						JOptionPane.showMessageDialog(null, cc.exibirSaldo(), "Confirmação", JOptionPane.INFORMATION_MESSAGE);
						break;
					case 3:
						valor1 = JOptionPane.showInputDialog("Digite quanto quer tirar de cheque especial");
						valor = Double.parseDouble(valor1);
						while(valor <= 0 || valor <= cc.saldo) {
							JOptionPane.showMessageDialog(null, cc.exibirSaldo(), "VOCÊ NÃO PRECISA DE CHEQUE ESPECIAL ", JOptionPane.INFORMATION_MESSAGE);
							valor1 = JOptionPane.showInputDialog(null, "TENTE NOVAMENTE, DIGITE UM VALOR MAIOR QUE SEU SALDO!");
							valor = Double.parseDouble(valor1);
						}
						cc.usarChequeEspecial(valor);
						JOptionPane.showMessageDialog(null, cc.exibirSaldo(), "Confirmação", JOptionPane.INFORMATION_MESSAGE);
						break;	
				}
			}while(escolha1 != JOptionPane.CLOSED_OPTION && escolha1 != 4);
		}else if(escolha == 1) {
			ContaPoupanca cp = new ContaPoupanca("101010", 200);
			do {
				String[] opcoes1 = { "Saque", "Deposito", "Saldo", "Rendimento", "Cancelar" };
				escolha1 = JOptionPane.showOptionDialog(null,
						"Qual opcão deseja?",
						"Escolha",
						JOptionPane.DEFAULT_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						opcoes1,
						opcoes1[0]);
				if(escolha1 == 4 || escolha1 == JOptionPane.CLOSED_OPTION) {
					break;
				}
					switch(escolha1) {
						case 0:
							valor1 = JOptionPane.showInputDialog("Digite quanto quer sacar");
							valor = Double.parseDouble(valor1);
							while(valor <= 0 || valor > cp.saldo) {
								valor1 = JOptionPane.showInputDialog("DIGITE UM VALOR MAIOR QUE 0 E MENOR QUE SEU SALDO!");
								valor = Double.parseDouble(valor1);
							}
							cp.Sacar(valor);
							JOptionPane.showMessageDialog(null, cp.exibirSaldo(), "Confirmação", JOptionPane.INFORMATION_MESSAGE);
							break;
						case 1:
							valor1 = JOptionPane.showInputDialog("Digite quanto quer depositar");
							valor = Double.parseDouble(valor1);
							while(valor <= 0) {
								valor1 = JOptionPane.showInputDialog("DIGITE UM VALOR MAIOR QUE 0!");
								valor = Double.parseDouble(valor1);
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
				}while(escolha1 != JOptionPane.CLOSED_OPTION && escolha1 != 4);
		}
	}while(escolha != JOptionPane.CLOSED_OPTION && escolha != 2);

	}	
}