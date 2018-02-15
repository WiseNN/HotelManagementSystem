package hotelroom;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author wjackson28 public void insert(String firstname, String lastname) {
 * Connection con = null; Statement st = null; ResultSet rs = null;
 *
 * PreparedStatement FN = null; PreparedStatement LN = null;
 *
 * String LNS = "INSERT INTO Guest (Pkey,FN,LN)" + "VALUES (null,?,?)";
 *
 * try { FN.setString(1, firstname); FN.setString(2, lastname);
 * FN.executeUpdate();
 *
 * /*
 * Class.forName("org.sqlite.JDBC"); con =
 * DriverManager.getConnection("jdbc:sqlite:db1.sqlite"); st =
 * con.createStatement();
 *
 * String url = "org.sqlite.JDBC"; con =
 * DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite"); st =
 * con.createStatement(); con.setAutoCommit(false); FN =
 * con.prepareStatement(LNS); LN = con.prepareStatement(LNS); //rs =
 * st.executeQuery("SELECT * FROM T1;");
 *
 * //st.executeUpdate("INSERT INTO Guest( First_Name, Last_Name)" //+ "VALUES
 * ("+firstname+","+lastname+")"); //st.executeUpdate("INSERT INTO Guest
 * (PKey,FN,LN)" //+ "VALUES (null, ? , ? )"); con.close(); } catch (Exception
 * e) { System.err.println("Got an exception! ");
 * System.err.println(e.getMessage()); }
 *
 * }
 *
 * public void insert2(String firstname, String lastname) { Connection con =
 * null;
 *
 * PreparedStatement updateSales = null;
 *
 * String updateString; updateString = "INSERT INTO Guest (FN,LN)" + " VALUES
 * (?,?)";
 *
 * try { con.setAutoCommit(false); updateSales =
 * con.prepareStatement(updateString); updateSales.setString(1, firstname);
 * updateSales.setString(2, lastname); updateSales.executeUpdate();
 * con.commit();
 *
 * } catch (Exception e) { System.err.println("Got an exception! ");
 * System.err.println(e.getMessage());
 *
 * }
 *
 * }
 */
public class Sqllc {

    public void insertGuestRow(String firstname, String lastname, int age,
            int cid, int cim, int ciy,
            int cod, int com, int coy, int nor) {
        /* The method inserts a  a name, age, check in date, check out date
        and the number of rooms for the customer into the database.      
         */

        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
            PreparedStatement updateemp = con.prepareStatement("insert into Guest(Pkey,FN,LN,Age"
                    + ",CID,CIM,CIY,COD,COM,COY,NumRooms)" + " values(null,?,?,?,?,?,?,?,?,?,?)");

            updateemp.setString(1, firstname);
            updateemp.setString(2, lastname);
            updateemp.setInt(3, age);
            updateemp.setInt(4, cid);
            updateemp.setInt(5, cim);
            updateemp.setInt(6, ciy);
            updateemp.setInt(7, cod);
            updateemp.setInt(8, com);
            updateemp.setInt(9, coy);
            updateemp.setInt(10, nor);
            updateemp.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.err.println("Got an exception guest first and last name! ");
            System.err.println(e.getMessage());
        }

    }

    public void updateGuestRow(String firstname, String lastname, int age,
            int cid, int cim, int ciy,
            int cod, int com, int coy, int nor) {
        /* The method updates/ changes the name, age, check in date, check out date
        and the number of rooms for the customer in the database.      
         */
        {
            Connection con = null;

            if ((getGuestID(firstname, lastname)) == -1) {
                System.out.println("Got an exception," + firstname + " " + lastname + " not in system! ");
            } else {
                int id = getGuestID(firstname, lastname);

                try {
                    Class.forName("org.sqlite.JDBC");
                    con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
                    PreparedStatement updateemp = con.prepareStatement("UPDATE Guest "
                            + "SET FN = ?, LN = ?, Age = ?, CID = ?, CIM = ?, CIY = ?,"
                            + " COD = ?, COM = ?, COY = ?, NumRooms = ? WHERE PKey = ?");

                    updateemp.setString(1, firstname);
                    updateemp.setString(2, lastname);
                    updateemp.setInt(3, age);
                    updateemp.setInt(4, cid);
                    updateemp.setInt(5, cim);
                    updateemp.setInt(6, ciy);
                    updateemp.setInt(7, cod);
                    updateemp.setInt(8, com);
                    updateemp.setInt(9, coy);
                    updateemp.setInt(10, nor);
                    updateemp.setInt(11, id);
                    updateemp.executeUpdate();

                    con.close();
                } catch (Exception e) {
                    System.err.println("Got an exception, update guest row ! ");
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    public void updateRoom(int oldroomnum, int roomnumber, String firstname, String lastname, String roomtype) {
        /* the methods take the inputs of the old room number and the new room number and update(change)
        the values of the RoomNum, GuestID, and RoomType column for a single row */
        {
            Connection con = null;

            if ((getGuestID(firstname, lastname)) == -1) {
                System.out.println("Got an exception," + firstname + " " + lastname + " not in system! ");
            } else {
                int id = getGuestID(firstname, lastname);
                int roomid = getRoomID(oldroomnum);

                try {
                    Class.forName("org.sqlite.JDBC");
                    con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
                    PreparedStatement updateemp = con.prepareStatement("UPDATE Rooms "
                            + "SET  RoomNum = ?, GuestID = ?, RoomType = ? WHERE RoomID = ?");

                    //updateemp.setInt(1, id);
                    updateemp.setInt(1, roomnumber);
                    updateemp.setInt(2, id);
                    updateemp.setString(3, roomtype);
                    updateemp.setInt(4, roomid);
                    updateemp.executeUpdate();

                    con.close();
                } catch (Exception e) {
                    System.err.println("Got an exception, update guest row ! ");
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    public void insertFLA(String firstname, String lastname, int age) throws Exception {
        /* The method inserts a name, age, into the database. This does not update, and 
        istead creates a new line filled with only this information and the rest of the 
        values contain null.      
         */
        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
            PreparedStatement updateemp = con.prepareStatement("insert into guest(Pkey,FN,LN,Age)"
                    + "values(null,?,?,?)");

            updateemp.setString(1, firstname);
            updateemp.setString(2, lastname);
            updateemp.setInt(3, age);
            updateemp.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.err.println("Got an exception guest first and last name! ");
            System.err.println(e.getMessage());
        }

    }

    /* public void insertNOR(int numberOfRooms, String firstname, String lastname) {
        Connection con = null;
        if ((getGuestID(firstname, lastname)) == -1) {
            System.out.println("Got an exception," + firstname + " " + lastname + " not in system! ");
        } else {
            int id = getGuestID(firstname, lastname);

            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
                PreparedStatement updateemp = con.prepareStatement("insert into guest(Pkey,FN,LN,Age)"
                        + "values(,?,?,?)");

                updateemp.setString(1, firstname);
                updateemp.setString(2, lastname);
                updateemp.setString(3,)
                updateemp.setInt(, age);
                updateemp.executeUpdate();

                con.close();
            } catch (Exception e) {
                System.err.println("Got an exception guest first and last name! ");
                System.err.println(e.getMessage());
            }

        }
     */
    public void insertCID(int checkinday, int checkinmonth, int checkinyear) {
        /*The method inserts a the check in date into the database. This does not update, and 
        istead creates a new line filled with only this information and the rest of the 
        values contain null*/

        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
            PreparedStatement updateemp = con.prepareStatement("insert into Guest(CID,CIM,CIY)"
                    + "values(?,?,?)");

            updateemp.setInt(1, checkinday);
            updateemp.setInt(2, checkinmonth);
            updateemp.setInt(3, checkinyear);
            updateemp.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.err.println("Got an exception, check in date! ");
            System.err.println(e.getMessage());
        }
    }

    public void updateGuestCID(String FN, String LN, int checkinday, int checkinmonth, int checkinyear) {
        /*The method updates the check in date that was previosly inserted into the database for a 
        specific customer. This does not insert  a new row, and only updates an exsisting row
        within the database.
         */
        Connection con = null;

        if ((getGuestID(FN, LN)) == -1) {
            System.out.println("Got an exception," + FN + " " + LN + " not in system! ");
        } else {
            int id = getGuestID(FN, LN);

            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
                PreparedStatement updateemp = con.prepareStatement("UPDATE Guest "
                        + "SET CID = ?, CIM = ?, CIY = ? WHERE PKey = ?");

                updateemp.setInt(1, checkinday);
                updateemp.setInt(2, checkinmonth);
                updateemp.setInt(3, checkinyear);
                updateemp.setInt(4, id);
                updateemp.executeUpdate();

                con.close();
            } catch (Exception e) {
                System.err.println("Got an exception, update guest first and last name! ");
                System.err.println(e.getMessage());
            }
        }
    }

    public void insertCOD(int checkoutday, int checkoutmonth, int checkoutyear) {
        /*The method inserts a the check out date into the database. This does not update, and 
        istead creates a new line filled with only this information and the rest of the 
        values contain null*/
        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
            PreparedStatement updateemp = con.prepareStatement("insert into guest(CID,CIM,CIY)"
                    + "values(?,?,?)");

            updateemp.setInt(1, checkoutday);
            updateemp.setInt(2, checkoutmonth);
            updateemp.setInt(3, checkoutyear);
            updateemp.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.err.println("Got an exception, Check out date! ");
            System.err.println(e.getMessage());
        }

    }

    public void updateGuestCOD(String FN, String LN, int checkoutday, int checkoutmonth, int checkoutyear) {
        /*The method updates the check out date that was previosly inserted into the database for a 
        specific customer. This does not insert  a new row, and only updates an exsisting row
        within the database.*/

        Connection con = null;

        if ((getGuestID(FN, LN)) == -1) {
            System.out.println("Got an exception," + FN + " " + LN + " not in system! ");
        } else {
            int id = getGuestID(FN, LN);

            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
                PreparedStatement updateemp = con.prepareStatement("UPDATE Guest "
                        + "SET COD = ?, COM = ?, COY = ? WHERE PKey = ?");

                updateemp.setInt(1, checkoutday);
                updateemp.setInt(2, checkoutmonth);
                updateemp.setInt(3, checkoutyear);
                updateemp.setInt(4, id);
                updateemp.executeUpdate();

                con.close();
            } catch (Exception e) {
                System.err.println("Got an exception, update guest first and last name! ");
                System.err.println(e.getMessage());
            }
        }
    }

    public void insertRoomWithName(int roomnumber, String GuestFN, String GuestLN, String roomtype) throws Exception {
        /*The method inserts a the a room number for a customer from the  guest table into the room table. This  method 
        requires that a the customer the room is created for already exsist in the guest database.*/
        Connection con = null;

        int id = getGuestID(GuestFN, GuestLN);
        if (id == -1) {
            System.err.print("Guest " + GuestFN + " " + GuestLN + " is not currently stored in the datbase, add"
                    + " guest to database before assigning room");
        }
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
            PreparedStatement updateemp = con.prepareStatement("insert into rooms(RoomID,RoomNum,GuestID,RoomType)"
                    + "values(null,?,?,?)");

            updateemp.setInt(1, roomnumber);
            updateemp.setInt(2, id);
            updateemp.setString(3, roomtype);
            updateemp.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.err.println("Got an exception guest room number with name first!");
            System.err.println(e.getMessage());
        }
    }

    public void insertRoom(Integer roomnumber, String roomtype) throws Exception {
        /*The method inserts a the a room number and room type into the room table. This  method 
        does not requires that a the customer name exsis for the room to be created.*/

        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
            PreparedStatement updateemp = con.prepareStatement("insert into rooms(RoomID,RoomNum,GuestID,RoomType)"
                    + "values(null,?,null,?)");

            updateemp.setInt(1, roomnumber);
            updateemp.setString(2, roomtype);
            updateemp.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.err.println("Got an exception guest room number with name first!");
            System.err.println(e.getMessage());
        }
    }

    public void ReplaceRoomID(String oldFN, String oldLN, String newFN, String newLN) {
        // method still in development*/

        Connection con = null;

        if ((getGuestID(oldFN, oldLN)) == 0) {
            System.out.println("Got an exception," + oldFN + " " + oldLN + " not in system! ");
        } else {
            int id = getGuestID(oldFN, oldLN);

            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
                PreparedStatement updateemp = con.prepareStatement("UPDATE Guest "
                        + "SET FN = ?, LN = ? WHERE PKey = ?");

                updateemp.setString(1, newFN);
                updateemp.setString(2, newLN);
                updateemp.setInt(3, id);
                updateemp.executeUpdate();

                con.close();
            } catch (Exception e) {
                System.err.println("Got an exception, replace room ID! ");
                System.err.println(e.getMessage());
            }
        }
    }

    public void updateRoomID(String firstname, String lastname, int room_number) {
        /*The method swaps a the guest id of a customer for another customer in the room table. */
        Connection con = null;

        if ((getRoomID(room_number)) == -1) {
            System.out.println("Got an exception, " + room_number + " not in system! ");
        } else {
            int id = getGuestID(firstname, lastname);

            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
                PreparedStatement updateemp = con.prepareStatement("UPDATE Rooms "
                        + "SET GuestID = ? WHERE RoomID = ?");

                updateemp.setInt(1, id);
                updateemp.setInt(2, getRoomID(room_number));
                updateemp.executeUpdate();

                con.close();
            } catch (Exception e) {
                System.err.println("Got an exception, update room ID! ");
                System.err.println(e.getMessage());
            }
        }
    }

    public void clearRoom(int room_number) {
        /*This method removes an entire column from the room table*/
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        if ((getRoomID(room_number)) == -1) {
            System.err.print("Room " + room_number + " is not in the system");

        } else {
            int id = getRoomID(room_number);

            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
                PreparedStatement updateemp = con.prepareStatement("UPDATE Rooms "
                        + "SET GuestID = NULL where RoomID = ? ");
                //Update myTable set MyColumn = NULL where Field = Condition
                updateemp.setInt(1, id);
                updateemp.executeUpdate();

                con.close();
            } catch (Exception e) {
                System.err.println("Got an exception, clear room! ");
                System.err.println(e.getMessage());
            }
        }
    }

    public int getGuestID(String firstname, String lastname) {
        /* This method uses the first and last name stored in the database
        to search the database for the specific row, identified by the primary key,
        and return that value so that the information of that specific customer can 
        be accessed.
         */
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        int id = -1;

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
//                Connection connection = DriverManager.getConnection("jdbc:sqlite::inSystemDb.sqlite:");

            String search = ("SELECT * FROM Guest " + "WHERE FN GLOB ? AND LN GLOB ?");
            PreparedStatement updateemp = con.prepareStatement(search);
            System.out.print(id);

            //SELECT * FROM COMPANY WHERE AGE >= 25 AND SALARY >= 65000
            updateemp.setString(1, firstname);
            updateemp.setString(2, lastname);
            rs = updateemp.executeQuery();

            while (rs.next()) {
                id = rs.getInt("PKey");
                // String name = rs.getString("name");
                System.out.println("ID = " + id);
                //System.out.println("NAME = " + name);
                System.out.println();

            }

            rs.close();
            st.close();
            con.close();
            System.out.print(id);
            return id;
        } catch (Exception e) {
            if (id == -1) {
                System.err.println("Got an exception,get  guest primary key! Error: " + e.getLocalizedMessage());
                //System.err.println(e.getMessage());
                return id;
            } else {
                return id;
            }
        }
    }

    public int getGuestIDWithAge(String firstname, String lastname, int age) {
        /* This method uses the first and last name and age stored in the database
        to search the database for the specific row containing these values, identified by the primary key,
        and returns the primary key/ row value so that the information of that specific customer can 
        be accessed.
         */
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        int id = -1;

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
            //st = con.createStatement();
            //
            String search = ("SELECT * FROM Guest " + "WHERE FN GLOB ? AND LN GLOB ? AND Age GLOB ?");
            PreparedStatement updateemp = con.prepareStatement(search);

            //SELECT * FROM COMPANY WHERE AGE >= 25 AND SALARY >= 65000
            updateemp.setString(1, firstname);
            updateemp.setString(2, lastname);
            updateemp.setInt(3, age);
            rs = updateemp.executeQuery();
            while (rs.next()) {
                id = rs.getInt("PKey");
                // String name = rs.getString("name");
                System.out.println("ID = " + id);
                //System.out.println("NAME = " + name);
                System.out.println();

            }

            rs.close();
            st.close();
            con.close();
            return id;
        } catch (Exception e) {
            if (id == -1) {
                System.err.println("Got an exception,get  guest primary key! ");
                //System.err.println(e.getMessage());
                return id;
            } else {
                return id;
            }
        }
    }

    public void removeGuest(String Str1, String Str2) {
        /*in development*/
        Connection con = null;

        if ((getGuestID(Str1, Str2)) == 0) {
            System.out.println("Got an exception," + Str1 + " " + Str2 + " not in system! ");
        } else {
            int id = getGuestID(Str1, Str2);

            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
                PreparedStatement updateemp = con.prepareStatement("DELETE from Guest where PKey = ?;");

                updateemp.setInt(2, id);
                updateemp.executeUpdate();

                con.close();
            } catch (Exception e) {
                System.err.println("Got an exception, remove guest! ");
                System.err.println(e.getMessage());
            }
        }
    }

    public void updateGuestFLA(String oldFN, String oldLN, String newFN, String newLN, int age) {
        /* the methods take the inputs of the old name and the new name and update(change)
        the values of the FN, LN column for a single row */
        Connection con = null;

        if ((getGuestID(oldFN, oldLN)) == 0) {
            System.out.println("Got an exception," + oldFN + " " + oldLN + " not in system! ");
        } else {
            int id = getGuestID(oldFN, oldLN);

            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:.sqlite");
                PreparedStatement updateemp = con.prepareStatement("UPDATE Guest "
                        + "SET FN = ?, LN = ?, Age = ? WHERE PKey = ?");

                updateemp.setString(1, newFN);
                updateemp.setString(2, newLN);
                updateemp.setInt(3, age);
                updateemp.setInt(4, id);
                updateemp.executeUpdate();

                con.close();
            } catch (Exception e) {
                System.err.println("Got an exception, update guest first and last name! ");
                System.err.println(e.getMessage());
            }
        }
    }

    public void removeGuestRow(String Str1, String Str2) {
        /*This method is still in development*/
        Connection con = null;

        if ((getGuestID(Str1, Str2)) == 0) {
            System.out.println("Got an exception," + Str1 + " " + Str2 + " not in system! ");
        } else {
            int id = getGuestID(Str1, Str2);

            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
                PreparedStatement updateemp = con.prepareStatement("DELETE from Guest where PKey = ?;");

                updateemp.setInt(2, id);
                updateemp.executeUpdate();

                con.close();
            } catch (Exception e) {
                System.err.println("Got an exception, update guest first and last name! ");
                System.err.println(e.getMessage());
            }
        }
    }

    public String getRoomType( int roomnumber) {
        /* This method uses room number stored in the database to search the database for the 
        specific row containing the value, identified by the primary key,
        and returns the primary key/row value so that the information of that specific room can 
        be accessed.
         */
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int id = getRoomID(roomnumber);
        String retstr = "no switch";

        try {
            Class.forName("org.sqlite.JDBC");
//          con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
            con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");

            //st = con.createStatement();
            //sqlite> SELECT * FROM COMPANY WHERE AGE  GLOB '2*';
            String search = ("SELECT * FROM Rooms WHERE RoomNum GLOB ? ");

            PreparedStatement updateemp = con.prepareStatement(search);

            //SELECT * FROM COMPANY WHERE AGE >= 25 AND SALARY >= 65000
            updateemp.setInt(1, roomnumber);
            // updateemp.setString(2, lastname);
            rs = updateemp.executeQuery();
            if (rs.next()) {
                retstr =rs.getString("RoomType");
                // String name = rs.getString("name");
                //System.out.println("NAME = " + name);
                System.out.println();

            }

            
            con.close();
            return retstr;
        } catch (Exception e) {
            System.err.println("Got an exception,get room type! ");
            //System.err.println(e.getMessage());
            return retstr;

        }
    }
     public int getCheckInDay(int checkinday, int checkinmonth, int checkinyear) {
        /* This method uses room number stored in the database to search the database for the 
        specific row containing the value, identified by the primary key,
        and returns the primary key/row value so that the information of that specific room can 
        be accessed.
         */
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        int day = 0;

        try {
            Class.forName("org.sqlite.JDBC");
//          con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
            con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");

            //st = con.createStatement();
            //sqlite> SELECT * FROM COMPANY WHERE AGE  GLOB '2*';
            String search = ("SELECT * FROM Guest WHERE CID GLOB ? AND CIM GLOB ? AND CIY GLOB ? ");

            PreparedStatement updateemp = con.prepareStatement(search);

            //SELECT * FROM COMPANY WHERE AGE >= 25 AND SALARY >= 65000
            updateemp.setInt(1, checkinday);
            updateemp.setInt(2, checkinmonth);
            updateemp.setInt(3, checkinyear);
            
            // updateemp.setString(2, lastname);
            rs = updateemp.executeQuery();
            if (rs.next()) 
            {
                day = rs.getInt("CID");
                // String name = rs.getString("name");
                //System.out.println("NAME = " + name);
                System.out.println();

            }

//            rs.close();
//            st.close();
            con.close();
            return day;
        } catch (Exception e) {
            System.err.println("Got an exception,get check in day is");
            return day;

        }
    }
     public int getCheckInMonth(int checkinday, int checkinmonth, int checkinyear) {
        /* This method uses room number stored in the database to search the database for the 
        specific row containing the value, identified by the primary key,
        and returns the primary key/row value so that the information of that specific room can 
        be accessed.
         */
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        int month = 0;

        try {
            Class.forName("org.sqlite.JDBC");
//          con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
            con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");

            //st = con.createStatement();
            //sqlite> SELECT * FROM COMPANY WHERE AGE  GLOB '2*';
            String search = ("SELECT * FROM Guest WHERE CID GLOB ? AND CIM GLOB ? AND CIY GLOB ? ");

            PreparedStatement updateemp = con.prepareStatement(search);

            //SELECT * FROM COMPANY WHERE AGE >= 25 AND SALARY >= 65000
            updateemp.setInt(1, checkinday);
            updateemp.setInt(2, checkinmonth);
            updateemp.setInt(3, checkinyear);
            
            // updateemp.setString(2, lastname);
            rs = updateemp.executeQuery();
            if (rs.next()) {
                month = rs.getInt("CIM");
                // String name = rs.getString("name");
                //System.out.println("NAME = " + name);
                System.out.println();

            }

            
            con.close();
            return month;
        } catch (Exception e) {
            System.err.println("Got an exception,get check in  month ! ");
            //System.err.println(e.getMessage());
            return month;

        }
    }
     public int getCheckInYear(int checkinday, int checkinmonth, int checkinyear) {
        /* This method uses room number stored in the database to search the database for the 
        specific row containing the value, identified by the primary key,
        and returns the primary key/row value so that the information of that specific room can 
        be accessed.
         */
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        int year = 0;

        try {
            Class.forName("org.sqlite.JDBC");
//          con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
            con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");

            //st = con.createStatement();
            //sqlite> SELECT * FROM COMPANY WHERE AGE  GLOB '2*';
            String search = ("SELECT * FROM Guest WHERE CID GLOB ? AND CIM GLOB ? AND CIY GLOB ? ");

            PreparedStatement updateemp = con.prepareStatement(search);

            //SELECT * FROM COMPANY WHERE AGE >= 25 AND SALARY >= 65000
            updateemp.setInt(1, checkinday);
            updateemp.setInt(2, checkinmonth);
            updateemp.setInt(3, checkinyear);
            
            // updateemp.setString(2, lastname);
            rs = updateemp.executeQuery();
            if (rs.next()) {
                year = rs.getInt("CIY");
                // String name = rs.getString("name");
                //System.out.println("NAME = " + name);
                System.out.println();

            }

            
            con.close();
            return year;
        } catch (Exception e) {
            System.err.println("Got an exception,get check in year! ");
            //System.err.println(e.getMessage());
            return year;

        }
    }
      int getCheckOutDay(int checkinday, int checkinmonth, int checkinyear) {
        /* This method uses room number stored in the database to search the database for the 
        specific row containing the value, identified by the primary key,
        and returns the primary key/row value so that the information of that specific room can 
        be accessed.
         */
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        int day = 0;

        try {
            Class.forName("org.sqlite.JDBC");
//          con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
            con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");

            //st = con.createStatement();
            //sqlite> SELECT * FROM COMPANY WHERE AGE  GLOB '2*';
            String search = ("SELECT * FROM Guest WHERE CID GLOB ? AND CIM GLOB ? AND CIY GLOB ? ");

            PreparedStatement updateemp = con.prepareStatement(search);

            //SELECT * FROM COMPANY WHERE AGE >= 25 AND SALARY >= 65000
            updateemp.setInt(1, checkinday);
            updateemp.setInt(2, checkinmonth);
            updateemp.setInt(3, checkinyear);
            
            // updateemp.setString(2, lastname);
            rs = updateemp.executeQuery();
            if (rs.next()) {
                day = rs.getInt("COD");
                // String name = rs.getString("name");
                //System.out.println("NAME = " + name);
                System.out.println();

            }

            
            con.close();
            return day;
        } catch (Exception e) {
            System.err.println("Got an exception,get check out day! ");
            //System.err.println(e.getMessage());
            return day;

        }
    }
     public int getCheckOutMonth(int checkinday, int checkinmonth, int checkinyear) {
        /* This method uses room number stored in the database to search the database for the 
        specific row containing the value, identified by the primary key,
        and returns the primary key/row value so that the information of that specific room can 
        be accessed.
         */
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        int month = 0;

        try {
            Class.forName("org.sqlite.JDBC");
//          con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
            con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");

            //st = con.createStatement();
            //sqlite> SELECT * FROM COMPANY WHERE AGE  GLOB '2*';
            String search = ("SELECT * FROM Guest WHERE CID GLOB ? AND CIM GLOB ? AND CIY GLOB ? ");

            PreparedStatement updateemp = con.prepareStatement(search);

            //SELECT * FROM COMPANY WHERE AGE >= 25 AND SALARY >= 65000
            updateemp.setInt(1, checkinday);
            updateemp.setInt(2, checkinmonth);
            updateemp.setInt(3, checkinyear);
            
            // updateemp.setString(2, lastname);
            rs = updateemp.executeQuery();
            if (rs.next()) {
                month = rs.getInt("COM");
                // String name = rs.getString("name");
                //System.out.println("NAME = " + name);
                System.out.println();

            }

            
            con.close();
            return month;
        } catch (Exception e) {
            System.err.println("Got an exception,get check out month! ");
            //System.err.println(e.getMessage());
            return month;

        }
    }
     public int getCheckOutYear(int checkinday, int checkinmonth, int checkinyear) {
        /* This method uses room number stored in the database to search the database for the 
        specific row containing the value, identified by the primary key,
        and returns the primary key/row value so that the information of that specific room can 
        be accessed.
         */
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        int year = 0;

        try {
            Class.forName("org.sqlite.JDBC");
//          con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
            con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");

            //st = con.createStatement();
            //sqlite> SELECT * FROM COMPANY WHERE AGE  GLOB '2*';
            String search = ("SELECT * FROM Guest WHERE CID GLOB ? AND CIM GLOB ? AND COY GLOB ? ");

            PreparedStatement updateemp = con.prepareStatement(search);

            //SELECT * FROM COMPANY WHERE AGE >= 25 AND SALARY >= 65000
            updateemp.setInt(1, checkinday);
            updateemp.setInt(2, checkinmonth);
            updateemp.setInt(3, checkinyear);
            
            // updateemp.setString(2, lastname);
            rs = updateemp.executeQuery();
            if (rs.next()) {
                year = rs.getInt("COY)");
                // String name = rs.getString("name");
                //System.out.println("NAME = " + name);
                System.out.println();

            }

            
            con.close();
            return year;
        } catch (Exception e) {
            System.err.println("Got an exception,get check out year! Error: "+e.getLocalizedMessage());
            //System.err.println(e.getMessage());
            return year;

        }
    }
    
    public int getRoomID(int roomnumber) {
        /* This method uses room number stored in the database to search the database for the 
        specific row containing the value, identified by the primary key,
        and returns the primary key/row value so that the information of that specific room can 
        be accessed.
        */
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        int id = -1;

        try {
            Class.forName("org.sqlite.JDBC");
//            con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
            con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
            
            //st = con.createStatement();
            //sqlite> SELECT * FROM COMPANY WHERE AGE  GLOB '2*';
            String search = ("SELECT * FROM Rooms WHERE RoomNum GLOB ? ");

            PreparedStatement updateemp = con.prepareStatement(search);

            //SELECT * FROM COMPANY WHERE AGE >= 25 AND SALARY >= 65000
            updateemp.setInt(1, roomnumber);
            // updateemp.setString(2, lastname);
            rs = updateemp.executeQuery();
            while (rs.next()) {
                id = rs.getInt("RoomID");
                // String name = rs.getString("name");
                System.out.println("ID = " + id);
                //System.out.println("NAME = " + name);
                System.out.println();

            }

            rs.close();
            st.close();
            con.close();
            return id;
        } catch (Exception e) {
            if (id == -1) {
                System.err.println("Got an exception,get roomID! ");
                //System.err.println(e.getMessage());
                return id;
            } else {
                return id;
            }
        }

    }

    public static void main(String[] args) {
        Sqllc s = new Sqllc();
        System.out.print(s.getGuestID("Taylor", "Long"));
        s.insertGuestRow(null, null, 0, 0, 0, 0, 0, 0, 0, 0);
    }
}
/*
    public int getGuestInfo(String Column, String firstname, String lastname) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        if ((getGuestID(firstname, lastname)) == -1) {
            System.out.println("Got an exception," + firstname + " " + lastname + " not in system! ");
        } 
        else {
            int id = getGuestID(firstname, lastname);

            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:inSystemDb.sqlite");
                //st = con.createStatement();
                //sqlite> SELECT * FROM COMPANY WHERE AGE  GLOB '2*';
                String search = ("SELECT * FROM Guest WHERE ? GLOB ? ");

                PreparedStatement updateemp = con.prepareStatement(search);

                //SELECT * FROM COMPANY WHERE AGE >= 25 AND SALARY >= 65000
                updateemp.setString(1,Column);
                updateemp.setInt(2, id);

                rs = updateemp.executeQuery();
                if (rs == String){
                    
                }

                rs.close();
                st.close();
                con.close();
                return id;
            } catch (Exception e) {
                if (id == -1) {
                    System.err.println("Got an exception,get guest info! ");
                    //System.err.println(e.getMessage());
                    return id;
                } else {
                    return id;
                }
            }
        }
       


}*/
