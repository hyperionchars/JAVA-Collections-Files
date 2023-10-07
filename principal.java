import paquetePersona.persona;

import java.io.*;
import java.util.*;





public class principal{

    public static void main (String[] args) throws IOException {

        String nombreDelArchivo = "0";

        //  Verificamos que el argumento insertado contiene un formato apto
        if (args.length != 1) {
            System.out.println("Por favor, proporciona el nombre del archivo como argumento." +
                               "\nRecuerda que se el nombre del archivo contiene espacios debe ser anadido entre comillas: \" \"");
            System.exit(1);
        }else{
            // Capturamos el nombre del archivo y eliminamos todo espacio al inicio y final
            nombreDelArchivo = args[0].trim();
        }

        // Verificar si el archivo no existe
        File ifile = new File(nombreDelArchivo);
        if (!ifile.exists()) {
            System.out.println("El archivo '" + nombreDelArchivo + "' no existe.");
            System.exit(1);
        }

        // Lectura de datos del fichero dado
        List<String> datos = leerDatosDesdeArchivo (nombreDelArchivo);

        // imprimo datos capturados
        for (int i = 0; i < datos.size(); i++) {
            System.out.println("Fila " + (i + 1) + ": " + datos.get(i));
        }

        // Genero una instacia de cada persona por fila
        persona[] ipeople = new persona[datos.size()];
        for (int i = 0; i < datos.size(); i++) {

            // Dividimos filas por *
            String[] partes = datos.get(i).split("\\*");
            // Creamos personas
            ipeople[i]  = new persona (partes[0].trim(), partes[1].trim(), partes[2].trim());

        }


        // creo un array de perosonas
        persona[] ipersona = new persona[2];

        ipersona [0]  = new persona ("Brais", "Alonso Almuina", "10/03/2001");
        ipersona [1] = new persona ("Felipe", "Martin Rey", "04/03/2000");


        // Imprimo datos almacenados
        for (int i = 0; i < ipeople.length; i++) {
            System.out.println("Persona " + (i + 1) + ": Nombre-> " + ipeople[i].nombre + " ,Apellidos-> " + ipeople[i].apellidos + ", Nacimiento-> " + ipeople[i].fechaNacimiento);
        }


        // pasamos el array a tipo list para poder ordenar sus elementos con el Collections.sort();
        List<persona> ilistaPersonas = new ArrayList<>();
        List<persona> listaPersonas = new ArrayList<>();

        for (persona apersona : ipeople) {
            ilistaPersonas.add(apersona);
        }
        for (persona apersona : ipersona) {
            listaPersonas.add(apersona);
        }

        Collections.sort(ilistaPersonas);
        Collections.sort(listaPersonas);




        // Imprimir la lista ordenada
        for (persona bpersona : ilistaPersonas) {
            System.out.println(bpersona.nombre);
        }
        // Imprimir la lista ordenada
        for (persona bpersona : listaPersonas) {
            System.out.println(bpersona.nombre);
        }





        // Me quede aqui: conversion de lista s y paso a fichero.
        // Llena la lista ilistaPersonas con objetos Persona...


        List<String> datos2 = new ArrayList<>();

        for (persona ypersona : ilistaPersonas) {

            datos2.add(ypersona.nombre + " " + ypersona.apellidos + " " + ypersona.fechaNacimiento);

        }


        // sobre escribimos el archivo:
        writeDataToFile(nombreDelArchivo, datos2);







    } // main

    public static List<String> leerDatosDesdeArchivo(String nombreArchivo) throws IOException {
        List<String> datos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nombreArchivo), "ISO-8859-1"))) {
        // try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                datos.add(linea);
            }
        }

        return datos;
    }


    /**
     * This method is takes care of write data overwriting a file exist.
     *
     * El archivo que se va a sobrescribir debe tener un juego de caracteres ISO-8859-1.
     *
     * @param nombreArchivo Descripción del primer parámetro.
     * @param parametro2 Descripción del segundo parámetro.
     * @return Descripción del valor de retorno (si el método devuelve algo).
     * @throws ExcepcionPersonalizada Descripción de la excepción (si el método la lanza).
     */
    public static void writeDataToFile (String nombreArchivo, List<String> datos) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nombreArchivo), "ISO-8859-1"))) {
        // try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String linea : datos) {
                bw.write(linea);
                bw.newLine();
            }
        }
    }



}// class