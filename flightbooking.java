/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swapspace;

/**
 *
 * @author Ogundimu
 */
import java.sql.*;
import java.util.*;
import java.util.GregorianCalendar;
import static swapspace.jumia.login;
public class flightbooking {
    private static int airplane_id;
    public static void login(Connection con,Statement stmt,PreparedStatement psm,ResultSet rs,Scanner input)throws SQLException{
        int c=1;
        while(c==1){
            System.out.println("ejo enter your surname and airplane_id");
            String u = input.next();
            String p = input.next();
            
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from clients");
            while(rs.next()){
                if((rs.getString("surname").equals(u))&&(rs.getString("airplane_id").equals(p))){
                    int clients_id= rs.getInt("airplane_id");
                    String f = rs.getString("fname")+" "+rs.getString("surname");
                    
                   System.out.println("login successful");
                   menu(con,stmt,psm,rs,input,clients_id,f);
                   c=3;
                }
            }
        }         
        }
     public static void booking(Connection con,Statement stmt,PreparedStatement psm,ResultSet rs,Scanner input) throws SQLException{
        Random rand = new Random();
         java.util.Date d= new java.util.Date();
          GregorianCalendar gcalendar = new  GregorianCalendar();
      int id;
       String months[] = {"jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"};
       int year;
      String al,frm,to,ob,r,c,ag,bf,t,f,s,D,e,cc,m;
      System.out.println("FROM(depature airport)");
      System.out.println("take off: "+(frm=input.next())+"\n");
      System.out.println("TO(arrival airport)");
      System.out.println("arrival point: "+(to=input.next())+"\n");
      System.out.println("OUTBOUND");
      System.out.println("outbound: "+(ob=input.next())+"\n");
      System.out.println("RETURN");
      System.out.println("return: "+(r=input.next())+"\n");
      System.out.println("CLASS(first class,economy,businnes)");
      System.out.println("class: "+(c=input.next())+"\n");
      System.out.println("AGE_GROUP(adult,children,infants)");
      System.out.println("age_group: "+(ag=input.next())+"\n");
      System.out.println("BOOKING_FROM");
      System.out.println("booking_from: "+(bf=input.next())+"\n");
      System.out.println("TITLE");
      System.out.println("title: "+(t=input.next())+"\n");
      System.out.println("FIRST_NAME");
      System.out.println("first_name: "+(f=input.next())+"\n");
      System.out.println("SURNAME(as per passport)");
      System.out.println("surname: "+(s=input.next())+"\n");
      System.out.println("DOB(YYYY-MM-DD)");
      System.out.println("DOB: "+(D=input.next())+"\n");
      System.out.println("EMAIL");
      System.out.println("email: "+(e=input.next())+"\n");
      System.out.println("country_code");
      System.out.println("country_code : "+(cc=input.next())+"\n");
      System.out.println("mobile_number");
      System.out.println("mobile_number: "+(m=input.next())+"\n");
      System.out.println("please enter your airline");
      System.out.println("airplane: "+(al=input.next())+"\n");
       try{
          stmt = con.createStatement();
          rs = stmt.executeQuery("select airplane_id from arik where airplane_id ="+(id=(rand.nextInt(20)+1)));
          while(rs.next()){
               rs = stmt.executeQuery("select airplane_id from arik where airplane_id ="+(id=(rand.nextInt(20)+1)));
          }
          psm = con.prepareStatement("insert into arik values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
          psm.setInt(1, id); 
          psm.setString(2, frm); 
          psm.setString(3, to); 
          psm.setString(4, ob);
          psm.setString(5, r);
          psm.setString(6, c);
          psm.setString(7, ag);
          psm.setString(8, bf);
          psm.setString(9, t);
          psm.setString(10, f);
          psm.setString(11, s);
          psm.setString(12, D);
          psm.setString(13, e);
          psm.setString(14, cc);
          psm.setString(15, m);
          psm.setString(16, al);
          psm.execute();
          //menu(con,stmt,psm,rs,input,id,(frm+" "+to" "+ob+" "+r+" "+c+" "+));
          System.out.println("PASSENGER'S DETAILS.");
          System.out.println("The following information is required by the airline to issue "
                        + "your ticket...please ensure your name is identical to what is started in your passport");
          System.out.println("TITLE: "+t+" \tFIRST_NAME(as per passport): "+f+"\tSURNAME(as per passport): "+s
          +"\tDOB(YYYY-MM-DD): "+D+"\tEMAIL: "+e+"\ncountry_code: "+cc+"\tmobile_number: "+m+"\n'");     
               filewriter fw = new filewriter();
               fw.openfile();
               fw.addrecord("PASSENGER'S DETAILS.");
               fw.addrecord("The following information is required by the airline to issue "
                        + "your ticket...please ensure your name is identical to what is started in your passport");
               fw.addrecord("TITLE: "+t+" \tFIRST_NAME(as per passport): "+f+"\tSURNAME(as per passport): "+s
          +"\tDOB(YYYY-MM-DD): "+D+"\tEMAIL: "+e+"\ncountry_code: "+cc+"\tmobile_number: "+m+"\n'");
               
               System.out.println("YOUR FLIGHT TICKET DETAILS.");
               System.out.println("MOYES travelstart........travel made simple");
               System.out.println("please save yourclient_id");
	       System.out.print("Date:   ");    
               System.out.print(months[gcalendar.get(Calendar.MONTH)]);
               System.out.print(" "+ gcalendar.get(Calendar.DATE) +" ");
               System.out.println(year = gcalendar.get(Calendar.YEAR));
               System.out.println("airplane_id ="+(id=(rand.nextInt(20)+1))); 
               System.out.println("client_id ="+(id=(rand.nextInt(10)+1)));
               System.out.println("AIRPLANE: "+al+"\tFROM(depature airport): "+frm+"\tTO(arrival airport): "+to+"\tCLASS: "+c+"\t DURATION:        "); 
               System.out.println("OUTBOUND: "+ob+"\tRETURN: "+r+"\tAGE_GROUP: "+ag+"\tBOOKING_FROM: "+bf);
               fw.addrecord("YOUR FLIGHT TICKET DETAILS.");
               fw.addrecord("MOYES travelstart........travel made simple");
               fw.addrecord("please save yourclient_id");
               fw.addrecord("Date:  "+months[gcalendar.get(Calendar.MONTH)]+" "+ gcalendar.get(Calendar.DATE)+" "+ gcalendar.get(Calendar.YEAR));
               fw.addrecord(String.format("%d", gcalendar.get(Calendar.YEAR)));
               fw.addrecord("airplane_id ="+(id=(rand.nextInt(20)+1)));
               fw.addrecord("client_id ="+(id=(rand.nextInt(10)+1)));
               fw.addrecord("AIRPLANE: "+al+"\tFROM(depature airport): "+frm+"\tTO(arrival airport): "+to+"\tCLASS: "+c+"\t DURATION:        ");
               fw.addrecord("OUTBOUND: "+ob+"\tRETURN: "+r+"\tAGE_GROUP: "+ag+"\tBOOKING_FROM: "+bf);
               fw.closefile();
               System.out.println("reg successful");
               System.out.println("Please check for your desktop for your flight details");
       }
      catch(Exception b){
          b.printStackTrace();
      }
      finally{
          psm.close();
          rs.close();con.close();
      }
    }
      public static void menu(Connection con,Statement stmt,PreparedStatement psm,ResultSet rs,Scanner input,int airplane_id,String f)throws SQLException{
        System.out.println();
        System.out.println("Welcome to MOYES travelstart ");
        System.out.println();
        System.out.println(" press 1 to view profile\n press 2 for available flight and amount\nenter 3 to book flight\nenter 4 to exit");
         int decision = input.nextInt();
          switch(decision){
           // case 1:
           //      profile(con,stmt,psm,rs,input,airplane_id,f);
             //    break;
            case 2:
                flight_schedule(con,stmt,psm,rs,input);
                 break;
            case 3:
                 booking(con,stmt,psm,rs,input);
                 break;
            case 4:
                 System.out.println("thank you and have a nice day"); 
                 System.exit(0);
            default:
                  System.out.println("invalid entry...");
                 
          }           
     }
     /*public static void profile(Connection con,Statement stmt,PreparedStatement psm,ResultSet rs,Scanner input,int airplane_id,String f)throws SQLException{
             System.out.println();
            
        java.util.Date d= new java.util.Date();
         Random rand = new Random();
          GregorianCalendar gcalendar = new  GregorianCalendar();
      int id;
       String months[] = {"jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"};
       int year;
        System.out.println("user details");
        System.out.println();
        stmt= con.createStatement();
        rs= stmt.executeQuery("select * from arik where airplane_id ="+airplane_id);
        while (rs.next()){
            System.out.println("first name: "+rs.getString("fname"));
            System.out.println("surname: "+rs.getString("surnmae"));
            System.out.println("airplane_id: "+rs.getString("password"));
        }
        System.out.println();
        System.out.println("booking made are");
        System.out.println("airplane_id: "+rs.getString("id"));
        System.out.println("AIRPLANE: "+rs.getString("airplane"));
        System.out.println("FROM(depature airport): "+rs.getString("from_where"));
        System.out.println("TO(arrival airport): "+rs.getString("to_where"));
        System.out.println("CLASS: "+rs.getString("class"));
        System.out.println("OUTBOUND: "+rs.getString("outbound"));
        System.out.println("RETURN: "+rs.getString("returnn"));
        System.out.println("AGE_GROUP: "+rs.getString("age_group"));
        System.out.println("BOOKING_FROM: "+rs.getString("booking_from"));
        stmt= con.createStatement();
        rs= stmt.executeQuery("select * from arik where airplane_id ="+airplane_id);
        int g=0,b=0;
        if(rs.next()){
            rs= stmt.executeQuery("select * arik orders where airplane_id ="+airplane_id);
        
        }
        System.out.println("\nenter 1 to return to menu\nenter 2 to exit");
            int decision = input.nextInt();
            switch(decision){
                case 1:
                    menu(con,stmt,psm,rs,input,airplane_id,f);
                    break;
                case 2:
                     System.out.println("\n Thank you and have a nice day");
                    System.exit(0);
                    break;
                default :
                    System.out.println("invalid entry");
            }
      }*/
       public static void process(Connection con,Statement stmt,PreparedStatement psm,ResultSet rs,Scanner input,int airplane_id,String f)throws SQLException{
         System.out.println("chosse your destination and dates.");
         System.out.println("pick your flight.");
         System.out.println("review your flight.");
         System.out.println("enter your details,");
         System.out.println("choose from our great range of travel.");
         System.out.println("pay using your preferred payment method which follows\n"
                 + "choose method of payment(debit card;internet bank transfer;cash payment;quickteller).\n"
                 + "if internet bank transfer, choose your bank(zenith,access,first bank,uba,guaranty trust bank,ecobank)\n"
                 + "after you select your purchase currency\n");
          System.out.println("\nenter 1 to return to menu\nenter 2 to exit");
            int decision = input.nextInt();
            switch(decision){
                case 1:
                    menu(con,stmt,psm,rs,input,airplane_id,f);
                    break;
                case 2:
                     System.out.println("\n Thank you and have a nice day");
                    System.exit(0);
                    break;
                default :
                    System.out.println("invalid entry");
            }
     }
       public static void flight_schedule(Connection con,Statement stmt,PreparedStatement psm,ResultSet rs,Scanner input)throws SQLException{
        System.out.println("\t\t\tReturn\t\tReturn\t\tReturn\t\tReturn\t\tReturn\t\tReturn\t\tReturn");
        System.out.println("\t\t\t(sat,8 aug 15)\t(sun,9 aug 15)\t(mon,10 aug 15)\t(tue,11 aug 15)\t(wed,12 aug 15)\t(thur,13 aug 15)(thur,13 aug 15)\n");
        System.out.println("Depart(fri,12 aug 15)\tN144,386\tN144,386\tN144,386\tN147,809\tN147,809\tN147,809\tN147,909");
        System.out.println("Depart(sun,13 aug 15)\tN144,586\tN144,356\tN144,386\tN144,389\tN145,386\tN144,380\tN144,376");
        System.out.println("Depart(mon,14 aug 15)\tN144,386\tN144,396\tN144,386\tN144,356\tN144,386\tN144,786\tN144,886");
        System.out.println("Depart(tue,15 aug 15)\tN134,286\tN134,386\tN134,396\tN134,886\tN134,486\tN134,986\tN134,396");
        System.out.println("Depart(wed,16 aug 15)\tN154,386\tN145,366\tN144,398\tN146,386\tN174,386\tN134,386\tN144,396");
        System.out.println("Depart(thur,17 aug 15)\tN144,386\tN144,386\tN144,386\tN144,386\tN144,386\tN144,386\tN144,386");
        System.out.println("Depart(fri,18 aug 15)\tN144,386\tN144,386\tN144,386\tN144,386\tN144,386\tN144,386\tN144,386");
   
     }
       public static void main(String [] args){
         Scanner input = new Scanner(System.in);
         Connection con=null;
         Statement stmt = null;
         PreparedStatement psm = null;
         ResultSet rs = null;
     String f =null;
     String url ="jdbc:mysql://localhost:3306/moyes travelstart";
     String driver ="com.mysql.jdbc.Driver";
     String userName ="root";
     String password ="";
     try{
         Class.forName(driver).newInstance();
         con = DriverManager.getConnection(url,userName,password);
         System.out.println("Connected to data base");
         
         System.out.println("Welcome to MOYES travelstart........travel made simple \n press 1 for the menu\n press 2 for how to book flight online\npress 3 to login\npress 4 to exit");
         int decision = input.nextInt();
         switch(decision){
             case 1:
         {
             int airplane_id = 0;
             menu(con,stmt,psm,rs,input,airplane_id,f);
         }
                 break;
             case 2:
                 process(con,stmt,psm,rs,input,airplane_id,f);
                 break;
           //        case 3:
             //    login(con,stmt,psm,rs,input);
             case 4:
                 System.out.println("\n Thank you and have a nice day");
                 System.exit(0);
                 break;
             default:
                 System.out.println("invalid entry.....try again");
         }
         }
         catch(Exception a){
         a.printStackTrace();
      }
       }
}