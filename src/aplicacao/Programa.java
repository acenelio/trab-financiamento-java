package aplicacao;

import java.util.Locale;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		String nome;
		double salario, porcentagemEntrada, totalFinanciado;
		int prestacoes, opcao;

		System.out.println("DIGITE OS DADOS DO FINANCIAMENTO");
		System.out.print("Nome do cliente: ");
		nome = sc.nextLine();
		System.out.print("Salario: ");
		salario = sc.nextDouble();

		while (salario < 0) {
			System.out.print("O salario nao pode ser negativo. Tente novamente: ");
			salario = sc.nextDouble();
		}

		System.out.print("Numero de prestacoes: ");
		prestacoes = sc.nextInt();
		System.out.print("Porcentagem de entrada: ");
		porcentagemEntrada = sc.nextDouble();
		System.out.print("Valor total financiado: ");
		totalFinanciado = sc.nextDouble();

		double prestacao = totalFinanciado * (100.0 - porcentagemEntrada) / 100.0 / prestacoes;

		while (prestacao > 0.3 * salario) {
			System.out.print("Capacidade de pagamento excedida! Tente novamente: ");
			totalFinanciado = sc.nextDouble();
			prestacao = totalFinanciado * (100.0 - porcentagemEntrada) / 100.0 / prestacoes;
		}

		double entrada = totalFinanciado * porcentagemEntrada / 100.0;
		double valorFinanciadoPrazo = totalFinanciado - entrada;
		
		do {
			System.out.println();
			System.out.println("MENU:");
			System.out.println("1 - Mostrar valor da entrada");
			System.out.println("2 - Mostrar o valor financiado");
			System.out.println("3 - Mostrar valor de cada prestação");
			System.out.println("4 - Sair");
			System.out.print("Digite uma opcao: ");
			opcao = sc.nextInt();
			System.out.println();
			
			if (opcao == 1) {
				System.out.printf("ENTRADA = R$ %.2f%n", entrada);
			}
			else if (opcao == 2) {
				System.out.printf("VALOR FINANCIADO = R$ %.2f%n", valorFinanciadoPrazo);
			}
			else if (opcao == 3) {
				System.out.printf("VALOR DE CADA PRESTACAO = R$ %.2f%n", prestacao);
			}
			else if (opcao != 4) {
				System.out.println("OPÇÃO INVÁLIDA!");
			}
			
		} while (opcao != 4);
		
		System.out.println("FIM DO PROGRAMA!");

		sc.close();
	}
}
