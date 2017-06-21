package tp06.ej6;

import clasesGrafos.Arista;
import clasesGrafos.Grafo;
import clasesGrafos.Vertice;
import clasesListasGenericas.ListaEnlazadaGenerica;
import clasesListasGenericas.ListaGenerica;

public class Mapa {
	Grafo<String> mapaCiudades;
	
	public ListaGenerica<String> devolverCamino(String c1, String c2){
		Vertice<String> Vini = null;
		Vertice<String> Vfin = null;
		ListaGenerica<Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
		vertices.comenzar();
		boolean ok = true;
		Vertice<String> Vaux;
		while(!vertices.fin() && ok==true){
			Vaux = vertices.proximo();
			if(Vaux.dato()==c1){
				Vini=Vaux;
			}
			if(Vaux.dato()==c2){
				Vfin=Vaux;
			}
			if(Vini!=null && Vfin!=null){
				ok = false;
			}
		}
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		boolean[] marca = new boolean[vertices.tamanio()+1];
		for(boolean eachPos : marca){
			eachPos = false;
		}
		return DevCamDFS(camino,marca,Vini,Vfin);
	}

	private ListaGenerica<String> DevCamDFS(ListaGenerica<String> camino, boolean[] marca, Vertice<String> Vini, Vertice<String> Vfin) {
		camino.agregarFinal(Vini.dato());
		marca[Vini.posicion()] = true;
		ListaGenerica<String> caminoAux = null;
		if(Vini.dato()==Vfin.dato()){
			caminoAux = camino;
		}
		else{
			ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(Vini);
			ady.comenzar();
			boolean seguir = true;
			while(!ady.fin() && seguir){
				Vertice<String> vAux = ady.proximo().verticeDestino();
				if(!marca[vAux.posicion()]){
					caminoAux = DevCamDFS(camino,marca,vAux,Vfin);
					if(!caminoAux.esVacia()){
						seguir = false;
					}
				}
			}
		}
		return caminoAux;
	}
	
	public ListaGenerica<String> devolverCaminoExceptuando(String c1, String c2, ListaGenerica<String> ciudades){
		Vertice<String> Vini = null;
		Vertice<String> Vfin = null;
		ListaGenerica<Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
		vertices.comenzar();
		boolean ok = true;
		Vertice<String> Vaux;
		while(!vertices.fin() && ok==true){
			Vaux = vertices.proximo();
			if(Vaux.dato()==c1){
				Vini=Vaux;
			}
			if(Vaux.dato()==c2){
				Vfin=Vaux;
			}
			if(Vini!=null && Vfin!=null){
				ok = false;
			}
		}
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		boolean[] marca = new boolean[vertices.tamanio()+1];
		for(boolean eachPos : marca){
			eachPos = false;
		}
		ciudades.comenzar();
		String ciudadAct;
		while(!ciudades.fin()){
			ciudadAct = ciudades.proximo();
			vertices.comenzar();
			ok = true;
			while(ok){
				Vaux = vertices.proximo();
				if(Vaux.dato()==ciudadAct){
					ok = false;
					marca[Vaux.posicion()] = true;
				}
			}
		}
		return DevCamDFS(camino,marca,Vini,Vfin);
	}
	
	public ListaGenerica<String> devolverCaminoMasCorto(String c1, String c2){
		Vertice<String> Vini = null;
		Vertice<String> Vfin = null;
		ListaGenerica<Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
		vertices.comenzar();
		boolean ok = true;
		Vertice<String> Vaux;
		while(!vertices.fin() && ok==true){
			Vaux = vertices.proximo();
			if(Vaux.dato()==c1){
				Vini=Vaux;
			}
			if(Vaux.dato()==c2){
				Vfin=Vaux;
			}
			if(Vini!=null && Vfin!=null){
				ok = false;
			}
		}
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		boolean[] marca = new boolean[vertices.tamanio()+1];
		for(boolean eachPos : marca){
			eachPos = false;
		}
		return DevCamMasCortoDFS(camino,marca,Vini,Vfin);
	}
	
	private ListaGenerica<String> DevCamMasCortoDFS(ListaGenerica<String> camino, boolean[] marca, Vertice<String> Vini, Vertice<String> Vfin) {
		camino.agregarFinal(Vini.dato());
		marca[Vini.posicion()] = true;
		ListaGenerica<String> caminoAux = null;
		ListaGenerica<String> caminoMin = null;
		if(Vini.dato()==Vfin.dato()){
			caminoMin = camino;
		}
		else{
			ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(Vini);
			ady.comenzar();
			int largo = Integer.MAX_VALUE;
			while(!ady.fin()){
				Vertice<String> vAux = ady.proximo().verticeDestino();
				if(!marca[vAux.posicion()]){
					caminoAux = DevCamDFS(camino,marca,vAux,Vfin);
					if(!caminoAux.esVacia() && caminoAux.tamanio()<=largo){
						largo = caminoAux.tamanio();
						caminoMin = caminoAux;
					}
				}
			}
		}
		return caminoMin;
	}
}
