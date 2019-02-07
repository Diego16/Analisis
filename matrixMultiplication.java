import java.util.concurrent.TimeUnit;
import static java.time.temporal.ChronoUnit.SECONDS;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.print ("Ingrese el valor de n para generar las matrices: ");
		n = sc.nextInt();
		//Creacion de matrices
		int[][] m1 = new int[n][n];
		int[][] m2 = new int[n][n];
		int[][] sol = new int [n][n];
		m1 = LlenarMatriz(m1, n);
		//Imprimir(m1, n);
		m2 = LlenarMatriz(m2, n);
		//Imprimir(m2, n);
		long startTime = System.nanoTime();
		sol = MultiplicarMatrices(m1, m2, n, sol);
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		//Imprimir(sol, n);
		System.out.println("Tiempo:"+timeElapsed+" ns (nanoTime)");
		totalMemory = Runtime.getRuntime().totalMemory() / MegaBytes;
		sc.close();
	}
	public static int[][] LlenarMatriz(int[][] mat, int n) {
		for(int x = 0; x < n; x++) {
			for(int y = 0; y < n; y++) {
				int randomNum = ThreadLocalRandom.current().nextInt(0, 6);
				mat[x][y] = randomNum;
			}
		}
		return mat;
	}
	public static int[][] MultiplicarMatrices(int[][]m1, int [][]m2, int n, int[][]sol){
		for(int x = 0; x < n; x ++) {
			for(int y = 0; y < n; y++) {
				sol[x][y] = 0;
				for(int z = 0; z < n; z++) {
					sol[x][y] += m1[x][z]* m2[z][y];
				}
			}
		}
		return sol;
	}
	public static void Imprimir(int[][]sol, int n){
		for(int x = 0; x < n; x ++) {
			for(int y = 0; y < n; y++) {
				System.out.print(sol[x][y] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n\n");
	}
}
