import java.util.ArrayList;

class Library extends File {
    String name;

    public void Library(){
        this.name = null;
        this.contents = null;
    }


    public static void setName(){
        
    }

    public static void getName(){

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