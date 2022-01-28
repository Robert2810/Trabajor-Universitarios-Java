package triangulodepascal;

import java.util.Scanner;

public class TrianguloDePascal {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int[][] triangulosPascal = new int[20][20];
        int aux = 1, auxM = 1, ren;

        System.out.println("Ingrese el  numero de renglones:");
        ren = leer.nextInt();

        //inicializacion triangulo
        for (int i = 0; i < ren; i++) {int c1 = 0, c2 = 1;
            for (int j = 0; j < aux; j++) {
                if (i >= 2 && j > 0 && j < (aux - 1)) {
                    triangulosPascal[i][j] = triangulosPascal[i - 1][c1] + triangulosPascal[i - 1][c2];
               c1++;c2++;
                } else {
                    triangulosPascal[i][j] = 1;

                }
                
            }
            aux++;
        }

        //impresion de Matriz
        for (int i = 0; i < ren; i++) {
            for (int j = 0; j < auxM; j++) {
//                System.out.print("[ "+i+" ] [ " +j+ " ] "+triangulosPascal[i][j]);
                System.out.print(triangulosPascal[i][j]);
                System.out.print("    ");
            }
            auxM++;
            System.out.println("");
        }

    }

}
