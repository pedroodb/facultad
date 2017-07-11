package tp01.ej1;

public class Metodos {
	
	public void conFor(int a,int b){
		for(int i=a;i<=b;i++){
			System.out.println(i);
		}
	}
	
	public void conWhile(int a, int b){
		while (a<=b){
			System.out.println(a);
			a++;
		}
	}
	
	public void conNada(int a, int b){
		if(a<=b){
			System.out.println(a);
			conNada(a+1,b);
		}
	}
}
