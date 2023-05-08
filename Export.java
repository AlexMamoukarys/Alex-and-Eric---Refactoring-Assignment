import java.io.File;
import java.util.ArrayList;

class Export {
    public static void printFileName(String fileName){
        System.out.println(fileName);
    }

    public static void printFlaggedContent(ArrayList<ArrayList<String>> flaggedContent){
        System.out.println("Flagged Content: ");
        
        int i = 0;
        for(String line: flaggedContent.get(i)){
                System.out.println(line);
                if(i % 3 == 0){
                    System.out.println();
                }
                i++;
        }
    }

    public static void exportResults(File submissionFile, ArrayList<ArrayList<String>> flaggedContent, ArrayList<String> flaggedLibraryFiles){
        printFileName(submissionFile.getName()); 

        for(int i = 0; i < flaggedContent.size(); i++){
            printFlaggedContent(flaggedContent);
            printFileName(flaggedLibraryFiles.get(i));
        }
    }
}