import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

class MamoukarysAlexHaiku {

    /**
     * Loads library files
     *
     * @return a string array of the contents of each file
     * @throws IOException
     */
    public static String[] loadLibrary() throws IOException{
        // Gets the library folder
        File libraryFolder = new File("library");
        // Initializes an array containing the filepaths of each library file
        File[] libraryFiles = libraryFolder.listFiles();

        // Initializes an array to hold the contents of each library file
        String[] libraryFileContents = new String[libraryFiles.length];
        // Use counter to represent the index of libraryFileContents
        int counter = 0;

        // Use BufferedReader to read each library file and store the contents in libraryFileContents
        for(File file: libraryFiles){
            BufferedReader inputStream = null;
            String line;
            try{
                libraryFileContents[counter] = "";
                inputStream = new BufferedReader(new FileReader(file));
                while((line = inputStream.readLine()) != null){
                    // Store each line of the library file in a single, mashed-together cell of the array
                    // This will later allow for easy comparison to the submission using .contains()
                    // Print "___" after every line is added
                    // This will later allow for easy separation of the lines when displaying results
                    libraryFileContents[counter] = libraryFileContents[counter] + line + "___";
                }
            }
            catch(IOException e){
                System.out.println(e);
            }
            finally{
                if(inputStream != null){
                    inputStream.close();
                }
            }
            counter++;
        }

        return libraryFileContents;
    }

    /**
     * Gets user to choose a submission file, validates and returns the filepath
     *
     * @return the user-chosen submission file's filepath
     */
    public static File getSubmissionName(){
        Scanner reader = new Scanner(System.in);

        // Prompts the user to enter the file name of a submission
        System.out.println("Enter the file name of the submission that will be checked for plagiarism (including the file extension): ");
        // Reads the user's chosen file name and stores it in fileName
        String fileName = reader.nextLine();

        // Recreates the submission file's filepath
        File submissionFileName = new File("submissions/" + fileName);

        // Uses the submission file's filepath to check if the file exists
        // While the file doesn't exist, reprompt the user to enter a valid file
        while(!submissionFileName.isFile()){
            System.out.println("Invalid file name. Please enter a valid file name");
            fileName = reader.nextLine();
            submissionFileName = new File("submissions/" + fileName);
        }

        reader.close();

        return submissionFileName;
    }

    /**
     * Loads given submission file
     *
     * @param submissionFileName name of submission file that is loaded
     * @see loadLibrary() method, load the submission file in a similar format
     * @return a string of the contents of the submission file
     * @throws IOException
     */
    public static String loadSubmission(File submissionFileName) throws IOException{
        BufferedReader inputStream = null;
        // Initializes a string to store the contents of the submission file
        String submission = "";
        String line;
        try{
            inputStream = new BufferedReader(new FileReader(submissionFileName));
            while((line = inputStream.readLine()) != null){
                    // Store each line of the submission file in a single, mashed-together string
                    // Print "___" after every line is added
                    // This will later allow for easy comparison to the library files using .contains()
                    submission = submission + line + "___";
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
        finally{
            if(inputStream != null){
                inputStream.close();
            }
        }
        return submission;
    }

    /**
     * Checks for plagiarism and creates results file
     *
     * @param libraryFileContents array of the contents of each library file
     * @param submission string of the contents of the submission file
     * @param submissionFileName name of the submission file
     * @throws IOException
     */
    public static void exportResults(String[] libraryFileContents, String submission, File submissionFileName) throws IOException{
        // Gets the library folder        
        File libraryFolder = new File("library");
        // Initializes an array containing the filepaths of each library file
        // Filepaths are referenced when writing the library file that contained flagged content
        File[] libraryFiles = libraryFolder.listFiles();

        // Gets the library folder        
        File resultsFolder = new File("results");
        // Initializes an array containing the filepaths of each results file
        File[] resultsFiles = resultsFolder.listFiles();

        // Prompts the user to overwrite either overwrite or create a new results.csv file
        // I couldn't get Scanner to work, but if I could, this is how I would implement the overwrite prompt

        // Scanner reader = new Scanner(System.in);
        // // Stores user input for overwriting or creating new results.csv file
        // String overwrite = "";
        // // Stores the number to designate to the new results file
        // int resultsFileNum = resultsFiles.length;

        // If there are no results files, no need to ask user if they want to overwrite
        // if(resultsFiles.length > 0){
        //     while(!overwrite.equals("1") || !overwrite.equals("2")){
        //         System.out.println("Enter 1 to overwrite the previous results file, enter 2 to create a new results file: ");
        //         overwrite = reader.nextLine();
        //     }
        //     // If user wants to overwrite the file, designate the previous results file number to the new results file
        //     if(overwrite.equals("1")){
        //         resultsFileNum = (resultsFiles.length - 1);
        //     }
        // }
       
        // reader.close();
       
        // I would change resultsFiles.length to resultsFileNum if Scanner worked
        // Creates a new results file
        // Uses resultsFiles.length to represent the version number of the results file
        FileWriter fileWriter = new FileWriter("results/results" + resultsFiles.length + ".csv");
        // Uses PrintWriter to write data to the results file
        PrintWriter printWriter = new PrintWriter(fileWriter);
       
        // For every library file, check if the contents of the library file appear in the submission
        for(int i = 0; i < libraryFileContents.length; i++){
            // Uses .contains() to check if the contents of each library file appear in submission
            // If there is plagiarized content, write data to results.csv
            if(submission.contains(libraryFileContents[i])){
                // Print the name of the submission file to results.csv
                // Uses .getName() to take the name from the end of the filepath provided by submissionFileName
                printWriter.println("Submission File Name: " + submissionFileName.getName());
                printWriter.println("");
               
                printWriter.println("Flagged Content: ");

                // Stores the contents of the library file that contained flagged content to use .split()
                String content = libraryFileContents[i];
                // Uses .split() to separate each line of the file so that the flagged content can be printed neatly in results.csv
                // This is why "___" was added to the end of every line in the loadLibrary() and loadSubmission() methods
                // "___" is a delimiter that marks the end of a line, that the following content should be printed on a new line
                // Stores each line of the flagged content in an array
                String[] lines = content.split("___");
                for(String line: lines){
                    // Prints each line of the flagged content in results.csv
                    printWriter.println(line);
                }

                printWriter.println("");
               
                // Prints the name of the library file that contained flagged content to results.csv
                // libraryFiles is an array of every library file's filepath
                // Uses .getName() to take the name from the end of the filepath provided by libraryFiles
                printWriter.println("Located in Library File: " + libraryFiles[i].getName());
                printWriter.println("");
                printWriter.println("");
            }
        }
        printWriter.close();
    }

    public static void main(String[] args) throws IOException{
        // Stores the contents of each library file in an array to be used in later methods as a parameter
        String[] libraryFileContents = loadLibrary();
        // Stores the name of the selected submission file to be used in later methods as a parameter
        File submissionFileName = getSubmissionName();
        // Stores the contents of the submission file to be used in later methods as a parameter
        String submission = loadSubmission(submissionFileName);
        // Checks for plagiarism
        // Exports results to results.csv by comparing content in library files with content in the submission file
        exportResults(libraryFileContents, submission, submissionFileName);
    }
}