class Haiku {
    //private String filepath; // Idk if we need this // ME NEITHER, WE COULD DELETE AND ADD BACK IF NEED IT LATER
    private String name;
    public String[] contents = new String[3];

    // Initializes the constructor method
    public Haiku() {
        //this.filepath = null;
        this.name = null;
    }

    // NEED YOU TO EXPLAIN EVERYTHING BELOW // A LOT OF THIS STUFF IS PROBABLY USELESS NOW - WE DO NEED THE NAME STUFF FOR PRIVATE
    // Can use this method for both library and submission data
    public void setContents(String haikuText, int haikuLineIndex){
        // Stores each haiku line into a specific index of the array
        this.contents[haikuLineIndex] = haikuText;
    }

    // Sets a file name into the 'name' variable
    public void setFileName(String name){
        this.name = name;
    }

    // Returns the file name
    public String getFileName(){
        return this.name;
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