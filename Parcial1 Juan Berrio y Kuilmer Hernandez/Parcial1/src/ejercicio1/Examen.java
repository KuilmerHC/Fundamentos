package ejercicio1;

/*
 * @author @KuilmerHernandez & @JuanBerrio
 */

import java.time.LocalDate;

public class Examen {
	public int id;
	public LocalDate fecha;
	public TipoExamen tipoExamen;
	public String resultado;

	public Examen(int id, TipoExamen tipoExamen, String resultado) {
		this.id = id;
		this.fecha = LocalDate.now();
		this.tipoExamen = tipoExamen;
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "Examen [id=" + id + ", resultado=" + resultado + "]";
	}
}
