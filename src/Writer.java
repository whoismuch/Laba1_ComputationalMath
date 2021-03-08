import java.text.DecimalFormat;

public class Writer {

    private DecimalFormat dF;

    public Writer ( ) {
        dF = new DecimalFormat("#.###");
    }

    public void printValue (String format, String message, double value) {
        if (message != null) System.out.print(message);
        if (dF.format(value).equals("-0")) System.out.printf(format, 0d);
        else System.out.printf(format, value);
    }

    public void printMatrix (double[][] matrix, double[] b) {
        DecimalFormat dF = new DecimalFormat("#.###");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                printValue("%15.3f", null, matrix[i][j]);
            }
            printValue("%15.3f", null, b[i]);
            System.out.println("\r");
        }
    }

    public void printVector (String message, String letter, double[] vector) {
        DecimalFormat dF = new DecimalFormat("#.###");
        System.out.println(message);
        int count = 0;
        for (int i = 0; i < vector.length; i++) {
            count++;
            System.out.print(letter + count + " = ");
            vector[i] = Math.round(vector[i] * 1000.0) / 1000.0;
            printValue("%1.3f", null, vector[i]);
            System.out.println( );
        }
    }


}
