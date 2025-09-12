package ejercicio1;
/*
 * @author @KuilmerHernandez & @JuanBerrio
 */

public class Tratamiento {
    private TipoTratamiento tipo;
    private int id;
    private String nombre;
    private int duracionDias;
    private String efectosSecundarios;



    public Tratamiento(TipoTratamiento tipo, int id, String nombre, int duracionDias, String efectosSecundarios) {
        this.tipo = tipo;
        this.id = id;
        this.nombre = nombre;
        this.duracionDias = duracionDias;
        this.efectosSecundarios = efectosSecundarios;
    }
    

}
