package hu.progmatic;

public class Urhajo {
  private final int epitesiEv;
  private String tipus;
  private int aktualisSebesseg;
  private int magassag;
  private int szelesseg;
  private int hosszusag;
  private boolean leszabalyozva;

  // KONSTRUKTOROK ------------------------------------------------------------------------------

  public Urhajo(int epitesiEv) {
    this.epitesiEv = epitesiEv;
  }

  public Urhajo(int epitesiEv, String tipus) {
    this.epitesiEv = epitesiEv;
    this.tipus = tipus;
  }

  public Urhajo(int epitesiEv, String tipus, int magassag, int szelesseg, int hosszusag) {
    this.epitesiEv = epitesiEv;
    this.tipus = tipus;
    this.magassag = magassag;
    this.szelesseg = szelesseg;
    this.hosszusag = hosszusag;
  }

  public Urhajo(int epitesiEv, String tipus, int magassag, int szelesseg, int hosszusag, int aktualisSebesseg) {
    this.epitesiEv = epitesiEv;
    this.tipus = tipus;
    this.magassag = magassag;
    this.szelesseg = szelesseg;
    this.hosszusag = hosszusag;
    this.aktualisSebesseg = aktualisSebesseg;
  }

  // GETTEREK, SETTEREK -------------------------------------------------------------------------

  public boolean isLeszabalyozva() {
    return leszabalyozva;
  }

  public void setLeszabalyozva(boolean leszabalyozva) {
    this.leszabalyozva = leszabalyozva;
  }

  public int getTerfogat() {
    return magassag * szelesseg * hosszusag;
  }

  public int getEpitesiEv() {
    return epitesiEv;
  }

  public String getTipus() {
    return tipus;
  }

  public void setTipus(String tipus) {
    this.tipus = tipus;
  }

  public int getAktualisSebesseg() {
    return aktualisSebesseg;
  }

  public void setAktualisSebesseg(int aktualisSebesseg) {
    if (leszabalyozva && aktualisSebesseg > 2500) {
      throw new RuntimeException("Leszabályozva!");
    }
    this.aktualisSebesseg = aktualisSebesseg;
  }

  public int getMagassag() {
    return magassag;
  }

  public void setMagassag(int magassag) {
    this.magassag = magassag;
  }

  public int getSzelesseg() {
    return szelesseg;
  }

  public void setSzelesseg(int szelesseg) {
    this.szelesseg = szelesseg;
  }

  public int getHosszusag() {
    return hosszusag;
  }

  public void setHosszusag(int hosszusag) {
    this.hosszusag = hosszusag;
  }

  // EGYÉB METÓDUSOK ------------------------------------------------------------

  @Override
  public String toString() {
    return "Építési év: " + epitesiEv + "\n"
            + "Típus: " + tipus + "\n"
            + "Aktuális sebesség: " + aktualisSebesseg + "\n"
            + "Magasság: " + magassag + "\n"
            + "Szélesség: " + szelesseg + "\n"
            + "Hosszúság: " + hosszusag + "\n"
            + "Leszabályozva: " + leszabalyozva;
  }
}