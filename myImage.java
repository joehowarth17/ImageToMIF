/**
 * Created by Joseph on 11/30/2017.
 */

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.imageio.ImageIO ;
import java.awt.*;
import java.io.File ;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class myImage {

    private int height;
    private int width;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    private String filename;

    private BufferedImage pic;
    private File f;

    private int[][] pixels;



    public myImage(String filename,int height, int width){

        this.height = height;
        this.width  = width;
        this.filename = filename;

        //read image
        try{
            f = new File(filename);
            System.out.println(f.getCanonicalPath());
            pic = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
            pic = ImageIO.read(f);
            System.out.println("Image Read.");
        }
        catch(IOException e){

            System.out.println(e);
        }

//        int pixl = pic.getRGB(166,146);
//        System.out.println(pixl);
//        Color rgb = new Color(pixl);
//        System.out.println(rgb.getRed() +" " + rgb.getGreen() +" " +rgb.getBlue());
//
//        int pixl2 = pic.getRGB(0,0);
//        System.out.println(pixl2);
//        Color rgb2 = new Color(pixl2);
//        System.out.println(rgb2.getRed() +" " + rgb2.getGreen() +" " +rgb2.getBlue());

        //get pixel array from image

        pixels = new int[width][height];
        int i =0;
        int j = 0;
        try{
        for ( i =0;i<height ;i++) {
           // System.out.print(i + " : ");
            for ( j = 0; j < width ; j++) {
                //System.out.println(j);
                pixels[j][i] = pic.getRGB(j,i);
            }
        }

        }catch(ArrayIndexOutOfBoundsException a){
            System.out.println(a);
            System.out.println("i: " +i);

            System.out.println("j: "+j);
        }
    }

    public void printPixel(int x, int y){


        System.out.println(pixels[x][y]);
    }

    public int getPixel(int x, int y){


        return pixels[x][y];
    }


//        public String toString(){
//
//            String result = "";
//
//            for(int i=0;i<width;i++){
//                for(int j=0;j<height;j++){
//
//                   result += pixels[i][j] + " ";
//                }
//                result += "\n";
//
//
//            }
//
//
//        return result;
//        }
    }




