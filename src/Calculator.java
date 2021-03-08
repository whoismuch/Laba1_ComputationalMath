import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.text.DecimalFormat;

public class Calculator {

    private int n;
    private double[][] matrix;
    private double[][] oldMatrix;
    private double[] b;
    private double[] oldB;
    private double[] x;
    private double[] r;
    private Writer writer;

    public Calculator (int n, double[][] matrix, double[] b) {
        writer = new Writer( );
        this.n = n;
        this.matrix = matrix;
        this.b = b;
        x = new double[n];
        r = new double[n];
        oldMatrix = new double[n][n];
        oldB = new double[n];
        copyData();
    }

    public void copyData ( ) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                oldMatrix[i][j] = matrix[i][j];
            }
            oldB[i] = b[i];
        }
    }

    public void solveByGauss ( ) {
        triangleForm( );
        findDeterminant( );
        findUnknowns( );
        findDiscrepancy( );
    }

    public void triangleForm ( ) {
        int step = 0;
        for (int i = 0; i < n - 1; i++) {
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

                        step++;
                        System.out.println("Шаг " + step + ": ");
                        writer.printMatrix(matrix, b);
                        break;
                    }
                }
                if (count == 0) continue;
            }


            for (int p = i + 1; p < n; p++) {
                double koef = -1 * matrix[p][i] / matrix[i][i];
                for (int s = i; s < n; s++) {
                    matrix[p][s] = matrix[i][s] * koef + matrix[p][s];
                }
                b[p] = b[i] * koef + b[p];
            }

            step++;
            System.out.println("Шаг " + step + ": ");
            writer.printMatrix(matrix, b);

        }


    }


    public void findDeterminant ( ) {
        double det = 1d;
        for (int i = 0; i < n; i++) {
            det *= matrix[i][i];
        }
        writer.printValue("%1.3f", "Определитель равен: ", det);
        System.out.println( );
        if (det == 0) {
            System.out.println("Ой-ой-ой, смотрите-ка, определитель равен нулю, а значит, система имеет либо бесконечное количество решений, либо не имеет решений вообще. \nНекрасиво, правда? Давайте-ка вы все исправите и мы попробуем еще раз." );
            System.exit(0);
        }
    }

    public void findUnknowns ( ) {
        for (int i = n - 1; i >= 0; i--) {
            double tmp = b[i];
            for (int j = n - 1; j > i; j--) {
                tmp -= matrix[i][j] * x[j];
            }
            x[i] = tmp / matrix[i][i];
        }

        writer.printVector("Вектор неизвестных: ", "x", x);
    }

    public void findDiscrepancy ( ) {
        for (int i = 0; i < n; i++) {
            double ax_ = 0;
            for (int j = 0; j < n; j++) {
                ax_ += oldMatrix[i][j] * x[j];
            }
            r[i] = ax_ - oldB[i];
        }

        writer.printVector("Вектор невязок: ", "r", r);
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
