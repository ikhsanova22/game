
public class Position {
    private int x;
    private int y;

    //Constructor of Position class
    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }

    //Getter and setter methods
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }

    //Comparing two positions
    public boolean equals(Position other){
        return this.getX() == other.getX();
    }

    //printing position
    public String toString() {
        return ""+this.x+" "+this.y ;
    }
}
