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

    public static Picture makeCollage()
    {
        Picture pic1 = new Picture("picopop_and_pocky.jpg");
        Picture pic2 = new Picture("picopop_and_pocky.jpg");
        Picture pic3 = new Picture("picopop_and_pocky.jpg");
        Picture pic4 = new Picture("picopop_and_pocky.jpg");

        pic2 = pic2.pic2();
        pic3.pic3();
        pic4.pic4();

        Picture penultimate_pic = new Picture(pic1.getHeight()*2, pic1.getWidth()*2);
        penultimate_pic.merge4(pic1, pic2, pic3, pic4);
        return penultimate_pic;

    }

    public Picture pic2()
    {
        Picture pic21 = this.scaleByHalf();
        Picture pic22 = new Picture(pic21);
        Picture pic23 = new Picture(pic22);
        Picture pic24 = new Picture(pic23);

        pic21.explore();

        Picture final_pic = new Picture(this.getPixels2D().length, this.getPixels2D()[0].length);
        final_pic.merge4(pic21, pic22, pic23, pic24);
        final_pic.grayscale();
        return final_pic;
    }

    public void pic3()
    {
        this.mirrorVertical();
        this.negate();
    }

    public void pic4()
    {
        this.mirrorHorizontal();
        this.posterizeByN(3);
        this.brightenTrueBlack();
    }
    


    /**
     * Don't know it this will work, but tries to brighten the image by increasing RGB by constant
     */
    public void brighten()
    {
        final double FACTOR = 1.5;

        Pixel[][] pixels = this.getPixels2D();

        for (Pixel[] arr : pixels)
        {
            for (Pixel pixel : arr)
            {
                pixel.setRed((int)(pixel.getRed()*FACTOR));
                pixel.setGreen((int)(pixel.getGreen()*FACTOR));
                pixel.setBlue((int)(pixel.getBlue()*FACTOR));
            }
        }

    }

    /**
     * Similar to brighten, just maintains "true black", hopefully avoiding washed-out style
     */
    public void brightenTrueBlack()
    {
        final double FACTOR = 1.5;

        Pixel[][] pixels = this.getPixels2D();

        for (Pixel[] arr : pixels)
        {
            for (Pixel pixel : arr)
            {
                if (!(pixel.getRed()==pixel.getBlue() && pixel.getBlue()==pixel.getGreen() && pixel.getRed()<70))
                {
                    pixel.setRed((int)(pixel.getRed()*FACTOR));
                    pixel.setGreen((int)(pixel.getGreen()*FACTOR));
                    pixel.setBlue((int)(pixel.getBlue()*FACTOR));
                }
            }
        }
    } 

    /*
     * 
     * Uses formula: f\left(x,y\right)=\ \operatorname{floor}\left(\frac{x}{\frac{256}{y}}\right)\cdot \frac{256}{y}+\frac{256}{2y}
     * Above is in LaTeX, where x is pixel.getFoo() and y is the amount of divisions, in this case, four.
     */
    public void posterize()
    {
        Pixel[][] pixels = this.getPixels2D();

        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                Pixel pixel = pixels[row][col];
                pixel.setRed((pixel.getRed()/64)*64+32);
                pixel.setGreen((pixel.getGreen()/64)*64+32);
                pixel.setBlue((pixel.getBlue()/64)*64+32);
                //Unnecessary iirc how object references work in Java, but just to be more obvious;
                pixels[row][col] = pixel;
            }
        }
    }

    /**
     * @param n how many divisions do I use for posterization
     */
    public void posterizeByN(int n)
    {
        Pixel[][] pixels = this.getPixels2D();

        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                Pixel pixel = pixels[row][col];
                pixel.setRed((pixel.getRed()/(256/n))*(256/n)+(256/(2*n)));
                pixel.setGreen((pixel.getGreen()/(256/n))*(256/n)+(256/(2*n)));
                pixel.setBlue((pixel.getBlue()/(256/n))*(256/n)+(256/(2*n)));
                //see above
                pixels[row][col] = pixel;
            }
        }
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

    public Picture scaleByHalf()
    {
        Pixel[][] pixels_init = this.getPixels2D();

        Picture final_pic = new Picture(pixels_init.length/2, pixels_init[0].length/2);

        Pixel[][] foo = new Pixel[1][3];

        Pixel[][] final_pixels = final_pic.getPixels2D();

        for (int row = 0; row < final_pixels.length; row++)
        {
            for (int col = 0; col < final_pixels[0].length; col++)
            {
                final_pic.setBasicPixel(row, col, this.getPixel((int)(2*row), (int)(2*col)).getColor().getRGB());
            }
        }
        return final_pic;

    }

    public Picture scaleByX(double x)
    {
        Pixel[][] pixels_init = this.getPixels2D();
        Picture final_pic = new Picture((int)(pixels_init.length*x), (int)(pixels_init[0].length*x));
        Pixel[][] final_pixels = final_pic.getPixels2D();

        for (int row = 0; row < final_pixels.length; row++)
        {
            for (int col = 0; col < final_pixels[0].length; col++)
            {
                final_pic.setBasicPixel(row, col, this.getPixel((int)(1/x)*(row), (int)(1/x)*(col)).getColor().getRGB());
            }
        }
        return final_pic;
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
