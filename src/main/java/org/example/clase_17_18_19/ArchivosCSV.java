package org.example.clase_17_18_19;

import org.example.clase_17_18_19.models.Participante;

import java.io.*;

public class ArchivosCSV {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/main/resources/semillero.csv");
        FileReader fileReader = new FileReader(file);
        //El bufferer reader necesita un reader, creado anteriormente
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String linea = bufferedReader.readLine(); //Asi omitimos que lea en el while la siguiente linea (nombre,fecha_asistencia,area,)
        while ((linea = bufferedReader.readLine()) != null) { //Desde que no sea nulo (exista el archivo)
            String[] lineaSeparada = linea.split(",");
            if (lineaSeparada.length > 1) {
                Participante participante1 = new Participante(lineaSeparada[0],
                        lineaSeparada[1],lineaSeparada[2]);
                System.out.println(participante1.toString());
            }

        }
    }
}
