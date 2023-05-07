import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// The parent class
abstract class FileData {

    //public String[] contents; // Contents are the (I assume) haikus? // NO, CONTENTS ARE THE LINES OF THE HAIKU
    //public static String name; All files have a name // NO NEED BECAUSE NAME CAN JUST BE AQUIRED USING getName()

    // EXPLAIN HOW THIS WORKS - PROBABLY NEED TO FIX UP BECAUSE IT'S ACTUALLY ABOUT LINES
    // Returns a String arraylist which holds the contents of each file (works with one file at a time).
    // Not String[] b/c we don't know how many haikus are in it // SINCE IT'S ABOUT LINES AND NOT HAIKUS, WE DO KNOW
    // Maybe this is the getContents() method from the UML diagram? // SURE
    public static void addLine (File fileObject, Haiku haiku) throws IOException{
        BufferedReader inputStream = null;
        String line;
        int i = 0;
        
        // BufferedReader needs try and catch + IOException
        try{
            inputStream = new BufferedReader(new FileReader(fileObject));
            while((line = inputStream.readLine()) != null){
        
                // Skips all the empty lines inside the file (So the spaces after each haiku)
                // Maybe add "|| line.equals(null)"
                if (!line.equals("")){
                    // Put the line into the ArrayList
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

    public static void addToArrayList(ArrayList<Haiku> storageArrayList, Haiku haiku){
        storageArrayList.add(haiku);
    }
}