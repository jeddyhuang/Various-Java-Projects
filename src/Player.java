import java.util.concurrent.atomic.AtomicInteger;

/**
 * A simple Player class which may cause race conditions in multi-thread program.
 * 
 */
public class Player {
    private AtomicInteger x;      //x position of the player
    private AtomicInteger y;      //y position of the player
    private int hp;     //health point of the player
    public static Object obj = new Object();
    
    public Player(int x, int y, int hp){
        this.x = new AtomicInteger(x);
        this.y = new AtomicInteger(y);
        this.hp = hp;
    }
    
    public void printPlayer(){
        System.out.printf("x position:\t%d\ny position:\t%d\nhealth point:\t%d\n", x.get(), y.get(), hp);
    }
    
    public void moveLeft(){
        x.decrementAndGet();
    }
    
    public void moveRight(){
        x.incrementAndGet();
    }
    
    public void moveUp(){
        y.decrementAndGet();
    }
    
    public void moveDown(){
        y.incrementAndGet();
    }
    
    public void loseHealth(){
        synchronized(obj) {
            hp --;
        }
    }
    
    public void gainHealth(){
        synchronized(obj) {
            hp ++;
        }
    }
}
