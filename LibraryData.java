import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

// THe child class of FileData
class LibraryData extends FileData {

    public static File[] loadLibraryFolder(){
        File library = new File("library");
        File[] libraryFolder = library.listFiles();
        return libraryFolder;
    }

    public static void setHaikuName(Haiku haiku, File libraryFile){
        haiku.name = libraryFile.getName();
    }

    // Returns a Haiku arraylist of haikus
    public ArrayList<Haiku> loadLibrary(ArrayList<Haiku> library) throws IOException{
        
        // EXPLAIN
        // This variable is used to fetch the specific index (or line) of the haiku from each library file
        // and will store it into an array of strings (String[] haikuText)
        int arrayListIndex = 0;
        
        // Using the method from the parent class, we can access the library folder
        File[] libraryFolder = loadLibraryFolder(); 

        // Loops through each file inside the library folder 
        for (File libraryFile: libraryFolder){
            int counter = 0;

            // Creates a new haiku object 
            Haiku haiku = new Haiku();
            
            //setLibraryFileName(haiku, libraryFile); <--- Don't need // AGREE, I THINK
            haiku.setFileName(libraryFile.getName());

            // Reads the library file and stores it's contents into this variable using the method from the parent class
            haiku.contents = addLine(libraryFile);
            
            // Loops once for every 3 lines (haiku)
            // For example, if there are 2 haikus which are basically 6 lines long, divide by 3. This way, we can store each haiku separately
            counter = fileContents.size()/3;
            
            // Iterates through the amount of haikus there are 
            for (int i = 0; i < counter; i++){

                // Creates an array of strings which holds 3 lines (basically the haiku)
                String[] haikuText = new String[3];
                
                // Do not hardcode
                // Adds each line in the arraylist into each index of the array of strings variable (haikuText)
                // By the end of this section of code, haikuText will essentially hold the entire haiku
                haikuText[0] = fileContents.get(arrayListIndex);
                arrayListIndex++;
                haikuText[1] = fileContents.get(arrayListIndex);
                arrayListIndex++;
                haikuText[2] = fileContents.get(arrayListIndex);
                arrayListIndex++;

                // Creates new haiku object
                haiku = new Haiku();

                // setContents(String[] wholeHaiku) from the Haiku class will then store each haiku into a Haiku object
                haiku.setContents(haikuText);

                haiku.setFileName(name);
                // Adds the haiku into the storageArrayList arraylist
                addToArrayList(libraryStorage, haiku);
            }
            // Resets the index value so it can continue getting more haikus if there are more than one haiku inside the file
            arrayListIndex = 0;
            
            //System.out.println("There is a library file");
        }
    
        // Stores all the library files into an array list
        return library;
    }

    // This just prints out all the contents of each library file inside the library folder
    // I just put this in to see that it prints the contents out successfully in the terminal which it does :)
    public static void main(String[] args) throws IOException{
        ArrayList<Haiku> arrList = loadLibrary();

        // For each library file inside the library folder basically
        for (int i = 0; i < arrList.size(); i++){
            // Stores the contents of each library file into a haiku object and prints out the library file number
            Haiku eachHaiku = arrList.get(i);
            System.out.println("This is contents of library file #" + (i + 1) + " and from " + eachHaiku.getFileName());
            
            // Prints out each line / haiku of the library file
            for (int k = 0; k < 3; k++){
                System.out.println(eachHaiku.getContents()[k]);
            }
            System.out.println();
        }
    }
}