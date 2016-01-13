import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 * @editor Jack Brandt as of Jan 15
 */
public class Picture extends SimplePicture 
{
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments 
     */
    public Picture ()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();  
    }

    /**
     * Constructor that takes a file name and creates the picture 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
     * Constructor that takes a picture and creates a 
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() + 
            " height " + getHeight() 
            + " width " + getWidth();
        return output;

    }

    /** Method to set the blue to 0 */
    public void zeroBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setBlue(0);
            }
        }
    }

    public void keepOnlyBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] arr : pixels)
        {
            for (Pixel pixel : arr)
            {
                pixel.setRed(0);
                pixel.setGreen(0);
            }
        }
    }

    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from left to right */
    public void mirrorVertical()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
    }

    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from right to left */
    public void mirrorVerticalRightToLeft()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width/2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        } 
    }

    /** Method that mirrors the picture around a 
     * horizontal mirror in the center of the picture
     * from left to right */
    public void mirrorHorizontal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels[0].length;
        for (int row = 0; row < pixels.length/2; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                topPixel = pixels[height-1-row][col];
                bottomPixel = pixels[row][col];
                topPixel.setColor(bottomPixel.getColor());
            }
        } 
    }

    public void mirrorHorizontalBottoTop()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels[0].length;
        for (int row = 0; row < pixels.length/2; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                topPixel = pixels[height-1-row][col];
                bottomPixel = pixels[row][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        } 
    }

    /** Mirror just part of a picture of a temple */
    public void mirrorTemple()
    {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++)
            {
                count++;
                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
        System.out.println(count);
    }

    public void mirrorArms()
    {
        int mirrorPoint = 177;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 158; row < mirrorPoint; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 104; col < 295; col++)
            {
                count++;
                leftPixel = pixels[mirrorPoint-row+mirrorPoint][col];    
                rightPixel = pixels[row][col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
        System.out.println(count);
    }

    public void mirrorGull()
    {
        int mirrorPoint = 361;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 236; row < 350; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 233; col < mirrorPoint; col++)
            {
                count++;
                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }

    }

    /** copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, 
    int startRow, int startCol)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow; 
        fromRow < fromPixels.length &&
        toRow < toPixels.length; 
        fromRow++, toRow++)
        {
            for (int fromCol = 0, toCol = startCol; 
            fromCol < fromPixels[0].length &&
            toCol < toPixels[0].length;  
            fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }   
    }

    /** Method to create a collage of several pictures */
    public void createCollage()
    {
        Picture flower1 = new Picture("flower1.jpg");
        Picture flower2 = new Picture("flower2.jpg");
        this.copy(flower1,0,0);
        this.copy(flower2,100,0);
        this.copy(flower1,200,0);
        Picture flowerNoBlue = new Picture(flower2);
        flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue,300,0);
        this.copy(flower1,400,0);
        this.copy(flower2,500,0);
        this.mirrorVertical();
        this.write("collage.jpg");
    }

    /** Method to show large changes in color 
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; 
            col < pixels[0].length-1; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > 
                edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }

    public void negate()
    {

        Pixel[][] pixels = this.getPixels2D();

        for (Pixel[] arr : pixels)
        {
            for (Pixel pixel : arr)
            {
                pixel.setBlue(255-pixel.getBlue());
                pixel.setGreen(255-pixel.getGreen());
                pixel.setRed(255-pixel.getRed());
            }
        }
    }

    public void grayscale()
    {

        Pixel[][] pixels = this.getPixels2D();

        for (Pixel[] arr : pixels)
        {
            for (Pixel pixel : arr)
            {
                int avg = (int) ((pixel.getBlue()+pixel.getGreen()+pixel.getRed())/3.0);

                pixel.setBlue(avg);
                pixel.setGreen(avg);
                pixel.setRed(avg);
            }
        }
    }

    public void collage()
    {
        ;
    }

    /**
     * merges 2 images side by side
     * @pre dimensions of params are equal
     * 
     */
    public void merge2(Picture pic1, Picture pic2)
    {
        Pixel[][] pixels1 = pic1.getPixels2D();
        Pixel[][] pixels2 = pic2.getPixels2D();

        int height = pixels1.length;
        int width = pixels1[0].length;

        Pixel[][] finalpixels = this.getPixels2D();
        
        /**
         * Sets the final pic so that it should look like
         *       __________
         *      |PIC1  PIC2|
         *       __________ 
         */
        for (int row = 0; row < height; row++)
        {
            for (int col = 0; col < width; col++)
            {
                finalpixels[row][col].setColor(pixels1[row][col].getColor());
                finalpixels[row][width+col].setColor(pixels2[row][col].getColor());
            }
        }
    }
    
    public void merge4(Picture pic1, Picture pic2, Picture pic3, Picture pic4)
    {
        Pixel[][] pixels1 = pic1.getPixels2D();
        Pixel[][] pixels2 = pic2.getPixels2D();
        Pixel[][] pixels3 = pic3.getPixels2D();
        Pixel[][] pixels4 = pic4.getPixels2D();
        
        int height = pixels1.length;
        int width = pixels1[0].length;
        
        Pixel[][] finalpixels = this.getPixels2D();
        
        /**
         * Sets the final pic so that it should look like
         *    
         *    __________
         *   |PIC1  PIC2|
         *   |PIC3  PIC4|
         *    __________
         */
        
        for(int row = 0; row < height; row++)
        {
            for(int col = 0; col < width; col++)
            {
                finalpixels[row][col].setColor(pixels1[row][col].getColor());
                finalpixels[row][width+col].setColor(pixels2[row][col].getColor());
                finalpixels[row+height][col].setColor(pixels3[row][col].getColor());
                finalpixels[row+height][width+col].setColor(pixels4[row][col].getColor());
            }
        }
    }
    
    public void sepia()
    {
        this.grayscale();
        Pixel[][] pixels = this.getPixels2D();
        
        for (Pixel[] arr : pixels)
        {
            for (Pixel pixel : arr)
            {
                if (pixel.getRed() < 60)
                {
                    pixel.setRed((int)(pixel.getRed()*.9));
                    pixel.setGreen((int)(pixel.getGreen()*.9));
                    pixel.setBlue((int)(pixel.getBlue()*.9));
                }
                else if (pixel.getRed() < 190)
                {
                    pixel.setBlue((int)(pixel.getBlue()*.8));
                }
                else
                {
                    pixel.setBlue((int)(pixel.getBlue()*.9));
                }
            }
        }
    }
                    

    /* Main method for testing - each class in Java can have a main 
     * method 
     */
    public static void main(String[] args) 
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this
