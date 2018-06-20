/**
 * This class demonstrates the binary search with an array of objects in a contact list.
 *
 * @author Briana Berger
 * @version 04/16/18
 */

public class ContactTester {
    public static void main(String[] args)
    {
        Contact[] contactList = new Contact[10];
        
        contactList[0] = new Contact("Deirdre Berger", "Mom", "January", "mom@gmail.com", "561-348-3948");
        contactList[1] = new Contact("Courtney Berger", "Sister", "November", "sis@gmail.com", "888-888-8888");
        contactList[2] = new Contact("Gregory Berger", "Dad", "March", "gdad@gmail.com", "561-783-2832");
        contactList[3] = new Contact("Douglas Berger", "Uncle", "December", "uncle@gmail.com", "888-888-8888");
        contactList[4] = new Contact("Sidratul Muntaha", "Friend", "April", "student@gmail.com", "343-234-2324");
        contactList[5] = new Contact("Cindy Jie", "Friend", "January", "student@gmail.com", "374-395-8480");
        contactList[6] = new Contact("Amanda DeVinney", "Friend", "April", "student@gmail.com", "343-373-9864");
        contactList[7] = new Contact("Garand T.", "Crush", "November", "boy@gmail.com", "234-239-9170");
        contactList[8] = new Contact("Claire Tseng", "Friend", "December", "student@gmail.com", "945-563-2345");
        contactList[9] = new Contact("Caroline Chu", "Friend", "August", "student@gmail.com", "349-546-5467");
 
        int test;
        
        printPlaylist(contactList);
        
        System.out.println("\n\nBinary Searching for the name, Courtney Berger: ");
        insertionName(contactList);  
        
        test = findNameBinary(contactList, "Courtney Berger");
        if(test != -1)
            System.out.println("Found: " + contactList[test]);
        else
            System.out.println("Not found. " );
        
        System.out.println("\n\nBinary Searching the name, Selena Gomez: ");
        test = findNameBinary(contactList, "Selena Gomez");
        if(test != -1)
            System.out.println("Found: " + contactList[test]);
        else
            System.out.println("Not found. " );
        
        System.out.println("\n\nBinary Searching for Friend: ");
        insertionRelation(contactList);
        findRelationBinary(contactList, "Friend");
       
        System.out.println("\n\nBinary Searching for Grandpa: ");
        insertionRelation(contactList);
        findRelationBinary(contactList, "Grandpa");
        
        System.out.println("\n\nSequential Searching for January Contacts: ");
        findBirthMonth(contactList, "January");
        
        System.out.println("\n\nSequential Searching for October Contacts: ");
        findBirthMonth(contactList, "October");
        
        System.out.println("\n\nSequential Searching for Phone Number of 888-888-8888 Contacts: ");
        findPhoneNumber(contactList, "888-888-8888");
        
        System.out.println("\n\nSequential Searching for Phone Number of 000-000-0000 Contacts: ");
        findPhoneNumber(contactList, "000-000-0000");
        
        System.out.println("\n\nSequential Searching for Email of student@gmail.com Contacts: ");
        findEmail(contactList, "student@gmail.com");
        
        System.out.println("\n\nSequential Searching for Email of professor@gmail.com Contacts: ");
        findEmail(contactList, "professor@gmail.com");
    }
   
    public static void printPlaylist(Contact[] r)
    {
        System.out.println("Name                      Relation            Birth Month              Phone              Email");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for(int i = 0; i < r.length; i++)
            System.out.println(r[i]);
    }
   
    public static int findNameBinary(Contact[] r, String toFind)
    {
        int high = r.length;
        int low = -1;
        int probe;

        while( high - low > 1 )
        {
            probe = ( high + low ) / 2;
            if( r[probe].getName().compareTo(toFind) > 0)
                high = probe;
            else
                low = probe;
        }
        
        if( (low >= 0) && (r[low].getName().compareTo(toFind) == 0 ))
            return low;
        else
            return -1;
    }
       
    public static void findRelationBinary(Contact[] r, String toFind)
    {
        int high = r.length;
        int low = -1;
        int probe;

        while( high - low > 1 )
        {
            probe = ( high + low ) / 2;

            if(r[probe].getRelation().compareTo(toFind) > 0)
                high = probe;
            else
            {
                low = probe;
                if( r[probe].getRelation().compareTo(toFind) == 0)
                {
                    break;
                }
            }
        }
        
        if( (low >= 0) && (r[low].getRelation().compareTo(toFind) == 0 ))
        {
            linearPrintRelation(r, low, toFind);
        }
        else
            System.out.println("NOT found: " + toFind);
    }
   
    public static void linearPrintRelation(Contact[] r, int low, String toFind)
    {
        int i;
        int start = low;
        int end = low;

        // find starting point of matches
        i = low - 1;
        while((i >= 0) && (r[i].getRelation().compareTo(toFind) == 0))
        {
            start = i;
            i--;
        }
        // find ending point of matches
        i = low + 1;
        while((i < r.length) && (r[i].getRelation().compareTo(toFind) == 0))
        {
            end = i;
            i++;
        }
        // now print out the matches
        for(i = start; i <= end; i++)
            System.out.println(r[i]);
    }
    
    // Insertion sort: sort array in ascending order based on title
    public static void insertionName(Contact[] source)
    {
        Contact[] dest = new Contact[ source.length ];

        for( int i = 0 ; i < source.length ; i++ )
        {
            Contact next = source[ i ];
            int insertIndex = 0;
            int k = i;
            while( k > 0 && insertIndex == 0 )
            {
                if( next.getName().compareTo(dest[k-1].getName()) > 0 )
                {
                    insertIndex = k;
                }
                else
                {
                    dest[ k ] = dest[ k - 1 ];
                }
                k--;
            }

            dest[ insertIndex ] = next;
        }
        
        for(int i = 0; i < dest.length; i++)
            source[i] = dest[i];
    }
    
    // Insertion sort: sort array in ascending order based on artist
    public static void insertionRelation(Contact[] source)
    {
        Contact[] dest = new Contact[ source.length ];

        for( int i = 0 ; i < source.length ; i++ )
        {
            Contact next = source[ i ];
            int insertIndex = 0;
            int k = i;
            while( k > 0 && insertIndex == 0 )
            {
                if( next.getRelation().compareTo(dest[k-1].getRelation()) > 0 )
                {
                    insertIndex = k;
                }
                else
                {
                    dest[ k ] = dest[ k - 1 ];
                }
                k--;
            }

            dest[ insertIndex ] = next;
        }
        
        for(int i = 0; i < dest.length; i++)
            source[i] = dest[i];
    }
    
    public static void findBirthMonth(Contact[] r, String toFind)
    {
        int found = 0;

        for(int i = 0; i < r.length; i++)
        {
            if(r[i].getBirthMonth().compareTo(toFind) == 0)
            {
                System.out.println(r[i]);
                found++;
            }
        }
        
        if(found == 0)
        {   // we have not found the year
            System.out.println(toFind + " is not in the contact list");
        }
    }
    
    public static void findPhoneNumber(Contact[] r, String toFind)
    {
        int found = 0;

        for(int i = 0; i < r.length; i++)
        {
            if(r[i].getPhoneNumber().compareTo(toFind) == 0)
            {
                System.out.println(r[i]);
                found++;
            }
        }
        
        if(found == 0)
        {   // we have not found the year
            System.out.println(toFind + " is not in the contact list");
        }
    }
    
    public static void findEmail(Contact[] r, String toFind)
    {
        int found = 0;

        for(int i = 0; i < r.length; i++)
        {
            if(r[i].getEmail().compareTo(toFind) == 0)
            {
                System.out.println(r[i]);
                found++;
            }
        }
        
        if(found == 0)
        {   // we have not found the year
            System.out.println(toFind + " is not in the contact list");
        }
    }
}
