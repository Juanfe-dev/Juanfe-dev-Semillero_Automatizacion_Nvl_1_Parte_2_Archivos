package org.example.clase_17_18_19;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import org.example.clase_17_18_19.models.Participante;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LeerArchivoOpenCsv {

    public static void main(String[] args) throws IOException, CsvException {

        // METODO USANDO LIBRERIA CSVReader

        //File file = new File("./src/main/java/resources/semillero.csv");
        //Con la siguiente linea reemplazamos la linea anterior
        FileReader fileReader = new FileReader("./src/main/resources/semillero.csv");
        //Creamos objeto CSV, el .build lo construye por defecto pero hay mas opciones de preconfiguración
        CSVReader csvReader = new CSVReaderBuilder(fileReader).build();
        //csvReader.readAll(); //retorna una lista de vectores por eso hay que crear la lista de vectores de string
        List<String[]> rows = csvReader.readAll();
        for (String[] row : rows ) {
            for (int i = 0; i < row.length; i++) {
                System.out.println(row[i]);
            }
        }

        // METODO USANDO UTILIDAD FILES CON BEANS de la clase PARTICIPANTE

        System.out.println("****************************");
        System.out.println("*PROBANDO BEAN*");
        System.out.println("****************************");

        //Hacemos match con la clase Participante
        //Se requiere que la clase para el bean (Participante) debe tener un constructor vacio
        FileReader fileReader2 = new FileReader("./src/main/resources/semillero.csv");
        CsvToBean csvToBean = new CsvToBeanBuilder(fileReader2)
                .withType(Participante.class)
                .build();
        List<Participante> listaObtenidaCSV = csvToBean.parse();
        for (Participante participante: listaObtenidaCSV
             ) {
            System.out.println(participante);
        }
    }

}
