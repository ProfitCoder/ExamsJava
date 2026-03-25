//Pablo Manuel Fernández Velázquez

import java.util.regex.*;
import java.util.Scanner;

public class EjercicioPrueba {

    public static void main(String[] args) {

        char[][] tabla = {
            {'A','B','C','D','E'},
            {'F','G','H','I','K'},
            {'L','M','N','O','P'},
            {'Q','R','S','T','U'},
            {'V','W','X','Y','Z'}
        };

        Scanner sc = new Scanner(System.in);
        
        String regex = "[a-zA-Z]+";
        String mensaje;
        String resultado = "";
        boolean valido = false;

        
        do {
            System.out.print("\nMensaje a cifrar: ");
            mensaje = sc.nextLine().toUpperCase();
            mensaje = mensaje.replace('J', 'I');

            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(mensaje);

            if (!m.matches()) {
                System.out.println("Solo se permiten letras y espacios.");
                continue;
            }

            resultado = "";

            for (int i = 0; i < mensaje.length(); i++) {
                char letra = mensaje.charAt(i);

                if (letra == ' ') {
                    resultado += " ";
                    continue;
                }

                boolean encontrada = false;

                for (int fila = 0; fila < 5 && !encontrada; fila++) {
                    for (int col = 0; col < 5; col++) {
                        if (tabla[fila][col] == letra) {
                            resultado += (fila + 1);
                            resultado += (col + 1);
                            encontrada = true;
                            break;
                        }
                    }
                }
            }

            System.out.println("\nMensaje cifrado: " + resultado);
            valido = true;

        } while (!valido);

        System.out.println("\nPrograma terminado.");
        sc.close();
    }
}



