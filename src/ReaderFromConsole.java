import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

public class ReaderFromConsole extends Reader{


//    private Scanner scanner;
    private Reader reader;

    public ReaderFromConsole (Scanner scanner, Reader reader) {
        super(scanner);
        this.reader = reader;
    }

    public void readFromConsole() {
       reader.setN(readNFromConsole());

//        super.matrix = readMatrixFromConsole();

    }

//    public int[][] readMatrixFromConsole ( ) {
//
//    }

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


}
