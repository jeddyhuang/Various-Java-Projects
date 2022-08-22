/**
 * A class that generates a 2-D char array representing an 'X'
 */
public class DrawX {
 
    private int size; 
    
    public DrawX(int size) {
        this.size = size; 
    }
       
    public char[][] generateArray() {
        
        char[][] xArray = new char[size][size]; 
        
        for (int i = 0; i < size; i ++) for (int j = 0; j < size; j ++) xArray[i][j] = ' ';
        
        for (int i = 0; i < size; i ++) {
            xArray[i][i] = '*';
            xArray[i][size - 1 - i] = '*';
        }
        
        return xArray; 
    }
}