package Classes;


public class Sprzeglo extends Komponent {
    private String stanSprzegla = "Zwolnione";

    public Sprzeglo(String _nazwa, double _waga, double _cena) {
        super(_nazwa, _waga, _cena);
    }

    public String getStan(){
        return this.stanSprzegla;
    }

    public void wcisnij(){
        System.out.println("Classes.Sprzeglo wcisniete");
        this.stanSprzegla = "Wcisniete";
    }
    public void zwolnij(){
        System.out.println("Classes.Sprzeglo zwolnione");
        this.stanSprzegla = "Zwolnione";
    }

}
