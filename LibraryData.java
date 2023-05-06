import java.util.ArrayList;
import java.io.File;

class LibraryData extends FileData {
    public String name;

    public void LibraryData(){
        this.name = null;
        this.contents = null;
    }

    public static void setName(Haiku haiku, File libraryFile){
        haiku.name = libraryFile.getName();
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
            
            setName(haiku, libraryFile);

            setContents();
            
            addToArrayList(libraryStorage, haiku);
        }
    }
}