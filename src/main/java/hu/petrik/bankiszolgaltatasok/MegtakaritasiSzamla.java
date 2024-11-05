package hu.petrik.bankiszolgaltatasok;

public class MegtakaritasiSzamla extends Szamla{
    private double kamat;
    public static double alapKamat = 1.1;

    public MegtakaritasiSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        kamat = alapKamat;
    }

    public double getKamat() {
        return kamat;
    }

    public void setKamat(double kamat) {
        this.kamat = kamat;
    }

    @Override
    public boolean kivesz(int osszeg) {
        if (super.aktualisEgyenleg - osszeg < 0){
            return false;
        }
        else{
            super.aktualisEgyenleg -= osszeg;
            return true;
        }
    }

    public void kamatJovairas(){
        super.aktualisEgyenleg = (int)Math.round(super.aktualisEgyenleg*kamat);
    }
}
