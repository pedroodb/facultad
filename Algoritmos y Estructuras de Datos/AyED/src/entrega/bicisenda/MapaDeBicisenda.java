package entrega.bicisenda;

import clasesGrafos.Arista;
import clasesGrafos.GrafoImplListAdy;
import clasesGrafos.Vertice;
import clasesListasGenericas.ListaEnlazadaGenerica;
import clasesListasGenericas.ListaGenerica;

public class MapaDeBicisenda {
	
	GrafoImplListAdy<String> grafo;
	ListaGenerica<String> camino=new ListaEnlazadaGenerica<String>();
	
	public ListaEnlazadaGenerica<String> buscarCaminoEntreOrigenYDestino (String origen, String destino){
		Vertice<String> vIni = null;
		ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
		vertices.comenzar();
		while(!vertices.fin()){
			Vertice<String> vAux = vertices.proximo();
			if(vAux.dato().equals(origen)){
				vIni=vAux;
			}
		}
		ListaEnlazadaGenerica <String> caminoActual = new ListaEnlazadaGenerica<String>();
		dfs(vIni,caminoActual,destino);
		return (ListaEnlazadaGenerica<String>) this.camino;
	}

	private void dfs(Vertice<String> vIni, ListaEnlazadaGenerica<String> caminoActual, String destino) {
		caminoActual.agregarFinal(vIni.dato());
		if(vIni.dato().equals(destino)){
			this.camino=caminoActual.clonar();
		}
		else{
			ListaGenerica<Arista<String>> ady = this.grafo.listaDeAdyacentes(vIni);
			ady.comenzar();
			while(!ady.fin()&&this.camino.esVacia()){
				Vertice<String> vAux = ady.proximo().verticeDestino();
				if(!caminoActual.incluye(vAux.dato())){
					dfs(vAux,caminoActual,destino);
				}
			}
		}
		caminoActual.eliminarEn(camino.tamanio());
	}
	
}
