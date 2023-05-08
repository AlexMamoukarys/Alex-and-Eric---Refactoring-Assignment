import java.util.ArrayList;

class Compare {

    public static ArrayList<ArrayList<String>> flaggedContent = new ArrayList<ArrayList<String>>();
    public static ArrayList<String> flaggedLibraryFiles = new ArrayList<String>();

    public static void compareData(ArrayList<Haiku> submission, ArrayList<Haiku> library){
        boolean b = false;
        for(Haiku submissionHaiku: submission){
            for(Haiku libraryHaiku: library){
                for(String libraryLine: libraryHaiku.contents){
                    ArrayList<String> x = new ArrayList<String>();
                    for(String submissionLine: submissionHaiku.contents){
                        if(submissionLine.equals(libraryLine)){
                            x.add(submissionLine); // FIX THIS
                            b = true;
                        }
                    }
                    flaggedContent.add(x);                    
                    if(b == true){
                        System.out.println();
                        //add library file name to flaggedLiubraryFIles;
                        b = false;
                    }
                }
            }
        }

        for(String line: flaggedContent.get(0)){
            System.out.println(line);
        }
    }
}