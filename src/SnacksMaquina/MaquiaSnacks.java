package SnacksMaquina;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquiaSnacks {

    public static void main(String[] args) {
        maquinaSnacks();
    }

    public static void maquinaSnacks() {
        var salir = false;
        var consola = new Scanner(System.in);
        //Creamos la lista de productos de tipo snack
        List<Snack> productos = new ArrayList<>();
        System.out.println("*** Maquina de Snacks ***");
        Snacks.mostrarSnack();//Mostramos el inventario
        while (!salir) {
            try {
                var opscion = mostrarMenu(consola);
                salir = ejecutarOpciones(opscion, consola, productos);
            } catch (Exception e) {

            } finally {

            }
        }
    }

    private static int mostrarMenu(Scanner consola) {
        System.out.print("MENU:");
        System.out.println("\n1. Comprar snack \n2. Mostrar ticket \n3. Agregar nuevo Snack \n4. Salir");
        System.out.println("Elige una opcion: ");
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack> productos) {
        var salir = false;
        switch (opcion) {
            case 1:
                comprarSnack(consola, productos);
                break;
            case 2:
                mostrarTicket(productos);
                break;
            case 3:
                agregarSnack(consola);
                break;
            case 4:
                System.out.println("Saliendo del proyecto, regresa pronto");
                salir=true;
                break;
            default:
                System.out.println("Opcion invalida");
        }
        return salir;
    }

    private static void comprarSnack(Scanner consola, List<Snack> productos) {
        System.out.println("Que snack quieres comprar (id)? ");
        var idSnack = Integer.parseInt(consola.nextLine());
        //Validar que el Snack exista en la lista de Snacks
        var snackEcnontrado = false;
        for (var snack : Snacks.getSnacks()) {
            if (idSnack == snack.getIdSnacks()) {
                //Agregamos el snack a la lista de productos
                productos.add(snack);
                System.out.println("OK, Snack agregado : " + snack);
                snackEcnontrado = true;
                break;
            }
        }
        if (!snackEcnontrado) {
            System.out.println("Snack no encontrado: " + idSnack);
        }
    }

    public static void mostrarTicket(List<Snack> productos) {
        var ticket = "*** Ticket de venta***";
        var total = 0.0;
        for (var producto : productos) {
            ticket += "\n\t-" + producto.getNombre() + " -$" + producto.getPrecio();
            total += producto.getPrecio();
        }
        ticket += "\n\t Total= " + total;
        System.out.println(ticket);
    }

    public static void agregarSnack(Scanner consola) {
        System.out.println("Nombre de Snack a agregar: ");
        var nombre=consola.nextLine();
        System.out.println("Precio del Snack: ");
        var precio= Double.parseDouble(consola.nextLine());
        Snacks.agregarSnack(new Snack(nombre, precio));
        System.out.println("Tu Snack se ha agregado correctamente");
        Snacks.mostrarSnack();
    }
}
