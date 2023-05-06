class Haiku {
    private String filepath; // Idk if we need this
    private String fileName;
    private String[] contents;

    // Initializes the constructor method
    public Haiku() {
        this.filepath = null;
        this.fileName = null;

        // We know each haiku will have 3 strings
        // this.contents = new String[2]; <--- This gets only 2 lines in a haiku
        this.contents = new String[3];
    }

    // Can use this method for both library and submission data
    public void setContents(String haikuText, int haikuLineIndex){
        // Stores each haiku line into a specific index of the array
        this.contents[haikuLineIndex] = haikuText;
    }

    // Sets a file name into the 'name' variable
    public void setFileName(String name){
        this.fileName = name;
    }

    // Returns the file name
    public String getFileName(){
        return this.fileName;
    }

    // Stores all 3 lines of a haiku into the contents array
    // Method overloading (not polymorphism) because the setContents method has different parameters in the same class
    public void setContents(String[] wholeHaiku){
        this.contents = wholeHaiku;
    }

    public String[] getContents(){
        return this.contents;
    }
}