package hu.petrik.bankiszolgaltatasok;

public class Szamla extends BankiSzolgáltatás {
    protected int aktualisEgyenleg;

    public Szamla(Tulajdonos nev, int aktualisEgyenleg) {
        super(nev);
    }

    public int getAktualisEgyenleg() {
        return aktualisEgyenleg;
    }

    public void befizet(int osszeg) {
        aktualisEgyenleg += osszeg;
    }

    public boolean kivetel(int osszeg) {
        throw new UnsupportedOperationException();
    }

    public Kartya ujKartya(String kartyaSzam) {
        return new Kartya(getNev(), this, kartyaSzam);
    }
}
