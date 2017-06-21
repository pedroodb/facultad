package tp02.ej1;

import clasesListasDeEnteros.ListaDeEnteros;

public class ImprimirRecursivo {
	
	public static void Imprimir (ListaDeEnteros lista,int a){
		if(lista.tamanio()>a){
			Imprimir(lista,a+1);
		}
		System.out.println(lista.elemento(a));
	}
	
	public static void Imprimir2 (ListaDeEnteros lista){
		if(!lista.fin()){
			int a = lista.proximo();
			Imprimir2(lista);
			System.out.println(a);
		}
	}
}
