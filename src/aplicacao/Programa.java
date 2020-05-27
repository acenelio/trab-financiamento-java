package aplicacao;

import java.util.Locale;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		String nome;
		double salario, porcentagemEntrada, valorFinanciado;
		int prestacoes;
		
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
		valorFinanciado = sc.nextDouble();
		
		double prestacao = valorFinanciado * (100.0 - porcentagemEntrada) / 100.0 / prestacoes;
		
		while (prestacao > 0.3 * salario) {
			System.out.print("Capacidade de pagamento excedida! Tente novamente: ");
			valorFinanciado = sc.nextDouble();
			prestacao = valorFinanciado * (100.0 - porcentagemEntrada) / 100.0 / prestacoes;
		}
		
		
		sc.close();
	}
}
