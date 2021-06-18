package Classes;

public class Silnik extends Komponent {
    private int maxObroty;
    private double obroty = 0;

    public Silnik(String _nazwa, double _waga, double _cena, int maxObroty) {
        super(_nazwa, _waga, _cena);
        this.maxObroty = maxObroty;
    }
    public double getObroty(){
        return this.obroty;
    }

    public void uruchom(){
        System.out.println("Classes.Silnik wlaczony");
        this.obroty = 800;
    }
    public void zatrzymaj(){
        System.out.println("Classes.Silnik wylaczony");
        this.obroty = 0;
    }
    public void zwiekszObroty(){
        if (this.obroty != this.maxObroty){
            obroty += 100;
            if(this.obroty > this.maxObroty){
                this.obroty = this.maxObroty;
            }
        }
    }
    public void zmniejszObroty(){
        if (this.obroty != 800) {
            this.obroty -= 100;
        }
        else {
            this.zatrzymaj();
        }
    }

}
