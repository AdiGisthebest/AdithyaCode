import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
class Family {
    public void read() {
        File file = null;
        Scanner scan = null;
        HashMap<String,Cow> cowSet = new HashMap<>();
        try {
            file = new File("family.in");
            scan = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] arr = scan.nextLine().split(" ");
        int length = Integer.parseInt(arr[0]);
        Cow bessie = new Cow(arr[1]);
        Cow elsie = new Cow(arr[2]);
        cowSet.put(arr[1],bessie);
        cowSet.put(arr[2],elsie);
        for(int i = 0; i < length; i++) {
            String[] arrs = scan.nextLine().split(" ");
            String cow1 = arrs[0];
            String cow2 = arrs[1];
            if (cowSet.containsKey(cow1) && cowSet.containsKey(cow2)) {
                Cow cow1Obj = cowSet.get(cow1);
                Cow cow2Obj = cowSet.get(cow2);
                cow1Obj.addChild(cow2Obj);
                cow2Obj.addParent(cow1Obj);
            } else if (cowSet.containsKey(cow1)) {
                Cow cow1Obj = cowSet.get(cow1);
                Cow cow2Obj = new Cow(cow2);
                cow1Obj.addChild(cow2Obj);
                cow2Obj.addParent(cow1Obj);
                cowSet.put(cow2, cow2Obj);
            } else if (cowSet.containsKey(cow2)) {

                Cow cow1Obj = new Cow(cow1);
                Cow cow2Obj = cowSet.get(cow2);
                cow1Obj.addChild(cow2Obj);
                cow2Obj.addParent(cow1Obj);
                cowSet.put(cow1, cow1Obj);
            } else {
                Cow cow1Obj = new Cow(cow1);
                Cow cow2Obj = new Cow(cow2);
                cow1Obj.addChild(cow2Obj);
                cow2Obj.addParent(cow1Obj);
                cowSet.put(cow1, cow1Obj);
                cowSet.put(cow2, cow2Obj);
            }
        }
        if(this.related(bessie,elsie)) {
            if(!this.directlyRelated(bessie,elsie,0).equals("false")) {
                System.out.println(elsie.name + " is the " + this.directlyRelated(bessie,elsie,0)+ " of " + bessie.name);
            } else if (this.checkSiblings(bessie,elsie)){
                System.out.println("SIBLINGS");
            } else if (!this.directlyRelated(elsie,bessie,0).equals("false")) {
                System.out.println(bessie.name + " is the " +this.directlyRelated(elsie,bessie,0)+ " of " + elsie.name);
            } else if(!this.giveAuntRelationship(elsie,bessie,0).equals("false")) {
                System.out.println(bessie.name + " is the " +this.giveAuntRelationship(elsie,bessie,0)+ " of " + elsie.name);
            } else if (!this.giveAuntRelationship(bessie,elsie,0).equals("false")) {
                System.out.println(elsie.name + " is the " +this.giveAuntRelationship(bessie,elsie,0)+ " of " + bessie.name);
            } else {
                System.out.println("COUSINS");
            }
        } else {
            System.out.println("NOT RELATED");
        }
    }
    public void solve() {

    }
    public boolean related(Cow cow1, Cow cow2) {
        if(cow1.parent == null && cow2.parent == null) {
            if(cow1.name.equals(cow2.name)) {
                return true;
            } else {
                return false;
            }
        } else if(cow2.parent == null){
            return this.related(cow1.parent,cow2);
        } else if (cow1.parent == null) {
            return this.related(cow1,cow2.parent);
        } else {
            if(cow1 == cow2) {
                return true;
            }
        }
        //System.out.println(cow1.name + " " +cow2.name);
        return this.related(cow1.parent,cow2.parent);
    }
    public String directlyRelated(Cow cow1, Cow cow2, int iter) {
        if(cow1.parent == null) {
            return "false";
        }
        if(cow1.parent == cow2) {
            String retString = "";
            switch(iter) {
                case 0:
                    retString = "mother";
                break;
                case 1:
                    retString = "grand-mother";
                break;
                default:
                    String append = "";
                    for(int i = 0; i < iter - 1; i ++) {
                        append = append + "great-";
                    }
                    return append + "grand-mother";
            }
            return retString;
        }
        return this.directlyRelated(cow1.parent,cow2, iter + 1);
    }
    public String giveAuntRelationship(Cow cow1, Cow cow2, int iter) {
        if(cow1.parent == null) {
            return "false";
        }
        if(cow1.parent.children.contains(cow2)) {
            String append = "";
            for(int i = 0; i < iter - 1; i++) {
                append= append + "great-";
            }
            return append+"aunt";
        }
        return this.giveAuntRelationship(cow1.parent,cow2,iter+1);
    }
    public boolean checkSiblings(Cow cow1, Cow cow2) {
        if(cow1.parent.children.contains(cow2)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        try {
            File file = new File("family.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Family family = new Family();
        family.read();
    }
}
class Cow {
    ArrayList<Cow> children = new ArrayList<>();
    String name;
    Cow parent;
    public Cow(String cowName) {
        name = cowName;
    }
    public void addParent(Cow cow) {
        parent = cow;
    }
    public void addChild(Cow child) {
        children.add(child);
    }
    public boolean equals(Object o) {
        if(o instanceof Cow) {
            Cow cow = (Cow) o;
            if(name.equals(cow.name)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    public String toString() {
        return name;
    }
}