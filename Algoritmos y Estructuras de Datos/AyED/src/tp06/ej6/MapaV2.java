package tp06.ej6;

import clasesGrafos.Arista;
import clasesGrafos.Grafo;
import clasesGrafos.Vertice;
import clasesListasGenericas.ListaEnlazadaGenerica;
import clasesListasGenericas.ListaGenerica;

public class MapaV2 {
	Grafo <String> mapaCiudades;
	
	public Grafo<String> getMapaCiudades() {
		return mapaCiudades;
	}

	public void setMapaCiudades(Grafo<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}

	ListaGenerica <String> camino;				//Ej 6a
	ListaGenerica <String> caminoExceptuando;	//Ej 6b
	ListaGenerica <String> caminoMasCorto;		
	int largoMin;								//Ej 6c
	
	public ListaGenerica <String> devolverCamino(String c1, String c2){
		Vertice <String> vIni = null;
		Vertice <String> vFin = null;
		ListaGenerica <Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
		vertices.comenzar();
		while(!vertices.fin()){
			Vertice <String> vAux = vertices.proximo();
			if(vAux.dato().equals(c1)){
				vIni = vAux;
			}
			if(vAux.dato().equals(c2)){
				vFin = vAux;
			}
		}
		ListaGenerica <String> caminoActual = new ListaEnlazadaGenerica <String>();
		this.camino = new ListaEnlazadaGenerica <String>();
		dfsCamino(vIni,vFin,caminoActual);
		return this.camino;
	}

	private void dfsCamino(Vertice<String> vIni, Vertice<String> vFin, ListaGenerica<String> caminoActual) {
		caminoActual.agregarFinal(vIni.dato());
		if(vIni == vFin){
			this.camino = caminoActual.clonar();
		}
		else{
			ListaGenerica <Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(vIni);
			while(!ady.fin()){
				Vertice <String> vAux = ady.proximo().verticeDestino();
				if(!caminoActual.incluye(vAux.dato())){
					dfsCamino(vAux,vFin,caminoActual);
				}
			}
		}
		caminoActual.eliminarEn(caminoActual.tamanio());
	}
	
	public ListaGenerica <String> devolverCaminoExceptuando(String c1, String c2, ListaGenerica<String> ciudades){
		Vertice <String> vIni = null;
		Vertice <String> vFin = null;
		ListaGenerica <Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
		vertices.comenzar();
		while(!vertices.fin()){
			Vertice <String> vAux = vertices.proximo();
			if(vAux.dato().equals(c1)){
				vIni = vAux;
			}
			if(vAux.dato().equals(c2)){
				vFin = vAux;
			}
		}
		ListaGenerica <String> caminoActual = new ListaEnlazadaGenerica <String>();
		this.caminoExceptuando = new ListaEnlazadaGenerica <String>();
		dfsCaminoExc(vIni,vFin,caminoActual,ciudades);
		return this.caminoExceptuando;
	}

	private void dfsCaminoExc(Vertice<String> vIni, Vertice<String> vFin, ListaGenerica<String> caminoActual, ListaGenerica<String> ciudades) {
		caminoActual.agregarFinal(vIni.dato());
		if(vIni == vFin){
			this.caminoExceptuando = caminoActual.clonar();
		}
		else{
			ListaGenerica <Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(vIni);
			while(!ady.fin()){
				Vertice <String> vAux = ady.proximo().verticeDestino();
				if(!caminoActual.incluye(vAux.dato()) && !ciudades.incluye(vAux.dato())){
					dfsCamino(vAux,vFin,caminoActual);
				}
			}
		}
		caminoActual.eliminarEn(caminoActual.tamanio());
	}

	public ListaGenerica <String> caminoMasCorto(String c1, String c2){
		Vertice <String> vIni = null;
		Vertice <String> vFin = null;
		ListaGenerica <Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
		vertices.comenzar();
		while(!vertices.fin()){
			Vertice <String> vAux = vertices.proximo();
			if(vAux.dato().equals(c1)){
				vIni = vAux;
			}
			if(vAux.dato().equals(c2)){
				vFin = vAux;
			}
		}
		ListaGenerica <String> caminoActual = new ListaEnlazadaGenerica <String>();
		this.largoMin = Integer.MAX_VALUE;
		this.caminoMasCorto = new ListaEnlazadaGenerica <String>();
		dfsCaminoMasCorto(vIni,vFin,caminoActual);
		return this.caminoMasCorto;
	}

	private void dfsCaminoMasCorto(Vertice<String> vIni, Vertice<String> vFin, ListaGenerica<String> caminoActual) {
		caminoActual.agregarFinal(vIni.dato());
		if(vIni == vFin){
			if(caminoActual.tamanio() <= this.largoMin){
				this.caminoMasCorto = caminoActual.clonar();
				this.largoMin = caminoActual.tamanio();
			}
		}
		else{
			ListaGenerica <Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(vIni);
			while(!ady.fin()){
				Vertice <String> vAux = ady.proximo().verticeDestino();
				if(!caminoActual.incluye(vAux.dato())){
					dfsCamino(vAux,vFin,caminoActual);
				}
			}
		}
		caminoActual.eliminarEn(caminoActual.tamanio());
	}
}
