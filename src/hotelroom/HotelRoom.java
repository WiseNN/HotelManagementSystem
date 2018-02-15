/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelroom;

import hotelmanagementsystemapp.SysConstants;
import java.time.LocalDate;
import hotelmanagementsystemapp.SysConstants.RoomTypeConst;

/**
 *
 * @author kyleaustin
 */
public class HotelRoom 
{

    /**
     * @param args the command line arguments
     */
    
    public static int myNum = 0;
    public int myNum2 = 0;
    
    
    public static void main(String[] args) 
    {
      // Scanner names = new Scanner(System.in);
    }
    //
    public void bookRoom(LocalDate fromDate, LocalDate toDate, SysConstants.RoomTypeConst roomType, int numOfRooms)
    {
        
      
        
       
/*
        
Make it so that each room type can be compared with the UI 
    1. if RoomTypeConst is set to HANDI the compare 
    2. else if RoomTypeConst is set to REG the compare
`   3. else if RoomTypeConst is set to HANDI the compare 
    4. else send error 

*/
        //if RoomType is set to HANDI then compare to the roomType
        if(RoomTypeConst.HANDI == roomType)
        {//lllll
            //if it succededs then print out the room type that was just compared
           System.out.print("HANDI"); 
        }
        //else if RoomType is set to REG then compare to the roomType
        else if(RoomTypeConst.REG == roomType)
        {
            //if it succededs then print out the room type that was just compared
            System.out.print("REG"); 
        }
        //else if RoomType is set to SUITE then compare to the roomType
        else if(RoomTypeConst.SUITE == roomType)
        {
            //if it succededs then print out the room type that was just compared
            System.out.print("SUITE"); 
        }
        else 
        {
            //else send error 
            System.out.print("Error"); 
        }
        
        
       if(numOfRooms ==1 && numOfRooms <=5)
       {
           fromDate.getDayOfWeek();
           fromDate.getMonthValue();
           fromDate.getYear();

           toDate.getDayOfWeek();
           toDate.getMonthValue();
           toDate.getYear();
       }
       else 
       {
           System.out.println("Error");
       }
       /*
        1. convert local date into intergers
        2. convert RoomTypeConst into a string 
        3. make sure numOfRooms is no more then 5. (must be able to have atleast one)
            1. if between 1 and 5 rooms is valid 
            2. else send error to user 
        4. send result data to data base 
        */

    }   

    /**
     * @return the myNum
     */
    public static int getMyNum() 
    {
        return myNum;
    }

    /**
     * @param aMyNum the myNum to set
     */
    public static void setMyNum(int aMyNum) 
    {
        myNum = aMyNum;
    }

}
