import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class PlagiarismChecker{
    ArrayList<Haiku> library = new ArrayList<Haiku>();
    LibraryData libraryObject = new LibraryData();

    ArrayList<Haiku> submission = new ArrayList<Haiku>();
    SubmissionData submissionObject = new SubmissionData();

    public static PrintWriter initializePrintWriter() throws IOException{
        File resultsFolder = new File("results");
        
        // Initializes an array containing the filepaths of each results file
        File[] resultsFiles = resultsFolder.listFiles();
    
        FileWriter fileWriter = new FileWriter("results/results" + resultsFiles.length + ".csv");
        
        // Uses PrintWriter to write data to the results file
        PrintWriter printWriter = new PrintWriter(fileWriter);

        return printWriter;
    }

    public void checkPlagiarism() throws IOException{
        library = libraryObject.loadLibrary(library);

        File submissionFile = SubmissionData.getSubmissionFile();

        submission = submissionObject.loadSubmission(submissionFile);

        Compare.compareData(submission, library);

        PrintWriter printWriter = initializePrintWriter();
        Export.exportResults(submissionFile, Compare.flaggedContent, Compare.flaggedLibraryFiles, printWriter);
    }
}