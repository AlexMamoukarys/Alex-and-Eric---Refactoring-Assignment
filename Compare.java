import java.util.ArrayList;

class Compare {

    protected static ArrayList<ArrayList<String>> flaggedContent = new ArrayList<ArrayList<String>>();

    protected static ArrayList<String> flaggedLibraryFiles = new ArrayList<String>();

    public static void compareData(ArrayList<Haiku> submission, ArrayList<Haiku> library){
        int i = 0;
        int j = 0;

        flaggedContent.add(new ArrayList<String>());

        for(Haiku submissionHaiku: submission){
            for(Haiku libraryHaiku: library){
                for(String libraryLine: libraryHaiku.contents){
                    for(String submissionLine: submissionHaiku.contents){
                        if(submissionLine.equals(libraryLine)){
                            flaggedContent.get(j).add(submissionLine);
                            i++;
                            if(i % 3 == 0){
                                flaggedContent.add(new ArrayList<String>());
                                j++;
                            }
                            if(!flaggedLibraryFiles.contains(libraryHaiku.getFileName())){
                                flaggedLibraryFiles.add(libraryHaiku.getFileName());
                            }
                        }
                    }
                }
            }
        }
    }
}