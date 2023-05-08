import java.io.IOException;

class AlexAndEricRefactoringAssignment{
    public static void main(String[] args) throws IOException{
        // Creates the Plagiarism Checker Object to act as a facade to run the important methods 
        PlagiarismChecker plagiarismCheckerObject = new PlagiarismChecker();
        plagiarismCheckerObject.checkPlagiarism();
    }
}