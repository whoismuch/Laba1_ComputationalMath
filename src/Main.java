import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Reader reader = new Reader(new Scanner(System.in));
        reader.read( );

        Calculator calculator = new Calculator(reader.getN( ), reader.getMatrix( ), reader.getB());
        calculator.solveByGauss( );

        System.out.println(reader.getN( ));
        double[][] matr = calculator.getMatrix( );
        double[] b = calculator.getB( );

        for (int i = 0; i < reader.getN( ); i++) {
            for (int j = 0; j < reader.getN( ); j++) {
                System.out.print(matr[i][j] + " ");
            }
            System.out.println(b[i]);
            System.out.println("\r");
        }

    }
}
