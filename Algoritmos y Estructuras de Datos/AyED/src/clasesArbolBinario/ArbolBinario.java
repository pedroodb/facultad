package clasesArbolBinario;

import claseCola.Cola;

public class ArbolBinario<T> {

	private NodoBinario<T> raiz;

	public ArbolBinario(T dato) {
		this.raiz = new NodoBinario<T>(dato);
	}

	private ArbolBinario(NodoBinario<T> nodo) {
		this.raiz = nodo;
	}

	private NodoBinario<T> getRaiz() {
		return raiz;
	}

	public T getDatoRaiz() {
		if (this.getRaiz() != null) {
			return this.getRaiz().getDato();
		} else {
			return null;
		}
	}

	public ArbolBinario<T> getHijoIzquierdo() {
		return new ArbolBinario<T>(this.raiz.getHijoIzquierdo());
	}

	public ArbolBinario<T> getHijoDerecho() {
		return new ArbolBinario<T>(this.raiz.getHijoDerecho());
	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.raiz.setHijoIzquierdo(hijo.getRaiz());
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.raiz.setHijoDerecho(hijo.getRaiz());
	}

	public void eliminarHijoIzquierdo() {
		this.raiz.setHijoIzquierdo(null);
	}

	public void eliminarHijoDerecho() {
		this.raiz.setHijoDerecho(null);
	}

	public boolean esVacio() {
		return this.getDatoRaiz() == null;
	}

	public boolean esHoja() {
		return this.getDatoRaiz() != null && this.getHijoIzquierdo().esVacio() && this.getHijoDerecho().esVacio();
	}

	public int contarHojas() {
		if (this.esVacio()) {
			return 0;
		} else {
			if (this.esHoja()) {
				return 1;
			} else {
				return (this.getHijoDerecho().contarHojas() + this.getHijoIzquierdo().contarHojas());
			}
		}
	}

	public ArbolBinario<T> espejo() {
		if (this.esVacio())
			return this;
		else {
			ArbolBinario<T> aux;
			aux = this.getHijoDerecho();
			this.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
			this.agregarHijoIzquierdo(aux.espejo());
			return this;
		}
	}

	public void recorridoPorNiveles() {
		ArbolBinario<T> arbol = null;
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				System.out.print(arbol.getDatoRaiz());
				if (!arbol.getHijoIzquierdo().esVacio()) {
					cola.encolar(arbol.getHijoIzquierdo());
				}
				if (!arbol.getHijoDerecho().esVacio()) {
					cola.encolar(arbol.getHijoDerecho());
				}
			}
			else if (!cola.esVacia()) {
					System.out.println(" ");
					cola.encolar(null);
			}
		}
	}

	public void recorridoEntreNiveles(int n,int m) {
		int i=0;
		ArbolBinario<T> arbol = null;
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				if(i>=n && i<=m){
					System.out.print(arbol.getDatoRaiz());
				}
				if (!arbol.getHijoIzquierdo().esVacio()) {
					cola.encolar(arbol.getHijoIzquierdo());
					if (!arbol.getHijoDerecho().esVacio()) {
						cola.encolar(arbol.getHijoDerecho());
					}
					else {
						if (!cola.esVacia()) {
							System.out.println();
							cola.encolar(null);
							i++;
						}
					}
				}
			}
		}
	}
	
	public boolean esArbolCreciente(){
		int nivel = 0,cantidad = 0;
		boolean si = true;
		ArbolBinario<T> arbol = null;
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia()&&si){
			arbol = cola.desencolar();
			if(arbol!=null){
				cantidad++;
				if(!arbol.getHijoDerecho().esVacio()){
					cola.encolar(arbol.getHijoDerecho());
				}
				if(!arbol.getHijoIzquierdo().esVacio()){
					cola.encolar(arbol.getHijoIzquierdo());
				}
			}
			else{
				if(!cola.esVacia()){
					cola.encolar(null);
				}
				si = (nivel==cantidad-1);
				cantidad = 0;
				nivel++;
			}
		}
		return si;
	}
	
	public int nodosPares(){
		int cant=0;
		if(!this.getHijoIzquierdo().esVacio()){
			cant+=this.getHijoIzquierdo().nodosPares();
		}
		if((!this.getHijoIzquierdo().esVacio()&&!this.getHijoDerecho().esVacio())||(this.esHoja())) {
			cant++;
		}
		if(!this.getHijoDerecho().esVacio()){
			cant+=this.getHijoDerecho().nodosPares();
		}
		return cant;
	}
}
