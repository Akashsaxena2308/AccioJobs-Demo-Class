package Library;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class book extends BorrowableItem{
    private String Author;

    book(String itemId, String title,String Author){
        super(itemId,title);
        this.Author=Author;

    }
   @Override
    public void specificDetails(){
       System.out.println("Author | "+ Author);
   }
}
