import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class OriginalFractal extends PApplet {

public void setup(){
	size(500,500);
	
}

public void draw(){
	background(0);
	fill(25,25,112);
	for(int n=0; n < 10; n++)
	{
		myFractal((int)(Math.random()*500), (int)(Math.random()*500), 100);
	}
}

public void myFractal(int x, int y, int siz){
		ellipse(x, y, siz/2, siz/2);
		if(siz > 5){
			pushMatrix();
		    translate(x-siz/2,y);
		    rotate(-PI/4);
		    myFractal(0,0,siz/2);
		    popMatrix();
		    pushMatrix();
		    translate(x+siz/2,y);
		    rotate(PI/4);
		    myFractal(0,0,siz/2);
	    	popMatrix();
	    	myFractal(x,y,siz/2);
		}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OriginalFractal" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
