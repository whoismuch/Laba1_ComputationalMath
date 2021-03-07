import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFromFile extends Reader {

//    private BufferedReader bufferedReader;
    private Reader reader;

    public ReaderFromFile (BufferedReader bufferedReader, Reader reader) {
        super(bufferedReader);
        this.reader = reader;
    }

    public void readFromFile() throws IOException {
        reader.setN(readNFromFile());
    }

    private int readNFromFile ( ) throws IOException {
        int n = 0;
        try {
            String value = getBufferedReader().readLine();
            if (value == null) System.out.println("Какой-то пустой у вас файл, заполните его, пожалуйста");
            n = Integer.parseInt(value);
            if (n < 2 || n > 20) throw new NumberFormatException( );
        } catch (NumberFormatException ex) {
            System.out.println("Размерность матрицы должна быть целым числом. 2 < n <= 20. Исправьте файл и повторите ввод");
        }
        return n;
    }

}
