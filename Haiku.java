class Haiku {
    // The name attribute is private and can only be accessed using the getter and setter methods below
    private String name;
    protected String[] contents = new String[3];

    /**
     * Setter method - Accepts a file name (in the form of a String variable) to set the name of the file in the Haiku Object
     * 
     * @param name the name of the file that the Haiku is from
     */
    public void setFileName(String name){
        this.name = name;
    }

    /**
     * Getter method  - Returns the file name
     * 
     * @return the name of the file that the Haiku is from
     */
    public String getFileName(){
        return this.name;
    }
}