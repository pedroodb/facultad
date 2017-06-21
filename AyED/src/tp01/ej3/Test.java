package tp01.ej3;

public class Test {

	public static void main(String[] args) {
		Estudiante[] arregloe = new Estudiante[2];
		Profesor[] arreglop = new Profesor[3];
		
		for (int i = 0; i < arregloe.length; i++) {
			arregloe[i] = new Estudiante(null, null, i, null, null);
			arregloe[i].setApellido("Perez");
			arregloe[i].setComision(3);
			arregloe[i].setDireccion("Tolosa");
			arregloe[i].setEmail("eee@gato.com");
			arregloe[i].setNombre("Hector");
		}
		
		for (int i = 0; i < arreglop.length; i++) {
			arreglop[i] = new Profesor();
			arreglop[i].setApellido("Gomez");
			arreglop[i].setCatedra(5);;
			arreglop[i].setDireccion("Puerrto Rico");
			arreglop[i].setEmail("eee@gato.com");
			arreglop[i].setNombre("Norbert");
		}
		
		for (int i = 0; i < arregloe.length; i++) {
			System.out.println(arregloe[i].tusDatos());
		}
		
		for (int i = 0; i < arreglop.length; i++) {
			System.out.println(arreglop[i].tusDatos());
		}
	}

}
