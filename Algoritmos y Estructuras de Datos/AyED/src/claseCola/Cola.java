package claseCola;

import clasesListasGenericas.NodoGenerico;

public class Cola<T> {
	
	private NodoGenerico<T> front = null;
	private NodoGenerico<T> rear = null;
	
	public void encolar(T elem) {
		NodoGenerico<T> temp = new NodoGenerico<T>();
		temp.setDato(elem);
		temp.setSiguiente(null);
		if (esVacia()) {
			this.front = this.rear = temp;			
		} else {
			this.rear.setSiguiente(temp);
			this.rear = temp;
		}		
	}
	
	public T desencolar() {
		T temp = this.front.getDato();
		if (this.front == this.rear){
			this.front = this.rear = null;
		}else{
			this.front = this.front.getSiguiente();
		}
		return temp;
	}
	
	public T tope() {
		return this.front.getDato(); 
	}
	
	public boolean esVacia() {
		return this.front == null && this.rear == null;
	}
	
}

