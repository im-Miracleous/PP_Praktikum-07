/*
 * PRAKTIKUM 07 "IN234 Paradigma Pemrograman"
 * Nama Program : CalculatorApp
 * Deskripsi    : Class yang menjalankan program kalkulator konversi bentuk bilangan.
 * Penulis      : Miracle Steven Gerrald
 * NRP          : 2472019
 */

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("[1] Convert to Binary");
        System.out.println("[2] Convert to Octal");
        System.out.println("[3] Convert to Hexadecimal");
        System.out.println("[4] Convert to Decimal");
        System.out.println("[5] Exit");

        int choice;
        do {
            System.out.print("Choice: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
                System.out.print("Choice: ");
            }
            choice = sc.nextInt();
            sc.nextLine();

            if (choice >= 1 && choice <= 3) {
                System.out.print("Input number: ");
                int decimal = sc.nextInt();
                sc.nextLine();
                if (decimal < 0) {
                    System.out.println("Number must be positive.");
                } else {
                    if (choice == 1) {
                        System.out.println(ConverterCalculator.toBinary(decimal));
                    } else if (choice == 2) {
                        System.out.println(ConverterCalculator.toOctal(decimal));
                    } else {
                        System.out.println(ConverterCalculator.toHex(decimal));
                    }
                }
            } else if (choice == 4) {
                System.out.print("Input radix: ");
                int radix = sc.nextInt();
                sc.nextLine();

                System.out.print("Input number: ");
                String numInString = sc.nextLine();

                Radix fromRadix = null;
                if (radix == 2) {
                    fromRadix = Radix.BINARY;
                } else if (radix == 8) {
                    fromRadix = Radix.OCTAL;
                } else if (radix == 16) {
                    fromRadix = Radix.HEXADECIMAL;
                }

                if (fromRadix != null) {
                    int result = ConverterCalculator.toDecimal(numInString, fromRadix);
                    System.out.printf("%s in decimal is %d%n", numInString, result);
                } else {
                    System.out.println("Sorry, that radix is not available. Please choose 2, 8, or 16.");
                }
            } else if (choice != 5) {
                System.out.println("Invalid choice. Please select a number between 1 and 5.");
            }
        } while (choice != 5);

        sc.close();
    }
}
