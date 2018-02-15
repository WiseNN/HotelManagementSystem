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
public class HotelRoom {

    /**
     * @param args the command line arguments
     */
    public static int myNum = 0;
    public int myNum2 = 0;
    
    public static void main(String[] args) throws Exception {
        Sqllc s = new Sqllc();
        int temproomnummber = (int) (Math.random());
            s.insertCID(2, 3, 4);
            s.insertCOD(2, 3, 4);
            s.insertRoom(temproomnummber, "Suite");
       // System.out.print(s.getCheckInDay(2, 3, 4));
         //   System.out.print(s.getCheckInMonth(2, 3, 4));
           // System.out.print(s.getCheckInYear(2, 3, 4));
            //System.out.print(s.getCheckOutDay(2, 3, 4));
            //System.out.print(s.getCheckOutMonth(2, 3, 4));
            //System.out.print(s.getCheckOutYear(2, 3, 4));
            //System.out.print(s.getRoomType( temproomnummber));
        // Scanner names = new Scanner(System.in);
    }

    //
    public void bookRoom(LocalDate fromDate, LocalDate toDate, SysConstants.RoomTypeConst roomType, int numOfRooms) throws Exception {
        
        String myRoomType = "";
        int temproomnummber = (int) (Math.random());
        System.out.println(temproomnummber);
        /*
        
Make it so that each room type can be compared with the UI 
    1. if RoomTypeConst is set to HANDI the compare 
    2. else if RoomTypeConst is set to REG the compare
`   3. else if RoomTypeConst is set to HANDI the compare 
    4. else send error 

         */
        //if RoomType is set to HANDI then compare to the roomType
        if (RoomTypeConst.HANDI == roomType) {//
            //if it succededs then print out the room type that was just compared
            System.out.print("HANDI");
            myRoomType = "HANDI";
        } //else if RoomType is set to REG then compare to the roomType
        else if (RoomTypeConst.REG == roomType) {
            //if it succededs then print out the room type that was just compared
            System.out.print("REG");            
            myRoomType = "REG";
        } //else if RoomType is set to SUITE then compare to the roomType
        else if (RoomTypeConst.SUITE == roomType) {
            //if it succededs then print out the room type that was just compared
            System.out.print("SUITE");            
            myRoomType = "SUITE";
        } else {
            //else send error 
            System.out.print("Error");            
        }
        
        if (numOfRooms == 1 && numOfRooms <= 5) {
            fromDate.getDayOfMonth();
            fromDate.getMonthValue();
            fromDate.getYear();
            
            toDate.getDayOfMonth();
            toDate.getMonthValue();
            toDate.getYear();

            //call database with params and get callback
            
            Sqllc s = new Sqllc();
            
            s.insertCID(fromDate.getDayOfMonth(), fromDate.getMonthValue(), fromDate.getYear());
            s.insertCOD(toDate.getDayOfMonth(), toDate.getMonthValue(), toDate.getYear());
            s.insertRoom(temproomnummber, myRoomType);
            
            
            
            System.out.print(s.getCheckInDay(fromDate.getDayOfMonth(), fromDate.getMonthValue(), fromDate.getYear()));
            System.out.print(s.getCheckInMonth(fromDate.getDayOfMonth(), fromDate.getMonthValue(), fromDate.getYear()));
            System.out.print(s.getCheckInYear(fromDate.getDayOfMonth(), fromDate.getMonthValue(), fromDate.getYear()));
            System.out.print(s.getCheckOutDay(fromDate.getDayOfMonth(), fromDate.getMonthValue(), fromDate.getYear()));
            System.out.print(s.getCheckOutMonth(fromDate.getDayOfMonth(), fromDate.getMonthValue(), fromDate.getYear()));
            System.out.print(s.getCheckOutYear(fromDate.getDayOfMonth(), fromDate.getMonthValue(), fromDate.getYear()));
            System.out.print(s.getRoomType(temproomnummber));
            
            
        } else {
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
    public static int getMyNum() {
        return myNum;
    }

    /**
     * @param aMyNum the myNum to set
     */
    public static void setMyNum(int aMyNum) {
        myNum = aMyNum;
    }
   
    
}
