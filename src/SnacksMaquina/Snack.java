package SnacksMaquina;

import java.io.Serializable;
import java.util.Objects;

public class Snack implements Serializable {
    private static int contadorSnacks = 0;
    private int idSnacks;
    private String nombre;
    private double precio;

    public Snack() {
        this.idSnacks = ++Snack.contadorSnacks;
    }

    public Snack(String nombre, double precio) {
        this();//llamada a constructor vacio y primer linea llamada a constructor
        this.nombre=nombre;
        this.precio=precio;
    }

    public static int getContadorSnacks() {
        return contadorSnacks;
    }

    public int getIdSnacks() {
        return idSnacks;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "idSnacks=" + idSnacks +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return idSnacks == snack.idSnacks && Double.compare(precio, snack.precio) == 0 && Objects.equals(nombre, snack.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSnacks, nombre, precio);
    }
}
