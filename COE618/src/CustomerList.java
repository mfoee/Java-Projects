/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jpapa
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class CustomerList  {
    
    static ArrayList<Customer> customers;
    File file;
    
    public CustomerList()
    {
        customers = new ArrayList<Customer>();
        file = new File("customers.txt");
    }
    
    public void addCustomer(Customer c)
    {
        customers.add(c);
    }
    
    public void removeCustomer(Customer c)
    {
        int tracker = 0;
        for(int i = 0;i<customers.size();i++)
        {
            if(customers.get(i).getName().equalsIgnoreCase(c.getName()))
            {
                customers.remove(i);
                tracker = 1;
            }
            
            if(tracker==0)
            {
                System.out.println("Customer not found.");
            }
        }
    }
    
    public void Read()
   {
       //File file = new File("filename.txt");
             
                    
            String tempuname;
            String tempname;
            String templname;
            String tempid;
            String tempadd;
            String tempcard;
            
            //Account tempAcc;
            
              
            try{
            
                Scanner scanner = new Scanner(file);
                
                while(scanner.hasNext())
                {
                    //String line = scanner.next();
                    tempuname = scanner.next();
                    tempname = scanner.next();
                    templname = scanner.next();
                    tempid = scanner.next();
                    tempadd = scanner.next();
                    tempcard = scanner.next();
                    
                    customers.add(new Customer(tempuname, templname, tempname, tempid, tempadd, tempcard));
                    
                }
                
                scanner.close();
                
                
            
        }
        
            catch(FileNotFoundException e)
            {
                e.printStackTrace();
            }
        
   }
     public void Write()
   {
       try {

            String content = "";
            
            File file = new File("customers.txt");

            if (!file.exists()) {
                file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
                        
            for(int i=0;i<customers.size();i++)
            {
                content = customers.get(i).getUname() + " " + customers.get(i).getName() +" "+ customers.get(i).getLast() + " " + customers.get(i).getId()+" " +customers.get(i).getAdd() + " " +customers.get(i).getCard();
                bw.write(content);
                bw.newLine();
            }

            bw.close();

            

            //System.out.print("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void list()
    {
        for(int j = 0;j<customers.size();j++)
        {
            System.out.println(customers.get(j).getName());
        }
    }
    
}
