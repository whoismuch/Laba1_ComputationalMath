import java.io.BufferedReader;
import java.io.IOException;

public class ReaderFromFile extends Reader {

    //    private BufferedReader bufferedReader;
    private Reader reader;

    public ReaderFromFile (BufferedReader bufferedReader, Reader reader) {
        super(bufferedReader);
        this.reader = reader;
    }

    public void readFromFile ( ) throws IOException {
        reader.setN(readNFromFile( ));
        reader.setMatrix(readMatrixFromFile( ));
    }

    private int readNFromFile ( ) throws IOException {
        int n = 0;
        try {
            String value = getBufferedReader( ).readLine( );
            if (value == null) System.out.println("Какой-то пустой у вас файл, заполните его, пожалуйста");
            n = Integer.parseInt(value);
            if (n < 2 || n > 20) throw new NumberFormatException( );
        } catch (NumberFormatException ex) {
            System.out.println("Размерность матрицы должна быть целым числом. 2 < n <= 20. Исправьте файл и повторите ввод");
        }
        return n;
    }

    private double[][] readMatrixFromFile ( ) throws IOException {
        double[][] matrix2 = new double[reader.getN( )][reader.getN( )];
        double[] b = new double[reader.getN()];
        try {
            for (int i = 0; i < reader.getN( ); i++) {
                String line = getBufferedReader( ).readLine( );
                String[] matrix1 = new String[reader.getN( )+1];
                matrix1 = line.split(" ");
                //Если столбцов больше, чем n+1 -> матрица не квадратная и все плохо
                if (matrix1.length > reader.getN() + 1) throw new NumberFormatException();
                for (int j = 0; j < reader.getN( ); j++) {
                    matrix2[i][j] = Double.parseDouble(matrix1[j]);
                }
                b[i] = Double.parseDouble(matrix1[reader.getN()]);
            }
            String line = getBufferedReader( ).readLine( );
            //Если строк больше, чем n -> матрица не квадратная и все плохо
            if (line != null) throw new NumberFormatException();
        } catch (NullPointerException | NumberFormatException ex) {
            System.out.println("Ваша матрица неисправна. Исправьте файл и повторите ввод");
            System.exit(0);
        }

        reader.setB(b);
        return matrix2;
    }

}
