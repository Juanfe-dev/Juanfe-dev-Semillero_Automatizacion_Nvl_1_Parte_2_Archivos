package org.example.clase_17_18_19.models;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class Participante {

    //@CsvBindByName
    @CsvBindByPosition(position = 0)
    private String nombre;
    //@CsvBindByName(column = "fecha_asistencia")
    @CsvBindByPosition(position = 1)
    private String fechaAsistencia;
    //@CsvBindByName
    @CsvBindByPosition(position = 2)
    private String area;

    //OBLIGATORIO PARA EL MATCH BEAN
    public Participante(){}

    public Participante(String nombre, String fechaAsistencia, String area) {
        this.nombre = nombre;
        this.fechaAsistencia = fechaAsistencia;
        this.area = area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(String fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "nombre='" + nombre + '\'' +
                ", fechaAsistencia='" + fechaAsistencia + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
