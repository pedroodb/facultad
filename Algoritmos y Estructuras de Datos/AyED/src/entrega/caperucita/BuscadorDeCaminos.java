package entrega.caperucita;

import clasesGrafos.Arista;
import clasesGrafos.Grafo;
import clasesGrafos.Vertice;
import clasesListasGenericas.ListaEnlazadaGenerica;
import clasesListasGenericas.ListaGenerica;

public class BuscadorDeCaminos {
	private Grafo<String> bosque;
	private ListaGenerica<ListaEnlazadaGenerica<String>> caminosMasSeguro;

	public BuscadorDeCaminos(Grafo<String> bosque) {
		super();
		this.bosque = bosque;
	}
	
	public ListaGenerica<ListaEnlazadaGenerica<String>> recoridoMasSeguro(){
		this.caminosMasSeguro = new ListaEnlazadaGenerica<ListaEnlazadaGenerica<String>>();
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		Vertice<String> Vini = null;
		Vertice<String> Vfin = null;
		ListaGenerica<Vertice<String>> vertices = this.bosque.listaDeVertices();
		vertices.comenzar();
		while(!vertices.fin()){
			Vertice<String> aux = vertices.proximo();
			if(aux.dato()=="Casa Caperucita"){
				Vini = aux;
			}
			if(aux.dato()=="Casa Abuelita"){
				Vfin = aux;
			}
		}
		dfs(Vini,Vfin,camino);
		return this.caminosMasSeguro;
	}

	private void dfs(Vertice<String> Vini, Vertice<String> Vfin, ListaEnlazadaGenerica<String> camino) {
		camino.agregarFinal(Vini.dato());
		if(Vini.dato()==Vfin.dato()){
			this.caminosMasSeguro.agregarFinal((ListaEnlazadaGenerica<String>) camino.clonar());
		}
		else{
			ListaGenerica<Arista<String>> ady = this.bosque.listaDeAdyacentes(Vini);
			ady.comenzar();
			while(!ady.fin()){
				Arista<String> aux = ady.proximo();
				if(aux.peso()<=5 && !camino.incluye(aux.verticeDestino().dato())){
					dfs(aux.verticeDestino(),Vfin,camino);
				}
			}
		}
		camino.eliminarEn(camino.tamanio());
	}
}
