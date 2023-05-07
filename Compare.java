import java.util.ArrayList;

class Compare {

    public static String[][] flaggedContent;

    public static String[][] compareData(ArrayList<Haiku> submission, ArrayList<Haiku> library){
        for(Haiku submissionHaiku: submission){
            for(Haiku libraryHaiku: library){
                for(String libraryLine: libraryHaiku.contents){
                    for(String submissionLine: submissionHaiku.contents){
                        if(submissionLine.equals(libraryLine)){
                            System.out.println(submissionLine);
                        }
                    }
                }
            }
        }
        return flaggedContent;
    }
}