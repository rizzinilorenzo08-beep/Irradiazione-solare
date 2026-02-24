import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var inverno = new Stagione(3.0, 5.0, 1.0, 17, 7, 4.25, 4.2, 3.25);
        var estate = new Stagione(5.125, 7.5, 2.0, 20, 6, 4.25, 3.25, 2.5);

        int ora = 0;
        int scelta;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("\n         --MENU--");
            System.out.println("0. esci dalla simulazione");
            System.out.println("1. Simulazione Estate ☀");
            System.out.println("2. Simulazione Inverno ❄");
            System.out.print("Scelta: ");

            scelta = input.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println("Quante ore vuoi simulare?");
                    int timeE = input.nextInt();
                    for (int i = 0; i < timeE; i++) {
                        ora++;
                        estate.calcIrradiazione(ora);
                    }
                    break;
                case 2:
                    System.out.println("Quante ore vuoi simulare?");
                    int timeI = input.nextInt();
                    for (int i = 0; i < timeI; i++) {
                        ora++;
                        inverno.calcIrradiazione(ora);
                    }
                    break;
            }

        } while (scelta != 0);

        input.close();
    }
}