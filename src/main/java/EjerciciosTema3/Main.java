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
                //Invoco el metodo alimentarTamagotchi()
                alimentarTamagotchi();
                break;
            case 3:
                //Invoco al metodo jugar()
                jugar();
                break;
            case 4:
                //Invoco al metodo dormir()
                dormir();
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
        String estadoTamagotchi = "\n--- ESTADO DEL TAMAGOTCHI ---\n"
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
            //Game over finaliza el programa
            System.exit(0);
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
        //Incremento saciedad
        if (saciedad < 10) {
            saciedad+=3;

            //Controlo que no pase del máximo
            if (saciedad > 10) {
                saciedad = 10;
            }

            //Resto diversion
            diversion--;
            if (diversion < 0) {
                diversion = 0;
            }

            //Comer da sueño
            energia--;
            if (energia < 0) {
                energia = 0;
            }

            System.out.println("\nÑam ñam, que rico");
            //Muestro estado actual del Tamagotchi
            mostrarEstado();
        }else {
            System.out.println("\nNo tengo hambre!");
        }
    }

    //Metodo para la opcion jugar del Tamagotchi
    private static void jugar() {
        if (diversion < 10) {
            diversion += 3;
            if (diversion > 10) {
                diversion = 10;
            }

            //Jugar da hambre
            saciedad--;
            if (saciedad < 0) {
                saciedad = 0;
            }

            //Jugar da sueño
            energia--;
            if (energia <0) {
                energia = 0;
            }

            System.out.println("\nA jugar!");
            mostrarEstado();
        }else {
            System.out.println("\nAhora no me apetece jugar.");
        }
    }

    //Metodo para la opcion dormir del Tamagotchi
    private static void dormir() {
        if (energia < 10) {
            energia += 5;
            if (energia > 10) {
                energia = 10;
            }

            saciedad -= 3; //Baja mucho el hambre al dormir
            if (saciedad < 0) {
                saciedad = 0;
            }

            diversion -= 3; //Aburrido estar dormido
            if (diversion < 0) {
                diversion = 0;
            }

            System.out.println("\nZzz....");
            mostrarEstado();
        }else {
            System.out.println("\nNo tengo sueño...");
        }
    }
}
