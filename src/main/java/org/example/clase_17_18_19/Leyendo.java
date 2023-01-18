package org.example.clase_17_18_19;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class Leyendo {
    public static void main(String[] args) {

        //Ruta relativa
        File fileRel = new File("./src/main/resources/texto.txt");
        System.out.println(fileRel.exists());

        //Ruta absoluta
        File fileAbs = new File("C:\\Users\\jgomez\\Documents\\Semillero_Automatizacion_SC\\semillero_automatizacion_nvl_1_sc_parte_2\\src\\main\\resources\\texto.txt");
        System.out.println(fileAbs.exists());

        //Crear nuevo file
        try {
            fileRel.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Consultar la ruta absoluta
        System.out.println(fileRel.getAbsolutePath());

        //Leer archivo
            // OPCION 1: Con BufferedReader

            //Try catch para existencia/no existencia de archivo
        try {
            //Creamos el reader
            FileReader fileReader = new FileReader(fileRel);
            //El bufferer reader necesita un reader, creado anteriormente
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null){ //Desde que no sea nulo (exista el archivo)
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Leer archivo
            // OPCION 2: Clase Files

            //Recibe un path y un charset
        try {
            //Charset.defaultCharset() = toma el charset del sistema
                //Otras opciones:
                    // StandardCharsets.UTF_8
                    // StandardCharsets.ISO_8859_1
            for (String linea:Files.readAllLines(fileRel.toPath(), Charset.defaultCharset()))
            {
                System.out.println(linea);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}