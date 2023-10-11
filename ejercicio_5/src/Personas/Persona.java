package Personas;

/**
 * Esta clase denominada Persona modela una persona que cuenta con
 * los atributos: nombre, apellidos, telefono y direccion.
 * @version 1.2/2020
 */
public class Persona {
    String nombre; // Atributo que identifica el nombre de una persona
    String apellidos; /* Atributo que identifica los apellidos de una
    persona */
    String telefono; // Atributo que identifica el telefono de una persona
    String direccion; /* Atributo que identifica la direccion de una
    persona */

    /**
     * Constructor de la clase Persona
     * @param nombre Parametro que define el nombre de una persona
     * @param apellidos Parametro que define los apellidos de una
     * persona
     * @param telefono Parametro que define el telefono de una persona
     * @param direccion Parametro que define la direccion de una
     * persona
     */
    public Persona(String nombre, String apellidos, String telefono,
                   String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
    }
}
