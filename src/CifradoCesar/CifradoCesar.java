package CifradoCesar;

import java.util.Scanner;

public class CifradoCesar {

    public static String cifrarMensajeCesar(String mensaje, int desplazamiento, char direccion) {
        StringBuilder mensajeCifrado = new StringBuilder();
        int direccionInt = (direccion == 'D') ? 1 : -1; // 1 para derecha, -1 para izquierda

        for (int i = 0; i < mensaje.length(); i++) {
            char caracter = mensaje.charAt(i);

            if (Character.isLetter(caracter)) {
                char base = Character.isLowerCase(caracter) ? 'a' : 'A';
                char cifrado = (char) (base + ((caracter - base + desplazamiento * direccionInt + 26) % 26));
                mensajeCifrado.append(cifrado);
            } else {
                mensajeCifrado.append(caracter);
            }
        }

        return mensajeCifrado.toString();
    }

    public static String descifrarMensajeCesar(String mensajeCifrado, int desplazamiento, char direccion) {
        StringBuilder mensajeDescifrado = new StringBuilder();
        int direccionInt = (direccion == 'D') ? -1 : 1;

        for (int i = 0; i < mensajeCifrado.length(); i++) {
            char caracter = mensajeCifrado.charAt(i);

            if (Character.isLetter(caracter)) {
                char base = Character.isLowerCase(caracter) ? 'a' : 'A';
                char descifrado = (char) (base + (caracter - base + desplazamiento * direccionInt) % 26);
                mensajeDescifrado.append(descifrado);
            } else {
                mensajeDescifrado.append(caracter);
            }
        }

        return mensajeDescifrado.toString();
    }


    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);
        System.out.println("Ingrese el mensaje a cifrar: ");
        String mensaje = Scanner.nextLine();

        System.out.print("Ingresa el valor de desplazamiento: ");
        int desplazamiento = Scanner.nextInt();

        System.out.print("¿Cifrar a la derecha (D) o a la izquierda (I)? ");
        char direccion = Scanner.next().toUpperCase().charAt(0);

        String mensajeCifrado = cifrarMensajeCesar(mensaje, desplazamiento, direccion);
        System.out.println(mensajeCifrado);

        String mensajeDescifrado = descifrarMensajeCesar(mensajeCifrado, desplazamiento, direccion);
        System.out.println(mensajeDescifrado);
    }
}
