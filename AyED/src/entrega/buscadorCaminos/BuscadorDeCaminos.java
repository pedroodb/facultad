package entrega.buscadorCaminos;

import clasesGrafos.Arista;
import clasesGrafos.Grafo;
import clasesGrafos.Vertice;
import clasesListasGenericas.ListaEnlazadaGenerica;
import clasesListasGenericas.ListaGenerica;

public class BuscadorDeCaminos {
	ListaGenerica <String> camino;
	
	public ListaGenerica <String> recorridoQuePasePorAlMenos5(Grafo <String> ciudades){
		Vertice <String> vIni = null;
		Vertice <String> vFin = null;
		ListaGenerica <Vertice<String>> vertices = ciudades.listaDeVertices();
		vertices.comenzar();
		while(!vertices.fin()){
			Vertice <String> vAux = vertices.proximo();
			if(vAux.dato().equals("La Plata")){
				vIni = vAux;
			}
			if(vAux.dato().equals("Madariaga")){
				vFin = vAux;
			}
		}
		this.camino = new ListaEnlazadaGenerica <String>();
		ListaGenerica <String> caminoActual = new ListaEnlazadaGenerica <String>();
		dfs(vIni,vFin,caminoActual,ciudades);
		return this.camino;
	}

	private void dfs(Vertice<String> vIni, Vertice<String> vFin, ListaGenerica<String> caminoActual, Grafo<String> ciudades) {
		caminoActual.agregarFinal(vIni.dato());
		if(vIni == vFin){
			if(caminoActual.tamanio() >= 5){
				this.camino = caminoActual.clonar();
			}
		}
		else{
			ListaGenerica <Arista<String>> ady = ciudades.listaDeAdyacentes(vIni);
			while(!ady.fin()){
				Vertice <String> vAux = ady.proximo().verticeDestino();
				if(!caminoActual.incluye(vAux.dato()) && !vAux.dato().equals("Tandil")){
					dfs(vAux,vFin,caminoActual,ciudades);
				}
			}
		}
		caminoActual.eliminarEn(caminoActual.tamanio());
	}

}
