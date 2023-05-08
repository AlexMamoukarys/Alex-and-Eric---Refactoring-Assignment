import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
// import java.util.Scanner;
import java.io.PrintWriter;

class Export {

    // Prints out all of the plagiarised haikus and lines
    public static void printFlaggedContent(ArrayList<String> flaggedContent, PrintWriter printWriter) {
        for(String line: flaggedContent){
            printWriter.println(line);
        }
    }
    
    // EXPLAIN THAT WE COULDN'T GET THE OVERWRITING OF THE FILE TO WORK
    // public static int askOverwrite(File[] resultsFiles){
    //     Scanner reader = new Scanner(System.in);
        
    //     System.out.println("Do you wish to overwrite the latest results.csv file? (y/n): ");

    //     String overwriteChoice = reader.nextLine();

    //     reader.close();

    //     if (!overwriteChoice.equals("y") || !overwriteChoice.equals("n")) {
    //         System.out.println("Invalid file name.");
    //         askOverwrite(resultsFiles);
    //     }

    //     if(overwriteChoice == "y"){
    //         return resultsFiles.length - 1;
    //     }
    //     return resultsFiles.length;
    // }

    // Prints out all ofthe results in the .csv file
    public static void exportResults(File submissionFile, ArrayList<ArrayList<String>> flaggedContent, ArrayList<String> flaggedLibraryFiles, PrintWriter printWriter) throws IOException {
        
        // Prints the user-inputted submissions file name
        printWriter.println("Submission File name: " + submissionFile.getName());

        // All of printWriter.println() is to improve readability of the results.csv file
        printWriter.println();

        // Prints out the plagiarised haiku from the submissions file
        // and the name of the library file that got plagiarised
        for(int i = 0; i < flaggedContent.size() - 1; i++){
            printWriter.println("Flagged Content: ");
            printFlaggedContent(flaggedContent.get(i), printWriter);
            printWriter.println();
            printWriter.println("Located in library file: " + flaggedLibraryFiles.get(i));
            printWriter.println();
        }

        printWriter.close();
    }
}