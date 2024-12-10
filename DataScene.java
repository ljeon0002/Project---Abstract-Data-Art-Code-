import org.code.theater.*;
import java.util.Random;

/**
  The DataScene class extends the Scene class to visualize the rocket data
  It uses 1D arrays to store the names and impulse, calculates data such as averages and maximum speeds, and generates visual scenes with detailed information about liquid and solid rocket engines
 */
public class DataScene extends Scene
{
    // Arrays to hold rocket data
    private double[] liquidImpulse;
    private double[] solidImpulse;
    private String[] liquidNames;
    private String[] solidNames;
    private String[] textColors;

    // Variables for rocket impulse
    private double liquidAverage;
    private double liquidHighest;
    private double solidAverage;
    private double solidHighest;

    // Constants for images
    private static final String SOLID_IMAGE = "Static_Test_Firing_DM-2_for_Solid_Rocket_Booster_-_GPN-2000-000053.jpg";
    private static final String LIQUID_IMAGE = "SpaceX_Testing_Merlin_1D_Engine_In_Texas.jpg";

    /**
     * Constructor for initializing the DataScene object with the given data arrays
     */
    public DataScene(double[] liquidImpulse, String[] liquidNames, double[] solidImpulse, String[] solidNames)
    {
        this.liquidImpulse = liquidImpulse;
        this.liquidNames = liquidNames;
        this.solidImpulse = solidImpulse;
        this.solidNames = solidNames;
        getAverageAndFastest(); // averages and fastest impulses
    }

    
     //Calculates the average and fastest impulses for both
    private void getAverageAndFastest()
    {
        liquidHighest = findMax(liquidImpulse);
        liquidAverage = findAverage(liquidImpulse);
        solidHighest = findMax(solidImpulse);
        solidAverage = findAverage(solidImpulse);
    }

   
    private double findMax(double[] array) 
    {
        double max = array[0];
        for (double value : array) {
            max = Math.max(max, value);
        }
        return max;
    }

    /**
     * Calculates the average value
     */
    private double findAverage(double[] array)
    {
        double total = 0;
        for (double value : array) {
            total += value;
        }
        return total / array.length;
    }

    /**
     * Displays details for a liquid roceket, including its name, impulse, and a message about its efficiency
     */
    public void showLiquidDetails(int index)
    {
        String message = getLiquidMessage(index);
        drawEngineDetails("Liquid Rocket Engine", message, liquidNames[index], liquidImpulse[index], LIQUID_IMAGE, "red");
    }

    /**
     * Displays details for a solid roceket, including its name, impulse, and a message about its efficiency
     */
    public void showSolidDetails(int index)
    {
        String message = getSolidMessage(index);
        drawEngineDetails("Solid Rocket Engine", message, solidNames[index], solidImpulse[index], SOLID_IMAGE, "blue");
    }

    /**
     * Generates a message for a liquid rocket based on its impulse
     */
    private String getLiquidMessage(int index)
    {
        if (liquidImpulse[index] == liquidHighest)
        {
            return "Most efficent liquid engine";
        }
          
        else if (liquidImpulse[index] > liquidAverage && liquidImpulse[index] > solidHighest)
        {
            return "Very high efficency";
        }
          
        else
        {
            return "Good efficency";
        }
    }

    /**
     * Generates a message for a solid rocket based on its impulse
     */
    private String getSolidMessage(int index)
    {
        if (solidImpulse[index] == solidHighest)
        {
            return "Most efficent solid engine";
        }
          
        else if (solidImpulse[index] > solidAverage || solidImpulse[index] > liquidAverage)
        {
            return "Very high efficency";
        }
          
        else
        {
            return "Good efficency";
        }
    }

    
    private void drawEngineDetails(String title, String message, String name, double impulse, String image, String color)
    {
        drawImage(image, 0, 0, 500);
        setFillColor(color);
        drawRectangle(0, 300, 425, 125);
        setTextColor("white");
        setTextHeight(35);
        drawText(title, 65, 40);
        setTextHeight(25);
        drawText(message, 20, 325);
        setTextHeight(20);
        drawText(name, 20, 350);
        drawText("Specific Impulse: " + Math.round(impulse), 20, 375);
        playSound("yay-6326.wav");
        pause(5);
    }

    //Iterates through both rocket types to create visual for both 
     
    public void createScene()
    {
        for (int i = 0; i < liquidNames.length; i++)
        {
            createLiquidScene(i);
            createSolidScene(i);
        }
    }

    // Creates a scene for a specific solid rocket
     
    public void createSolidScene(int index)
    {
        drawEngineDetails("Solid Rocket Engine", getSolidMessage(index), solidNames[index], solidImpulse[index], SOLID_IMAGE, "red");
    }

    // Creates a scene for a specific liquid rocket
     
    public void createLiquidScene(int index)
    {
        drawEngineDetails("Liquid Rocket Engine", getLiquidMessage(index), liquidNames[index], liquidImpulse[index], LIQUID_IMAGE, "blue");
    }
}