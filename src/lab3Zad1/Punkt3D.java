package lab3Zad1;

public class Punkt3D {
    private double wspolrzednaX;
    private double wspolrzednaY;
    private double wspolrzednaZ;

    public Punkt3D(){
        wspolrzednaX = 0;
        wspolrzednaY = 0;
        wspolrzednaZ = 0;
    }

    public Punkt3D(double wspolrzednaX, double wspolrzednaY, double wspolrzednaZ){
        this.wspolrzednaX = wspolrzednaX;
        this.wspolrzednaY = wspolrzednaY;
        this.wspolrzednaZ = wspolrzednaZ;
    }

    public double getWspolrzednaX() {
        return wspolrzednaX;
    }

    public void setWspolrzednaX(double wspolrzednaX) {
        this.wspolrzednaX = wspolrzednaX;
    }

    public double getWspolrzednaY() {
        return wspolrzednaY;
    }

    public void setWspolrzednaY(double wspolrzednaY) {
        this.wspolrzednaY = wspolrzednaY;
    }

    public double getWspolrzednaZ() {
        return wspolrzednaZ;
    }

    public void setWspolrzednaZ(double wspolrzednaZ) {
        this.wspolrzednaZ = wspolrzednaZ;
    }

    public double Euklides(){
        return Math.sqrt(Math.pow((wspolrzednaX - 0), 2) + Math.pow((wspolrzednaY - 0),2) + Math.pow((wspolrzednaZ - 0), 2));
    }
    public double Manhattan(){
        return (wspolrzednaX - 0) + (wspolrzednaY - 0) + (wspolrzednaZ -0);
    }
}
