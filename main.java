import java.awt.image.BufferedImage;

/**
 * Created by Joseph on 11/30/2017.
 */



public class main {


    public static void main(String[] args) {

        String filename = ""; // change to black and white file to be used
        myImage pong = new myImage(filename,480,640);

        int[][] bitArray;
        bitArray = generateBitArray(pong);
        convertToVerilog(bitArray,"data");
    }


   public static int[][] generateBitArray(myImage pic){
        int[][] bitArray;
        int height = pic.getHeight();
        int width = pic.getWidth();

        bitArray = new int[height][width];
        for(int i =0; i <height; i++){

            for(int j = 0; j<width; j++){
                int pixel = pic.getPixel(j,i);
                bitArray[i][j] = pixel == -1 ? 1:0 ;
                //System.out.print(bitArray[i][j]);
            }
           // System.out.println(" ");
        }

       return bitArray;


   }

   public static String convertToVerilog1(int[][] bitArray,String dataName){

       String assignStatment ="assign " + dataName +"[%d] = %d'd%s;";
       String output = "";

       for(int i =0; i<bitArray.length; i++){

           String binData = "";
           for(int j=0; j<bitArray[0].length;j++){

                binData += Integer.toString(bitArray[i][j]);
           }

           output += String.format(assignStatment,i ,bitArray[0].length,binData);
            output += "\n";
       }
       System.out.println(output);
       return output;
   }
    public static String convertToVerilog(int[][] bitArray,String dataName){

        String top =String.format("DEPTH = %d;\nWIDTH= %d;\nADDRESS_RADIX = DEC;\nDATA_RADIX = BIN;\nCONTENT\nBEGIN\n",bitArray.length,bitArray[0].length);
        String output = top;

        for(int i =0; i<bitArray.length; i++){

            String binData = "";
            binData += i +" : ";
            for(int j= bitArray[0].length-1; j >= 0 ;j--){

                binData += Integer.toString(bitArray[i][j]) ;
            }

            output += binData + ";";
            output += "\n";
        }
        output += "END;";
        System.out.println(output);
        return output;
    }
}