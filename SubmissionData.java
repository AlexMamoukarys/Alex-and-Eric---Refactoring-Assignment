import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Child class of FileData
class SubmissionData extends FileData {

    // Returns a valid file that the user inputted to check for plagiarism
    public static File getSubmissionFile(){ 
        
        Scanner reader = new Scanner(System.in);

        // Allows user to enter a file name into the terminal
        System.out.println("Enter the file name of the submission that will be checked for plagiarism (including the file extension): ");
        String submissionFileName = reader.nextLine();
        
        // Accesses the submissions file
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

    // MAYBE PUT THIS CODE INTO PARENT CLASS (can be reused for LibraryData and SubmissionData)
    // EXPLAIN WHY WE DIDN'T PUT THIS METHOD INTO THE PARENT CLASS
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
                
                //Haiku haiku = new Haiku(); <--- creates a haiku object for every line read
                
                // Reads the line in the file if there is no empty space/empty line
                if (!line.equals("")){
                    
                    // Appends the read line into a specific index in the ArrayList from the Haiku class (can only hold 3 lines)
                    haiku.contents[i] = line;
                    
                    //System.out.println("added line " + haiku.contents[i]);
                    i++;

                    // Adds the entire haiku to the arraylist and creates a new Haiku object so it can continously repeat the process
                    if(i == 3){
                        haikuArrayList.add(haiku);
                        haiku = new Haiku();
                        //System.out.println("added haiku to arraylist and created new haiku object");
                    }
                }

                // When BufferedReader hits an empty line, it resets the 'i' counter so the lines of the next haiku can be stored correctly
                else if(line.equals("")){
                    i = 0;
                    //System.out.println("reset counter");
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
        // Wrote code to see if it works
        /*
        System.out.println("oooooooooooooooooooooooooooooo");
        for(int j = 0; j < haikuArrayList.size(); j++){
            Haiku hk = haikuArrayList.get(j);
            String[] s = hk.getContents();
            System.out.println(s[0]);
            System.out.println(s[1]);
            System.out.println(s[2]);
        }
        System.out.println("//////////////////////////////");
        */

        // Returns an ArrayList of Haiku objects (it's contents)
        return haikuArrayList;
    }


    public ArrayList<Haiku> loadSubmission(File submissionFile) throws IOException{
        
        // Gets submission file name that user typed
        //Haiku hk;


        ArrayList<Haiku> submission = this.addContents(submissionFile);

        // Wrote code to see if it works
        /*
        System.out.println("----------------");
        for(int i = 0; i < submission.size(); i++){
            hk = submission.get(i);
            System.out.println(hk.getContents()[0]);
            System.out.println(hk.getContents()[1]);
            System.out.println(hk.getContents()[2]);
            System.out.println("+++++++++++++++++++++++");
        }
        System.out.println("========================");
        */

        return submission;
    }

    /*
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
    */
}