import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Child class of FileData
class SubmissionData extends FileData {

    public SubmissionData(){ // DO WE NEED?

    }

    public static File getSubmissionFile(){ // MIGHT WANT TO CALL THIS IN PlagiarismChecker.jav SO WE CAN ACCESS LATER WHEN EXPORTING?
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter the file name of the submission that will be checked for plagiarism (including the file extension): ");
        String submissionFileName = reader.nextLine();
        
        File submissionFile = new File("submissions/" + submissionFileName);
        
        // COULD USE RECURSION HERE?
        while(!submissionFile.isFile()){
            System.out.println("Invalid file name. Please enter a valid file name");
            submissionFileName = reader.nextLine();
            submissionFile = new File("submissions/" + submissionFileName);
        }

        reader.close();

        return submissionFile;
    }

    public static int getNumberOfHaikus(File submissionFile) throws IOException{
        BufferedReader inputStream = null;
        String line;
        int counter = 0;
        
        inputStream = new BufferedReader(new FileReader(submissionFile));
        while((line = inputStream.readLine()) != null){
            if (!line.equals("")){
                counter++;
            }
        }
        
        inputStream.close();

        return counter/3;
    }

    public ArrayList<Haiku> loadSubmission(ArrayList<Haiku> submission) throws IOException{
        
        // Gets submission file name that user typed
        File submissionFile = getSubmissionFile();

        // Gets number of haikus inside the file the user typed
        int numberOfHaikus = getNumberOfHaikus(submissionFile);
        
        for(int j = 0; j < numberOfHaikus; j++){
            Haiku haiku = new Haiku();
            
            // PROBLEM: SEE COMMENT IN PlagiarismChecker.java
            addContents(submissionFile, haiku);

            addToArrayList(submission, haiku);
        }
        return submission;
    }
}