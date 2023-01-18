package org.example.clase_17_18_19;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class Escribiendo {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/main/resources/textoEscritura.txt");
            //true : para crear un append, es decir que el texto que
            // se escriba no sobreescriba el que hay y lo agregue al final
        FileWriter fileWriter = new FileWriter(file, true);

        //Escribir con BufferedWriter
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("\nHola escribiendo con BW");
        bufferedWriter.close(); //Hay que cerrar el bufferedWriter

        //Escribir con clase Files
            //Aqui el append es asi: StandardOpenOption.APPEND
        Files.write(file.toPath(), "\nHOLA COMO VAN?".getBytes(), StandardOpenOption.APPEND);



    }
}
