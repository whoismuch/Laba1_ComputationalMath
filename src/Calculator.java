import java.text.DecimalFormat;

public class Calculator {

    private int n;
    private double[][] matrix;
    private double[] b;

    public Calculator (int n, double[][] matrix, double[] b) {
        this.n = n;
        this.matrix = matrix;
        this.b = b;
    }


    public void solveByGauss ( ) {
        int step = 0;
        for (int i = 0; i < n-1; i++) {
            if (matrix[i][i] == 0) {
                int count = 0;
                for (int j = i + 1; j < n; j++) {
                    if (matrix[j][i] != 0) {
                        count++;
                        double[] tmp = matrix[i];
                        matrix[i] = matrix[j];
                        matrix[j] = tmp;
                        double tmpB = b[i];
                        b[i] = b[j];
                        b[j] = tmpB;

                        step ++;
                        System.out.println("Шаг " + step + ": ");
                        printMatrix();
                        break;
                    }
                }
                if (count == 0) continue;
            }


            for (int p = i+1; p < n; p++) {
                double koef = -1*matrix[p][i]/matrix[i][i];
                for (int s = i; s<n; s++) {
                    matrix[p][s] = matrix[i][s]*koef+matrix[p][s];
                }
                b[p] = b[i]*koef+b[p];
            }

            step++;
            System.out.println("Шаг " + step + ": ");
            printMatrix();

        }
    }

    public void printMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                DecimalFormat dF = new DecimalFormat( "#.###" );
                if (dF.format(matrix[i][j]).equals("-0.000")) System.out.printf("%15.3f", 0d);
                else System.out.printf("%15.3f", matrix[i][j]);
            }
            System.out.printf("%15.3f", b[i]);
            System.out.println("\r");
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

    public double[] getB ( ) {
        return b;
    }

    public void setB (double[] b) {
        this.b = b;
    }
}
