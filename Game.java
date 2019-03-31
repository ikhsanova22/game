
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Game extends Application{
    private Stage stage;

    public void start(Stage stage) throws FileNotFoundException {
        // BorderPane for starting scene to where we add text PAC-MAN and Start button
        BorderPane bpane = new BorderPane();
        bpane.setPadding(new Insets(50,0,50,30));

        Text text = new Text( 100,100,"PAC-MAN");
        text.setFont(Font.font("Times New Roman", FontPosture.REGULAR, 70));
        text.setFill(Color.ORANGE);

        String style = "-fx-background-color: \n" +
                "        #ecebe9,\n" +
                "        rgba(0,0,0,0.05),\n" +
                "        linear-gradient(#dcca8a, #c7a740),\n" +
                "        linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n" +
                "        linear-gradient(#f6ebbe, #e6c34d);\n" +
                "    -fx-background-insets: 0,9 9 8 9,9,10,11;\n" +
                "    -fx-background-radius: 50;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 18px;\n" +
                "    -fx-text-fill: #311c09;\n" +
                "    -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.1) , 2, 0.0 , 0 , 1);" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );";

        Button start = new Button("START");
        start.setStyle(style);

        bpane.setTop(text);
        bpane.setCenter(start);
        start.setAlignment(Pos.CENTER);

        //Coloring background
        bpane.setBackground(Background.EMPTY);
        bpane.setStyle("-fx-background-color: rgba(11, 255, 230, 0.5);");

        //Create buttons for different maps
        Button map1_1 = new Button("MAP №1");
        Button map1_2 = new Button("MAP №2");
        Button map1_3 = new Button("MAP №3");

        map1_1.setStyle(style);
        map1_2.setStyle(style);
        map1_3.setStyle(style);

        // To VBox we add three buttons
        VBox vBox = new VBox(30);
        vBox.setPadding(new Insets(70,100,100,130));
        vBox.setStyle("-fx-background-color: rgba(11, 255, 230, 0.5);");
        vBox.getChildren().addAll(map1_1, map1_2, map1_3);

        // Set action to three buttons for choose map
        map1_1.setOnMouseClicked(e -> {
            try {
                Map map = new Map("C:/Users/Адилхан/Desktop/Project/map0.txt");
                Player my = new MyPlayer(map);
                Food food = new Food(map,my);
                map.setPadding(new Insets(50,50,50,50));

                // Control movement of ball with keys
                map.setOnKeyPressed(e3 ->{
                    try {
                        if (e3.getCode().equals(KeyCode.LEFT)) { // If Left key pressed we check whether the wall on the next cell
                            if (map.getMap()[my.getPosition().getX() - 1][my.getPosition().getY()] == 1
                                    || my.getPosition().getX() > map.getSize()
                                    || my.getPosition().getY() > map.getSize())
                                System.out.println("Invalid position!");
                            else
                                my.moveLeft();
                        } else if (e3.getCode().equals(KeyCode.RIGHT)) { // If Right key pressed we check whether the wall on the next cell
                            if (map.getMap()[my.getPosition().getX() + 1][my.getPosition().getY()] == 1
                                    || my.getPosition().getX() > map.getSize()
                                    || my.getPosition().getY() > map.getSize())
                                System.out.println("Invalid position!");
                            else
                                my.moveRight();
                        } else if (e3.getCode().equals(KeyCode.UP)) { // If Up key pressed we check whether the wall on the next cell
                            if (map.getMap()[my.getPosition().getX()][my.getPosition().getY() - 1] == 1
                                    || my.getPosition().getX() > map.getSize()
                                    || my.getPosition().getY() > map.getSize())
                                System.out.println("Invalid position!");
                            else
                                my.moveUp();
                        } else if (e3.getCode().equals(KeyCode.DOWN)) { // If Down key pressed we check whether the wall on the next cell
                            if (map.getMap()[my.getPosition().getX()][my.getPosition().getY() + 1] == 1
                                    || my.getPosition().getX() > map.getSize()
                                    || my.getPosition().getY() > map.getSize())
                                System.out.println("Invalid position!");
                            else
                                my.moveDown();
                        }
                    }catch (ArrayIndexOutOfBoundsException ex){
                        System.out.println("Invalid position!");
                    }
                });
                Scene sc1 = new Scene(map, 400,400);
                stage.setScene(sc1);

                map.requestFocus();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        });

        map1_2.setOnMouseClicked(e ->{
            try {
                Map map = new Map("C:/Users/Адилхан/Desktop/Project/map1.txt");
                Player my = new MyPlayer(map);
                Food food = new Food(map,my);
                map.setPadding(new Insets(50,50,50,50));

                map.setOnKeyPressed(e3 ->{
                    try {
                        if (e3.getCode().equals(KeyCode.LEFT)) {
                            if (map.getMap()[my.getPosition().getX() - 1][my.getPosition().getY()] == 1
                                    || my.getPosition().getX() > map.getSize()
                                    || my.getPosition().getY() > map.getSize())
                                System.out.println("Invalid position!");
                            else
                                my.moveLeft();
                        } else if (e3.getCode().equals(KeyCode.RIGHT)) {
                            if (map.getMap()[my.getPosition().getX() + 1][my.getPosition().getY()] == 1
                                    || my.getPosition().getX() > map.getSize()
                                    || my.getPosition().getY() > map.getSize())
                                System.out.println("Invalid position!");
                            else
                                my.moveRight();
                        } else if (e3.getCode().equals(KeyCode.UP)) {
                            if (map.getMap()[my.getPosition().getX()][my.getPosition().getY() - 1] == 1
                                    || my.getPosition().getX() > map.getSize()
                                    || my.getPosition().getY() > map.getSize())
                                System.out.println("Invalid position!");
                            else
                                my.moveUp();
                        } else if (e3.getCode().equals(KeyCode.DOWN)) {
                            if (map.getMap()[my.getPosition().getX()][my.getPosition().getY() + 1] == 1
                                    || my.getPosition().getX() > map.getSize()
                                    || my.getPosition().getY() > map.getSize())
                                System.out.println("Invalid position!");
                            else
                                my.moveDown();
                        }
                    }catch (ArrayIndexOutOfBoundsException ex){
                        System.out.println("Invalid position!");
                    }
                });
                Scene sc1 = new Scene(map, 400,400);
                stage.setScene(sc1);
                stage.show();

                map.requestFocus();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        });

        map1_3.setOnMouseClicked(e ->{
            try {
                Map map2 = new Map("C:/Users/Адилхан/Desktop/Project/map2.txt");
                Player my2 = new MyPlayer(map2);
                Food food = new Food(map2,my2);
                map2.setPadding(new Insets(50,50,50,50));

                map2.setOnKeyPressed(e1 ->{
                    try {
                        if (e1.getCode().equals(KeyCode.LEFT)) {
                            if (map2.getMap()[my2.getPosition().getY()][my2.getPosition().getX() - 1] == 1
                                    || my2.getPosition().getX() > map2.getSize()
                                    || my2.getPosition().getY() > map2.getSize())
                                System.out.println("Invalid position!");
                            else
                                my2.moveLeft();
                        } else if (e1.getCode().equals(KeyCode.RIGHT)) {
                            if (map2.getMap()[my2.getPosition().getY()][my2.getPosition().getX() + 1] == 1
                                    || my2.getPosition().getX() > map2.getSize()
                                    || my2.getPosition().getY() > map2.getSize())
                                System.out.println("Invalid position!");
                            else
                                my2.moveRight();
                        } else if (e1.getCode().equals(KeyCode.UP)) {
                            if (map2.getMap()[my2.getPosition().getY() - 1][my2.getPosition().getX()] == 1
                                    || my2.getPosition().getX() > map2.getSize()
                                    || my2.getPosition().getY() > map2.getSize())
                                System.out.println("Invalid position!");
                            else
                                my2.moveUp();
                        } else if (e1.getCode().equals(KeyCode.DOWN)) {
                            if (map2.getMap()[my2.getPosition().getY() + 1][my2.getPosition().getX()] == 1
                                    || my2.getPosition().getX() > map2.getSize()
                                    || my2.getPosition().getY() > map2.getSize())
                                System.out.println("Invalid position!");
                            else
                                my2.moveDown();
                        }
                    }catch (ArrayIndexOutOfBoundsException ex){
                        System.out.println("Invalid position!");
                    }
                });
                Scene sc3 = new Scene(map2, 400,400);
                stage.setScene(sc3);

                map2.requestFocus();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }

        });

        Scene sc = new Scene(bpane, 400, 400);
        Scene sc1 = new Scene(vBox, 400,400);

        // When start button clicked display the scene with 3 buttons
        start.setOnMouseClicked(e -> stage.setScene(sc1));

        stage.setScene(sc);
        stage.setTitle("PAC-MAN");
        stage.show();

    }
}
