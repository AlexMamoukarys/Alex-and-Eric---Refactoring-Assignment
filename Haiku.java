class Haiku {
    //private String filepath; // Idk if we need this // ME NEITHER, WE COULD DELETE AND ADD BACK IF NEED IT LATER
    private String name;
    public String[] contents = new String[3];

    // Sets a file name into the 'name' variable
    public void setFileName(String name){
        this.name = name;
    }

    // Returns the file name
    public String getFileName(){
        return this.name;
    }
}