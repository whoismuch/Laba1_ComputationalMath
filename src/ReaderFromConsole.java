import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReaderFromConsole extends Reader {

    private Reader reader;

    public ReaderFromConsole (Scanner scanner, Reader reader) {
        super(scanner);
        this.reader = reader;
    }

    public void readFromConsole ( ) {
        reader.setN(readNFromConsole( ));
        reader.setMatrix(readMatrixFromConsole( ));
    }

    public int readNFromConsole ( ) {
        int n = 0;
        boolean flag = false;
        while (!flag) {
            try {
                String value = readString("Введите размерность матрицы: ");
                n = Integer.parseInt(value);
                if (n < 2 || n > 20) throw new NumberFormatException( );
                flag = true;
            } catch (NumberFormatException ex) {
                System.out.println("Размерность матрицы должна быть целым числом. 2 < n <= 20");
            }
        }
        return n;
    }

    public double[][] readMatrixFromConsole ( ) {
        double[][] matrix = new double[reader.getN( )][reader.getN( )];
        double[] b = new double[reader.getN()];
        System.out.println("Перейдем к заполнению матрицы: ");
        for (int i = 0; i < reader.getN( ); i++) {
            for (int j = 0; j < reader.getN( ); j++) {
                matrix[i][j] = readInt(null);
            }
            b[i] = readInt(null);

        }
        reader.setB(b);
        return matrix;

    }


    public String readString (String message) throws NoSuchElementException {
        String result = "";
        do {
            if (result == null) {
                System.out.println("Введите не пустую строку");
            }
            if (message != null) System.out.println(message);
            result = getScanner().nextLine( );
            result = result.trim( );
            result = result.isEmpty( ) ? null : result;
        } while (result == null);

        return result;
    }

    public int readInt (String message) throws NoSuchElementException {
        Integer result = 0;
        boolean flag = false;
        while (!flag) {
            try {
                if (message != null) System.out.println(message);
                if (!getScanner().hasNextInt()) throw new NumberFormatException();
                result = getScanner().nextInt();
                if (result == null) {
                    System.out.println("Введите не пустую строку");
                }
                flag = true;

            } catch (NumberFormatException ex) {
                System.out.println("Элемент матрицы должен быть вещественным числом. К сожалению, вам придется повторить ввод");
                System.exit(0);
            }
        }

        return result;
    }



}


