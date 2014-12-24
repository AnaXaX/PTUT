/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;



/**
 *
 * @author Simka
 */
public class Carte {
    /*
        -- Cette classe permettra de gérer les maps (Transition / Colision ...)
    */
    
    private TiledMap map;
    
    public void init() throws SlickException{
        this.map = new TiledMap("ressource/map/map1.tmx");
    }
    
    public void render(){
        this.map.render(0, 0);
    }
    
}
