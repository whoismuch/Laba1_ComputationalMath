import java.io.*;
import java.util.Scanner;

public class Reader {

    private Scanner scanner;
    private BufferedReader bufferedReader;
    private int n;
    private double[][] matrix;
    private double[] b;

    public void read ( ) {
        try {
            boolean in = false;
            while (!in) {
                System.out.println("Выберите метод ввода данных [Консоль/Из файла]: ");
                String decision = scanner.nextLine( );

                if (decision.toLowerCase( ).equals("консоль")) {
                    ReaderFromConsole readerFromConsole = new ReaderFromConsole(scanner, this);
                    readerFromConsole.readFromConsole( );
                    in = true;
                }

                if (decision.toLowerCase( ).equals("из файла")) {
                    System.out.println("Введите название файла: ");

                    String nameOfFile = scanner.nextLine( );
                    File file = new File(nameOfFile);

                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    ReaderFromFile readerFromFile = new ReaderFromFile(bufferedReader, this);
                    readerFromFile.readFromFile( );
                    in = true;
                }

                if (!in) {
                    System.out.println("Выберите корректный вариант: ");
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Файла с таким именем не существует");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Ой-ой, что-то пошло не так");
            System.exit(0);

        }

    }


    public int getN ( ) {
        return n;
    }

    public void setN (int n) {
        this.n = n;
    }

    public double[][] getMatrix ( ) {
        return matrix;
    }

    public void setMatrix (double[][] matrix) {
        this.matrix = matrix;
    }


    public Reader (Scanner scanner) {
        this.scanner = scanner;
    }

    public Reader (BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public Scanner getScanner ( ) {
        return scanner;
    }

    public void setScanner (Scanner scanner) {
        this.scanner = scanner;
    }

    public BufferedReader getBufferedReader ( ) {
        return bufferedReader;
    }

    public void setBufferedReader (BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }


    public double[] getB ( ) {
        return b;
    }

    public void setB (double[] b) {
        this.b = b;
    }

}
