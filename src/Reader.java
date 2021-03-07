import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Reader {

    private Scanner scanner;
    private BufferedReader bufferedReader;
    private int n;



    private int matrix[][];

    public Reader (Scanner scanner) {
        this.scanner = scanner;
    }

    public Reader (BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public BufferedReader getBufferedReader ( ) {
        return bufferedReader;
    }

    public void setBufferedReader (BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public void read ( ) {
        try {
            System.out.println("Выберите метод ввода данных [Консоль/Из файла]: ");
            String decision = scanner.nextLine( );

            if (decision.toLowerCase( ).equals("консоль")) {
               ReaderFromConsole readerFromConsole = new ReaderFromConsole(scanner, this);
               readerFromConsole.readFromConsole();
            }

            if (decision.toLowerCase( ).equals("из файла")) {
                System.out.println("Введите название файла: ");

                String nameOfFile = scanner.nextLine( );
                File file = new File(nameOfFile);

                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                ReaderFromFile readerFromFile = new ReaderFromFile(bufferedReader, this);
                readerFromFile.readFromFile();
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Файла с таким именем не существует");
        } catch (IOException e) {
            System.out.println("Ой-ой, что-то пошло не так");
        }

    }




    public String readString (String message) throws NoSuchElementException {
        String result = "";
        do {
            if (result == null) {
                System.out.println("Введите не пустую строку");
            }
            System.out.println(message);
            result = scanner.nextLine( );
            result = result.trim( );
            result = result.isEmpty( ) ? null : result;
        } while (result == null);

        return result;
    }

    public boolean checkIntInput (String input) {
        try {
            if (input == null) {
                System.out.println("Это значение вам не null");
                return false;
            }
            int a = Integer.parseInt(input);
            if (a < 2 || a > 20) throw new NumberFormatException( );
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Размерностоь матрицы должна быть целым числом. 2 < n <= 20");
            return false;
        }
    }

    public int getN ( ) {
        return n;
    }

    public void setN (int n) {
        this.n = n;
    }

    public int[][] getMatrix ( ) {
        return matrix;
    }

    public void setMatrix (int[][] matrix) {
        this.matrix = matrix;
    }
}
