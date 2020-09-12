package ProgramavimoTechnologijos.LD1;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ši klasę atlieka pirmo laboratorinio darbo "Java kalbos pagrindai" užduotys
 * 
 * 
 * @author Evaldas Jankauskas
 */
public class LaboratorinisVienas {
    // Evaldas Jankauskas Prif 18-2 20184390
    public static void main(final String[] args) {

        final Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        final String name = sc.next();
        System.out.println("Enter your surname: ");
        final String surname = sc.next();
        sc.close();

        // #3 Paruošia kintamuosius naudoti toliau užduotyje
        final int n = name.length();
        final int m = surname.length();
        final int a = Wowel(name);
        final int b = n + m;

        // #4 Naudojant dviguba for loop uzpildomas dvigubas masyvas atsitiktiniais
        // skaiciais nuo a iki b ir parodomas masyvas ekrane
        System.out.println("4 uzduotys");
        final int[][] numberArray = new int[n][m];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                // Lenteles uzpildimui
                if (i < n && j < m) {
                    numberArray[i][j] = RandomNumber(a, b);
                }
                // Lenteles rasymui
                if (i == 0 && j == 0) {
                    System.out.print("x " + "\t");
                } else if (i == 0) {
                    System.out.print("[" + (j - 1) + "]" + "\t");
                } else if (j == 0) {
                    System.out.print("[" + (i - 1) + "]" + "\t");
                } else {
                    System.out.print(numberArray[i - 1][j - 1] + " \t");
                }
            }
            System.out.println();
        }

        // #5 Sukuriami masyvai užpildomi ir paduodami į ekraną
        System.out.println("5 uzduotys");
        double[] rowArray = new double[n];
        double[] columnArray = new double[m];
        System.out.print("Eiluciu vidurkiu masyvas: ");
        for (int i = 0; i < n; i++) {
            double avg = 0;
            for (int j = 0; j < m; j++) {
                avg = avg + numberArray[i][j];
            }
            rowArray[i] = avg / m;
            System.out.print(String.format("%.4f ", rowArray[i]));
        }
        System.out.println();
        System.out.print("Stulpeliu vidurkiu masyvas: ");
        for (int i = 0; i < m; i++) {
            double avg = 0;
            for (int j = 0; j < n; j++) {
                avg = avg + numberArray[j][i];
            }
            columnArray[i] = avg / n;
            System.out.print(String.format("%.4f ", columnArray[i]));
        }
        System.out.println();

        // #6 Suranda kiek skaiciu eiluteje yra didesni uz eilutes vidurki
        System.out.println("6 uzduotys");
        for (int i = 0; i < n; i++) {
            int aboveAverage = 0;
            for (int j = 0; j < m; j++) {
                if (numberArray[i][j] > rowArray[i]) {
                    aboveAverage = aboveAverage + 1;
                }
            }
            System.out.println("Skaiciai didesni uz vidurki " + i + " eiluteje :" + aboveAverage);
        }

        // #7 Randa koks didžiausias skaičius dvigubame masyve neiskaitant a eilutes ar
        // stulpelio
        System.out.println("7 uzduotys");
        int max = a;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i != a - 1 || j != a - 1) {
                    if (max < numberArray[i][j]) {
                        max = numberArray[i][j];
                    }
                }
            }
            if (max == b) {
                break;
            }
        }
        System.out.println("Didziausias skaicius neiskaitant " + a + " eilutes ar stuleplio: " + max);

        // #8 Sudeda a eilutes skaičius į naują masyvą ir išrikiavus atspausdina į
        // ekraną
        System.out.println("8 uzduotys");
        int rowOfA[] = new int[m];
        for (int i = 0; i < m; i++) {
            rowOfA[i] = numberArray[a - 1][i];
        }
        Arrays.sort(rowOfA);
        for (int x : rowOfA) {
            System.out.print(x + " ");
        }
        System.out.println();
        // #9 Pirmas loop suranda minimum average stulpeli kitas masyvas suranda tame
        // stulpelyje esanti maziausia numeri
        System.out.println("9 uzduotys");

        double minAverageColumnValue = b;
        int minColumnIndex = 0;
        for (int i = 0; i < m; i++) {
            if (minAverageColumnValue > columnArray[i]) {
                minAverageColumnValue = columnArray[i];
                minColumnIndex = i;
            }
        }
        int minNumber = b;
        int minRowIndex = 0;
        for (int i = 0; i < n; i++) {
            if (minNumber > numberArray[i][minColumnIndex]) {
                minNumber = numberArray[i][minColumnIndex];
                minRowIndex = i;
            }
        }

        System.out.println("Minimalus numeris: " + minNumber + " jo indeksas:[" + minRowIndex + "] [" + minColumnIndex + "]");
    }

    // Suskaiciuojamos balses zodyje
    public static int Wowel(String name) {
        name = name.toLowerCase();
        int wovelcount = 0;
        for (int i = 0; i < name.length(); i++) {
            final char letter = name.charAt(i);
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                wovelcount = wovelcount + 1;
            }
        }
        return wovelcount;
    }

    // Sugeneruojamas atsitiktinis skaicius
    public static int RandomNumber(final int min, final int max) {
        final int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }

}
