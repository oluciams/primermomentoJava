package proyectotriqui;

import java.util.Scanner;

public class JuegoTriqui {

    static char[][] recuadro = new char[3][3];
    static char jugador = 'X';

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        inicializarRecuadro();
        boolean hayGanador = false;

        System.out.println("Bienvenido vamos a juagar Triqui");
        System.out.println("Con el simbolo de la 'X' es el Jugador 1: X");
        System.out.println("Con el simbolo de la 'O' es el Jugador 2: O");

        while (!hayGanador) {
            System.out.println("\nTurno del jugador " + jugador);
            System.out.println("Por favor ingresa la fila y columna para realizar tu movimiento (ejemplo: 0 0):");
            int fila = sc.nextInt();
            int columna = sc.nextInt();

            movimiento(fila, columna);
            imprimirRecuadro();

            if (verificarGanador()) {
                hayGanador = true;
                jugador = (jugador == 'X') ? 'O' : 'X';
                System.out.println("¡El jugador " + jugador + " ha ganado!");
            }
        }
    }

    static void inicializarRecuadro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                recuadro[i][j] = '-';
            }
        }
    }

    static void imprimirRecuadro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(recuadro[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void movimiento(int fila, int columna) {
        if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && recuadro[fila][columna] == '-') {
            recuadro[fila][columna] = jugador;
            if(jugador == 'X'){
                jugador = 'O';
            } else {
                jugador = 'X';
            }
        } else {
            System.out.println("Movimiento inválido, por favor intenta de nuevo.");
        }
    }

    static boolean verificarGanador() {
        for (int i = 0; i < 3; i++) {
            if (recuadro[i][0] != '-' && recuadro[i][0] == recuadro[i][1] && recuadro[i][0] == recuadro[i][2]) {
                return true;
            }
            if (recuadro[0][i] != '-' && recuadro[0][i] == recuadro[1][i] && recuadro[0][i] == recuadro[2][i]) {
                return true;
            }
        }
        if (recuadro[0][0] != '-' && recuadro[0][0] == recuadro[1][1] && recuadro[0][0] == recuadro[2][2]) {
            return true;
        }
        if (recuadro[0][2] != '-' && recuadro[0][2] == recuadro[1][1] && recuadro[0][2] == recuadro[2][0]) {
            return true;
        }
        return false;
    }
}
