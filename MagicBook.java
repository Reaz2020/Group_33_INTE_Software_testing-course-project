import java.util.ArrayList;
import java.util.List;



public class MagicBook {
    //using new List<>() works too, decied to go with ArrayList though
    //added static Magic before hand is possible, did not do it mainly because of not needed to yet
    private List<Magic> magicBook = new ArrayList<>(); //Primitve way of how its saved


    public void addMagicBook(String name, int manaCost, int damage) {
        //This goes into the Magic class, creates the magic and then saves it to the magicBook
        magicBook.add(new Magic(name, manaCost, damage) {
        });//add magic to magicBook
    }//addMagicBook

    //Primitivt way of printing it out and see how its formated
    public String printOutArrayList() {
        StringBuilder sb = new StringBuilder();
        //NOTE at every entry in the Arraylist is added with ", " with the space at the end of the entry, rememeber that
        for (Magic print : magicBook) {
            sb.append(print);
            sb.append(", ");
        }//For loop
        return sb.toString();
    }//printOutArrayList
}//Class MagicBook
