
import org.newdawn.slick.Music;
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
public class MusicGame {
    
    private MenuGame menuG;
    private Joueur joueur;
    
    // BGM
    private Music backgroundMusic;
    
    // SE
    private Music select;
    
    public MusicGame(Joueur joueur,MenuGame menuG) {
        this.joueur = joueur;
        this.menuG = menuG;
    }
    
    public void init() throws SlickException {
        
        this.backgroundMusic = new Music("ressource/Music/BGM/TitleMomo.ogg");
        backgroundMusic.loop();
        this.select = new Music("ressource/Music/SE/select.wav");
    }
    
    public void update() throws SlickException {
        if(menuG.getGameTitle() == false) {
            backgroundMusic.stop();
            if(this.joueur.getGameBegin() == true) {
                if(joueur.getMoving() == true) {
                    this.select.play();
                }
            }
        }
    }


    public Music getSelect() {
        return select;
    }
}
