/**
 * Assignment 1
 * CSE360 W 3:05 - 4:20
 *
 * Name: Stephanie Lee
 * Student ID: 1215239818
 * Class ID: 418
 *
 * This class will manipulate a simple list, including funtions
 * that will add, remove, count, and list elements.
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
     * parameter and add it to the front of the list.
     * If the list is full upon accessing this method,
     * 50% of the elements will be cleared in order to
     * add elements.
     * 
     * @param newNum
     * @return none
     */
    public void add(int newNum)
    {
        //if list is already full
        if(list.length == count)
        {
            //make new temporary array and copy elements over
            int[] copyList = new int[10];


            for(int i = 0; i < (int)(list.length-(list.length*(0.5))); i++)
            {
                copyList[i] = list[i];
            }
            for(int i = 0; i < count; i++)
            {
                list[i] = copyList[i];
            }

            //adjust count
            count = count - (int)(list.length-(list.length*(0.5)));

        }

        //adjust count
        if(count < 10)
        {
            count++;
        }

        int[] temp = new int[10];
        //copy list array into temp array
        for(int i = 0; i < count; i++)
        {
            temp[i] = list[i];
        }

        //add newNum to beginning of array
        list[0] = newNum;

        //shift array
        for(int i = 1; i < count; i++)
        {
            list[i] = temp[i-1];
        }

    }
    
    /**
     * This method will remove the element from 
     * the list. If the list has more than 25% of
     * unused space, 25% of the list will be deleted.
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

        //check if list has 25% empty space
        if(count < (int)(list.length-(list.length*(0.25))) && count > 1)
        {
            int[] tempList = new int[10];
            for(int i = 0; i < (int)(count-(count*(0.25))); i++)
            {
                tempList[i] = list[i];
            }

            //adjust count
            count = (int)(count-(count*(0.25)));

            //add elements back to original list
            for(int i = 0; i < count; i++)
            {
                list[i] = tempList[i];
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

    /**
     * This method will add the element to the end
     * of the list. If list is full, it will clear
     * 50% of the list to make room.
     * @param num
     * @return none
     */
    public void append(int num)
    {
        //if list is already full
        if(list.length == count)
        {
            //make new temporary array and copy elements over
            int[] copyList = new int[10];


            for(int i = 0; i < (int)(list.length-(list.length*(0.5))); i++)
            {
                copyList[i] = list[i];
            }
            for(int i = 0; i < count; i++)
            {
                list[i] = copyList[i];
            }

            //adjust count
            count = count - (int)(list.length-(list.length*(0.5)));
        }

        //add element to end of list
        list[count] = num;
        count++;

    }

    /**
     * This method will return the 1st element
     * of the list
     *
     * @return 1st element of list
     */

    public int first()
    {
        if(count == 0)
        {
            return -1;
        }
        else
        {
            return list[0];
        }
    }

    /**
     * This method will return the last
     * element of the list
     *
     * @return last element of list
     */

    public int last()
    {
        if(count == 0)
        {
            return -1;
        }
        else
        {

            return list[count-1];
        }
    }

    /**
     * This method will return the size of
     * the list.
     *
     * @return size of list
     */
    public int size()
    {
        return list.length;
    }



}
