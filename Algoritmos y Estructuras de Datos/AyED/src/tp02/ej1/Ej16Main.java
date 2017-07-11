package tp02.ej1;

import clasesListasDeEnteros.ListaDeEnterosEnlazada;

public class Ej16Main {

	public static void main(String[] args) {
		ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
		Ej16a i = new Ej16a();
		lista = i.calcularsucesion(6);
		lista.comenzar();
		ImprimirRecursivo.Imprimir2(lista);
	}

}
