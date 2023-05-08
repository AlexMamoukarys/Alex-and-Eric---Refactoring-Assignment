import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * The parent class of LibraryData and SubmissionData
 * 
 * This class is abstract because its methods are inherited; there is no need to instantiate a FileData object
 */
abstract class FileData {    
    /**
     * Reads a file and stores its contents into a Haiku Object
     * 
     * This method was intended to work for both LibraryData and SubmissionData
     * However, we could not figure out how to make it work for both
     * So, we made another addContents() in SubmissionData
     * 
     * @param file the file to be read
     * @param haiku the Haiku Object to write file contents to 
     * @throws IOException
     */
    public void addContents(File file, Haiku haiku) throws IOException{
        // Initializes BufferedReader
        BufferedReader inputStream = null;
        String line;
        
        // Used to pass each line that BufferedReader to a new cell in the Haiku's contents attribute 
        int i = 0;
        
        try{
            inputStream = new BufferedReader(new FileReader(file));
            while((line = inputStream.readLine()) != null){
        
                // Skips all the empty lines inside the file (the spaces after each haiku)
                if (!line.equals("") || line.equals(null)){
                    
                    // Appends the read line into an array
                    haiku.contents[i] = line;
                }

                i++;
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
    }

    // Appends a Haiku object into the ArrayList of Haiku objects (used for library and submissio)
    public static void addToArrayList(ArrayList<Haiku> storageArrayList, Haiku haiku){
        storageArrayList.add(haiku);
    }
}