package CifradoEspartano;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CifradoEspartano {
    public List<String>  dividirPalabra(String palabra, int caracteresPorLinea) {
        int indice = 0;
        List<String> lineasDePalabra = new ArrayList<>();
        while (indice < palabra.length()) {
            int fin = Math.min(indice + caracteresPorLinea, palabra.length());
            String linea = palabra.substring(indice, fin);
            lineasDePalabra.add(linea);
            indice = fin;
        }
        return lineasDePalabra;
    }

    public String Encriptar(String palabra, int caracteresPorLinea){

        List<String>palabraDividida = dividirPalabra(palabra, caracteresPorLinea);
        int columnas = palabraDividida.get(0).length();
        StringBuilder palabraReconstruida = new StringBuilder();

        for(int i=0;i<columnas;i++){
            for(int j=0;j<palabraDividida.size();j++){

                if(i<palabraDividida.get(j).length()){
                    palabraReconstruida.append(palabraDividida.get(j).charAt(i));
                }else{
                    palabraReconstruida.append(" ");
                }
            }
        }
        return palabraReconstruida.toString();
    }

    public String Desencriptar(String palabraEncriptada,int columnas) {

        String a = Encriptar(palabraEncriptada, columnas);
        return a;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la palabra a encriptar: ");
        String palabra = scanner.nextLine();

        boolean caracteresPorLineaValido = false;
        int caracteresPorLinea = 0;
        while(!caracteresPorLineaValido){
            System.out.println("Ingrese la cantidad de caracteres por linea: ");
            caracteresPorLinea = scanner.nextInt();
            if(caracteresPorLinea>=2 && caracteresPorLinea<=palabra.length()){
                caracteresPorLineaValido = true;
            }else{
                System.out.println("La cantidad de caracteres por linea debe ser mayor o igual a 2 y menor o igual a la cantidad de caracteres de la palabra");
            }
        }

        CifradoEspartano cifradoEspartano = new CifradoEspartano();
        String palabraEncriptada = cifradoEspartano.Encriptar(palabra,caracteresPorLinea);
        System.out.println(palabraEncriptada);

        System.out.println("Quieres descifrar la palabra? (S/N)");
        String respuesta = scanner.next();
        if(respuesta.equals("S")){

            List<String> dividirPalabra = cifradoEspartano.dividirPalabra(palabra,caracteresPorLinea);
            String descifrado= cifradoEspartano.Desencriptar(palabraEncriptada, dividirPalabra.size());
            System.out.println(descifrado);

        }

    }

}

