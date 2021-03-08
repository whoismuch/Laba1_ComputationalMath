import java.util.Scanner;

public class Main {

    public static void main (String[] args) {

        //Считываем данные
        Reader reader = new Reader(new Scanner(System.in));
        reader.read( );

        //Производим расчет
        Calculator calculator = new Calculator(reader.getN( ), reader.getMatrix( ), reader.getB());
        calculator.solveByGauss( );

    }
}
