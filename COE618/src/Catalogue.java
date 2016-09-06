/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jpapa
 */
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Catalogue {
    
    static ArrayList<Book> cat;
    File file;
    Book tempbook;
    
    public Catalogue()
    {
        cat = new ArrayList<Book>();
        file = new File("catalogue.txt");
        
    }
    
    public void Read()
    {
            String tempName;
            String tempAuthor;
            double tempPrice;
            
            //Account tempAcc;
            
              
            try{
            
                Scanner scanner = new Scanner(file);
                
                while(scanner.hasNext())
                {
                    //String line = scanner.next();
                    tempName= scanner.nextLine();
                    tempAuthor = scanner.nextLine();
                    tempPrice = Double.parseDouble(scanner.nextLine());
                    
                    tempbook = new Book(tempName, tempAuthor, tempPrice);
                    cat.add(tempbook);
                                      
                }
                
                scanner.close();
                
                
            
        }
        
            catch(FileNotFoundException e)
            {
                //e.printStackTrace();
            }
        
   
   }
    
   public void readCatalogue()
   {
       for(int k = 0;k<cat.size();k++)
       {
           System.out.println(cat.get(k));
       }
   }
   
   public ArrayList getCatalogue()
   {
       return cat;
   }
   
   public void setCatalogue(ArrayList a)
   {
       cat = a;
   }
}
    

