package Classes;

import Classes.Pozycja;

public class Samochod extends Thread {
    private boolean stanWlaczenia = false;
    private String nrRejestracyjny;
    private String model;
    private int maxPred;
    private Pozycja cel;
    private SkrzyniaBiegow skrzyniaBiegow;
    private Silnik silnik;
    private Pozycja pozycja;

    public Samochod(String _nrRejestr, String _model, int _maxpred, SkrzyniaBiegow _skrzynia, Silnik _silnik, Pozycja _pozycja) {
        this.model = _model;
        this.nrRejestracyjny = _nrRejestr;
        this.maxPred = _maxpred;
        this.skrzyniaBiegow = _skrzynia;
        this.silnik = _silnik;
        this.pozycja = _pozycja;
        this.cel = new Pozycja(0, 0);
        this.start();
    }
    public double getCena() {
        return this.skrzyniaBiegow.getCena() + this.silnik.getCena() + 30000;
    }
    public double getWaga() {
        return this.skrzyniaBiegow.getWaga() + this.silnik.getWaga() + this.skrzyniaBiegow.getWagaSprzegla();
    }

    public double getAktPredk() {
        if (this.skrzyniaBiegow.getAktPrzelozenie() * this.silnik.getObroty()/100 * 2 > maxPred) return maxPred;
        else if(this.silnik.getObroty() == 800) return 0;
        else return this.skrzyniaBiegow.getAktPrzelozenie() * this.silnik.getObroty()/100 * 2;
    }

    public String getAktPozycja() {
        double x = this.pozycja.getX();
        double y = this.pozycja.getY();
        return "Classes.Pozycja: " + x + ", " + y;
    }
    public double getX(){
        return this.pozycja.getX();
    }
    public double getY(){
        return this.pozycja.getY();
    }
    public Pozycja getPozycja(){
        return this.pozycja;
    }
    public double getCelx(){
        return this.cel.getX();
    }
    public double getCely(){
        return this.cel.getY();
    }
    public void wlacz() {
        this.stanWlaczenia = true;
        this.silnik.uruchom();
    }

    public void wylacz() {
        this.stanWlaczenia = false;
        this.silnik.zatrzymaj();
    }

    public void jedzDo(Pozycja docelowa) {
        this.cel.setX(docelowa.getX());
        this.cel.setY(docelowa.getY());
    }
    public String getModel() {
        return this.model;
    }
    public String getNrRejestracyjny() {
        return this.nrRejestracyjny;
    }
    public SkrzyniaBiegow getSkrzyniaBiegow(){
        return this.skrzyniaBiegow;
    }
    public Silnik getSilnik(){
        return this.silnik;
    }
    public Sprzeglo getSprzeglo(){
        return this.skrzyniaBiegow.getSprzeglo();
    }

    public static void main(String[] args) {

    }

    @Override
    public String toString() {
        return nrRejestracyjny + " " + model;
    }

    public void run() {
        while (true) {
            if ((this.pozycja.getX() != this.cel.getX()) || (this.pozycja.getY() != this.cel.getY())) {
                int deltaT = 200;
                this.pozycja.przemiesc(this.getAktPredk(), deltaT, cel);
                try {
                    Thread.sleep(deltaT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (((this.pozycja.getX()) == (this.cel.getX())) && ((this.pozycja.getY()) == (this.cel.getY()))) {
                System.out.println("Samochód " + this.nrRejestracyjny + " dojechał do celu");
            }
        }
    }
}
