package CifradoVigeñere;

import java.util.Scanner;

public class CifradoVigenere {
    public static String encryptVigenere(String message, String key) {
        StringBuilder encryptedMessage = new StringBuilder();
        int keyLength = key.length();

        for (int i = 0; i < message.length(); i++) {
            char messageChar = message.charAt(i);
            char keyChar = key.charAt(i % keyLength);

            if (Character.isUpperCase(messageChar)) {
                int offset = (keyChar - 'A' + messageChar - 'A') % 26;
                char encryptedChar = (char) ('A' + offset);
                encryptedMessage.append(encryptedChar);
            } else {

                encryptedMessage.append(messageChar);
            }
        }

        return encryptedMessage.toString();
    }

    public static String decryptVigenere(String encryptedMessage, String key) {
        StringBuilder decryptedMessage = new StringBuilder();
        int keyLength = key.length();

        for (int i = 0; i < encryptedMessage.length(); i++) {
            char encryptedChar = encryptedMessage.charAt(i);
            char keyChar = key.charAt(i % keyLength);

            if (Character.isUpperCase(encryptedChar)) {
                int offset = (encryptedChar - keyChar + 26) % 26;
                char decryptedChar = (char) ('A' + offset);
                decryptedMessage.append(decryptedChar);
            } else {

                decryptedMessage.append(encryptedChar);
            }
        }

        return decryptedMessage.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la clave: ");
        String key = scanner.next().toUpperCase();
        scanner.nextLine();

        System.out.print("Ingrese el mensaje a cifrar: ");
        String message = scanner.next().toUpperCase();

        String encryptedMessage = encryptVigenere(message, key);
        System.out.println("Mensaje cifrado: " + encryptedMessage);

        String decryptedMessage = decryptVigenere(encryptedMessage, key);
        System.out.println("Mensaje descifrado: " + decryptedMessage);

    }
}
