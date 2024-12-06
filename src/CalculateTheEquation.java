import java.io.*;
import java.util.Scanner;

public class CalculateTheEquation implements CalculateTheEquationInterface, ReadWriteData {
    protected double variable = 0;

    @Override
    public double doCalculation() {
        try {
            variable = (variable - 4) / Math.sin(3 * variable - 1);
            return variable;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception: illegal value.");
        }
        return 0;
    }

    @Override
    public void writeResultToTxt(String fileName) throws IOException {
        PrintWriter f = new PrintWriter(fileName);
        f.printf("%f ", variable);
        f.close();
    }

    @Override
    public void writeResultToBin(String fileName) throws IOException {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fileName));
        f.writeDouble(variable);
        f.close();
    }

    @Override
    public void readResultFromTxt(String fileName) throws IOException {
        File f = new File(fileName);
        if (f.exists() && f.length() > 0) {
            Scanner scanner = new Scanner(f);
            if (scanner.hasNextDouble()) {
                variable = scanner.nextDouble();
            } else {
                System.out.println("Файл не містить допустимих даних.");
            }
            scanner.close();
        } else {
            throw new IOException("Файл " + fileName + " не знайдено або він порожній.");
        }
    }

    @Override
    public void readResultFromBin(String fileName) throws IOException {
        File f = new File(fileName);
        if (f.exists() && f.length() > 0) {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(f));
            variable = dataInputStream.readDouble();
            dataInputStream.close();
        } else {
            throw new IOException("Файл " + fileName + " не знайдено або він порожній.");
        }
    }
}
