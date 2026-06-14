import processing.core.PApplet;

public class Mole {

    // instance variables
    PApplet app;
    private int x;
    private int y;
    private int diameter;
    boolean boom;
    //private boolean color;

    // constructor method
    Mole(PApplet app, int x, int y, int diameter) {
        this.app = app;
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        BoomIf();
    }

    private void BoomIf() {
        boom = Math.random() < 0.15; 
        //0.05 makes 5% 
    }
  

    // other methods

    public void display() {
        if (boom) {
            app.fill(243, 17, 17);//red balls
        } else {
            app.fill(251, 241, 26);//yellow balls
        }
        app.ellipse(x, y, diameter, diameter); //circles 
    }
    // public void display() {
        
    //     app.fill(243, 17, 17); // makes BOOM - BOOM (RED) 
    //     app.ellipse(x, y, diameter, diameter); //circle :)
    // }

    // public void display2() {
    //     app.fill(251, 241, 26); //yellow
    //     app.ellipse(x, y, diameter, diameter); 
    // }

//challenge of location
    public void updatePosition() {
        x = (int)(Math.random() * 550); 
        y = (int)(Math.random() * 550);
        //rand of BOOM
        BoomIf(); // BOOM??
    }

    public boolean getBoom(){
        return boom;
    }

//checkClick 
    public boolean checkClick(int mouseX, int mouseY) {
        double distance = calcD(mouseX, mouseY);
        if (distance < diameter/2) { 
            return true;
        } else {
            return false;
        }
        //changeBackground();
    }

    //calling method for calcD
    public double calcD(int x1, int y1){
        double diffX = x - x1;
        double diffY = y - y1;
        double distance = Math.sqrt((diffX * diffX)+(diffY * diffY));
        return distance;
    }

    // public boolean getBoom() {
    //     return boom;
    // }
}//end class