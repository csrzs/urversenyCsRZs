package hu.progmatic;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int menuValasztas;
    String stringValasz = "";
    String valasztottUrhajoTipus = "";
    Varos valasztottVaros;

    Urhajo urhajo1 = new Urhajo(2250, "Űrgolyhó", 10, 20, 50);
    Varos varos1 = new Varos("Alfapolisz", 5);
    Varos varos2 = new Varos("Bétapolisz", 10);

    nUrhajoGeneralasa(varos1.getUrhajokSzama(), varos1);
    nUrhajoGeneralasa(varos2.getUrhajokSzama(), varos2);

    varos1.setUrhajo(1, null);
    varos2.setUrhajo(1, null);

    do {
      valasztottVaros = varosValasztas(scanner, varos1, varos2);
      System.out.println(printMenu(valasztottVaros.getNev()));
      menuValasztas = menupontValasztas(scanner, valasztottVaros);
    } while (menuValasztas != 0);
    System.out.println("Viszont látásra!");

    /* ARCHIVÁLT KÓDRÉSZLETEK --------------------------------------------------------------------------------

    System.out.println(varos1.urhajoLista());
    System.out.println(varos2.urhajoLista());

    System.out.println(varos1.leggyorsabbUrhajo());
    System.out.println(varos2.leggyorsabbUrhajo());

    System.out.println(varos1.tipusLista("Alfa-4"));
    System.out.println(varos2.tipusLista("Alfa-5"));

    System.out.println(varos1.gyorshajtokLista());
    System.out.println(varos2.gyorshajtokLista());

    urhajo1.setAktualisSebesseg(2000);
    varos1.setUrhajo(0, urhajo1);

    System.out.println(
            "Építési év: " + varos1.getUrhajo(0).getEpitesiEv() + "\n"
                    + "Típus: " + varos1.getUrhajo(0).getTipus() + "\n"
                    + "Aktuális sebesség: " + varos1.getUrhajo(0).getAktualisSebesseg() + "\n"
                    + "Magasság: " + varos1.getUrhajo(0).getMagassag() + "\n"
                    + "Szélesség: " + varos1.getUrhajo(0).getSzelesseg() + "\n"
                    + "Hosszúság: " + varos1.getUrhajo(0).getHosszusag() + "\n"
                    + "Térfogat: " + varos1.getUrhajo(0).getTerfogat()
    );
    System.out.println();*/
  }

  private static int menupontValasztas(Scanner scanner, Varos valasztottVaros) {
    String valasztottUrhajoTipus;
    int menuValasztas;
    System.out.println("Kérem válasszon a lehetséges menüpontok közül!");
    menuValasztas = scanner.nextInt();
    switch (menuValasztas) {
      case 1:
        System.out.println(valasztottVaros.urhajoLista());
        break;
      case 2:
        System.out.println(valasztottVaros.leggyorsabbUrhajo());
        break;
      case 3:
        System.out.println("Adja meg a szűrni kívánt típust!");
        valasztottUrhajoTipus = scanner.next();
        System.out.println(valasztottVaros.tipusLista(valasztottUrhajoTipus));
        break;
      case 4:
        System.out.println(valasztottVaros.gyorshajtokLista());
        break;
      default:
        break;
    }
    return menuValasztas;
  }

  private static Varos varosValasztas(Scanner scanner, Varos varos1, Varos varos2) {
    Varos valasztottVaros;
    String stringValasz;
    System.out.println("Elérhető városok listája:");
    System.out.println("=========================");
    System.out.println(varos1.getNev());
    System.out.println(varos2.getNev());
    System.out.println("=========================");
    System.out.println("Kérem adja meg melyik város nyilvántartó rendszerébe szeretne belépni!");

    stringValasz = scanner.next();
    switch (stringValasz) {
      case "Alfapolisz":
        valasztottVaros = varos1;
        break;
      case "Bétapolisz":
        valasztottVaros = varos2;
        break;
      default:
        throw new RuntimeException("Nem létező várost adott meg!");
    }
    return valasztottVaros;
  }

  public static String printMenu(String valasztottVaros) {
    String menuRendszer = "";

    menuRendszer += "========================================" + "\n"
            + valasztottVaros + " űrhajó nyilvántartó rendszere" + "\n"
            + "========================================" + "\n"
            + "0. KILÉPÉS" + "\n"
            + "1. Nyilvántartott űrhajók listázása" + "\n"
            + "2. Leggyorsabb űrhajó listázása" + "\n"
            + "3. Adott típusú űrhajók listázása" + "\n"
            + "4. Gyorshajtó űrhajók listázása" + "\n";

    return menuRendszer;
  }

  public static void nUrhajoGeneralasa(int darabszam, Varos celVaros) {
    for (int i = 0; i < darabszam; i++) {
      celVaros.setUrhajo(0 + i, new Urhajo(2250 + i, "Alfa-" + i, 10 + i, 20 + i, 50 + i, (int) (Math.random() * 2501)));
    }
  }
}