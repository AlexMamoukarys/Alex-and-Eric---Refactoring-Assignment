import java.util.ArrayList;
import java.io.File;

// Child class of FilaData
class SubmissionData extends FileData {
    
    public int numberOfHaikus; // The additional property?

    public SubmissionData(){
        this.numberOfHaikus = 0; // Initially there are no haikus
        this.contents = null; // Initially there are no contents
    }

    /*
    // Method only does one thing, not needed
    public static void setSubmissionFileName(Haiku haiku, File submissionFile){
        haiku.name = submissionFile.getName();
    }
    */

    public static File[] loadSubmissionFolder(){
        File submissions = new File("submissions");
        File[] submissionFiles = submissions.listFiles();
        return submissionFiles;
    }

    // Use buffered reader
    public static void getNumberOfHaikus(){

    }

    public ArrayList<Haiku> loadSubmission(){
        ArrayList<Haiku> submissionStorage = new ArrayList<Haiku>();
        File[] submissionFolder = loadSubmissionFolder();
        for(File submissionFile: submissionFolder){
            Haiku haiku = new Haiku();
            
            //setSubmissionFileName(haiku, submissionFile); <--- Don't need this.
            //haiku.name = submissionFile.getName();

            haiku.setFileName(submissionFile.getName());

            //setContents(haiku, contents);
            
            addToArrayList(submissionStorage, haiku);

            System.out.println("There is a submission file");
        }
        return submissionStorage;
    }
    // public static void loadSubmission(){
    //     ArrayList<Haiku> submissionStorage = new ArrayList<Haiku>();
    //     for(Haiku in submission){
    //         Haiku haiku = new Haiku();

    //         createHaiku();
    //         getContents();
    //         setContents();
    //         addToArrayList(submissionStorage, haiku);
    //     }
    // }
}