import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
// import java.util.Scanner;
import java.io.PrintWriter;

class Export {

    public static void printFlaggedContent(ArrayList<String> flaggedContent, PrintWriter printWriter) {
        for(String line: flaggedContent){
            printWriter.println(line);
        }
    }
    
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

    public static void exportResults(File submissionFile, ArrayList<ArrayList<String>> flaggedContent, ArrayList<String> flaggedLibraryFiles, PrintWriter printWriter) throws IOException {
        
        printWriter.println("Submission File name: " + submissionFile.getName());
        printWriter.println();
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