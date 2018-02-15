/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelroom;

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
    public void bookRoom(LocalDate fromDate, LocalDate toDate, RoomTypeConst roomType, int numOfRooms)
    {
        
      
        
       
       //dateofcheckout = Integer.parseInt(toDate);
       
      
          //return numOfRooms;
          /* fromDate.getDayOfWeek();
           fromDate.getMonthValue();
           fromDate.getYear();

           toDate.getDayOfWeek();
           toDate.getMonthValue();
           toDate.getYear();*/
        String myRoomType;
//        switch([possibleVar])
//        {
//            case [condition1] : 
//                [do what...]
//                    break;
//                    
//            case [condition1] : 
//                [do what...]
//                    break;
//                    
//        }
//        
//        if
//                (roomType.HANDI == )
//        
//           switch (roomType)
//           {
//                   case instance roomType.REG :   
//                       myRoomType = "REG";
//                        break;
//                   case 2: roomType.SUITE = "SUITE";
//                        break;
//                   case 3: roomType.HANDI = "HANDI";
//                        break;
//           }
                   
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
