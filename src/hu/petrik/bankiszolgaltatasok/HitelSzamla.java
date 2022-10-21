package hu.petrik.bankiszolgaltatasok;

public class HitelSzamla extends Szamla{
    private int hitelKeret;

    public HitelSzamla(Tulajdonos nev, int aktualisEgyenleg, int hitelKeret) {
        super(nev, aktualisEgyenleg);
        this.hitelKeret = hitelKeret;
    }

    public int getHitelKeret() {
        return hitelKeret;
    }

    @Override
    public boolean kivetel(int osszeg) {
        if (aktualisEgyenleg - osszeg < hitelKeret){
            return false;
        }
        else {
            aktualisEgyenleg-=osszeg;
            return true;
        }
        }
    }