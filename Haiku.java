class Haiku {
    public String filepath;
    public String name;
    public String[] contents = new String[2];

    public Haiku(String filepath, String name, String[] contents){
        this.filepath = filepath;
        this.name = name;
        this.contents = contents;
    }

}