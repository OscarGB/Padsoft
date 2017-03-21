package persona;

import java.time.LocalDate;

public class Profesor extends Persona {
	public Profesor(String nia, String password){
		super(nia, "Profesor", password, LocalDate.now().toString());
	}
}
