package pacman;

public class pacmanclass {

    int x, y;

    public void setAwal() {
        x = 1;
        y = 1;
    }

    public void setKiri() {
        x = x - 1;
    }

    public void setKanan() {
        x = x + 1;
    }

    public void setNaik() {
        y = y - 1;
    }

    public void setTurun() {
        y = y + 1;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
