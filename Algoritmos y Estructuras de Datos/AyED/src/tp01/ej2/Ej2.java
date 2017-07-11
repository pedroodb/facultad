package tp01.ej2;
import java.util.Scanner;
public class Ej2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in) ;
		int num = s.nextInt();
		int[] arreglo = new int[num];
		for (int i = 0; i < num; i++) {
			arreglo[i]=(1+i)*num;
		}
		for (int i = 0; i < arreglo.length; i++) {
			System.out.println(arreglo[i]);
		}
		s.close();
	}

}
