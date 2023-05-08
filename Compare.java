import java.util.ArrayList;

class Compare {

    protected static ArrayList<ArrayList<String>> flaggedContent = new ArrayList<ArrayList<String>>();

    protected static ArrayList<String> flaggedLibraryFiles = new ArrayList<String>();

    /**
     * Compares all of the library haikus to each haiku in the submission file
     * 
     * @param submission the ArrayList of submission Haikus
     * @param library the ArrayList of library Haikus
     */
    public static void compareData(ArrayList<Haiku> submission, ArrayList<Haiku> library){
        int i = 0;
        int j = 0;

        // Creates a sub-ArrayList to be filled with the contents of one flagged Haiku, THEN stored in flaggedContent
        flaggedContent.add(new ArrayList<String>());

        // For every haiku in the submission ArrayList (from SubmissionData.java)
        for(Haiku submissionHaiku: submission){

            // And for every haiku in the library ArrayList (from LibraryData.java)
            for(Haiku libraryHaiku: library){

                // For every line/index in the library String[]
                for(String libraryLine: libraryHaiku.contents){

                    // For every line/index in the submission String[]
                    for(String submissionLine: submissionHaiku.contents){

                        // If both a library line and submission line is the same
                        if(submissionLine.equals(libraryLine)){

                            // Appends the plagiarised line into an ArrayList<String>
                            flaggedContent.get(j).add(submissionLine);
                            i++;

                            // Once 2 more lines are appended (the whole haiku is appended), 
                            // add a new sub-ArrayList to store the next plagiarized haiku
                            if(i % 3 == 0){
                                flaggedContent.add(new ArrayList<String>());
                                j++;
                            }

                            // Add the name of the library file that the flagged content was found in (if it hasn't already been added)
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