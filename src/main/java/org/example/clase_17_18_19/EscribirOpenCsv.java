package org.example.clase_17_18_19;

import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.ColumnPositionMappingStrategyBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.example.clase_17_18_19.models.Participante;

import java.io.FileWriter;
import java.io.IOException;

public class EscribirOpenCsv {
    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

        // METODO USANDO LIBRERIA CSVWriter

        FileWriter fileWriter = new FileWriter("./src/main/resources/semillero.csv", true);
        CSVWriter csvWriter = (CSVWriter) new CSVWriterBuilder(fileWriter)
                .withQuoteChar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(',').build();

        String[] fila = {"Escribiendo nombre Juan","Clase 19","Funciona"};
        csvWriter.writeNext(fila);
        csvWriter.close();


        // METODO USANDO UTILIDAD FILES CON BEANS de la clase PARTICIPANTE

        //System.out.println("****************************");
        //System.out.println("*PROBANDO BEAN to CSV*");
        //System.out.println("****************************");

        fileWriter = new FileWriter("./src/main/resources/semillero.csv", true);
        //Clase modelo
        Participante participante = new Participante("Juan con bean", "23/12/2023", "PCA");
        //Asigna el orden de las columnas
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategyBuilder<Participante>().build();
        strategy.setType(Participante.class);
        strategy.setColumnMapping("nombre","fechaAsistencia*","area");
        //Creamos el Bean con la mappeo creado anteriormente y con el no_quote_character
        // que quita "" de los datos de entrada el instancias participante
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(fileWriter)
                //.withMappingStrategy(strategy)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
        //Escribimos
        beanToCsv.write(participante);
        //Cerramos escritura
        fileWriter.close();
    }
}
