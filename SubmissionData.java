import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Child class of FileData
class SubmissionData extends FileData {

    public static File getSubmissionFile(){ 
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter the file name of the submission that will be checked for plagiarism (including the file extension): ");
        String submissionFileName = reader.nextLine();
        
        File submissionFile = new File("submissions/" + submissionFileName);

        if (!submissionFile.isFile()) {
            System.out.println("Invalid file name.");
            submissionFile = getSubmissionFile();
        }

        reader.close();

        return submissionFile;
    }

    // MAYBE PUT THIS CODE INTO PARENT CLASS (can be reused for LibraryData and SubmissionData)
    public ArrayList<Haiku> addContents(File file) throws IOException{
        ArrayList<Haiku> haikuArrayList = new ArrayList<Haiku>();
        BufferedReader inputStream = null;
        String line;
        int i = 0;
        
        // BufferedReader needs try and catch + IOException
        try{
            inputStream = new BufferedReader(new FileReader(file));
            Haiku haiku = new Haiku();

            while((line = inputStream.readLine()) != null){
                

                //Haiku haiku = new Haiku(); <--- creates a haiku object for every line read
                // Skips all the empty lines inside the file (So the spaces after each haiku)

                if (!line.equals("")){
                    // Put the line into the ArrayList
                    haiku.contents[i] = line;
                    //System.out.println("added line " + haiku.contents[i]);
                    i++;

                    // Adds haiku to arraylist
                    if(i == 3){
                        haikuArrayList.add(haiku);
                        haiku = new Haiku();
                        //System.out.println("added haiku to arraylist and created new haiku object");
                    }
                }

                // When it hits an empty line, resets counter, then creartes a new Haiku object
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