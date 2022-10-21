package hu.petrik.bankiszolgaltatasok;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Bank {
    private LinkedList<Szamla> szamlaLista;
    private int maxSzamlak;

    public Bank(int maxSzamlak) {
        this.szamlaLista = new LinkedList<>();
        this.maxSzamlak = maxSzamlak;
    }

    public Szamla szamlanyitas(Tulajdonos nev, int hitelKeret,int aktualis) {
        if (szamlaLista.size() >= maxSzamlak)
            throw new Error("Nem lehet több számlát nyitni!");

        Szamla sz;

        if (hitelKeret == 0)
            sz = new MegtakaritasiSzamla(nev,aktualis,hitelKeret);
        else
            sz = new HitelSzamla(nev, hitelKeret,hitelKeret);

        szamlaLista.add(sz);
        return sz;
    }
    public Stream<Szamla> getSzamlak(Tulajdonos tulajdonos) {
        return szamlaLista
                .stream()
                .filter(x -> x.getNev() == tulajdonos);
    }
    public int getOsszegyenleg(Tulajdonos tulajdonos) {
        AtomicInteger ossz = new AtomicInteger();
        getSzamlak(tulajdonos).forEach(x -> ossz.addAndGet(x.aktualisEgyenleg));
        return ossz.get();
    }
/*
    public Szamla getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos) {
        //return getSzamlak(tulajdonos).max(i -> i.aktualisEgyenleg);

    }

    public long getOsszhitelkeret() {
        return szamlaLista;

    }*/
}
