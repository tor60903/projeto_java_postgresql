package controllers;

import java.util.List;
import java.util.Scanner;

import entities.Pessoa;
import repositories.PessoaRepository;

public class PessoaController {

	//atributo
	private Scanner scanner = new Scanner(System.in);
	
	public void cadastrarPessoa() {
		
		try {
			
			System.out.println("\nCADASTRO DE PESSOA:\n");
			
			Pessoa pessoa = new Pessoa();
			
			System.out.print("Informe o nome da pessoa.........: ");
			pessoa.setNome(scanner.nextLine());
			
			System.out.print("Informe o email da pessoa........: ");
			pessoa.setEmail(scanner.nextLine());
			
			System.out.print("Informe o cpf da pessoa..........: ");
			pessoa.setCpf(scanner.nextLine());
			
			PessoaRepository pessoaRepository = new PessoaRepository();
			pessoaRepository.create(pessoa);
			
			System.out.println("\nPessoa cadastrado com sucesso!");
		}
		catch (Exception e) {
			System.out.println("\nFalha ao cadastrar pessoa: " + e.getMessage());
		}		
	}

	public void atualizarPessoa() {

		try {
		
			System.out.println("\nATUALIZAÇÃO DE PESSOA:\n");
			
			System.out.print("Informe o id da pessoa...........: ");
			Integer idPessoa = Integer.parseInt(scanner.nextLine());
			
			PessoaRepository pessoaRepository = new PessoaRepository();
			Pessoa pessoa = pessoaRepository.findById(idPessoa);
			
			if(pessoa != null) {
				
				System.out.print("Altere o nome da pessoa..........: ");
				pessoa.setNome(scanner.nextLine());
				
				System.out.print("Altere o email da pessoa.........: ");
				pessoa.setEmail(scanner.nextLine());
				
				System.out.print("Altere o cpf da pessoa...........: ");
				pessoa.setCpf(scanner.nextLine());
				
				//atualizando no banco de dados
				pessoaRepository.update(pessoa);
				
				System.out.println("\nPessoa atualizada com sucesso!");
			}
			else {
				System.out.println("\nPessoa não encontrada, verifique o ID informado.");
			}
		}
		catch(Exception e) {
			System.out.println("\nFalha ao atualizar pessoa: " + e.getMessage());
		}
	}

	public void excluirPessoa() {

		try {
			
			System.out.println("\nEXCLUSÃO DE PESSOA:\n");
			
			System.out.print("Informe o id da pessoa...........: ");
			Integer idPessoa = Integer.parseInt(scanner.nextLine());
			
			PessoaRepository pessoaRepository = new PessoaRepository();
			Pessoa pessoa = pessoaRepository.findById(idPessoa);
			
			if(pessoa != null) {				
				
				//excluindo no banco de dados
				pessoaRepository.delete(pessoa);
				
				System.out.println("\nPessoa excluída com sucesso!");
			}
			else {
				System.out.println("\nPessoa não encontrada, verifique o ID informado.");
			}
		}
		catch(Exception e) {
			System.out.println("\nFalha ao excluir pessoa: " + e.getMessage());
		}		
	}

	public void consultarPessoas() {

		try {
		
			System.out.println("\nCONSULTA DE PESSOAS:\n");
			
			PessoaRepository pessoaRepository = new PessoaRepository();
			List<Pessoa> lista = pessoaRepository.findAll();
			
			//imprimindo a lista (foreach)
			for(Pessoa pessoa : lista) {
				
				System.out.println("ID DA PESSOA....: " + pessoa.getIdPessoa());
				System.out.println("NOME............: " + pessoa.getNome());
				System.out.println("EMAIL...........: " + pessoa.getEmail());
				System.out.println("CPF.............: " + pessoa.getCpf());
				System.out.println("..");
			}			
		}
		catch(Exception e) {
			System.out.println("\nFalha ao consultar pessoas: " + e.getMessage());
		}
	}

}


