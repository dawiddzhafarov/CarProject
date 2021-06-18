package Classes;

public class Pozycja {
    private double x;
    private double y;

    public Pozycja(double _x, double _y) {
    this.x = _x;
    this.y = _y;
    }

    public void przemiesc(double _v, double deltaT, Pozycja cel){
        double odleglosc_all = odleglosc(cel.getX(), x, cel.getY(), y);
        double x_roznica = cel.getX()-x;
        double y_roznica = cel.getY()-y;
        if(odleglosc_all!=0) {
            double odl_temp = _v * deltaT / 1000;
            if (odl_temp >= odleglosc_all) {
                this.x = cel.getX();
                this.y = cel.getY();
            } else {
                double deltaX = odl_temp * (cel.getX() - x) / odleglosc_all;
                double deltaY = odl_temp * (cel.getY() - y) / odleglosc_all;
                this.x += deltaX;
                this.y += deltaY;
            }
        }
        }
    public double odleglosc(double x1, double x2, double y1, double y2){
        return Math.sqrt(Math.pow(((x1)-(x2)), 2) + (Math.pow(((y1)-(y2)), 2)));
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public void setX(double _x){
        this.x = _x;
    }
    public void setY(double _y){
        this.y = _y;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pozycja)) {
            return false;
        }
        var cel = (Pozycja)obj;
        return cel.getX() == x && cel.getY() == y;
    }
}
