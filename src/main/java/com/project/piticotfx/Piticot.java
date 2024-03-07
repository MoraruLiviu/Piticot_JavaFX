package com.project.piticotfx;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Piticot extends Application {

    public int rand;
    public Label randResult;

    public Label commentary;

    public int[][] circlePos = new int[10][10];
    public static final int tile_size = 80;
    public static final int width = 10;
    public static final int height = 8;

    public Circle player1;
    public Circle player2;

    public int playerPos1 = 1;
    public int playerPos2 = 1;

    public boolean player1Turn = true;
    public boolean player2Turn = true;

    public boolean player1Timeout = false;
    public boolean player2Timeout = false;

    public static int player1XPos = 40;
    public static int player1YPos = 600;
    public static int player2XPos = 40;
    public static int player2YPos = 600;

    public boolean gameStart = true;

    private Group tileGroup = new Group();
    private Parent createWindow(){
        Pane root = new Pane();
        root.setPrefSize(width * tile_size, (height * tile_size) + 80);
        root.getChildren().addAll(tileGroup);

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                Tile tile = new Tile(tile_size,tile_size);
                tile.setTranslateX(j * tile_size);
                tile.setTranslateY(i * tile_size);
                tileGroup.getChildren().add(tile);
                circlePos[i][j] = j * (tile_size - 40);

            }
        }

        for(int i = 0; i < height; i++){
            for(int j =0; j < width; j++){
                System.out.print(circlePos[i][j] + " ");
            }
            System.out.println();
        }

        player1 = new Circle(30);
        player1.setId("player1");
        player1.setFill(Color.AQUA);
        player1.setTranslateX(player1XPos);
        player1.setTranslateY(player1YPos);

        player2 = new Circle(30);
        player2.setId("player2");
        player2.setFill(Color.CHOCOLATE);
        player2.setTranslateX(player2XPos);
        player2.setTranslateY(player2YPos);

        Button button1 = new Button("Player1");
        button1.setTranslateX(40);
        button1.setTranslateY(660);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart){
                    if(player1Turn){
                        if(!player1Timeout){
                            commentary.setText("");
                            randDiceGen();
                            randResult.setText(String.valueOf(rand));
                            movePlayer1();
                            translatePlayer(player1XPos, player1YPos, player1);

                            if((player1XPos == 280 && player1YPos == 600) ||
                                    (player1XPos == 680 && player1YPos == 440) ||
                                    (player1XPos == 280 && player1YPos == 360) ||
                                    (player1XPos == 360 && player1YPos == 200) ||
                                    (player1XPos == 520 && player1YPos == 40)){
                                player1Timeout = true;

                            }
                        } else{
                            player1Timeout = false;
                            commentary.setText("Player One must wait a turn");

                        }
                        player1Turn = false;
                        player2Turn = true;


                        // 8 -> 12
                        if(player1XPos == 600 && player1YPos == 600){
                            translatePlayer(player1XPos = 680, player1YPos= 520, player1);
                            playerPos1++;
                            commentary.setText("Player One landed on 8 -> 12");
                        }
                        // 14 -> 1
                        if(player1XPos == 520 && player1YPos == 520){
                            translatePlayer(player1XPos = 40, player1YPos= 600, player1);
                            playerPos1--;
                            commentary.setText("Player One landed on 14 -> 1");
                        }
                        // 17 -> 13
                        if(player1XPos == 280 && player1YPos == 520){
                            translatePlayer(player1XPos = 600, player1YPos= 520, player1);
                            commentary.setText("Player One landed on 17 -> 13");
                        }
                        // 21 -> 26
                        if(player1XPos == 40 && player1YPos == 440){
                            translatePlayer(player1XPos = 440, player1YPos= 440, player1);
                            commentary.setText("Player One landed on 21 -> 26");
                        }
                        // 33 -> 27
                        if(player1XPos == 600 && player1YPos == 360){
                            translatePlayer(player1XPos = 520, player1YPos= 440, player1);
                            playerPos1--;
                            commentary.setText("Player One landed on 33 -> 27");
                        }
                        // 40 -> 44
                        if(player1XPos == 40 && player1YPos == 360){
                            translatePlayer(player1XPos = 280, player1YPos= 280, player1);
                            playerPos1++;
                            commentary.setText("Player One landed on 40 -> 44");
                        }
                        // 43 -> 38
                        if(player1XPos == 200 && player1YPos == 280){
                            translatePlayer(player1XPos = 200, player1YPos= 360, player1);
                            playerPos1--;
                            commentary.setText("Player One landed on 43 -> 38");
                        }
                        // 46 -> 52
                        if(player1XPos == 440 && player1YPos == 280){
                            translatePlayer(player1XPos = 680, player1YPos= 200, player1);
                            playerPos1++;
                            commentary.setText("Player One landed on 46 -> 52");
                        }
                        // 49 -> 45
                        if(player1XPos == 680 && player1YPos == 280){
                            translatePlayer(player1XPos = 360, player1YPos= 280, player1);
                            commentary.setText("Player One landed on 49 -> 45");
                        }
                        // 53 -> 57
                        if(player1XPos == 600 && player1YPos == 200){
                            translatePlayer(player1XPos = 280, player1YPos= 200, player1);
                            commentary.setText("Player One landed on 53 -> 57");
                        }
                        // 58 -> 50
                        if(player1XPos == 200 && player1YPos == 200){
                            translatePlayer(player1XPos = 760, player1YPos= 280, player1);
                            playerPos1--;
                            commentary.setText("Player One landed on 58 -> 50");
                        }
                        // 62 -> 65
                        if(player1XPos == 120 && player1YPos == 120){
                            translatePlayer(player1XPos = 360, player1YPos= 120, player1);
                            commentary.setText("Player One landed on 62 -> 65");
                        }
                        // 66 -> 56
                        if(player1XPos == 440 && player1YPos == 120){
                            translatePlayer(player1XPos = 360, player1YPos= 200, player1);
                            playerPos1--;
                            player1Timeout = true;
                            commentary.setText("Player One landed on 66 -> 56");
                        }
                        // 70 -> 75
                        if(player1XPos == 760 && player1YPos == 120){
                            translatePlayer(player1XPos = 440, player1YPos= 40, player1);
                            playerPos1++;
                            commentary.setText("Player One landed on 70 -> 75");
                        }
                        // 78 -> 80
                        if(player1XPos == 200 && player1YPos == 40){
                            translatePlayer(player1XPos = 40, player1YPos= 40, player1);
                            commentary.setText("Player One landed on 78 -> 80");
                            randResult.setText("Player One Won");
                            gameStart = false;
                        }

                        // 25 -> dead
                        if(player1XPos == 360 && player1YPos == 440){
                            randResult.setText("Player Two Won");
                            commentary.setText("Player One landed on 25 -> dead");
                            gameStart = false;
                        }

                    }
                }
            }
        });

        Button button2 = new Button("Player2");
        button2.setTranslateX(700);
        button2.setTranslateY(660);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart){
                    if(player2Turn){
                        if (!player2Timeout){
                            commentary.setText("");
                            randDiceGen();
                            randResult.setText(String.valueOf(rand));
                            movePlayer2();
                            translatePlayer(player2XPos, player2YPos, player2);

                            if((player2XPos == 280 && player2YPos == 600) ||
                                    (player2XPos == 680 && player2YPos == 440) ||
                                    (player2XPos == 280 && player2YPos == 360) ||
                                    (player2XPos == 360 && player2YPos == 200) ||
                                    (player2XPos == 520 && player2YPos == 40)){
                                player2Timeout = true;
                            }
                        } else{
                            player2Timeout = false;
                            commentary.setText("Player Two must wait a turn");
                        }

                        player1Turn = true;
                        player2Turn = false;

                        // 8 -> 12
                        if(player2XPos == 600 && player2YPos == 600){
                            translatePlayer(player2XPos = 680, player2YPos= 520, player2);
                            playerPos2++;
                            commentary.setText("Player Two landed on 8 -> 12");
                        }
                        // 14 -> 1
                        if(player2XPos == 520 && player2YPos == 520){
                            translatePlayer(player2XPos = 40, player2YPos= 600, player2);
                            playerPos2--;
                            commentary.setText("Player Two landed on 14 -> 1");
                        }
                        // 17 -> 13
                        if(player2XPos == 280 && player2YPos == 520){
                            translatePlayer(player2XPos = 600, player2YPos= 520, player2);
                            commentary.setText("Player Two landed on 17 -> 13");
                        }
                        // 21 -> 26
                        if(player2XPos == 40 && player2YPos == 440){
                            translatePlayer(player2XPos = 440, player2YPos= 440, player2);
                            commentary.setText("Player Two landed on 21 -> 26");
                        }
                        // 33 -> 27
                        if(player2XPos == 600 && player2YPos == 360){
                            translatePlayer(player2XPos = 520, player2YPos= 440, player2);
                            playerPos2--;
                            commentary.setText("Player Two landed on 33 -> 27");
                        }
                        // 40 -> 44
                        if(player2XPos == 40 && player2YPos == 360){
                            translatePlayer(player2XPos = 280, player2YPos= 280, player2);
                            playerPos2++;
                            commentary.setText("Player Two landed on 40 -> 44");
                        }
                        // 43 -> 38
                        if(player2XPos == 200 && player2YPos == 280){
                            translatePlayer(player2XPos = 200, player2YPos= 360, player2);
                            playerPos2--;
                            commentary.setText("Player Two landed on 43 -> 38");
                        }
                        // 46 -> 52
                        if(player2XPos == 440 && player2YPos == 280){
                            translatePlayer(player2XPos = 680, player2YPos= 200, player2);
                            playerPos2++;
                            commentary.setText("Player Two landed on 46 -> 52");
                        }
                        // 49 -> 45
                        if(player2XPos == 680 && player2YPos == 280){
                            translatePlayer(player2XPos = 360, player2YPos= 280, player2);
                            commentary.setText("Player Two landed on 49 -> 45");
                        }
                        // 53 -> 57
                        if(player2XPos == 600 && player2YPos == 200){
                            translatePlayer(player2XPos = 280, player2YPos= 200, player2);
                            commentary.setText("Player Two landed on 53 -> 57");
                        }
                        // 58 -> 50
                        if(player2XPos == 200 && player2YPos == 200){
                            translatePlayer(player2XPos = 760, player2YPos= 280, player2);
                            playerPos2--;
                            commentary.setText("Player Two landed on 58 -> 50");
                        }
                        // 62 -> 65
                        if(player2XPos == 120 && player2YPos == 120){
                            translatePlayer(player2XPos = 360, player2YPos= 120, player2);
                            commentary.setText("Player Two landed on 62 -> 65");
                        }
                        // 66 -> 56
                        if(player2XPos == 440 && player2YPos == 120){
                            translatePlayer(player2XPos = 360, player2YPos= 200, player2);
                            playerPos2--;
                            player2Timeout = true;
                            commentary.setText("Player Two landed on 66 -> 56");
                        }
                        // 70 -> 75
                        if(player2XPos == 760 && player2YPos == 120){
                            translatePlayer(player2XPos = 440, player2YPos= 40, player2);
                            playerPos2++;
                            commentary.setText("Player Two landed on 70 -> 75");
                        }
                        // 78 -> 80
                        if(player2XPos == 200 && player2YPos == 40){
                            translatePlayer(player2XPos = 40, player2YPos= 40, player2);
                            commentary.setText("Player Two landed on 78 -> 80");
                            randResult.setText("Player Two Won");
                            gameStart = false;
                        }

                        // 25 -> dead
                        if(player2XPos == 360 && player2YPos == 440){

                            randResult.setText("Player One Won");
                            commentary.setText("Player Two landed on 25 -> dead");
                            gameStart = false;
                        }
                    }
                }
            }
        });

        randResult = new Label("0");
        randResult.setTranslateX(400);
        randResult.setTranslateY(660);

        commentary = new Label("");
        commentary.setTranslateX(320);
        commentary.setTranslateY(680);


        Image img = new Image("C:\\Users\\shiny\\IdeaProjects\\PiticotFX\\src\\main\\java\\com\\project\\piticotfx\\piticot_board.png");
        ImageView bgImage = new ImageView();
        bgImage.setImage(img);
        bgImage.setFitHeight(640);
        bgImage.setFitWidth(800);

        tileGroup.getChildren().addAll(bgImage,player1,player2,button1,button2, randResult, commentary);

        return root;
    }


    private void randDiceGen(){
        rand = (int)(Math.random()*6+1);
    }

    private void movePlayer1(){
        for(int i = 0; i < rand; i++){
            if(playerPos1 % 2 == 1){
                player1XPos += 80;
            }
            if(playerPos1 % 2 == 0){
                player1XPos -= 80;
            }

            if(player1XPos > 760) {
                player1YPos -= 80;
                player1XPos -= 80;
                playerPos1++;
            }

            if(player1XPos < 40){
                player1YPos -= 80;
                player1XPos += 80;
                playerPos1++;
            }

            if(player1XPos <= 40 && player1YPos <= 40){
                player1XPos = 40;
                player1YPos = 40;
                commentary.setText("Player One Won");
                gameStart = false;
            }
        }
    }

    private void movePlayer2(){
        for(int i = 0; i < rand; i++){
            if(playerPos2 % 2 == 1){
                player2XPos += 80;
            }
            if(playerPos2 % 2 == 0){
                player2XPos -= 80;
            }

            if(player2XPos > 760) {
                player2YPos -= 80;
                player2XPos -= 80;
                playerPos2++;
            }

            if(player2XPos < 40){
                player2YPos -= 80;
                player2XPos += 80;
                playerPos2++;
            }

            if(player2XPos <= 40 && player2YPos <= 40){
                player2XPos = 40;
                player2YPos = 40;
                commentary.setText("Player Two Won");
                gameStart = false;
            }
        }
    }



    private void translatePlayer(int x, int y, Circle c){
        TranslateTransition animate = new TranslateTransition(Duration.millis(1000),c);
        animate.setToX(x);
        animate.setToY(y);
        animate.setAutoReverse(false);
        animate.play();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(createWindow());
        stage.setTitle("Piticot");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}