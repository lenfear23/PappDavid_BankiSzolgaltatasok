package hu.petrik.bankiszolgaltatasok;

public class BankiSzolgáltatás {
    private Tulajdonos nev;

    public BankiSzolgáltatás(Tulajdonos nev) {
        this.nev = nev;
    }

    public Tulajdonos getNev() {
        return nev;
    }
}
