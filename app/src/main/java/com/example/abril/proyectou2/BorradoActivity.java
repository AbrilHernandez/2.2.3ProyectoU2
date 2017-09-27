package com.example.abril.proyectou2;

/**
 * Created by Abril on 18/09/2017.
 */

public class BorradoActivity {

    //constantes de los campos
    public static final String TABLA_CONTACTOS = "contactos";
    public static final String campo_id = "id";
    public static final String campo_nombre = "nombre";
    public static final String campo_email = "email";
    public static final String campo_tel = "tel";

   public static final String CREAR_TABLA_CONTACTO= "Create table" + TABLA_CONTACTOS+" ("+campo_id+" Integer, "+campo_nombre+
           " TEXT, "+campo_email+" TEXT, "+campo_tel+" TEXT)";
}
