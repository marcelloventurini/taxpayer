import entities.Company;
import entities.Individual;
import entities.Taxpayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of taxpayers: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        List<Taxpayer> taxpayers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Taxpayer #" + (i + 1));
            System.out.print("Individual (i) or company (c)? ");
            char taxpayerType = scanner.nextLine().charAt(0);

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Anual income: ");
            double anualIncome = scanner.nextDouble();

            if (taxpayerType == 'i') {
                System.out.print("Medical expenses: ");
                double medicalExpenses = scanner.nextDouble();
                scanner.nextLine();

                taxpayers.add(new Individual(name, anualIncome, medicalExpenses));
            } else if (taxpayerType == 'c') {
                System.out.print("Number of employees: ");
                int numberOfEmployees = scanner.nextInt();
                scanner.nextLine();

                taxpayers.add(new Company(name, anualIncome, numberOfEmployees));
            }
        }

        System.out.println("Paid taxes:");
        double sum = 0;
        for (Taxpayer taxpayer : taxpayers) {
            sum += taxpayer.calculateTax();
            System.out.printf("%s: $ %.2f\n", taxpayer.getName(), taxpayer.calculateTax());
        }

        System.out.printf("Total taxes: $ %.2f", sum);

        scanner.close();
    }
}
