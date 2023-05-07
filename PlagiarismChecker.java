import java.io.IOException;
import java.util.ArrayList;

class PlagiarismChecker{
    
    public void checkPlagiarism() throws IOException{
        ArrayList<Haiku> library = new ArrayList<Haiku>();
        LibraryData libraryObject = new LibraryData();
        library = libraryObject.loadLibrary(library);

        // Testing if I can access library data
        System.out.println(library.get(0).getFileName());
        System.out.println(library.get(0).contents[0]);
        System.out.println(library.get(0).contents[1]);
        System.out.println(library.get(0).contents[2]);
        System.out.println(library.get(1).getFileName());
        System.out.println(library.get(1).contents[0]);
        System.out.println(library.get(1).contents[1]);
        System.out.println(library.get(1).contents[2]);
        System.out.println(library.get(2).getFileName());
        System.out.println(library.get(2).contents[0]);
        System.out.println(library.get(2).contents[1]);
        System.out.println(library.get(2).contents[2]);

        ArrayList<Haiku> submission = new ArrayList<Haiku>();
        SubmissionData submissionObject = new SubmissionData();
        submission = submissionObject.loadSubmission();
        //submission = submissionObject.loadSubmission(submission);

        // Testing if I can access submission data
        // PROBLEM: EVERY TIME addContents() IS CALLED, IT STARTS READING THE FILE FROM THE START
        // THIS MEANS IT WILL PRINT THE SAME HAIKU AGAIN AND AGAIN
        // HOW CAN WE GET THE BUFFERED READER TO PICK UP WHERE IT LEFT OFF, WITHOUT CHANGING THE METHOD TOO MUCH BC INHERITANCE?
        for(int j = 0; j < submission.size(); j++){
            Haiku hk = submission.get(j);
            String[] s = hk.getContents();
            System.out.println("haiku # " + j);
            System.out.println(s[0]);
            System.out.println(s[1]);
            System.out.println(s[2]);
        }
        
        /*
        System.out.println(submission.get(0).contents[0]);
        System.out.println(submission.get(0).contents[1]);
        System.out.println(submission.get(0).contents[2]);
        System.out.println(submission.get(1).contents[0]);
        System.out.println(submission.get(1).contents[1]);
        System.out.println(submission.get(1).contents[2]);
        System.out.println(submission.get(2).contents[0]);
        System.out.println(submission.get(2).contents[1]);
        System.out.println(submission.get(2).contents[2]);
        */

        // compare
        // export
    }
}