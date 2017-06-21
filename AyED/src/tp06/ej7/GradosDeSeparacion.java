package tp06.ej7;

import claseCola.Cola;
import clasesGrafos.Arista;
import clasesGrafos.Grafo;
import clasesGrafos.Vertice;
import clasesListasGenericas.ListaGenerica;

public class GradosDeSeparacion {
	public int maxGrSeparacion(Grafo<String> gr){
		ListaGenerica<Vertice<String>> vertices = gr.listaDeVertices();
		int grMax=0;
		int aux;
		for(int i=1;i<vertices.tamanio();i++){
			aux=maxGr(i,gr);
			if(aux>grMax){
				grMax=aux;
			}
		}
		return grMax;
	}

	private int maxGr(int i, Grafo<String> gr) {
		ListaGenerica<Arista<String>> ady = null;
		boolean[] marca = new boolean[gr.listaDeVertices().tamanio()+1];
		Cola<Vertice<String>> cola = new Cola<Vertice<String>>();
		marca[i]=true;
		cola.encolar(gr.listaDeVertices().elemento(i));
		cola.encolar(null);
		int nivel=0;
		while(!cola.esVacia()){
			Vertice<String> Vact = cola.desencolar();
			if(Vact==null){
				if(!cola.esVacia()){
					cola.encolar(null);
					nivel++;
				}
			}
			else{
				ady=gr.listaDeAdyacentes(Vact);
				ady.comenzar();
				while(!ady.fin()){
					int j=ady.proximo().verticeDestino().posicion();
					if (!marca[j]){
						cola.encolar(ady.elemento(j).verticeDestino());
					}
				}
			}
		}
		boolean conexo=true;
		for(boolean a:marca){
			if(!a){
				conexo=false;
			}
		}
		if (conexo) return nivel;
		else return 0;
	}
}
