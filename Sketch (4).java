import processing.core.PApplet;

public class Sketch extends PApplet {
    Mole[] moles; // creating moles
    int numMoles = 15; //just 5 cirlces
    int score;
    int size;
    

    public void settings() {
        size(600, 600);
    }

    public void setup() { 
        moles = new Mole[numMoles]; //new moles:)
        for (int i = 0; i < numMoles; i++){
            int x = (int)random(50, width - 50); //rand min
            int y = (int)random(50, height - 50); //rand max
            
            size = (int)random(20, 80); //rand size

            //let's create new moles?
            moles[i] = new Mole(this, x, y, size);// new cirlces
        }
    }

    public void draw() {
        background(4, 9, 44);
        fill(157, 90, 191);
        textSize(60);
        text(score, 250, 250);

        if (frameCount % 100 == 0) {
            int randLocation = (int)random(numMoles);
            moles[randLocation].updatePosition();
        }// different every sec

        for(int i = 0; i < numMoles; i++){
            moles[i].display();
        }//cirlces caming in the skreen
    }
    
    public void  mousePressed() {
        boolean touch = false;//touch yes or no
        for (int i = 0; i < numMoles; i++) {
            if (moles[i].checkClick(mouseX, mouseY)) {
                touch = true; 
                //so deacrese
                if(moles[i].boom) {
                    //score
                    score--;
                    System.out.println("Chk-Chk boom!");
                } else {
                    //increases
                    score++;
                    System.out.println("YES");
                }
                moles[i].updatePosition();//changing places
            } // end if
        }// end for
    

        //Missed touch
        if(!touch){
            System.out.println("Oh no, -1");
            score--;
            }
        //not negative
        if(score < 0) {
            score = 5;
        }
    }
}