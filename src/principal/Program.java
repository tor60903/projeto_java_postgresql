package principal;

import java.util.Scanner;

import controllers.PessoaController;

public class Program {

	public static void main(String[] args) {

		try {

			Scanner Scanner = new Scanner(System.in);

			System.out.println("(1) Cadastro de pessoas");
			System.out.println("(2) Atualização de pessoas");
			System.out.println("(3) Exclusão de pessoas");
			System.out.println("(4) Consulta de pessoas");

			System.out.print("\nInforme a opção desejada: ");
			Integer opcao = Integer.parseInt(Scanner.nextLine());

			PessoaController pessoaController = new PessoaController();

			switch (opcao) {

			case 1:
				pessoaController.cadastrarPessoa();
				break;

			case 2:
				pessoaController.atualizarPessoa();
				break;

			case 3:
				pessoaController.excluirPessoa();
				break;

			case 4:
				pessoaController.consultarPessoas();
				break;

			default:
				System.out.println("\nOpção inválida!");
				break;
			}
		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}

	}

}
