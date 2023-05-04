import java.util.ArrayList;

class PlagiarismChecker {
    public static void main(String[] args){
        ArrayList<Haiku> ha = new ArrayList<Haiku>();

        Haiku grah = new Haiku("library/MB1.txt", "MB1.txt", null);
        Haiku grah2 = new Haiku("library/MB2.txt", "MB2.txt", null);

        LOAD LIB CLASS
        create arraylist
        for(file in library){
            create haiku Object
            // get and set filepath - might not need it
            get and set Name
            get and set contents
            add to arraylist
        }

        LOAD SUB CLASS
        create arraylist
        for(haiku in submission){
            create haiku
            get and set contents
            add to arraylist            
        }

        ha.add(grah);

        ha.add(grah2);

        System.out.println(ha.get(0).name);
        System.out.println(ha.get(1).name);

    }
}