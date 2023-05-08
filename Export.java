import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;

class Export {

    public static void printFlaggedContent(ArrayList<String> flaggedContent, PrintWriter printWriter) {
        System.out.println("Flagged Content: ");
        
        for(String line: flaggedContent){
            printWriter.println(line);
        }
    }
    
    public static void exportResults(File submissionFile, ArrayList<ArrayList<String>> flaggedContent, ArrayList<String> flaggedLibraryFiles, PrintWriter printWriter) throws IOException {
        
        printWriter.println("Submission File name: " + submissionFile);
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