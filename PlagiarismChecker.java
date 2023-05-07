import java.io.IOException;
import java.util.ArrayList;

class PlagiarismChecker{
    
    public void checkPlagiarism() throws IOException{
        ArrayList<Haiku> library = new ArrayList<Haiku>();
        LibraryData libraryObject = new LibraryData();
        library = libraryObject.loadLibrary(library);

        // Testing if I can access library data
        System.out.println(library.get(0).name);
        System.out.println(library.get(0).contents[0]);
        System.out.println(library.get(0).contents[1]);
        System.out.println(library.get(0).contents[2]);
        System.out.println(library.get(1).name);
        System.out.println(library.get(1).contents[0]);
        System.out.println(library.get(1).contents[1]);
        System.out.println(library.get(1).contents[2]);
        System.out.println(library.get(2).name);
        System.out.println(library.get(2).contents[0]);
        System.out.println(library.get(2).contents[1]);
        System.out.println(library.get(2).contents[2]);

        ArrayList<Haiku> submission = new ArrayList<Haiku>();
        SubmissionData submissionObject = new SubmissionData();
        submission = submissionObject.loadSubmission(submission);

        // Testing if I can access submission data
        // PROBLEM: EVERY TIME addContents() IS CALLED, IT STARTS READING THE FILE FROM THE START
        // THIS MEANS IT WILL PRINT THE SAME HAIKU AGAIN AND AGAIN
        // HOW CAN WE GET THE BUFFERED READER TO PICK UP WHERE IT LEFT OFF, WITHOUT CHANGING THE METHOD TOO MUCH BC INHERITANCE?
        System.out.println(submission.get(0).contents[0]);
        System.out.println(submission.get(0).contents[1]);
        System.out.println(submission.get(0).contents[2]);
        System.out.println(submission.get(1).contents[0]);
        System.out.println(submission.get(1).contents[1]);
        System.out.println(submission.get(1).contents[2]);

        // compare
        // export
    }
}