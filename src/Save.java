
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Albert
 */
public class Save implements Serializable{
    
    private Joueur joueur;
    
    public Save(Joueur joueur) {
        this.joueur = joueur;
    }
    
    
}
