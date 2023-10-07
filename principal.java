import paquetePersona.persona;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class principal{

    public static void main (String[] args) {

        //  Verificamos que el argumento insertado contiene un formato apto
        if (args.length != 1) {
            System.out.println("Por favor, proporciona el nombre del archivo como argumento." +
                               "\nRecuerda que se el nomrbe del archivo contiene espacios debe ser anadido entre comillas: \" \"");
        }else{
            // Capturamos el nombre del archivo y eliminamos todo espacio al inicio y final
            String nombreArchivo = args[0].trim();
        }


        // creo un array de perosonas
        persona[] ipersona = new persona[2];

        ipersona [0]  = new persona ("Brais", "Alonso Almuina", "10/03/2001");
        ipersona [1] = new persona ("Felipe", "Martin Rey", "04/03/2000");


        // imprimo el array (sin ordenar)
        for (int i = 0; i < ipersona.length; i++) {
            System.out.println("Persona " + (i + 1) + ": " + ipersona[i].nombre);
        }


        // pasamos el array a tipo list para poder ordenar sus elementos con el Collections.sort();
        List<persona> listaPersonas = new ArrayList<>();

        for (persona apersona : ipersona) {
            listaPersonas.add(apersona);
        }

        Collections.sort(listaPersonas);

        // Imprimir la lista ordenada
        for (persona bpersona : listaPersonas) {
            System.out.println(bpersona.nombre);
        }

        // Ahora solo hay que hacer lo mismo pero leer los datos de un fichero y rellenarlo con ellos en el orden correcto.






    }

}