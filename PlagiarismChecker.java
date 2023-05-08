import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class PlagiarismChecker{
    // Initializes ArrayLists to hold all library and submission Haikus
    ArrayList<Haiku> library = new ArrayList<Haiku>();
    ArrayList<Haiku> submission = new ArrayList<Haiku>();
    
    // Initializes library and submission Objects to use each classes' methods and attributes
    LibraryData libraryObject = new LibraryData();
    SubmissionData submissionObject = new SubmissionData();

    /**
     * Initializes PrintWriter to write to results.csv 
     * 
     * @return the PrintWriter Object
     * @throws IOException
     */
    public static PrintWriter initializePrintWriter() throws IOException{
        // Initializes an array containing the filepaths of each results file
        File resultsFolder = new File("results");
        File[] resultsFiles = resultsFolder.listFiles();
    
        /*
         * Creates a new results.csv file (results1.csv) to write to
         * We could not get the ask-to-overwrite functionality to work due to issues with Scanner
         * Below is how we would have done it if Scanner worked
         * 
         * int resultsFileNum = Export.askOverwrite(resultsFiles);
         * resultsFiles.length would become resultsFileNum
         */
        FileWriter fileWriter = new FileWriter("results/results" + resultsFiles.length + ".csv");
        
        PrintWriter printWriter = new PrintWriter(fileWriter);

        return printWriter;
    }

    /**
     * Acts as the main through which the important methods are executed
     * 
     * @throws IOException
     */
    public void checkPlagiarism() throws IOException{
        // Loads the ArrayList of library Haikus
        library = libraryObject.loadLibrary(library);

        // Gets the submission file's name using a method in the SubmissionData class - asks user for desired submission file
        File submissionFile = SubmissionData.getSubmissionFile();
        
        // Loads the ArrayList of submission Haikus
        submission = submissionObject.loadSubmission(submissionFile);

        // Runs the method to check for plagiarized content
        Compare.compareData(submission, library);

        // Initializes the PrintWriter Object and runs the method to export results
        PrintWriter printWriter = initializePrintWriter();
        Export.exportResults(submissionFile, Compare.flaggedContent, Compare.flaggedLibraryFiles, printWriter);
    }
}