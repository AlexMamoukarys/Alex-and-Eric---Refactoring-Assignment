import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

// The subclass of FileData
class LibraryData extends FileData {

    // Returns a file array with all of the library files
    public static File[] loadLibraryFolder(){
        File library = new File("library");
        File[] libraryFolder = library.listFiles();
        return libraryFolder;
    }

    // Returns an ArrayList of Haikus from the library folder
    public ArrayList<Haiku> loadLibrary(ArrayList<Haiku> library) throws IOException{
        
        // Acts as a placefolder to access the files inside the library folder
        File[] libraryFolder = loadLibraryFolder(); 

        // Loops through each file inside the library folder 
        for (File libraryFile: libraryFolder){
            
            // Creates a new Haiku object 
            Haiku haiku = new Haiku();
            
            //setLibraryFileName(haiku, libraryFile); <--- Don't need // AGREE, I THINK
            
            // Gets the file name of each library file
            haiku.setFileName(libraryFile.getName());

            // Reads and stores the haiku of each library file using the method from the parent class 
            addContents(libraryFile, haiku);

            // Appends the Haiku object into an ArrayList of haikus
            addToArrayList(library, haiku);
        }

        // Returns an ArrayList containing the name and contents of each Haiku in the Library
        return library;
    }
}