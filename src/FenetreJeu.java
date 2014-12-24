/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SavedState;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Simka
 */

public class FenetreJeu extends BasicGame {
    /*
        Cette classe permet d'afficher notre jeu. 
    */
    private GameContainer container;
    private Carte map = new Carte();
    private Joueur joueur = new Joueur(map);
    private JoueurCommande commande = new JoueurCommande(this.joueur);
    private MenuGame menuG = new MenuGame(joueur,commande);
    private MusicGame music = new MusicGame(this.joueur,this.menuG);
    /*
        -- A l'heure actuelle, il manque les classes Musique, Caméra, Map (A completer), Quete, MainMenu
        -- 
    */
    public static void main(String []args) throws SlickException {
        new AppGameContainer(new FenetreJeu(),800, 600, false).start();
        
    }
    
    public FenetreJeu() throws SlickException {
        super("PTUT -DEMO");
    }
    
     //Cette methode init charge les ressources.
    @Override
    public void init(GameContainer gc) throws SlickException {
        this.container = container;
        this.map.init();
        this.joueur.init();
        this.menuG.init();
        this.music.init();
        gc.setTargetFrameRate(60);
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) throws SlickException {
        if(joueur.getGameStart()== true){
            this.map.render();
            this.joueur.render(grphcs);
        } 
        try {
            this.menuG.render(grphcs);
        } catch (IOException ex) {
            Logger.getLogger(FenetreJeu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        try {
            this.menuG.update();
        } catch (InterruptedException ex) {
            Logger.getLogger(FenetreJeu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FenetreJeu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.joueur.update(delta);
        this.music.update();
        
    }
     @Override
    public void keyReleased(int key, char c) {
        if (Input.KEY_SPACE == key) {
            this.container.exit();
        }
        else {
            this.commande.keyReleased(key, c);
        }
    }
  
    public void keyPressed(int key, char c) {
        this.commande.keyPressed(key, c);
    }

    /**
     * @param joueur the joueur to set
     */
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
}
