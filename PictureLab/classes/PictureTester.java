/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
    /** Method to test zeroBlue */
    public static void testZeroBlue()
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

    /** Method to test mirrorVertical */
    public static void testMirrorVertical()
    {
        Picture caterpillar = new Picture("picopop_and_pocky.jpg");
        caterpillar.explore();
        caterpillar.mirrorVertical();
        caterpillar.explore();
    }

    public static void testMirrorVerticalRightToLeft()
    {
        Picture pic = new Picture("picopop_and_pocky.jpg");
        pic.explore();
        pic.mirrorVerticalRightToLeft();
        pic.explore();
    }

    public static void testMirrorHorizontal()
    {
        Picture pic = new Picture("picopop_and_pocky.jpg");
        pic.explore();
        pic.mirrorHorizontal();
        pic.explore();
    }

    public static void testMirrorHorizontalBottoTop()
    {
        Picture pic = new Picture("cheshire_cat.jpg");
        pic.explore();
        pic.mirrorHorizontalBottoTop();
        pic.explore();
    }

    /** Method to test mirrorTemple */
    public static void testMirrorTemple()
    {
        Picture temple = new Picture("temple.jpg");
        temple.explore();
        temple.mirrorTemple();
        temple.explore();
    }
    public static void testMirrorArms()
    {
        Picture pic = new Picture("snowman.jpg");
        pic.explore();
        pic.mirrorArms();
        pic.explore();
    }
    /** Method to test the collage method */
    public static void testCollage()
    {
        /*
        Picture canvas = new Picture("640x480.jpg");
        canvas.createCollage();
        canvas.explore();
        */
    }
   
    /** Method to test edgeDetection */
    public static void testEdgeDetection()
    {
        Picture swan = new Picture("swan.jpg");
        swan.edgeDetection(10);
        swan.explore();
    }
    public static void testMirrorGull()
    {
        Picture pic = new Picture("seagull.jpg");
        pic.explore();
        pic.mirrorGull();
        pic.explore();
    }
    
    public static void testKeepOnlyBlue()
    {
        Picture pic = new Picture("cheshire_cat.jpg");
        pic.explore();
        pic.keepOnlyBlue();
        pic.explore();
    }
    
    public static void testNegate()
    {
        Picture pic = new Picture("little_planets.jpg");
        pic.explore();
        pic.negate();
        pic.explore();
    }
    
    public static void gb()
    {
        Picture pic = new Picture("picopop_and_pocky.jpg");
        pic.explore();
        pic.negate();
        pic.grayscale();
        pic.mirrorVertical();
        pic.explore();
    }
    
    public static void testGrayscale()
    {
        Picture pic = new Picture("cheshire_cat.jpg");
        pic.explore();
        pic.grayscale();
        pic.explore();
        
     
    }
    
    public static void testMerge2()
    {
        Picture pic1 = new Picture("little_planets.jpg");
        Picture pic2 = new Picture(pic1);
        Picture finalpic = new Picture(pic1.getPixels2D().length, pic1.getPixels2D()[0].length*2);
        finalpic.merge2(pic1, pic2);
        
        pic1.explore();
        pic2.explore();

        finalpic.explore();
    }
    
    public static void testMerge4()
    {
        Picture pic1 = new Picture("picopop_and_pocky.jpg");
        Picture pic2 = new Picture(pic1);
        Picture pic3 = new Picture(pic2);
        Picture pic4 = new Picture(pic3);
        
        Picture finalpic = new Picture(pic1.getPixels2D().length*2, pic1.getPixels2D()[0].length*2);
        finalpic.merge4(pic1, pic2, pic3, pic4);
        
        finalpic.explore();
    }
    public static void testSepia()
    {
        Picture pic = new Picture("picopop_and_pocky.jpg");
        pic.explore();
        pic.sepia();
        pic.explore();
    }
    
    public static void testScaleByHalf()
    {
        Picture pic = new Picture("cheshire_cat.jpg");
        pic.explore();
        pic.scaleByHalf().explore();
    }
    
    public static void makeCollage()
    {
        Picture pic = Picture.makeCollage();
        pic.explore();
        pic.write("MyCollage.jpg");
    }
    /** Main method for testing.  Every class can have a main
     * method in Java */
    public static void main(String[] args)
    {
        // uncomment a call here to run a test
        // and comment out the ones you don't want
        // to run

    
        //testZeroBlue();
        //testKeepOnlyBlue();
        //testKeepOnlyRed();
        //testKeepOnlyGreen();
        //testNegate();
        //testGrayscale();
        //testFixUnderwater();
        
        //testMirrorTemple();
        //testMirrorArms();
        //testMirrorGull();
        //testMirrorDiagonal();
        //testCollage();
        //testCopy();
        //testEdgeDetection();
        //testEdgeDetection2();
        //testChromakey();
        //testEncodeAndDecode();
        //testGetCountRedOverValue(250);
        //testSetRedToHalfValueInTopHalf();
        //testClearBlueOverValue(200);
        //testGetAverageForColumn(0);
    }
}