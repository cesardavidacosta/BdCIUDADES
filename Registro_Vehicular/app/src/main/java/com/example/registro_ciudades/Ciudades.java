package com.example.registro_ciudades;

import androidx.annotation.NonNull;

public class Ciudades {
    private int Id;
    private String Nombre;
    private int Latitud;
    private int Longitud;
    private int Poblacion;

    public Ciudades() {

    }

    public Ciudades(int id, String nombre, int latitud, int longitud, int poblacion) {
        Id = id;
        Nombre = nombre;
        Latitud = latitud;
        Longitud = longitud;
        Poblacion = poblacion;
    }


    @Override
    public String toString() {
        return "Resultado:  "  + '\'' +
                "Id = " + Id + '\''  +
                ", Nombre = "  + Nombre  + '\'' +
                ", Longitud = "  + Longitud  + '\'' +
                ", Latitud = "  + Latitud  + '\'' +
                ", Poblacion actual = "  + Poblacion + '\'' ;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getLatitud() {
        return Latitud;
    }

    public void setLatitud(int latitud) {
        Latitud = latitud;
    }

    public int getLongitud() {
        return Longitud;
    }

    public void setLongitud(int longitud) {
        Longitud = longitud;
    }

    public int getPoblacion() {
        return Poblacion;
    }

    public void setPoblacion(int poblacion) {
        Poblacion = poblacion;
    }

}
