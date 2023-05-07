import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// The parent class
abstract class FileData {

    //public String[] contents; // Contents are the (I assume) haikus? // NO, CONTENTS ARE THE LINES OF THE HAIKU
    //public static String name; All files have a name // NO NEED BECAUSE NAME CAN JUST BE AQUIRED USING getName()

    // Maybe this is the getContents() method from the UML diagram? // SURE
    public void addContents(File file, Haiku haiku) throws IOException{
        BufferedReader inputStream = null;
        String line;
        int i = 0;
        
        // BufferedReader needs try and catch + IOException
        try{
            inputStream = new BufferedReader(new FileReader(file));
            while((line = inputStream.readLine()) != null){
        
                // Skips all the empty lines inside the file (So the spaces after each haiku)
                // Maybe add "|| line.equals(null)"
                if (!line.equals("")){
                    // Put the line into the ArrayList
                    haiku.contents[i] = line;
                }

                // TEMPORARY FIX (DOESN'T EVEN FULLY FIX THE PROBLEM) (SEE COMMENT ON PlagiarismChecker.java)
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

    public static void addToArrayList(ArrayList<Haiku> storageArrayList, Haiku haiku){
        storageArrayList.add(haiku);
    }
}