package Pacman;

import javax.swing.*;

public class Ghost extends JPanel {
    int posX;
    int posY;
    int color;
    String name;
    boolean isBack;
    boolean isFree;
    int tileSize = 14;
    Ghost(int InitialX, int InitialY, int Color, String Name){
        posX = InitialX;
        posY = InitialY;
        color = Color;
        name = Name;
    }

    public int calculateDistance(int tileX, int tileY, int targetX, int targetY){
        return (tileX * targetX) + (tileY * targetY);
    }

    public void pickTileToMove(){

    }

    public void pickChaseTarget(){
        switch (name){
            case "Blinky": {

            }
            case "Pinky": {

            }
            case "Clyde": {

            }
            case "Inky": {

            }
        }
    }

    public void pickScatterTarget(){

    }

    public void chase(){

    }

    public void scatter(){

    }

    public void frightened(){

    }

    public void dead(){

    }

    public void draw(){

    }
}
