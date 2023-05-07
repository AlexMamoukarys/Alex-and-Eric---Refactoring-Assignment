import java.util.ArrayList;
class PlagiarismChecker{
    
    public void checkPlagiarism(){
        ArrayList<Haiku> library = new ArrayList<Haiku>();
        LibraryData libraryObject = new LibraryData();
        library = libraryObject.loadLibrary(library);
    }
}