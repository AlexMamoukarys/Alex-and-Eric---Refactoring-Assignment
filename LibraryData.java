import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

// Subclass of FileData
class LibraryData extends FileData {

    public static File[] loadLibraryFolder(){
        File library = new File("library");
        File[] libraryFolder = library.listFiles();
        return libraryFolder;
    }

    public static void setHaikuName(Haiku haiku, File libraryFile){
        haiku.name = libraryFile.getName();
    }

    // Returns an ArrayList of Haikus
    public ArrayList<Haiku> loadLibrary(ArrayList<Haiku> library) throws IOException{
        
        // Using the method from the parent class, we can access the library folder
        File[] libraryFolder = loadLibraryFolder(); 

        // Loops through each file inside the library folder 
        for (File libraryFile: libraryFolder){
            // Creates a new Haiku object 
            Haiku haiku = new Haiku();
            
            //setLibraryFileName(haiku, libraryFile); <--- Don't need // AGREE, I THINK
            haiku.setFileName(libraryFile.getName());

            // Reads the library file and stores it's contents into this variable using the method from the parent class
            addContents(libraryFile, haiku);

            addToArrayList(library, haiku);
        }

        // Returns an ArrayList containing the name and contents of each Haiku in the Library
        return library;
    }
}