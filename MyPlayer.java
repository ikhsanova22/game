
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MyPlayer implements Player {
    private Circle ball;
    private Map map;
    private Position position;

    //Constructor of MyPlayer class
    MyPlayer(Map map){
        this.map =map;
        position = map.getStartPosition();
        ball = new Circle(map.getStartPosition().getX()*map.getUnit()+map.getUnit()/2,
                map.getStartPosition().getY()*map.getUnit()+map.getUnit()/2, map.getUnit()/2-1);
        ball.setFill(Color.VIOLET);

        map.getChildren().add(ball);
    }

    //Overriding methods from Player interface
    public void moveRight(){
        ball.setCenterX(ball.getCenterX()+map.getUnit());
    }
    public void moveLeft(){
        ball.setCenterX(ball.getCenterX()-map.getUnit());
    }
    public void moveUp(){
        ball.setCenterY(ball.getCenterY()-map.getUnit());
    }
    public void moveDown(){
        ball.setCenterY(ball.getCenterY()+map.getUnit());
    }

    //method for returning position of ball
    public Position getPosition(){
        int x = (int)ball.getCenterX()/map.getUnit();
        int y = (int)ball.getCenterY()/map.getUnit();
        Position p = new Position(x,y);
        return p;
    }
}
