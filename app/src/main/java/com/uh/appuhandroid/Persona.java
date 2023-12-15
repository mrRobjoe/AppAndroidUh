package com.uh.appuhandroid;

import java.io.Serializable;

//se convierte clase a implements Serializable
//serializable es la capacidad de transformar un objeto de una clase, en otro objeto
// en otro sitio donde se volverá a utilizar
public class Persona implements Serializable {
    public String nombre;
    public byte edad;
    public String identificacion;
    public String residencia;
}
