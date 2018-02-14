/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelroom;

import java.time.LocalDate;

/**
 *
 * @author kyleaustin
 */
public class HotelRoom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
      // Scanner names = new Scanner(System.in);
    }
    public static void bookRoom(LocalDate fromDate, LocalDate toDate, RoomTypeConst roomType, int numOfRooms)
    {
      
        fromDate.getDayOfWeek();
        fromDate.getMonthValue();
        fromDate.getYear();
       
       toDate.getDayOfWeek();
       toDate.getMonthValue();
       toDate.getYear();
       //dateofcheckout = Integer.parseInt(toDate);
       
      
        
       if(numOfRooms ==1 && numOfRooms <=5)
       {
            //return numOfRooms;
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

}
