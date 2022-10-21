package hu.petrik.bankiszolgaltatasok;

public class Kartya extends BankiSzolgáltatás {
    private Szamla szamla;
    private String kartyaSzam;

    public Kartya(Tulajdonos nev, Szamla szamla, String kartyaSzam) {
        super(nev);
        this.szamla = szamla;
        this.kartyaSzam = kartyaSzam;
    }

    public String getKartyaSzam() {
        return kartyaSzam;
    }

    public boolean vasarlas(int osszeg) {
        return szamla.kivetel(osszeg);
    }
}
