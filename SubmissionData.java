import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Child class of FileData
class SubmissionData extends FileData {

    /**
     * Gets the user's desired submission file to check for plagiarism
     * 
     * @return a valid file that the user inputted to be checked for plagiarism
     */
    public static File getSubmissionFile(){ 
        
        Scanner reader = new Scanner(System.in);

        // Allows user to enter a file name into the terminal
        System.out.println("Enter the file name of the submission that will be checked for plagiarism (including the file extension): ");
        String submissionFileName = reader.nextLine();
        
        // Accesses the submission file
        File submissionFile = new File("submissions/" + submissionFileName);

        // Using recursion, it will continuously prompt the user to enter a valid file name to be checked for plagiarism
        if (!submissionFile.isFile()) {
            System.out.println("Invalid file name.");
            submissionFile = getSubmissionFile();
        }

        // Closes Scanner so no data accidentally leaks
        reader.close();

        // Returns the file that is to be checked for plagiarism
        return submissionFile;
    }

    /**
     * Reads and adds contents of a file to a Haiku Object
     * 
     * @see FileData.java addContents() for explanation of redundancy
     * 
     * @param file the file to be read
     * @return the ArrayList of Haiku Objects
     * @throws IOException
     */
    public ArrayList<Haiku> addContents(File file) throws IOException{

        // Stores all of the haikus inside a submission file into an ArrayList of Haikus
        ArrayList<Haiku> haikuArrayList = new ArrayList<Haiku>();
        BufferedReader inputStream = null;
        String line;
        int i = 0;
        
        try{
            inputStream = new BufferedReader(new FileReader(file));
            
            // Creates a new Haiku object (for every haiku inside the user-inputted submission file)
            Haiku haiku = new Haiku();

            // Reads each line in the submissions file
            while((line = inputStream.readLine()) != null){
                                
                // Reads the line in the file if there is no empty space/empty line
                if (!line.equals("")){
                    
                    // Appends the read line into a specific index in the ArrayList from the Haiku class (can only hold 3 lines)
                    haiku.contents[i] = line;
                    
                    i++;

                    // Adds the entire haiku to the arraylist and creates a new Haiku object so it can continously repeat the process
                    if(i == 3){
                        haikuArrayList.add(haiku);
                        haiku = new Haiku();
                    }
                }

                // When BufferedReader hits an empty line, it resets the 'i' counter so the lines of the next haiku can be stored correctly
                else if(line.equals("")){
                    i = 0;
                }
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

        // Returns an ArrayList of Haiku objects (its contents)
        return haikuArrayList;
    }

    /**
     * Reads and stores contents of the submission file
     * 
     * @param submissionFile the submission file to be read
     * @return the ArrayList of all submission Haikus
     * @throws IOException
     */
    public ArrayList<Haiku> loadSubmission(File submissionFile) throws IOException{

        ArrayList<Haiku> submission = this.addContents(submissionFile);

        return submission;
    }
}