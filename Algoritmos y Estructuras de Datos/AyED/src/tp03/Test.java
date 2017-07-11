package tp03;

import clasesArbolBinario.ArbolBinario;

public class Test {

	public static void main(String[] args) {
		
		ArbolBinario<Integer> ar = new ArbolBinario<Integer>(new Integer(40));
		ArbolBinario<Integer> hd = new ArbolBinario<Integer>(new Integer(50));
		hd.agregarHijoDerecho(new ArbolBinario<Integer>(70));
		hd.agregarHijoIzquierdo(new ArbolBinario<Integer>(45));
		ar.agregarHijoDerecho(hd);
		ArbolBinario<Integer> hi = new ArbolBinario<Integer>(new Integer(20));
		hi.agregarHijoDerecho(new ArbolBinario<Integer>(30));
		hi.agregarHijoIzquierdo(new ArbolBinario<Integer>(50));
		ar.agregarHijoIzquierdo(hi);
		ar.recorridoPorNiveles();
		System.out.println("");
		ar.espejo().recorridoPorNiveles();
		System.out.println("");
/*		ContadorArbol c = new ContadorArbol();
		c.numerosPares2(ar);
		while(!c.getL().esVacia()){
			System.out.println(c.getL().proximo());
		}*/
		ProfundidadArbolBinario pruebaPr = new ProfundidadArbolBinario();
		pruebaPr.arbol = ar;
		System.out.println(pruebaPr.sumaElemProf(2));

	}

}
