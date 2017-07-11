package tp01.ej5;

public class Ej5 {

	public static void main(String[] args) {
		int [] ar = new int[5];
		for (int i = 0; i < ar.length; i++) {
			ar[i]=i+1;
		}
		
		Resultados a = Ej5a.resolver(ar);
		System.out.println(a.getMax()+" "+a.getMin()+" "+a.getProm());
		Resultados b = new Resultados();
		Ej5b.resolver(ar, b);
		System.out.println(b.getMax()+" "+b.getMin()+" "+b.getProm());
	}
	
}
