package entidad;

public class Persona {

	private String DNI;
	private String nombre;
	private String apellido;
	
	public Persona() {}

	
	public Persona(String dni, String nombre, String apellido) {
		super();
		this.DNI = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	//Metodo Tostring
	
	@Override
	public String toString() {
		return nombre + " " + apellido + " - " + DNI;
	}

	//Getters and setters
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dni) {
		this.DNI = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}
