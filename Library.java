class Library extends File {
    
    public static void setName(){
        
    }

    public static void getName(){

    }

    public static void loadLibrary(){
        createArrayList();
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