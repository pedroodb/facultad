package clasesArbolBinario.Examen;

import clasesArbolBinario.ArbolBinario;

public class ContadorArbol {
	//Entrega turno miercoles tarde
	ArbolBinario<Integer> ab;
	
	public int contadorOcurrencias(int e){
		if(ab!=null){
			return contadorAux(e,ab);
		}
		else return 0;
	}
	
	private int contadorAux(int e,ArbolBinario<Integer> arbol){
		int cant=0;
		if(!arbol.getHijoIzquierdo().esVacio()){
			cant+=contadorAux(e, arbol.getHijoIzquierdo());
		}
		if(!arbol.getHijoDerecho().esVacio()){
			cant+=contadorAux(e, arbol.getHijoDerecho());
		}
		if(arbol.getDatoRaiz().equals(e)){
			cant++;
		}
		return cant;
	}
}
