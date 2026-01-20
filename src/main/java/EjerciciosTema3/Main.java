package EjerciciosTema3;

import java.util.Scanner;

public class Main {
    // Declaro el Scanner como static para usarlo en toda la clase
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Variables
        int opcion;

        // Bucle hasta que el usuario elija Salir (0)
        do {
            opcion = menuPrincipal();
            System.out.println("Has elegido la opción: " + opcion);
            procesarOpcion(opcion);
        } while (opcion != 0);
    }

    //Metodo para mostrar el menu principal
    private static int menuPrincipal() {
        int opcion;
        String menu = "1. Estado\n"
                    + "2. Comer\n"
                    + "3. Jugar\n"
                    + "4. Dormir\n"
                    + "-----------\n"
                    + "0. Salir\n";

        do {
            System.out.println(menu);
            System.out.print("Seleccione un opción del menú: ");
            opcion = scanner.nextInt();
            //Muestro mensaje si no es una opcion valida
            if (opcion < 0 || opcion > 4) {
                System.out.println(opcion + " no és una ópcion válida");
            }
        }while (opcion < 0 || opcion > 4);

        return opcion;
    }

    //Metodo para procesar la opcion
    private static void procesarOpcion(int opcion) {
        //Proceso la opcion seleccionada con switch case
        switch (opcion) {
            case 1:
                //Estado
                System.out.println("opcion 1");
                break;
            case 2:
                //Comer
                System.out.println("opcion 2");
                break;
            case 3:
                //Jugar
                System.out.println("opcion 3");
                break;
            case 4:
                //Dormir
                System.out.println("opcion 4");
                break;
            case 0:
                System.out.println("Bye");
                break;
            default:
                System.out.println(opcion + " no és una ópcion válida");
                break;
        }
    }
}
