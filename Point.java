import java.io.Serializable;



public class Point extends Object implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public  int x, y;
    public  String name ;


    public Point(int x, int y,String name){
        this.x=x;
        this.y=y;
        this.name=name;
    }

    public void setX(int p) {
        x = p;
    }
    public void setY(int p) {
        y = p;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}