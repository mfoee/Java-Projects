/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jpapa
 */
import java.util.ArrayList;
public class ShoppingCart {
    
   ArrayList<Book> cart;
   private double totalprice = 0;
   
   public ShoppingCart()
   {
       cart = new ArrayList<Book>();
   }
   
   public void addBook(Book b)
   {
       cart.add(b);
   }
   
   public String toString()
   {
       return cart.toString();
   }
   
   public void resetPrice()
   {
       totalprice = 0;
   }
   
   public double getTotal()
   {
       
       for(int i = 0;i<cart.size();i++)
       {
           totalprice = totalprice + (cart.get(i).getPrice()+5);
       }
       
       return totalprice;
   }
   
   public String printCart()
   {
       String temps = "";
       
       for(int i = 0;i<cart.size();i++)
       {
           temps = cart.get(i).getTitle() + "\n" + temps;
           //System.out.println(cart.get(i).getTitle());
       }
       
       return temps;
   }
    
}
