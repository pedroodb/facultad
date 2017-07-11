package clasesGrafos;

import claseCola.Cola;
import clasesListasGenericas.ListaEnlazadaGenerica;
import clasesListasGenericas.ListaGenerica;

public class Recorridos<T> {
	public ListaGenerica<T> dfs(Grafo<T> grafo){
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		ListaEnlazadaGenerica<T> lis = new ListaEnlazadaGenerica<T>();
		for(int i=1; i<=grafo.listaDeVertices().tamanio();i++){
			if (!marca[i])
				this.dfs(i, grafo, lis, marca);
		}
		return lis;
	}

	
	private void dfs(int i,Grafo<T> grafo,ListaEnlazadaGenerica<T> lis,boolean[] marca){
		marca[i] = true;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		lis.agregarFinal(v.dato());
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()){
			int j = ady.proximo().verticeDestino().posicion();
			if (!marca[j]){
				this.dfs(j, grafo, lis, marca);
			}
		}
	}
	
	public ListaGenerica<T> bfs(Grafo<T> grafo) {
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		ListaEnlazadaGenerica<T> lis = new ListaEnlazadaGenerica<T>();
		for (int i = 1; i <= marca.length; i++) {
			if (!marca[i])
				this.bfs(i, grafo, lis, marca); //las listas empiezan en la pos 1
		}
		return lis;
	}
	
	private void bfs(int i,Grafo<T> grafo,ListaEnlazadaGenerica<T> lis, boolean[] marca) {
		ListaGenerica<Arista<T>> ady = null;
		Cola<Vertice<T>> q = new Cola<Vertice<T>>();
		q.encolar(grafo.listaDeVertices().elemento(i));
		marca[i] = true;
		while (!q.esVacia()) {
			Vertice<T> v = q.desencolar();
			lis.agregarFinal(v.dato());
			ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<T> arista = ady.proximo();
				int j = arista.verticeDestino().posicion();
				if (!marca[j]) {
					Vertice<T> w = arista.verticeDestino();
					marca[j] = true;
					q.encolar(w);
				}
			}
		}
	}


}

