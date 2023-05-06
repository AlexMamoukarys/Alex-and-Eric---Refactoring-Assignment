import java.util.ArrayList;
import java.io.File;

class LibraryData extends FileData {
    public String name;

    public void Library(){
        this.name = null;
        this.contents = null;
    }


    public static void setName(){
        
    }

    public static void getName(){

    }

    public static File[] loadLibraryFolder(){
        File library = new File("library");
        File[] libraryFolder = library.listFiles();
        return libraryFolder;
    }

    public static void loadLibrary(){
        ArrayList<Haiku> libraryStorage = new ArrayList<Haiku>();
        File[] libraryFolder = loadLibraryFolder();
        for(File libraryFile: libraryFolder){
            Haiku haiku = new Haiku();
            
            getName();
            setName();
            getContents();
            setContents();
            
            addToArrayList(libraryStorage, haiku);
        }
    }
}