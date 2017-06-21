package tp06;

import clasesGrafos.Grafo;
import clasesGrafos.GrafoImplListAdy;
import clasesGrafos.Vertice;
import clasesGrafos.VerticeImplListAdy;
import clasesListasGenericas.ListaGenerica;
import entrega.buscadorCaminos.BuscadorDeCaminos;
import tp06.ej6.MapaV2;

public class Test {

	public static void main(String[] args) {
		Grafo <String> gr = new GrafoImplListAdy <String>();
		Vertice <String> lp = new VerticeImplListAdy <String>("La Plata");
		gr.agregarVertice(lp);
		Vertice <String> pi = new VerticeImplListAdy <String>("Pila");
		gr.agregarVertice(pi);
		Vertice <String> ta = new VerticeImplListAdy <String>("Tandil");
		gr.agregarVertice(ta);
		Vertice <String> ma = new VerticeImplListAdy <String>("Madariaga");
		gr.agregarVertice(ma);
		Vertice <String> le = new VerticeImplListAdy <String>("Lezama");
		gr.agregarVertice(le);
		Vertice <String> mda = new VerticeImplListAdy <String>("Mar de Ajo");
		gr.agregarVertice(mda);
		Vertice <String> mdq = new VerticeImplListAdy <String>("Mar del Plata");
		gr.agregarVertice(mdq);
		Vertice <String> vg = new VerticeImplListAdy <String>("Villa Gessel");
		gr.agregarVertice(vg);
		Vertice <String> pin = new VerticeImplListAdy <String>("Pinamar");
		gr.agregarVertice(pin);
		
		gr.conectar(lp, ta);
		gr.conectar(ta, lp);
		gr.conectar(lp, le);
		gr.conectar(le, lp);
		gr.conectar(le, pi);
		gr.conectar(pi, le);
		gr.conectar(le, mda);
		gr.conectar(mda, le);
		gr.conectar(ta, pi);
		gr.conectar(pi, ta);
		gr.conectar(ta, ma);
		gr.conectar(ma, ta);
		gr.conectar(mdq, ta);
		gr.conectar(ta, mdq);
		gr.conectar(pi, ma);
		gr.conectar(ma, pi);
		gr.conectar(pi, mda);
		gr.conectar(mda, pi);
		gr.conectar(mda, pin);
		gr.conectar(pin, mda);
		gr.conectar(mdq, vg);
		gr.conectar(vg, mdq);
		gr.conectar(pin, ma);
		gr.conectar(ma, pin);
		gr.conectar(pin, vg);
		gr.conectar(vg, pin);
				
		BuscadorDeCaminos bdc = new BuscadorDeCaminos();
		MapaV2 mapa = new MapaV2();
		//ListaGenerica<String> lis = bdc.recorridoQuePasePorAlMenos5(gr);
		mapa.setMapaCiudades(gr);
		ListaGenerica<String> lis;
		/*lis = mapa.devolverCamino("Villa Gessel", "Lezama");
		lis.comenzar();
		while(!lis.fin()){
			String ciu = lis.proximo();
			System.out.println(ciu);
		}*/
		System.out.println("-------------------");
		lis = mapa.caminoMasCorto("La Plata", "Tandil");
		lis.comenzar();
		while(!lis.fin()){
			String ciu = lis.proximo();
			System.out.println(ciu);
		}
	}

}
