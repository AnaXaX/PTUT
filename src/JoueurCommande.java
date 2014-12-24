/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;

enum GameStatus { StartMenu, PlayArea, PlayMenu, NewGameRequested, Unknown };

/**
 *
 * @author Simka
 */
public class JoueurCommande implements KeyListener {
    
    /*
        Cette classe permet de déplacer notre personnage sur les map
        
    */
    private Joueur joueur;
    private Input input;
  
        public JoueurCommande(Joueur joueur) throws SlickException{
            this.joueur=joueur;
        }
        
       
    
        
    @Override
    public void setInput(Input input) {
            this.input = input;
    }
    
   
    public void keyPressed(int key, char c) {
        
        GameStatus status = getGameStatus();
                
        if(status==GameStatus.StartMenu) {
            switch (key) {
                    case Input.KEY_UP:
                        joueur.setDirection(1);
                        joueur.setMoving(true);
                    break;
                    case Input.KEY_DOWN:
                        joueur.setDirection(2);
                        joueur.setMoving(true);
                    break;
                    case Input.KEY_ENTER:
                        joueur.setDirection(3);
                        joueur.setMoving(true);
                    break;
            }
        }
        else if(status==GameStatus.NewGameRequested) {
	 if (joueur.getNom().length()<10 && key != Input.KEY_BACK) 
	  if (c!=0) {
            joueur.setNom(joueur.getNom() + c);
	  } 
          if (key == Input.KEY_BACK && joueur.getNom().length() > 0) 
              joueur.setNom(joueur.getNom().substring(0,joueur.getNom().length()-1));
          if(key == Input.KEY_ENTER) {
              joueur.setGameBegin(false);
              joueur.setNewGame(false);
              joueur.setGameStart(true);
          }
        }
        else if(status==GameStatus.PlayArea) {
            switch (key) {
            case Input.KEY_UP:
                this.joueur.setDirection(0); 
                this.joueur.setMoving(true);
                break;

            case Input.KEY_LEFT:
                this.joueur.setDirection(1);
                this.joueur.setMoving(true);
                break;

            case Input.KEY_DOWN:
                this.joueur.setDirection(2);
                this.joueur.setMoving(true);
                break;

            case Input.KEY_RIGHT:
                this.joueur.setDirection(3);
                this.joueur.setMoving(true);
                break;
            case Input.KEY_ENTER :
                this.joueur.setMenu(true);
            }
        }
        else if(status==GameStatus.PlayMenu) {
            switch (key) {
                case Input.KEY_UP:
                    joueur.setDirection(1);
                    joueur.setMoving(true);
                    //System.out.println("up");
                break;
                case Input.KEY_DOWN:
                    joueur.setDirection(2);
                    joueur.setMoving(true);
                    //ystem.out.println("down");
                break;
                case Input.KEY_ENTER:
                    joueur.setDirection(3);
                    joueur.setMoving(true);
                    //System.out.println("enter");
                break;
            }
        }
}

    @Override
    public void keyReleased(int key, char c) {
     
            this.joueur.setMoving(false);
        
    }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void inputEnded() {
    }

    @Override
    public void inputStarted() {
    }

    private GameStatus getGameStatus() {
        GameStatus status = GameStatus.Unknown;
        if(joueur.getGameBegin() == true || joueur.getMenu() == true) {
            status = GameStatus.StartMenu;
        }
        if(joueur.getNewGame() == true){
            status = GameStatus.NewGameRequested;
        }
        if(joueur.getGameStart()== true && joueur.getNewGame() == false && joueur.getMenu() == false) {
            status = GameStatus.PlayArea;
        }
        if(joueur.getGameStart()== true && joueur.getNewGame() == false && joueur.getMenu() == true) {
            status = GameStatus.PlayMenu;
        }
        return status;
    }

   
  
    
}
