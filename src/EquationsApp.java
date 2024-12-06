import java.io.*;
import java.util.Scanner;

public class EquationsApp {
    public static void main(String[] args) {
        CalculateTheEquation calc = new CalculateTheEquation();

        // Початковий запис даних у файли
        calc.variable = 5.0;  // Початкове значення
        try {
            calc.writeResultToTxt("src/txt.txt");
            calc.writeResultToBin("src/bin.bin");
        } catch (IOException e) {
            System.out.println("Помилка запису в файл: " + e.getMessage());
        }

        // Основна логіка програми
        try {
            calc.readResultFromBin("src/bin.bin");
            System.out.println("Result of calculation (binary): " + calc.doCalculation());
            calc.writeResultToBin("src/bin.bin");
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            calc.readResultFromTxt("src/txt.txt");
            System.out.println("Result of calculation (text): " + calc.doCalculation());
            calc.writeResultToTxt("src/txt.txt");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
