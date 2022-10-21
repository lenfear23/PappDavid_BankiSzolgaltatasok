package hu.petrik.bankiszolgaltatasok;

public class MegtakaritasiSzamla extends Szamla {
    private double kamat;
    public static double alapKamat = 1.01;

    public MegtakaritasiSzamla(Tulajdonos nev, int aktualisEgyenleg, double kamat) {
        super(nev, aktualisEgyenleg);
        this.kamat = alapKamat;
    }

    public double getKamat() {
        return kamat;
    }

    public void setKamat(double kamat) {
        this.kamat = kamat;
    }

    @Override
    public boolean kivetel(int osszeg) {
        if (aktualisEgyenleg - osszeg < 0){
            return false;
        }
        else {
            aktualisEgyenleg-=osszeg;
            return true;
        }
    }
    public void kamatJovairas() {
        aktualisEgyenleg *= kamat;
    }
}
