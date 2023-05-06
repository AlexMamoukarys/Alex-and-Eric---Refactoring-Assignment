import java.util.ArrayList;
import java.io.File;

class Library extends FileData {
    public String name;

    public void Library(){
        this.name = null;
        this.contents = null;
    }


    public static void setName(){
        
    }

    public static void getName(){

    }

    public static void loadLibraryFolder(){
        File libraryFolder = new File("library");

    }

    public static void loadLibrary(){
        ArrayList<Haiku> libraryStorage = new ArrayList<Haiku>();
        for(file in library){
            createHaiku();
            getName();
            setName();
            getContents();
            setContents();
            addToArrayList();
        }
    }
}