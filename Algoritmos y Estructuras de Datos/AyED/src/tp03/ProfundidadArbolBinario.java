package tp03;

import claseCola.Cola;
import clasesArbolBinario.ArbolBinario;

public class ProfundidadArbolBinario {
	public ArbolBinario<Integer> arbol;

	public int sumaElemProf(int p) {
		ArbolBinario<Integer> aux = null;
		int nivel = 0;
		int total = 0;
		Cola<ArbolBinario<Integer>> cola = new Cola<ArbolBinario<Integer>>();
		cola.encolar(arbol);
		cola.encolar(null);
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {
				if (nivel != p) {
					if (!aux.getHijoIzquierdo().esVacio()) {
						cola.encolar(aux.getHijoIzquierdo());
					}
					if (!aux.getHijoDerecho().esVacio()) {
						cola.encolar(aux.getHijoDerecho());
					}
				}
				else {
					total+=aux.getDatoRaiz();
				}
			} else if (!cola.esVacia()) {
				cola.encolar(null);
				nivel++;
			}
		}
		return total;
	}
}
