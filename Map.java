
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map extends Pane {
    private int unit = 50;
    private int size;
    private int[][] map;
    private Position start;

    //Constructor for Map class
    public Map(String maps) throws FileNotFoundException {
        File file = new File(maps);

        //read map from txt file and save it in array
        Scanner out = new Scanner(file);
        while (out.hasNextLine()) {
            size = out.nextInt();
            map = new int[size][size];

            for (int y = 0; y<size; y++){
                for (int x=0; x<size; x++){
                    map[x][y]=out.nextInt();

                    if (map[x][y]==2)
                        start = new Position(x,y);
                }
            }
        }
        //Save rectangles in array and draw to pane
        Rectangle[][] rectangles = new Rectangle[size][size];
        for(int x=0; x<size; x++){
            for (int y=0; y<size; y++){
                rectangles[y][x] = new Rectangle(unit*y, unit*x, unit, unit);
                if(map[y][x]==1) {
                    rectangles[y][x].setFill(Color.BLACK);
                    rectangles[y][x].setStroke(Color.BLACK);
                }
                else{
                    rectangles[y][x].setFill(Color.WHITE);
                    rectangles[y][x].setStroke(Color.BLACK);
                }
                getChildren().addAll(rectangles[y][x]);
            }
        }
    }
    //method for returning unit
    public int getUnit(){
        return unit;
    }
    //method for returning size of map
    public int getSize(){
        return size;
    }
    //method for returning map
    public int[][] getMap(){
        return map;
    }
    //method for returning start position
    public Position getStartPosition(){
        return start;
    }
}
