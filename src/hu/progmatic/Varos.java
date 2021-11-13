package hu.progmatic;

import java.util.Arrays;

public class Varos {
  public static int sebesseghatar = 1500;
  private final String nev;
  private int urhajokSzama;
  private Urhajo[] urhajokListaja;

  // KONSTRUKTOROK ---------------------------------------------------------------

  public Varos(String nev) {
    this.nev = nev;
  }

  public Varos(String nev, int urhajokSzama) {
    this.nev = nev;
    this.urhajokSzama = urhajokSzama;
    urhajokListaja = new Urhajo[urhajokSzama];
  }

  // GETTEREK, SETTEREK ------------------------------------------------------------

  public void setUrhajo(int index, Urhajo input) {
    if (index < 0
            || index > urhajokListaja.length) {
      throw new RuntimeException("setUrhajo: hivatkozott index (" + index + ") tömbterületen kívüli!");
    }
    this.urhajokListaja[index] = input;
  }

  public Urhajo getUrhajo(int index) {
    if (index < 0 || index > urhajokListaja.length) {
      throw new RuntimeException("getUrhajo: hivatkozott index (" + index + ") tömbterülen kívüli!");
    } else if (urhajokListaja[index] == null) {
      throw new RuntimeException("getUrhajo: hivatkozott index (" + index + ") null értékű!");
    }
    return urhajokListaja[index];
  }

  public String getNev() {
    return nev;
  }

  public int getUrhajokSzama() {
    return urhajokSzama;
  }

  // EGYÉB METÓDUSOK ------------------------------------------------------------

  public String urhajoLista() {
    String adatlapok = "==========" + "\n"
            + nev + "\n"
            + "==========" + "\n";

    for (int i = 0; i < urhajokListaja.length; i++) {
      if (urhajokListaja[i] == null) {
        adatlapok += "A(z) " + i + " indexen nincs űrhajó!" + "\n" + "\n";
        continue;
      }
      adatlapok += "Típus: " + urhajokListaja[i].getTipus() + "\n"
              + "Építési év: " + urhajokListaja[i].getEpitesiEv() + "\n"
              + "Aktuális sebesség: " + urhajokListaja[i].getAktualisSebesseg() + "\n"
              + "Magasság: " + urhajokListaja[i].getMagassag() + "\n"
              + "Szélesség: " + urhajokListaja[i].getSzelesseg() + "\n"
              + "Hosszúság: " + urhajokListaja[i].getHosszusag() + "\n"
              + "Térfogat: " + urhajokListaja[i].getTerfogat() + "\n"
              + "\n";
    }
    return adatlapok;
  }

  public String leggyorsabbUrhajo() {
    int leggyorsabbIndex = 0;
    String adatlap = "===============================" + "\n"
            + nev + " (leggyorsabb űrhajó)" + "\n"
            + "===============================" + "\n";

    for (int i = 0; i < urhajokListaja.length; i++) {
      if (urhajokListaja[i] == null) {
        continue;
      }
      if (urhajokListaja[leggyorsabbIndex].getAktualisSebesseg() < urhajokListaja[i].getAktualisSebesseg()) {
        leggyorsabbIndex = i;
      }
    }

    adatlap += "Típus: " + urhajokListaja[leggyorsabbIndex].
            getTipus() + "\n"
            + "Építési év: " + urhajokListaja[leggyorsabbIndex].
            getEpitesiEv() + "\n"
            + "Aktuális sebesség: " + urhajokListaja[leggyorsabbIndex].
            getAktualisSebesseg() + "\n";

    return adatlap;
  }

  public String tipusLista(String tipus) {
    String adatlapok = "==========================================" + "\n"
            + nev + " (" + tipus + " típusú űrhajók listája)" + "\n"
            + "==========================================" + "\n";

    for (int i = 0; i < urhajokListaja.length; i++) {
      if (urhajokListaja[i] == null) {
        continue;
      }
      if (urhajokListaja[i].getTipus().equals(tipus)) {
        adatlapok += "Típus: " + urhajokListaja[i].getTipus() + "\n"
                + "Építési év: " + urhajokListaja[i].getEpitesiEv() + "\n"
                + "Aktuális sebesség: " + urhajokListaja[i].getAktualisSebesseg() + "\n"
                + "\n";
      }
    }
    return adatlapok;
  }

  public String gyorshajtokLista() {
    String adatlapok = "=======================================" + "\n"
            + nev + " (gyorshajtó űrhajók listája)" + "\n"
            + "=======================================" + "\n";
    if (sebesseghatar > 0) {
      for (int i = 0; i < urhajokListaja.length; i++) {
        if (urhajokListaja[i] == null) {
          continue;
        }
        if (urhajokListaja[i].getAktualisSebesseg() > sebesseghatar) {
          adatlapok += "Típus: " + urhajokListaja[i].getTipus() + "\n"
                  + "Építési év: " + urhajokListaja[i].getEpitesiEv() + "\n"
                  + "Aktuális sebesség: " + urhajokListaja[i].getAktualisSebesseg() + "\n"
                  + "\n";
        }
      }
    } else {
      adatlapok += "Traffipax rendszer üzemen kívül!";
    }
    return adatlapok;
  }


  @Override
  public String toString() {
    return "============================================" + "\n"
            + nev + " városban jegyzett űhrajók listája" + "\n"
            + "============================================" + "\n"
            + "Regisztrált űrhajók száma: " + urhajokSzama + "\n"
            + "============================================" + "\n"
            + "Űrhajók adatlapjai: " + "\n"
            + "============================================" + "\n"
            + Arrays.toString(urhajokListaja);
  }
}