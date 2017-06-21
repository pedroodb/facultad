package tp02.ej1;

import clasesListasDeEnteros.ListaDeEnterosConArreglos;

public class TestListaDeEnterosConArreglos {

	public static void main(String[] args) {
		ListaDeEnterosConArreglos listaa = new ListaDeEnterosConArreglos();
		for (int i = 0; i < args.length; i++) {
			Integer a =new Integer(args[i]);
			listaa.agregarFinal(a);
		}
		int b;
		for (int i = 1; i <= listaa.tamanio(); i++) {
			b=listaa.elemento(i);
			System.out.println(b);
		}
		ImprimirRecursivo.Imprimir(listaa, 1);
		listaa.comenzar();
		ImprimirRecursivo.Imprimir2(listaa);
	}

}
