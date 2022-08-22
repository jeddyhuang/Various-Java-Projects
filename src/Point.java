public final class Point {
    private int x;
    private int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public static void main(String[] args){
        Point point0;
        Point point1;
        
        point0 = new Point(0,0);
        point1 = new Point(0,0);
        
        System.out.println(point0 == point1);
    }
}