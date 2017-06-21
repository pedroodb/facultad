package tp01.ej5;

public class Ej5a {
	public static Resultados resolver(int[] arreglo){
		double promedio =0;
		int min=9999;
		int max=-9999;
		Resultados res = new Resultados();
		for (int i = 0; i < arreglo.length; i++) {
			if (arreglo[i]<min){
				res.setMin(arreglo[i]);
				min=arreglo[i];
			}
		
			if (arreglo[i]>max){
				res.setMax(arreglo[i]);
				max=arreglo[i];
			}
		
			promedio=promedio+arreglo[i];
		}
		promedio=promedio/arreglo.length;
		res.setProm(promedio);
		return (res);
	}

}
