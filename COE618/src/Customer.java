/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jpapa
 */
public class Customer {
    
    private String uname;
    private String name;
    private String lastname;
    private String idnumber;
    private String address;
    private String ccard;
    private ShoppingCart books = new ShoppingCart();
    private String member = "Yes";
    
    public Customer(String u,String n, String l, String d, String ad, String c)
    {
        uname = u;
        name = n;
        lastname = l;
        idnumber = d;
        address = ad;
        ccard = c;
        member = "no";
        
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getLast()
    {
        return lastname;
    }
    
    public String getId()
    {
        return idnumber;
    }
    
    public String getAdd()
    {
        return address;
    }
    
    public String getCard()
    {
        return ccard;
    }
    
    public String getUname()
    {
        return uname;
    }
    
    public ShoppingCart getCart()
    {
        return books;
    }
    
    public String toString()
    {
        return name + " " + idnumber + " " + address + " " + ccard;
    }
    
    public void isaMember()
    {
        member = "Yes";
    }
    
    public String getMember()
    {
        return member;
    }
    
    public String getReceipt()
    {
        String rec;
        rec = "Customer " + name + " purchased:\n" + books.printCart() + "\nAmount due: \n"; //+ Double.toString((this.getCart().getTotal()));
        System.out.println(Double.toString(books.getTotal()));
        System.out.println(books.printCart());
        return rec;
    }
    
}
