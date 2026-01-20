package EjerciciosTema3;

import java.util.Scanner;

public class Main {
    // Declaro el Scanner como static para usarlo en toda la clase
    static Scanner scanner = new Scanner(System.in);

    //Variables de estado Tamagotchi (globales y estaticas)
    static int saciedad = 6;
    static int energia = 6;
    static int diversion = 6;

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
                //Invoco al metodo mostrarEstado()
                mostrarEstado();
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

    //Metodo para mostrar los graficos
    private static void mostrarEstado() {
        String estadoTamagotchi = "\n--- ESTADO DEL TAMAGOTCHI ---"
                                + "Nivel de Saciedad: " + saciedad + "\n"
                                + "Nivel de Energía: " + energia + "\n"
                                + "Nivel de Diversión: " + diversion + "\n"
                                + "-------------------------------";

        System.out.println(estadoTamagotchi);

        //Logica de sprites
        if (saciedad == 0 || energia == 0 || diversion == 0) {
            System.out.println(" (x_x) Game Over");
            System.out.println(" /| |\\ ");
            System.out.println("  | |");
        } else if (diversion <= 4) {
            System.out.println(" (-,-) Estoy aburrido");
            System.out.println(" /| |\\ ¡Juega conmigo!");
            System.out.println("  / \\");
        } else if (energia <= 4) {
            System.out.println(" (-_-) Zzz");
            System.out.println(" /|_|\\ ");
            System.out.println("  | |");
        } else if (saciedad <= 4) {
            System.out.println(" (•︵•) Tengo hambre");
            System.out.println(" /|x|\\ ");
            System.out.println("  | |");
        } else {
            //Saciedad, energia y diversion > 5
            System.out.println(" (•‿•)   ¡Estoy feliz!");
            System.out.println(" /|_|\\ ");
            System.out.println("  | |");

        }
    }

    //Metodo para la opcion comer del Tamagotchi
    private static void alimentarTamagotchi() {
        //Bug intencionado 1: sumamos 5 (deberia ser 3)
        if (saciedad < 10) {
            saciedad+=5;

            //Bug intencionado 2: se me 'olvida' llamar a mostrarEstado()

            //Controlo que no pase del máximo
            if (saciedad > 10) {
                saciedad = 10;
            }

            //Resto diversion
            diversion--;
            if (diversion < 0) {
                diversion = 0;
            }

            System.out.println("Ñam ñam, que rico");
        }else {
            System.out.println("No tengo hambre!");
        }
        break;
    }
}
