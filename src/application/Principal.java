package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Emplyoee;

public class Principal {

	public static void main(String[] args) {
		// Fazer um programa para ler um número inteiro N e depois os dados 
		// (id, nome e salario) de N funcionários. Não deve haver repetição de id.
		// Em seguida, efetuar o aumento de X por cento no salário de um determinado 
		// funcionário.
		// Para isso, o programa deve ler um id e o valor X. Se o id informado não 
		// existir, mostrar uma mensagem e abortar a operação. 
		// Ao final, mostrar a listagem atualizada dos funcionários.
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("How many employees will be registered? ");
		int num = sc.nextInt();
		List<Emplyoee> list = new ArrayList<>();
		for(int i=1 ; i <= num ; i++) {
			System.out.println();
			System.out.println("Emplyoee #"+i);
			System.out.print("Id: ");
			int id = sc.nextInt();
			// Verifico se já existe o ids
			while(hasId(list,id)) {
				System.out.println("Id Existente! Tente novamente.");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			list.add(new Emplyoee(id, name, salary));
		}
		
		System.out.print("Enter the employee id that will have salary increase: ");
		int localizaId = sc.nextInt();
		//Integer posicao = position(list, localizaId);
		Emplyoee posicao = list.stream().filter(x -> x.getId() == localizaId).findFirst().orElse(null);
		if(posicao == null) {
			System.out.println("This id does not exist!");
			//System.out.println("Programa abortado!");
			//System.exit(0);
		}else {
			System.out.print("Enter the percentage: ");
			double porcento = sc.nextDouble();
			//list.get(posicao).increaseSalary(porcento);
			posicao.increaseSalary(porcento);
		}
		System.out.println();
		System.out.println("List of employees:");
		for(Emplyoee emp : list) {
			System.out.println(emp);
		}
		
		sc.close();
	}
	public static Integer position(List<Emplyoee> list, int id) {
		for(int i=0 ; i < list.size() ; i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public static boolean hasId(List<Emplyoee> list, int id) {
		Emplyoee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp !=null;
	}
}
