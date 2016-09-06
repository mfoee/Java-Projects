/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jpapa
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.util.Arrays;
import java.util.ArrayList;

public class Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JTextField uname = new JTextField();
        JTextField name = new JTextField();
        JTextField lname = new JTextField();
        JTextField id = new JTextField();
        JTextField address = new JTextField();
        JTextField card = new JTextField();
        JTextField emailadd = new JTextField();
        
        Catalogue catalogue = new Catalogue();
        catalogue.Read();
        
        
        Sorter theSorter = new Sorter(catalogue.getCatalogue());
        ArrayList<Book> lol = new ArrayList();
        
        //System.out.println(theSorter.unsorted);
        //theSorter.sortTitle();
        //catalogue.setCatalogue(theSorter.sortTitle());
        //BookChecklist checklist = new BookChecklist();
        //checklist.addClist();
        
        Customer tempcustomer = null;
        CustomerList custlist = new CustomerList();
        custlist.Read();
        
        String tempuname;
        String tempname;
        String templname;
        String tempid;
        String tempadd;
        String tempcard;
        String eadd;
        ShoppingCart tempcart = null;
        int createnew = 0;
        int createacc = 0;
        int ruregistered = 0;
        int relog = 0;
        int guestflag = 0;
        
        //FORMAT: null, inside box, top of box, type of gui
        JOptionPane.showMessageDialog(null, "Welcome to Book Club!", null, JOptionPane.INFORMATION_MESSAGE);
        ruregistered = JOptionPane.showConfirmDialog(null,"Are you an existing Book Club member?","Book Club",JOptionPane.YES_NO_OPTION);
        
        
        
        if(ruregistered==JOptionPane.NO_OPTION)
        {
            createnew = JOptionPane.showConfirmDialog(null, "Would you like to join the Book Club to get a 20% discount on your total purchase?",null,JOptionPane.YES_NO_OPTION);
  
        if(createnew==JOptionPane.YES_OPTION)
        {
            int temp;
            
            Object[] message = {"Desired Username:",uname,
                                "Name:", name,
                                "Last Name: ", lname,
                                "ID:", id,
                                "Country:", address,
                                "Credit Card:", card         
            };
            
            temp = JOptionPane.showConfirmDialog(null, message, "Enter your credentials",JOptionPane.OK_CANCEL_OPTION);
            
            if(temp==JOptionPane.OK_OPTION)
            {
                tempuname = uname.getText();
                tempname = name.getText();
                templname = lname.getText();
                tempid = id.getText();
                tempadd = address.getText();
                tempcard = card.getText();
                
                if(tempname==null || tempid==null || tempadd==null || tempcard==null)
                {
                    JOptionPane.showMessageDialog(null, "One or more empty fields!", "Can't create account!", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                
                tempcustomer = new Customer(tempuname,tempname, templname, tempid, tempadd, tempcard);
                custlist.addCustomer(tempcustomer);
                custlist.Write();
                JOptionPane.showMessageDialog(null, "Welcome to the club " + tempcustomer.getName() + "!", "Welcome!", JOptionPane.INFORMATION_MESSAGE);
                tempcustomer.isaMember();
                //System.out.println("Welcome to the club" + " " + tempcustomer.getName());
            }
            
            else if(temp==JOptionPane.CANCEL_OPTION)
            {
                JOptionPane.showMessageDialog(null,"Welcome, Guest!", "Guest Account", JOptionPane.INFORMATION_MESSAGE);
                tempcustomer = new Customer("temp", "temp", "temp", "temp", "temp", "temp");
            }     
        }
        
        else
        {
            
            JOptionPane.showMessageDialog(null,"Welcome, Guest!", "Guest Account", JOptionPane.INFORMATION_MESSAGE);
            tempcustomer = new Customer("temp", "temp", "temp", "temp", "temp", "temp");
            
        }
        
        }
        
        if(ruregistered==JOptionPane.YES_OPTION)
        {
            //LOG IN STUFFS
            //WINDOW OF LOG IN SCREEN
            while(relog==0){
            int temp;
            int found = 0;
            
            Object[] message = {"Registered Name:", name,
                                "ID:", id,        
            };
            
            temp = JOptionPane.showConfirmDialog(null, message, "Log In",JOptionPane.OK_OPTION);
            
            while(found==0){
            
            if(temp==JOptionPane.OK_OPTION);
            {
                tempname = name.getText();
                tempid = id.getText();
                
                
                for(int j = 0;j<custlist.customers.size();j++)
                {
                    //if username is found
                    if(tempname.equalsIgnoreCase(custlist.customers.get(j).getUname()) && tempid.equalsIgnoreCase(custlist.customers.get(j).getId()))
                    {
                        JOptionPane.showMessageDialog(null, "Welcome back " + custlist.customers.get(j).getName(), "Welcome Back!", JOptionPane.INFORMATION_MESSAGE);
                        tempcustomer = custlist.customers.get(j);
                        tempcustomer.isaMember();
                        System.out.println(tempcustomer.getMember());
                        found = 1;
                        relog = 1;
                    }

                }
                
                
                
                if(found==0)
                {
                    int wannarelog = JOptionPane.showConfirmDialog(null, "Account not found.  Are you sure you registered?", "No such account found!", JOptionPane.YES_NO_OPTION);
                    if(wannarelog==JOptionPane.NO_OPTION)
                    {
                        JOptionPane.showMessageDialog(null,"Logging in as a Guest account.","Guest account",JOptionPane.OK_OPTION);
                        JOptionPane.showMessageDialog(null,"Welcome, Guest!", "Guest Account", JOptionPane.INFORMATION_MESSAGE);
                        tempcustomer = new Customer("Guest", "Guest", "Guest", "Guest", "Guest", "Guest");
                        relog=1;
                        found = 1;
                    }
                    
                    if(wannarelog==JOptionPane.YES_OPTION)
                    {
                        relog=0;
                        found = 1;
                    }
                    
                }
                
                
            }
            }
            }
        }
        
        
        
        catalogue.readCatalogue();
        //theSorter.sortTitle(catalogue.getCatalogue());
        custlist.list();
        
        //SORT CHOICE
        JRadioButton sortby = new JRadioButton("By Title");
        JRadioButton sortby2 = new JRadioButton("By Author");
        JRadioButton sortby3 = new JRadioButton("By Price");
        
        Frame frame2 = new Frame("Sort By");
        frame2.add(sortby);
        frame2.add(sortby2);
        frame2.add(sortby3);
        
        JPanel panel2 = new JPanel(new GridLayout(0,1));
        Border border2 = BorderFactory.createTitledBorder("Sort By");
        panel2.setBorder(border2);
        panel2.add(sortby);
        panel2.add(sortby2);
        panel2.add(sortby3);
        

        


        JOptionPane.showMessageDialog(null,panel2,"How would you like to sort our library?",JOptionPane.OK_OPTION);
        
        if(sortby.isSelected())
        {
            lol = theSorter.sortTitle();
            catalogue.setCatalogue(lol);
            
        }
        
        else if(sortby2.isSelected())
        {
            lol = theSorter.sortAuthor();
            catalogue.setCatalogue(lol);
        }
        
        else if(sortby3.isSelected())
        {
            lol = theSorter.sortPrice();
            catalogue.setCatalogue(lol);
        }
        
        
        JCheckBox[] checkboxes = new JCheckBox[catalogue.getCatalogue().size()];
        for(int k = 0;k<catalogue.getCatalogue().size();k++)
        {
            checkboxes[k] = new JCheckBox(catalogue.cat.get(k).toString());
        }
        
        
        Object[] books = new Object[10000];
        books[0] = "Choose books to purchase: ";
        for(int l = 0;l<checkboxes.length;l++)
        {
            books[l] = checkboxes[l];
        }
        
        
       Frame frame = new Frame("Book List");
       for(int i=0;i<checkboxes.length;i++)
       {
           frame.add(checkboxes[i]);
       }
       
      JPanel panel = new JPanel(new GridLayout(0,1));
      Border border = BorderFactory.createTitledBorder("Books List");
      panel.setBorder(border);
      
      for(int i=0;i<checkboxes.length;i++)
      {
          panel.add(checkboxes[i]);
      }
      

        
        JScrollPane myScrollPane = new JScrollPane(panel);
        
        myScrollPane.setPreferredSize(new Dimension(500,250));
       
        
        //CART FLAG HERE
        int cartstatus = 0;
        
        while(cartstatus==0){
        JOptionPane.showMessageDialog(null, "Choose the books you want to purchase below.\nPlease note that each book has a $5 shipping charge.\nThe books are formatted as Title - Author - Price", "Reminder",JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null,myScrollPane,"Book List",JOptionPane.OK_CANCEL_OPTION);
        
        for(int x = 0;x<checkboxes.length;x++)
        {
            if(checkboxes[x].isSelected())
            {
                tempcustomer.getCart().cart.add((Book)catalogue.getCatalogue().get(x));
                //tempcustomer.getCart().addBook((Book)catalogue.getCatalogue().get(x));
                cartstatus=1;
            }
        }
         
         
        
        
        if(tempcustomer.getCart().cart.isEmpty())
        {
            int noitem = JOptionPane.showConfirmDialog(null,"You do not have any items in the cart.  Go back?","No items",JOptionPane.YES_NO_OPTION);
            if(noitem==JOptionPane.YES_OPTION)
            {
                cartstatus=0;
            }
            
            else
            {
                JOptionPane.showMessageDialog(null,"Thank you for browsing!",":D",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
        
        while(cartstatus==1){
         
        JOptionPane.showMessageDialog(null, "You have chosen the books\n" + "\n" + tempcustomer.getCart().printCart() + "\nFor purchase.", "Your Shopping Cart", JOptionPane.INFORMATION_MESSAGE);
        
        int pricecheck = 0;
        int email = 0;
        double pricedue = tempcustomer.getCart().getTotal();
        double discount = 0.8;
        
        if(tempcustomer.getMember().equalsIgnoreCase("no"))
        {
            int temp2;
            pricecheck = JOptionPane.showConfirmDialog(null, "Amount due: "+ Double.toString((double)Math.round(pricedue*100)/100) +"\nConfirm payment?","Amount Due",JOptionPane.YES_NO_CANCEL_OPTION);
            //System.out.print("PRICECHECK VALUE" + Double.toString(pricedue));
            
           //IF PAYMENT IS CONFIRMED
            if(pricecheck==JOptionPane.YES_OPTION){
            email = JOptionPane.showConfirmDialog(null, "Would you like an email receipt?", "E-mail receipt",JOptionPane.YES_NO_OPTION);
               
               
            if(email==JOptionPane.YES_OPTION)
            {
                Object[] message2 = {"E-mail address:", emailadd};
            
               temp2 = JOptionPane.showConfirmDialog(null, message2, "Enter your E-mail address",JOptionPane.OK_OPTION);
               if(temp2==JOptionPane.OK_OPTION)
               {
                   //Customer tcust2 = tempcustomer;
                   eadd = emailadd.getText();
                   SendMail mailer = new SendMail(tempcustomer, eadd, Double.toString((double)Math.round(pricedue*100)/100));
                   JOptionPane.showMessageDialog(null, "Thanks for shopping!",":)",JOptionPane.INFORMATION_MESSAGE);
                   System.exit(0);
               }

            
            
               else
               {
                   JOptionPane.showMessageDialog(null, "Thanks for shopping!","Come again!",JOptionPane.INFORMATION_MESSAGE);
                   System.exit(0);
               }
            
            }
            
            else if(email==JOptionPane.NO_OPTION)
            {
                JOptionPane.showMessageDialog(null, "Thanks for shopping!","Come again!",JOptionPane.INFORMATION_MESSAGE);
               System.exit(0);
            }
            
            }
            //IF PAYMENT AIN'T CONFIRMED
            else if(pricecheck==JOptionPane.NO_OPTION)
            {
                tempcustomer.getCart().cart.clear();
                tempcustomer.getCart().resetPrice();
                cartstatus = 0;
               
            }
            
            else if(pricecheck==JOptionPane.CANCEL_OPTION)
            {
                tempcustomer.getCart().cart.clear();
                tempcustomer.getCart().resetPrice();
                cartstatus = 0;
            }
            
            
        }
        
        
        if(tempcustomer.getMember().equalsIgnoreCase("yes"))
        {
            int temp2;
            pricecheck = JOptionPane.showConfirmDialog(null, "Amount due (Includes Shipping): "+ Double.toString((double)Math.round(pricedue*100)/100)
                                                        + "\nMember Price: " + Double.toString((double)Math.round(pricedue*discount*100)/100)
                                                        +"\nYou saved " + Double.toString((double)Math.round((pricedue-(pricedue*discount))*100/100))
                                                        + "\nConfirm payment?","Amount Due",JOptionPane.YES_NO_CANCEL_OPTION);
            //IF PAYMENT IS CONFIRMED   
            if(pricecheck==JOptionPane.YES_OPTION){
            
            email = JOptionPane.showConfirmDialog(null, "Would you like an email receipt?", "E-mail receipt",JOptionPane.YES_NO_OPTION);
               
               if(email==JOptionPane.YES_OPTION)
               {
               Object[] message2 = {"E-mail address:", emailadd};
            
               temp2 = JOptionPane.showConfirmDialog(null, message2, "Enter your E-mail address",JOptionPane.OK_OPTION);
               if(temp2==JOptionPane.OK_OPTION)
               {
                   eadd = emailadd.getText();
                   SendMail mailer = new SendMail(tempcustomer, eadd, Double.toString((double)Math.round(pricedue*100)/100));
                   JOptionPane.showMessageDialog(null, "Thanks for shopping!",":)",JOptionPane.INFORMATION_MESSAGE);
                   System.exit(0);
               }
               }
            else if(email==JOptionPane.NO_OPTION)
                {
                    JOptionPane.showMessageDialog(null, "Thanks for shopping!","Come again!",JOptionPane.INFORMATION_MESSAGE);
                     System.exit(0);
                }
            }
            
            else if(pricecheck==JOptionPane.NO_OPTION)
            {
                tempcustomer.getCart().cart.clear();
                tempcustomer.getCart().resetPrice();
                cartstatus = 0;
                
            }
            
            else if(pricecheck==JOptionPane.CANCEL_OPTION)
            {
                JOptionPane.showMessageDialog(null, "Thanks for browsing!","Come Again!",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            }
               
               
        }

        tempcustomer.getCart().cart.clear();
        
        }
    }
        
}
