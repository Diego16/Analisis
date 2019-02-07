/*
 * Operaciones basicas =18
 * sea n=arreglo de numeros
 * (2n+1)->tamaño maximo de la respuesta
 * T(n)=(36n+18)
 */


package prueba;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class main {
    
        private static final int MegaBytes = 10241024;
	public static List<Integer>llenar(int n) {
		List<Integer> s1 = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
		 s1.add((int) (Math.random() * 9) + 1);
		}
		return s1;
		}
	public static void main(String[] args) {
                 
                 long freeMemory = Runtime.getRuntime().freeMemory()/MegaBytes;
                 long totalMemory = Runtime.getRuntime().totalMemory()/MegaBytes;
                 long maxMemory = Runtime.getRuntime().maxMemory()/MegaBytes;
		 int n,aux1,aux2=0,aux3;
		 long inicio,fin;
		 Scanner Sc = new Scanner(System.in);
		 List<Integer> s1 = new ArrayList<Integer>();
		 List<Integer> s2 = new ArrayList<Integer>();
		 List<Integer> aux = new ArrayList<Integer>();
		 List<List<Integer>> s3 = new ArrayList<List<Integer>>();
		 System.out.println("ingrese el tamaño");
		 n=Sc.nextInt();
		 s1=llenar(n);
		 s2=llenar(n);
		 System.out.println(s1);
		 System.out.println(s2);
		 aux3=n-1;
		 inicio=System.nanoTime();
		 for(int i=0;i<n;i++) {
			 aux1=0;
			 aux = new ArrayList<Integer>();
			 for(int j=0;j<i;j++) {
				 aux.add(0);
			 }
			 for(int j=0;j<n;j++) {//2n^2+
				 aux.add(((s1.get(i)*s2.get(j))+aux1)%10);
				 aux1=(s1.get(i)*s2.get(j)+aux1)/10;
			 }
			 aux.add(aux1);
			 s3.add(aux);
		 }
		 for(int i=0;i<n;i++) {
			 for(int j=s3.get(i).size();j<s3.get(aux3).size();j++) {
				 s3.get(i).add(0);
			 }
		 }
		 aux = new ArrayList<Integer>();
		 for(int i=0;i<s3.get(aux3).size();i++) {
			 aux1=0;
			 for(int j=0;j<n;j++){
				 aux1+=s3.get(j).get(i);
			 }
			 aux.add((aux1+aux2)%10);
			 aux2=((aux1+aux2)/10);
		 }
		 fin=System.nanoTime();
		 System.out.println(aux);
		 System.out.println(fin-inicio);
                 
                   freeMemory = Runtime.getRuntime().freeMemory() / MegaBytes;
              totalMemory = Runtime.getRuntime().totalMemory() / MegaBytes;
              maxMemory = Runtime.getRuntime().maxMemory() / MegaBytes;

              System.out.println("Used Memory in JVM : "
                                         + totalMemory);
              System.out.println("maxMemory in JVM: " + maxMemory);

	}
}
