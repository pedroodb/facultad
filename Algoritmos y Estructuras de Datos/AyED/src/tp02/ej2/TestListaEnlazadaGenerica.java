package tp02.ej2;
import clasesListasGenericas.*;
import tp01.ej3.*;

public class TestListaEnlazadaGenerica {
	public static void main(String[] args){
	ListaEnlazadaGenerica<Estudiante> l = new ListaEnlazadaGenerica<Estudiante>();
	l.comenzar();
	for (int i=0;i<4;i++){
		Estudiante es = new Estudiante("pedro","dal",4,"d@gm","2bis");
		l.agregarFinal(es);
	}
	for (int i = 0; i < 4; i++) {
		System.out.println(l.proximo().tusDatos());	
	}
	}
}
