package clasesArbolBinario.Examen;

import clasesArbolBinario.ArbolBinario;

public class ValidadorArbol {
	//Entrega turno jueves tarde
	ArbolBinario<Integer> ab;
	
	public boolean esMonodistante(int k){
		if(ab!=null){
			return(monoAux(k,ab));
		}
		else {
			return false;
		}
	}
	
	private boolean monoAux(int k, ArbolBinario<Integer> arbol){
		if (arbol.esHoja()){
			if(k-arbol.getDatoRaiz()==0){
				return true;
			}
			else return false;
		}
		else{
			return (monoAux(k-arbol.getDatoRaiz(),arbol.getHijoIzquierdo())&&monoAux(k-ab.getDatoRaiz(),arbol.getHijoDerecho()));
		}
	}
}
