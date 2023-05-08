import java.util.ArrayList;

class Compare {

    public static ArrayList<ArrayList<String>> flaggedContent = new ArrayList<ArrayList<String>>();
    public static ArrayList<String> flaggedLibraryFiles = new ArrayList<String>();

    public static void compareData(ArrayList<Haiku> submission, ArrayList<Haiku> library){
        for(Haiku submissionHaiku: submission){
            for(Haiku libraryHaiku: library){
                for(String libraryLine: libraryHaiku.contents){
                    for(String submissionLine: submissionHaiku.contents){
                        if(submissionLine.equals(libraryLine)){
                            flaggedContent.get(0).add(submissionLine); // FIX THIS
                        }
                    }
                }
            }
        }
    }
}