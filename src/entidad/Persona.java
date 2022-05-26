package entidad;

public class Persona {

	private String DNI;
	private String Nombre;
	private String Apellido;
	
	public Persona() {}

	
	
	
	public Persona(String dNI, String nombre, String apellido) {
		super();
		DNI = dNI;
		Nombre = nombre;
		Apellido = apellido;
	}




	//Metodo Tostring
	
	@Override
	public String toString() {
		return "Persona [DNI=" + DNI + ", Nombre=" + Nombre + ", Apellido=" + Apellido + "]";
	}




	//Getters and setters
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	
	
}
