/**
 * Tom Chiapete
 * Assignment 3 : Project Survey : Triangulation Class
 * October 4, 2005
 * 
 * This program will calculate two distances:
 * From one tripod to an object and from a second tripod to the same object.
 * The first tripod, the second tripod, and the object make up a triangle.
 * 
 * The program will ask for three inputs:
 * The angle measured at the first tripod, the angle measured at the second 
 * tripod, and the distance between those two tripods.
 * 
 * The distance between from the first tripod and the object, as well as 
 * the second tripod and the object, can be calculated using the 
 * Law of Sines.
 *
 * This program imports javax.swing for a more GUI feel.
 * 
 * Known bugs:  None.
 */

import javax.swing.*;

public class Triangulation
{
    /**
     * main() method
     * Starting point for execution.
     */
    public static void main(String [] args)
    {
        /** 
         * Note: Client is asked to input all angles in degrees, 
         * since they will be converted automatically to radians 
         * later in this program.
         */
        /**
         * USER INPUT
         * Read in the String from the showInputDialog() box, 
         * to tell what the angle given from the first tripod, and assign 
         * it to a line variable (type String).  Then parse a double 
         * from the line String, and place it in a1Deg (type double).
         */
        String line = JOptionPane.showInputDialog(null,
                "Please enter angle, in degrees, measured at first tripod:");
        double a1Deg = Double.parseDouble(line);
        
        // Like above, read in input, put it into a double, for 
        // angle given at second tripod.
        line = JOptionPane.showInputDialog(null,
                "Please enter angle, in degrees, measured at second tripod:");
        double a2Deg = Double.parseDouble(line);
        
        // Read in input, put it into a double, for distance between 
        // the two tripods.
        line = JOptionPane.showInputDialog(null,
                "Now, please enter the distance between "+
                "the first and second tripod:");
        double d3 = Double.parseDouble(line);
        
        
        /** CALCULATIONS
         *  Using some trigonometry, we can calculate the distance between
         *  the first tripod and the object, as well as the second tripod,
         *  and the object, using Law of Sines.
         */ 
        // First, calculate the third angle measure.
        double a3Deg = 180.0 - a1Deg - a2Deg;
        
        // Convert all three angles from degrees to radians.
        // Store them in new variables.
        double a1Rad = a1Deg * Math.PI/180.0; 
        double a2Rad = a2Deg * Math.PI/180.0; 
        double a3Rad = a3Deg * Math.PI/180.0; 
        
        // Using the Law of Sines, find the distance between the 
        // first tripod and the object.
        double d1 = (d3 * Math.sin(a1Rad)) / Math.sin(a3Rad);
        
        // Again, using the Law of Sines, find the distance between 
        // the second tripod and the object.
        double d2 = (d1 * Math.sin(a2Rad)) / Math.sin(a1Rad);
        
        // Neatly, output all the given and calculated information
        // in a showMessageDialog() box.
        JOptionPane.showMessageDialog(null,
                "Given:\n"+
                "First Tripod Angle Measure: "+a1Deg+",°\n"+
                "Second Tripod Angle Measure: "+a2Deg+"°,\n"+
                "Distance Between First and Second Tripod: "+d3+",\n"+
                "Assumed, Third Tripod Angle Measure: "+a3Deg+"°,\n"+
                "-----------------------------------------\n\n"+
                "Results:\n"+
                "Distance From First Tripod to Object: "+d2+",\n"+
                "Distance From Second Tripod to Object: "+d1+".");
    }
    
}
