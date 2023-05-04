class Submission extends File {
    
    int numberOfHaikus;
    

    public static void getNumberOfHaikus(){

    }

    public static void loadSubmission(){
        createArrayList();
        for(Haiku in submission){
            createHaiku();
            getContents();
            setContents();
            addToArrayList();
        }
    }
}