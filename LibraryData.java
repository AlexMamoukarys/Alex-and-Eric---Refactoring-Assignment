import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

// The subclass of FileData
class LibraryData extends FileData {

    /**
     * Loads the names of each library file's filepath
     * 
     * @return a file array with all of the library files' filepaths
     */
    public static File[] loadLibraryFolder(){
        File library = new File("library");
        File[] libraryFolder = library.listFiles();
        return libraryFolder;
    }

    /**
     * Loads the ArrayList of library Haiku Objects
     * 
     * @param library the ArrayList of library Haiku Objects
     * @return an ArrayList of Haikus from the library folder
     * @throws IOException
     */
    public ArrayList<Haiku> loadLibrary(ArrayList<Haiku> library) throws IOException{
        
        // Acts as a placeholder to access the files inside the library folder
        File[] libraryFolder = loadLibraryFolder(); 

        // Loops through each file inside the library folder 
        for (File libraryFile: libraryFolder){
            
            // Creates a new Haiku object 
            Haiku haiku = new Haiku();
                        
            // Sets and gets the file name of each library file
            haiku.setFileName(libraryFile.getName());

            // Reads and stores the Haiku's contents using the method from the parent class 
            addContents(libraryFile, haiku);

            // Appends the Haiku object to the ArrayList of Haiku Objects
            addToArrayList(library, haiku);
        }

        // Returns an ArrayList containing the name and contents of each Haiku in the Library
        return library;
    }
}