/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author Simka
 */
public class Joueur {
    
    //Animation
    private float x = 300, y = 300;
    private int direction;
    private boolean moving = false;
    private Animation[] animations = new Animation[8];
    private Carte map;
    
    // Variable d'état
    private boolean gameBegin;
    private boolean gameStart;
    private boolean gameBattle;
    private boolean newGame;
    
    //Variable menu
    private boolean menu;
            
    //Variable Stat (Nom,Gold,etc ...)
    private String nom;
    private int gold;
    private int badge;
    private int pokedex;
    
    public Joueur(Carte map){
        this.map = map;
    }
    
    public void init() throws SlickException {
        //Variable d'état
        this.gameBegin = true;
        this.gameStart = false;
        this.gameBattle = false;
        this.newGame = false;
        
        //Varialbe menu
        this.menu = false;
        
        //Variable Stat
        this.nom= "Momo";
        this.gold = 0;
        this.badge = 0;
        this.pokedex = 0;
        
        SpriteSheet spriteSheet = new SpriteSheet("ressource/sprites/spriteMomo.png", 57, 57);// image contenant les sprites
        // animations[0] pour aller au sud, [1] a l'ouest, [2] au nord [3] à l'est
        
        this.animations[0] = loadAnimation(spriteSheet, 0, 1, 3);//Dans les lignes avec loadAnimation
        this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);//(spriteSheet, x, final x, y)
        this.animations[2] = loadAnimation(spriteSheet, 0, 1, 0);//x represente la position initial du personnage 
        this.animations[3] = loadAnimation(spriteSheet, 0, 1, 2);//final x, represente la position final du personnage.
        this.animations[4] = loadAnimation(spriteSheet, 1, 3, 3);//y represente la ligne ou se situe le personnage
        this.animations[5] = loadAnimation(spriteSheet, 1, 3, 1);
        this.animations[6] = loadAnimation(spriteSheet, 1, 3, 0);
        this.animations[7] = loadAnimation(spriteSheet, 1, 3, 2);
    }
    
    // Cette méthode loadAnimation, permet d'effectuer les animations
    private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 200);
        }
        return animation;
    }
    
    /* Cete méthode permet d'afficher le personnage
            -fillOval permet de mettre une ombre sous le personnage.
    
    */
      public void render( Graphics g) throws SlickException {
        g.setColor(new Color(0, 0, 0, .5f));
        g.fillOval(x-30 , y - 6, 32, 16); 
        g.drawAnimation(animations[direction + (moving ? 4 : 0)], x - 40, y - 40);
    }
    
    // Cette méthode permet de mettre à jour la position du personnage
      public void update(int delta){
          if(gameStart == true && menu == false) {
            if (this.moving) {
             switch (this.direction) {
                 //0 sud, 1 ouest, 2 nord, 3 est ...
             case 0:
                 this.y -= .1f * delta;
                 break;
             case 1:
                 this.x -= .1f * delta;
                 break;
             case 2:
                 this.y += .1f * delta;
                 break;
             case 3:
                 this.x += .1f * delta;
                 break;
             }
           }
         }
       }
      
    public void transformerEn(Joueur data) {
        x = data.getX();
        y = data.getY();
        nom = data.getNom();
        gold = data.getGold();
        pokedex = data.getPokedex();
        direction = data.getDirection();
        gameStart = data.getGameStart();
    }
    /*      Les getteurs et setteur permettent, à partir de la classe JoueurCommande d'avoir acces
            à la position du personnage, savoir si il est en mouvement via sa direction et le boolean
            mooving.
    */
           
           public float getX(){
               return x;
           }
           
           public void setX(float x){
               this.x = x;
           }
           
           public float getY(){
               return y;
           }
           
           public void setY(float y){
               this.y = y;
           }
           
           public int getDirection (){
               return direction;
           }
           
           public void setDirection(int direction){
               this.direction = direction;
           }
           public boolean getMoving(){
               return moving;
           }
           public void setMoving(boolean moving){
               this.moving = moving;
           }
           public boolean getGameBegin() {
               return gameBegin;
           }
           public void setGameBegin(boolean gameBegin) {
               this.gameBegin = gameBegin;
           }
           public boolean getGameStart() {
               return gameStart;
           }
           public void setGameStart(boolean gameStart) {
               this.gameStart = gameStart;
           }
           public boolean getGameBattle() {
               return gameBattle;
           }
           public void setGameBattle(boolean gameBattle) {
               this.gameBattle = gameBattle;
           }
           public String getNom() {
               return nom;
           }
           public void setNom(String nom) {
               this.nom = nom;
           }
           public int getGold() {
               return gold;
           }
           public void setGold(int gold) {
               this.gold = gold;
           }
           public int getBadge() {
               return badge;
           }
           public void setBadge(int badge) {
               this.badge = badge;
           }
           public int getPokedex() {
               return pokedex;
           }
           public void setPokedex(int pokedex) {
               this.pokedex = pokedex;
           }
           public boolean getNewGame() {
               return newGame;
           }
           public void setNewGame(boolean newGame) {
               this.newGame = newGame;
           }
            public boolean getMenu() {
                return menu;
            }
            public void setMenu(boolean menu) {
                this.menu = menu;
            }

}
      
