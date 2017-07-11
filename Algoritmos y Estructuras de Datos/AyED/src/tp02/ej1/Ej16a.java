package tp02.ej1;

import clasesListasDeEnteros.ListaDeEnterosEnlazada;

public class Ej16a {
	ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();

	public ListaDeEnterosEnlazada calcularsucesion(int n) {
		lista.agregarFinal(n);
		if (n != 1) {
			if (n % 2 == 0) {
				calcularsucesion(n / 2);
			} else {
				calcularsucesion(n * 3 + 1);
			}
		}
		return lista;
	}
}
