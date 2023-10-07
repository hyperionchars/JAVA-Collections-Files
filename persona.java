package paquetePersona;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;


public class persona implements Comparable<persona>{

    public String nombre;
    public String apellidos;
    public String fechaNacimiento;

    public persona(String nombre, String apellidos, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }


    // clase para convesion de fechas a formato comparable
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    // implementeamos el metodo compareTo para poder manejar el metodo Collections.sort
    public int compareTo(persona Aux) {

        // Downcasting
        // persona Aux = (persona) auxObject;

        try {
            Date fechaThis = sdf.parse(this.fechaNacimiento);
            Date fechaAux = sdf.parse(Aux.fechaNacimiento);

            // Comparar las fechas
            if (fechaThis.before(fechaAux)) {
                return -1;
            } else if (fechaThis.after(fechaAux)) {
                return 1;
            } else {
                return 0;
            }
        } catch (ParseException e) {
            System.err.println("Error al analizar las fechas: " + e.getMessage());
            return 0;
        }

    }

}