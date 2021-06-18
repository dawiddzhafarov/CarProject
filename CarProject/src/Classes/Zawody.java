package Classes;

import Classes.Samochod;

public class Zawody {
    private String nazwa;
    private String data;
    private Samochod[] samochody;

    public Zawody(String _data, String _nazwa, Samochod[] cars) {
        this.data = _data;
        this.nazwa = _nazwa;
        this.samochody = cars;
    }

    public void rozegrajZawody(){
        int len = this.samochody.length; //2 na razie
        Samochod auto1 = this.samochody[0];
        Samochod auto2 = this.samochody[1];

    }
}
