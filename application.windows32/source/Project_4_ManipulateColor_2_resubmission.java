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

public class Project_4_ManipulateColor_2_resubmission extends PApplet {

PImage source;       // Source image
PImage img;       // Source image
PImage imgb;       // Source image
PImage destination;  // Destination image

public void setup() {
  source = loadImage("TestPhoto.jpg");
  //destination = loadImage("TestPhoto_result.jpg");
  img = loadImage("TestPhoto.jpg");
  imgb = loadImage("OIP.jpg");
  System.out.println("the height is " + source.height + ". Be sure to add this to the code line 8." );
  System.out.println("the width is " + source.width + "."); 
  
  imgb.resize(960, 768);
  destination = createImage(source.width, source.height, RGB);
}

public void draw() {  
  float threshold = 127;

  // We are going to look at both image's pixels
  source.loadPixels();
  destination.loadPixels();
  
  for (int x = 0; x < source.width; x++) {
    for (int y = 0; y < source.height; y++ ) {
      int loc = x + y*source.width;
      
      //loadPixels();
      noStroke();
      
      if(x % 2==0) destination.pixels[loc]  =color(img.pixels[loc]) ;  // reapply color 
      else destination.pixels[loc]  =color(imgb.pixels[loc]);
      }
  }

  // We changed the pixels in destination
  destination.updatePixels();
  // Display the destination
  image(destination,0,0);
}
  public void settings() {  size(960 , 768); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "Project_4_ManipulateColor_2_resubmission" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
