package Classes;

public class SkrzyniaBiegow extends Komponent {
    private int aktualnyBieg = 0;
    private int iloscBiegow;
    private double aktualnePrzelozenie = 1;
    private Sprzeglo sprzeglo;

    public double getWagaSprzegla(){
        return this.sprzeglo.getWaga();
    }
    public Sprzeglo getSprzeglo(){
        return this.sprzeglo;
    }
    public int getAktBieg(){
        return this.aktualnyBieg;
    }
    public double getAktPrzelozenie(){
        return this.aktualnePrzelozenie;
    }
    public String getStanSprzegla(){
        return this.sprzeglo.getStan();
    }

    public SkrzyniaBiegow(String _nazwa, double _waga, double _cena, int iloscBiegow, Sprzeglo _sprzeglo) {
        super(_nazwa, _waga, _cena);
        this.iloscBiegow = iloscBiegow;
        this.sprzeglo = _sprzeglo;
    }

    public void zwiekszBieg(){
        if (this.aktualnyBieg != iloscBiegow) {
            this.aktualnyBieg++;
            this.aktualnePrzelozenie += 0.4;
            if(this.aktualnyBieg == 0){
                this.aktualnePrzelozenie = 1;
            }
        }
    }
    public void zmnniejszBieg(){
        if (aktualnyBieg != -1){
            this.aktualnyBieg--;
            this.aktualnePrzelozenie -= 0.4;
            if (this.aktualnyBieg == 0){
                this.aktualnePrzelozenie = 1;
            }
        }
    }

}
