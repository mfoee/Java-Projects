/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Main
 */
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Sorter {
    
    ArrayList<Book> unsorted = new ArrayList();
    static private Comparator<Book> bookTitle;
    static private Comparator<Book> bookAuthor;
    
    public Sorter(ArrayList books)
    {
        unsorted = books;
    }
    
    
    public ArrayList sortTitle()
    {
        Book temp = null;
        
        for(int i = 0;i<unsorted.size()-1;i++)
        {
            for(int j = 0;j<unsorted.size()-1;j++){
            if(unsorted.get(j).getTitle().compareTo(unsorted.get(j+1).getTitle())>0)
            {
                temp = unsorted.get(j);
                unsorted.set(j, unsorted.get(j+1));
                unsorted.set(j+1, temp);
                
            }
            }
        }
        
        return unsorted;
    }
    
     public ArrayList sortAuthor()
    {
        Book temp = null;
        
        for(int i = 0;i<unsorted.size()-1;i++)
        {
            for(int j = 0;j<unsorted.size()-1;j++){
            if(unsorted.get(j).getAuthor().compareTo(unsorted.get(j+1).getAuthor())>0)
            {
                temp = unsorted.get(j);
                unsorted.set(j, unsorted.get(j+1));
                unsorted.set(j+1, temp);
                
            }
            }
        }
        
        return unsorted;
    }
     
     public ArrayList sortPrice()
    {
        Book temp = null;
        
        for(int i = 0;i<unsorted.size()-1;i++)
        {
            for(int j = 0;j<unsorted.size()-1;j++){
            if(unsorted.get(j).getPrice()>unsorted.get(j+1).getPrice())
            {
                temp = unsorted.get(j);
                unsorted.set(j, unsorted.get(j+1));
                unsorted.set(j+1, temp);
                
            }
            }
        }
        
        return unsorted;
    }
    
    
    
    /*static{
        
        bookTitle = new Comparator<Book>()
        {
            @Override
            public int compare(Book b1, Book b2)
            {
                return b1.getTitle().compareTo(b2.getTitle());
            }
        };
        
        bookAuthor = new Comparator<Book>()
        {
            @Override
            public int compare(Book b1, Book b2)
            {
                return b1.getTitle().compareTo(b2.getTitle());
            }
        };

    }
    
    public void sortTitle()
        {
            Arrays.asList(unsorted, bookTitle);
        }
    
    public void sortAuthor()
    {
        Arrays.asList(unsorted, bookTitle);
    }*/
    
    
    
}
