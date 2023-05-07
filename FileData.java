import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// The parent class
class FileData {

    public String[] contents; // Contents are the (I assume) haikus? // NO, CONTENTS ARE THE LINES OF THE HAIKU
    //public static String name; All files have a name // NO NEED BECAUSE NAME CAN JUST BE AQUIRED USING getName()

    // USELESS
    public static void createHaiku(){

    }

    // EXPLAIN HOW THIS WORKS - PROBABLY NEED TO FIX UP BECAUSE IT'S ACTUALLY ABOUT LINES
    // Returns a String arraylist which holds the contents of each file (works with one file at a time).
    // Not String[] b/c we don't know how many haikus are in it // SINCE IT'S ABOUT LINES AND NOT HAIKUS, WE DO KNOW
    // Maybe this is the getContents() method from the UML diagram? // SURE
    public static ArrayList<String> readFileContents(File fileObject) throws IOException{
        BufferedReader inputStream = null;
        String line;
        ArrayList<String> fileContents = new ArrayList<String>();
        
        // BufferedReader needs try and catch + IOException
        try{
            inputStream = new BufferedReader(new FileReader(fileObject));
            while((line = inputStream.readLine()) != null){
        
                // Skips all the empty lines inside the file (So the spaces after each haiku)
                if (!line.equals("")){
                    // Put the line into the ArrayList
                    fileContents.add(line);
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
        return fileContents;        
    }

    public static void getContents(){ // NO NEED FOR GET AND SET, ONLY ONE
        
    }

    // DON'T NEED THIS - ONLY NEED FOR LIBRARY, NOT SUBMISSION
    // Takes a pathname (the folder name) and returns the list of files in the folder (so either the library or submissions folder)
    public static File[] getFilesInDirectory(String pathname){
        File folder = new File(pathname);
        File[] fileList = folder.listFiles();
        return fileList;
    }

    public static void addToArrayList(ArrayList<Haiku> storageArrayList, Haiku haiku){
        storageArrayList.add(haiku);
    }
}