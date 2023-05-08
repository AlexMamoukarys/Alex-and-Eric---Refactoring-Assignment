class Haiku {
    private String name;
    protected String[] contents = new String[3];

    // Setter method - Sets a file name equal to a String variable to get the name of a file
    public void setFileName(String name){
        this.name = name;
    }

    // Getter method  - Returns the file name
    public String getFileName(){
        return this.name;
    }
}