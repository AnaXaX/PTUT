
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.IOException;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SavedState;
import org.newdawn.slick.SlickException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Albert
 */
public class MenuGame {
    
    // GameBegin
    private Image background;
    private Image choixImg;
    private int choixContinue;
    private float choixX;
    private float choixY;

    private Joueur joueur;
    private JoueurCommande commande;
    
    //Menu inGame
    private Image menuImg;
    private int choixMenu;
    private XStream save;
    
    //Variable d'état
    private boolean gameTitle;
    
    public MenuGame(Joueur joueur, JoueurCommande commande){
        this.joueur =joueur;
        this.commande = commande;
    }
    
    public void init() throws SlickException {
        //GameBegin
        this.gameTitle = true;
        this.choixImg = new Image("ressource/Background/arrow.png");
        this.background = new Image("ressource/Background/bg_1.png");
        this.choixContinue = 1;
        this.choixX = 35;
        this.choixY = 47;
        
        //Menu Jeu
        this.menuImg = new Image("ressource/Pictures/Menu.png");
        this.choixMenu = 1;
    }
    
    public void render(Graphics g) throws SlickException, IOException {
        if(joueur.getGameBegin() == true) {
            background.draw(0, 0, 800, 600);
            if(joueur.getNewGame() == true) {
                g.drawString(joueur.getNom(), 450, 480);
            }       
            if(joueur.getNewGame() == false) {
                if(gameTitle == false) {
                    choixImg.draw(choixX, choixY);
                    g.setColor(Color.black);
                    g.drawString(joueur.getNom(),160,350);
                    g.drawString(Integer.toString(joueur.getGold()),160,410);
                    g.drawString(Integer.toString(joueur.getBadge()),180,470);
                    g.drawString(Integer.toString(joueur.getPokedex()),120,530);
               }
            }
        }
        if(joueur.getMenu() == true) {
            System.out.println(choixY);
            choixX= 570;
            menuImg.draw(0, 0, 800, 600);
            choixImg.draw(choixX,choixY);
        }
    }
    
    public void update() throws SlickException, InterruptedException, IOException {
        if(gameTitle == false && joueur.getNewGame() == false) background= new Image("ressource/Background/continue.png");
        if(joueur.getGameBegin() == true) {
            if(joueur.getMoving() == true) {
                switch (joueur.getDirection()) {
                    case 1:
                        if(choixContinue > 1){
                            choixContinue --;
                            choixY -= 60 ;
                            Thread.sleep(100);
                        }
                    break;
                    case 2:
                        if(choixContinue < 3) {
                            choixContinue ++;
                            choixY += 60; 
                            Thread.sleep(100);
                       }
                    break;
                    case 3:
                        if(gameTitle == false) {
                            if(choixContinue == 1) {
                                    joueur.setGameBegin(false);
                                    joueur.setGameStart(true);   
                           }
                            if(choixContinue == 2) {
                                joueur.setNewGame(true);
                                joueur.setNom("");
                                background = new Image("ressource/Background/newGame.png");
                           }
                        } 
                        else {
                            joueur.setDirection(1);
                            gameTitle = false;
                        }
                    break; 

               }
           }
        }
        if(joueur.getMenu() == true) {
            if(joueur.getMoving() == true) {
                switch (joueur.getDirection()) {
                    case 1:
                        if(choixMenu > 1){
                            choixMenu --;
                            choixY -= 60 ;
                            Thread.sleep(100);
                        }
                    break;
                    case 2:
                        if(choixMenu < 8) {
                            choixMenu ++;
                            choixY += 60; 
                            Thread.sleep(100);
                        }
                    break;
                    case 3:
                        if(choixMenu == 6) {  
                            
                            joueur.setMenu(false);
                           }
                        if(choixMenu == 8) joueur.setMenu(false);
                    break;
                }
            }
        }
    }
    public Image getChoixImg() {
        return choixImg;
    }
    public int getChoixContinue() {
        return choixContinue;
    }
    public void setChoixImg(Image choixImg) {
        this.choixImg = choixImg;
    }
    public void setChoixContinue(int choixContinue) {
        this.choixContinue = choixContinue;
    }
    public void setGameTitle(boolean gameTitle) {
        this.gameTitle = gameTitle;
    }
    public boolean getGameTitle() {
        return gameTitle;
    }

    /**
     * @return the choixMenu
     */
    public int getChoixMenu() {
        return choixMenu;
    }
}