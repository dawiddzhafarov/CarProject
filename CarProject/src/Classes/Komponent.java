package Classes;

public class Komponent {
    private String nazwa;
    private double waga;
    private double cena;

    public Komponent(String _nazwa,double _waga, double _cena){
        this.nazwa = _nazwa;
        this.waga = _waga;
        this.cena = _cena;
    }

    public String getNazwa(){
        return this.nazwa;
    }
    public double getWaga(){
        return  this.waga;
    }
    public double getCena(){
        return this.cena;
    }
}
