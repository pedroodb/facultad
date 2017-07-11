package clasesArbolBinario.Examen;

import claseCola.Cola;
import clasesArbolBinario.ArbolBinario;

public class NivelArbol {
	ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(null);

	public ArbolBinario<Integer> minEnNivelDeAB(int n) {
		Cola<ArbolBinario<Integer>> cola = new Cola<ArbolBinario<Integer>>();
		ArbolBinario<Integer> aux = arbol;
		cola.encolar(aux);
		cola.encolar(null);
		ArbolBinario<Integer> min = null;
		int nivel = 0;
		while (!cola.esVacia() && nivel <= n) {
			aux = cola.desencolar();
			if (aux != null) {
				if (!aux.getHijoIzquierdo().esVacio()) {
					cola.encolar(aux.getHijoIzquierdo());
				}
				if (!aux.getHijoDerecho().esVacio()) {
					cola.encolar(aux.getHijoDerecho());
				}
				if (nivel == n && aux.esHoja()) {
					if (min == null) {
						min = aux;
					} else {
						if (aux.getDatoRaiz() < min.getDatoRaiz()) {
							min = aux;
						}
					}
				}
			} else {
				if (!cola.esVacia()) {
					cola.encolar(null);
					nivel++;
				}
			}
		}
		return min;
	}
}
