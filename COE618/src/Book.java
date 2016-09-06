/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jpapa
 */
public class Book {
    
   String title;
   private String author;
   private double price;
   
   public Book(String t, String a, double p)
   {
       title = t;
       author = a;
       price = p;
   }
   
   public String getTitle()
   {
       return title;
   }
   
   public String getAuthor()
   {
       return author;
   }
   
   public double getPrice()
   {
       return price;
   }
   
   public String toString()
   {
       return title + " by " + author + " $" + Double.toString(price);
   }
}
