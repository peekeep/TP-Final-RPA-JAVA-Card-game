import java.util.Scanner;

public class tpFinal {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String nombreJugador1, nombreJugador2;
        int valorCarta, ronda, rondaMayorPuntaje1, rondaMayorPuntaje2;
        double puntajeAcumulado1, puntajeAcumulado2, mayorPuntaje1, mayorPuntaje2, puntajeRonda1, puntajeRonda2;
        puntajeAcumulado1 = 0;
        puntajeAcumulado2 = 0;
        ronda = 0;
        mayorPuntaje1 = 0;
        mayorPuntaje2 = 0;
        rondaMayorPuntaje1 = 0;
        rondaMayorPuntaje2 = 0;
        puntajeRonda1 = 0;
        puntajeRonda2 = 0;

        System.out.println("Ingrese el nombre del primer jugador: ");
        nombreJugador1 = sc.nextLine();

        System.out.println("Ingrese el nombre del segundo jugador: ");
        nombreJugador2 = sc.nextLine();

        do {
          ronda++;  
          System.out.println("Ronda: "+ronda);
          System.out.println(nombreJugador1+" inicia su turno:");
          do {
            System.out.println("Ingrese el valor de su carta: ");
            valorCarta = sc.nextInt();
            puntajeRonda1 = puntajeRonda1 + calcularPuntaje(valorCarta);
            puntajeAcumulado1 = puntajeAcumulado1 + calcularPuntaje(valorCarta);

            if (finRonda(valorCarta)) {
                System.out.println("Saca "+valorCarta+". Termina su jugada. Puntaje acumulado: "+puntajeAcumulado1);
            }
            else {
                System.out.println("Saca "+valorCarta+". Puntaje acumulado: "+puntajeAcumulado1);
            }
          }
          while (!finRonda(valorCarta));
          if (mayorPuntaje1<puntajeRonda1) {
            mayorPuntaje1 = puntajeRonda1;
            rondaMayorPuntaje1 = ronda;
          }
          puntajeRonda1 = 0;

          System.out.println(nombreJugador2+" inicia su turno:");
          do {
            System.out.println("Ingrese el valor de su carta: ");
            valorCarta = sc.nextInt();
            puntajeRonda2 = puntajeRonda2 + calcularPuntaje(valorCarta);
            puntajeAcumulado2 = puntajeAcumulado2 + calcularPuntaje(valorCarta);

            if (finRonda(valorCarta)) {
                System.out.println("Saca "+valorCarta+". Termina su jugada. Puntaje acumulado: "+puntajeAcumulado2);
            }
            else {
                System.out.println("Saca "+valorCarta+". Puntaje acumulado: "+puntajeAcumulado2);
            }
          }
          while (!finRonda(valorCarta));
          if (mayorPuntaje2<puntajeRonda2) {
            mayorPuntaje2 = puntajeRonda2;
            rondaMayorPuntaje2 = ronda;
          }
          puntajeRonda2 = 0;
        }
        while (!(puntajeAcumulado1>=60 || puntajeAcumulado2>=60));
        if (puntajeAcumulado1>=60 && puntajeAcumulado2<60) {
            System.out.println("El jugador "+nombreJugador1+" gano el juego. Su puntaje acumulado fue de: "+puntajeAcumulado1);
        } else if (puntajeAcumulado2>=60 && puntajeAcumulado1<60) {
                System.out.println("El jugador "+nombreJugador2+" gano el juego. Su puntaje acumulado fue de: "+puntajeAcumulado2);
        } else {
            System.out.println("El juego termina en empate. Puntaje acumulado del jugador 1: "+puntajeAcumulado1+". Puntaje acumulado del jugador 2: "+puntajeAcumulado2);
        }
        System.out.println("Del jugador "+nombreJugador1+", que su mayor puntaje en una ronda es: "+mayorPuntaje1+" fue obtenido en la ronda: "+rondaMayorPuntaje1);
        System.out.println("Del jugador "+nombreJugador2+", que su mayor puntaje en una ronda es: "+mayorPuntaje2+" fue obtenido en la ronda: "+rondaMayorPuntaje2);
        System.out.println("La cantidad de rondas jugadas fue de: "+ronda);

        sc.close();
    }

    public static boolean esPar(int valorCarta) {
        return valorCarta % 2 == 0;
    }

    public static boolean validarCarta(int valorCarta) {
        return valorCarta>=1 && valorCarta<=12;
    }

    public static double calcularPuntaje(int valorCarta) {
        if (!validarCarta(valorCarta) || valorCarta == 1 || valorCarta == 12) {
            return 0;
        }
        if (esPar(valorCarta)) {
            return valorCarta * 2;
        }
        else {
            return valorCarta / 2.0;
        }
    }

    public static boolean finRonda (int valorCarta) {
        return valorCarta == 1 || valorCarta == 12;
    }
}