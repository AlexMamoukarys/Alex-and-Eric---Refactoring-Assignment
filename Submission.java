import java.util.ArrayList;

class Submission extends File {
    
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
            createHaiku();
            getContents();
            setContents();
            addToArrayList();
        }
    }
}