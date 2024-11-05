package hu.petrik.bankiszolgaltatasok;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Szamla> szamlaLista;

    public Bank() {
        this.szamlaLista = new ArrayList<Szamla>();
    }

    public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelKeret) {
        if (hitelKeret == 0){
            MegtakaritasiSzamla szamla = new MegtakaritasiSzamla(tulajdonos);
            szamlaLista.add(szamla);
            return szamla;
        }
        else if(hitelKeret < 0){
            throw new IllegalArgumentException("Hitel keret nem lehet negativ");
        }
        else{
            HitelSzamla szamla = new HitelSzamla(tulajdonos, hitelKeret);
            szamlaLista.add(szamla);
            return szamla;
        }
    }

    public int getOsszEgyenleg(Tulajdonos tulajdonos) {
        int ossz = 0;
        for (Szamla szamla : szamlaLista) {
            if (szamla.getTulajdonos().equals(tulajdonos)) {
                ossz += szamla.getAktualisEgyenleg();
            }
        }
        return ossz;
    }

    public Szamla getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos) {
        Szamla legnagy = szamlaLista.get(0);
        int ossz = 0;
        for (Szamla szamla : szamlaLista) {
            if(szamla.getTulajdonos().equals(tulajdonos)) {
                if (szamla.getAktualisEgyenleg() > ossz) {
                    ossz = szamla.getAktualisEgyenleg();
                    legnagy = szamla;
                }
            }
        }
        return legnagy;
    }

    public long getOsszHitelkeret(){
        long ossz = 0;
        for (Szamla szamla : szamlaLista) {
            if (szamla.getClass() == HitelSzamla.class){
                ossz += ((HitelSzamla) szamla).getHitelKeret();
            }
        }
        return ossz;
    }
}
