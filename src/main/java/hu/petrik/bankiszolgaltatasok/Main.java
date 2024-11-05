package hu.petrik.bankiszolgaltatasok;

public class Main {
    public static void main(String[] args) {
        Tulajdonos tulaj1 = new Tulajdonos("Gábor");
        Tulajdonos tulaj2 = new Tulajdonos("Kata");


        Bank bank = new Bank();

        bank.szamlaNyitas(tulaj1,0);
        bank.szamlaNyitas(tulaj2,10000);
        bank.szamlaNyitas(tulaj1,1000000);
        bank.szamlaNyitas(tulaj2,0);

        System.out.println(bank.getOsszEgyenleg(tulaj1));
        System.out.println(bank.getLegnagyobbEgyenleguSzamla(tulaj2).getTulajdonos().getNev());
        System.out.println(bank.getOsszHitelkeret());


    }
}
