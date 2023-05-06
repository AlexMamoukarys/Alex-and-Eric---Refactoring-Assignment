import java.util.ArrayList;

class SubmissionData extends FileData {
    
    int numberOfHaikus;

    public void Submission(){
        this.numberOfHaikus = 0;
        this.contents = null;
    }

    public static void getNumberOfHaikus(){

    }

    public static void loadSubmission(){
        ArrayList<Haiku> submissionStorage = new ArrayList<Haiku>();
        for(Haiku in submission){
            Haiku haiku = new Haiku();

            createHaiku();
            getContents();
            setContents();
            addToArrayList(submissionStorage, haiku);
        }
    }
}