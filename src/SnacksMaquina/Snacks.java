package SnacksMaquina;

import java.util.ArrayList;
import java.util.List;

public class Snacks {
    private static final List<Snack> snacks;

    //Bloque static inicializador
    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Papas", 20));
        snacks.add(new Snack("Refresco", 25));
        snacks.add(new Snack("Semillas", 10));
        snacks.add(new Snack("chocolate", 15));
        snacks.add(new Snack("jugo", 30));
    }

    public static void agregarSnack(Snack snack) {
        snacks.add(snack);
    }

    public static void mostrarSnack() {
        var inventarioSnacks = "";
        for (var snack : snacks) {
            inventarioSnacks += snack.toString()+ "\n";
        }
        System.out.println("---Snacks en el inventario---");
        System.out.println(inventarioSnacks);
    }
    public static List<Snack> getSnacks(){
        return snacks;
    }
}
