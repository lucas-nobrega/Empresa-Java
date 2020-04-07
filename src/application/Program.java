package application;

import java.util.*;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);

		System.out.print("How many employees will be registered? ");
		int temp = sc.nextInt();
		System.out.println();

		List<Funcionario> lista = new ArrayList<Funcionario>();

		for (int i = 0; i < temp; i++) {
			System.out.printf("Emplyoee #%d:", i + 1);
			System.out.printf("Id: ");
			int id = sc.nextInt();
			System.out.printf("Name: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.printf("Salary: ");
			double salario = sc.nextDouble();
			Funcionario fun = new Funcionario(id, nome, salario);
			lista.add(fun);
		}
		System.out.println();

		System.out.print("Enter the employee id that will have salary increase : ");
		Funcionario f = lista.stream().filter(x -> sc.nextInt() == x.getId()).findFirst().orElse(null);
		if (f == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.println("Enter the percentage: ");
			f.increaseSalary(sc.nextDouble());
		}

		System.out.println();
		System.out.println("List of employees: ");
		lista.forEach(funcionario -> System.out.printf("%d, %s, %.2f%n", funcionario.getId(), funcionario.getNome(),
				funcionario.getSalario()));

		sc.close();
	}

}
