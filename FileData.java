import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// The parent class
// class FileData {
abstract class FileData {

    //public String[] contents; // Contents are the (I assume) haikus? // NO, CONTENTS ARE THE LINES OF THE HAIKU
    //public static String name; All files have a name // NO NEED BECAUSE NAME CAN JUST BE AQUIRED USING getName()

    // Maybe this is the getContents() method from the UML diagram? // SURE
    
    // Reads a file and stores the contents into a Haiku object(?) of ONE haiku
    public void addContents(File file, Haiku haiku) throws IOException{
        BufferedReader inputStream = null;
        String line;
        int i = 0;
        
        try{
            inputStream = new BufferedReader(new FileReader(file));
            while((line = inputStream.readLine()) != null){
        
                // Skips all the empty lines inside the file (So the spaces after each haiku)
                if (!line.equals("") || line.equals(null)){
                    
                    // Appends the read line into an array
                    haiku.contents[i] = line;
                }
                
                // TEMPORARY FIX (DOESN'T EVEN FULLY FIX THE PROBLEM) (SEE COMMENT ON PlagiarismChecker.java)
                // When BuffedReader reads 3 lines, the while loop will break (so it reads one haiku)
                if(i == 3){
                    break;
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

    // Appends a Haiku object into the ArrayList of Haiku objects
    public static void addToArrayList(ArrayList<Haiku> storageArrayList, Haiku haiku){
        storageArrayList.add(haiku);
    }
}