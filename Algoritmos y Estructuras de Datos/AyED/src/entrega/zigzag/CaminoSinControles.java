package entrega.zigzag;

import clasesGrafos.Arista;
import clasesGrafos.Grafo;
import clasesGrafos.Vertice;
import clasesListasGenericas.ListaEnlazadaGenerica;
import clasesListasGenericas.ListaGenerica;

public class CaminoSinControles {
	
	Grafo<String> mapa;
	
	public ListaGenerica<ListaGenerica<String>> devolverCaminos(String origen, String destino){
		ListaGenerica<ListaGenerica<String>> caminos = new ListaEnlazadaGenerica<ListaGenerica<String>>();
		Vertice<String> vIni = null;
		Vertice<String> vFin = null;
		ListaGenerica<Vertice<String>> vertices = this.mapa.listaDeVertices();
		vertices.comenzar();
		while(!vertices.fin()){
			Vertice<String> vAux = vertices.proximo();
			if(vAux.dato().equals(origen)){
				vIni=vAux;
			}
			if(vAux.dato().equals(destino)){
				vFin=vAux;
			}
		}
		ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<String>();
		dfs(vIni,vFin,caminoActual,caminos);
		return caminos;
	}

	private void dfs(Vertice<String> vIni, Vertice<String> vFin, ListaGenerica<String> caminoActual,ListaGenerica<ListaGenerica<String>> caminos) {
		caminoActual.agregarFinal(vIni.dato());
		if(vIni==vFin){
			caminos.agregarFinal(caminoActual.clonar());
		}
		else{
			ListaGenerica<Arista<String>> ady = this.mapa.listaDeAdyacentes(vIni);
			ady.comenzar();
			while(!ady.fin()){
				Arista<String> arAux = ady.proximo();
				if(arAux.peso()!=0){
					Vertice<String> vAux = arAux.verticeDestino();
					if(!caminoActual.incluye(vAux.dato())){
						dfs(vAux,vFin,caminoActual,caminos);
					}
				}
			}
		}
		caminoActual.eliminarEn(caminoActual.tamanio());
	}

}
