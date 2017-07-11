package tp03;

import clasesArbolBinario.ArbolBinario;
import clasesListasGenericas.ListaEnlazadaGenerica;

public class ContadorArbol {
	private ListaEnlazadaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
	
	public ListaEnlazadaGenerica<Integer> getL() {
		return l;
	}

	public void numerosPares(ArbolBinario<Integer> ab){
		if(!ab.esVacio()){
			numerosPares(ab.getHijoIzquierdo());
			if(ab.getDatoRaiz()%2==0){
				l.agregarFinal(ab.getDatoRaiz());
			}
			numerosPares(ab.getHijoDerecho());
		}
	}
	
	public void numerosPares2(ArbolBinario<Integer> ab){
		if(!ab.esVacio()){
			numerosPares(ab.getHijoIzquierdo());
			numerosPares(ab.getHijoDerecho());
			if(ab.getDatoRaiz()%2==0){
				l.agregarFinal(ab.getDatoRaiz());
			}
		}
	
	}

}
