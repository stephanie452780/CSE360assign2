/**
 * Assignment 1
 * CSE360 W 3:05 - 4:20
 *
 * Name: Stephanie Lee
 * Student ID: 1215239818
 * Class ID: 418
 */

package CSE360assign2;

public class SimpleList
{
    private int[] list;
    private int count;

    /**
     * The constructor of the program, initializes 
     * list array and count
     * 
     * @param none
     * @return none
     */
    public SimpleList()
    {
        list = new int[10];
        count = 0;
    }

    /**
     * This method will take the value passed in the 
     * parameter and add it to the front of the list
     * 
     * @param newNum
     * @return none
     */
    public void add(int newNum)
    {
        //adjust count
        if(count < 10)
        {
            count++;
        }

        int[] temp = new int[10];
        
        //copy list array into temp array
        for(int tempCounter = 0; tempCounter < count; tempCounter++)
        {
            temp[tempCounter] = list[tempCounter];
        }

        //add newNum to beginning of array
        list[0] = newNum;

        //shift array
        for(int tempCounter = 1; tempCounter < count; tempCounter++)
        {

            list[tempCounter] = temp[tempCounter-1];
        }

    }
    
    /**
     * This method will remove the element from 
     * the list 
     * 
     * @param remove
     * @return none
     */

    public void remove(int remove)
    {
        int found = 0;
        boolean foundbool = false;

        //parse through list to find element
        for(int tempCounter = 0; tempCounter < count; tempCounter++)
        {
            if(list[tempCounter] == remove)
            {
                found = tempCounter;
                foundbool = true;
            }
        }

        //if element is found, remove it and shift elements over 
                if(foundbool == true)
        {
            //move elements down
            for(int tempCounter = found ; tempCounter < count-1; tempCounter++)
            {
                list[tempCounter] = list[tempCounter + 1];
            }
            
            count--;
            for(int tempCounter = 9 ; tempCounter >= count; tempCounter--)
            {
                list[tempCounter] = 0;
            }
        }
    }

    /**
     * This element will convert the integer array
     * into a string type
     * 
     * @param none
     * @return string
     */
    public String toString()
    {
    	//initialize string variable
        String string = "";
        
        //parse through list and add to string
        for(int tempCounter = 0; tempCounter < count; tempCounter++)
        {
        	//makes sure there is a space between elements in the string
            string += list[tempCounter];
            if(tempCounter != count - 1)
            {
                string += " ";
            }
            else
            {
                return string;
            }
        }
        return string;
    }

    /**
     * This method will count the number of elements
     * in the list and return the value
     * 
     * @param none
     * @return counter or -1
     */
    public int count()
    {
        int counter = 0;
        //parse through the list and return the number of elements
        for(int tempCounter = 0; tempCounter < list.length; tempCounter++)
        {
            if(list[tempCounter] != 0)
            {
                counter++;
            }
        }
        return counter;
    }
    
    
    /**
     * This method will look for the element passed
     * in the parameter and return its location in 
     * the list. 
     * 
     * @param num
     * @return location or -1
     */
    public int search(int num)
    {
    	int location = 0;
    	//parse through list and look for element passed in from parameter
        for(int tempCounter = 0; tempCounter < count; tempCounter++)
        {
            if(list[tempCounter] == num)
            {
            	location = tempCounter;
                return location;
            }
        }
        return -1;
    }


}
