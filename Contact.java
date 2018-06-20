
/**
 * Purpose: To provide a class structure for Contact
 *
 * @author Briana Berger
 * @version 04/16/2018
 *
 */
public class Contact
{
    // instance variables
    private String name, relation, birthMonth, email, phoneNumber;
    
    // Constructor for objects of class Music
    public Contact(String n, String r, String b, String e, String p)
    {
        // initialize instance variables
        name = n;
        relation = r; 
        birthMonth = b;
        email = e;
        phoneNumber = p;
    }

    public String getName()
    {
        return name;
    }
   
    public void setName(String n)
    {
        name = n;
    }
   
    public String getRelation()
    {
        return relation;
    }
    
    public void setRelation(String r)
    {
        relation = r;
    }
   
    public String getBirthMonth()
    {
        return birthMonth;
    }
    
    public void setBirthMonth(String b)
    {
        birthMonth = b;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String e)
    {
        email = e;
    }
    
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String p)
    {
        phoneNumber = p;
    }
   
    public String toString()
    {
        String str = String.format( "%-25s %-20s %-20s %-20s %-20s", name,  relation , birthMonth, phoneNumber, email);
        return str;
    }
}
