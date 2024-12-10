import org.code.theater.*;

public class TheaterRunner {
    public static void main(String[] args) {
       /**
         * Read data from files
        */
        // Reading the new data from different files
        String[] liquidNamesArray = FileReader.toStringArray("LiquidNames.txt");
        double[] liquidImpulseArray = FileReader.toDoubleArray("LiquidImpulse.txt");
        String[] solidNamesArray = FileReader.toStringArray("SolidNames.txt");
        double[] solidImpulseArray = FileReader.toDoubleArray("SolidImpulse.txt");


        /**
         * Create a DataScene object
        */
        DataScene myDataScene = new DataScene(liquidImpulseArray, liquidNamesArray, solidImpulseArray, solidNamesArray);

        // Create and play scenes
        myDataScene.createScene();
        Theater.playScenes(myDataScene);

    }
}