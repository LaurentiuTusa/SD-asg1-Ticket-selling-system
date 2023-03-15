package Presentation;

import Business_logic.Admin;
import Business_logic.Cashier;
import Business_logic.UserN;
import Model.Artist;
import Model.Ticket;
import Model.User;
import Persistance.ArtistDAO;
import Persistance.ConcertDAO;
import Persistance.TicketDAO;
import Persistance.UserDAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Presentation {


    public void present() {
        UserN po = new UserN(new UserDAO());

        String un; //We're going to read all user's text into a String and we try to convert it later
        String pw; //We're going to read all user's text into a String and we try to convert it later
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Here you declare your BufferedReader object and instance it.
        try{
            System.out.println("Start with the authentication:");
            System.out.println("Username?");
            un = br.readLine(); //We read from user's input
            po.setUsername(un);
            System.out.println("Password?"); //If all was right, we print this
            pw = br.readLine();
            po.setPassword(pw);

            if (po.vreifyAdmin()==1){ // admin
                Admin admin = new Admin(new UserDAO(), new ArtistDAO(), new ConcertDAO());
                System.out.println("Admin access granted!");
                //todo print operations

                String exit = "";
                while (!(exit.equals("q"))){
                    System.out.println("Input the operation number you want to do:\n1.Export a show to CSV  2.Select all users  3.Insert new user  4.Update user by id  5.Delete user  6.Select all artists  7.Insert new artist  8.Update artist  9.Delete artist  q exit");
                    exit = br.readLine();
                    switch(exit) { // enumerate operations
                        case "1": // export CSV
                            System.out.println("Insert concertId");
                            int cId = Integer.parseInt(br.readLine());
                            admin.setSearchId(cId);
                            admin.export();
                            break;
                        //USERS
                        case "2": // Select all users
                            List<User> test = new ArrayList<>();
                            test = admin.getUd().select();
                            for (User usr: test) {
                                System.out.println(usr.toString());
                            }
                            break;
                        case "3": // insert user
                            System.out.println("Insert username:");
                            String u = br.readLine();
                            System.out.println("Insert password:");
                            String p = br.readLine();
                            System.out.println("Give admin access rights? y for yes, n for no");
                            String b = br.readLine();
                            boolean bol;
                            bol = b.equals("y");

                            User newUser = new User(1, u, p, bol);
                            admin.getUd().insert(newUser);
                            break;
                        case "4": // update user
                            System.out.println("Insert id");
                            int idu = Integer.parseInt(br.readLine());
                            System.out.println("Insert username:");
                            String uu = br.readLine();
                            System.out.println("Insert password:");
                            String pu = br.readLine();
                            System.out.println("Give admin access rights? y for yes, n for no");
                            String bu = br.readLine();
                            boolean bolu;
                            bolu = bu.equals("y");

                            User newUseru = new User(idu, uu, pu, bolu);
                            admin.getUd().update(newUseru);
                            break;
                        case "5": // delete user
                            System.out.println("Insert id");
                            int idd = Integer.parseInt(br.readLine());

                            User newUserd = new User(idd, "", "", false);
                            admin.getUd().delete(newUserd);
                            break;
                        //ARTISTS
                        case "6": // Select all artist
                            List<Artist> testa = new ArrayList<>();
                            testa = admin.getAd().select();
                            for (Artist art: testa) {
                                System.out.println(art.toString());
                            }
                            break;
                        case "7": // insert artist
                            System.out.println("Insert artist name:");
                            String an = br.readLine();
                            System.out.println("Insert music type:");
                            String musicType = br.readLine();

                            Artist newArtist = new Artist(1, an, musicType);
                            admin.getAd().insert(newArtist);
                            break;
                        case "8": // update artist
                            System.out.println("Insert artist id");
                            int ida = Integer.parseInt(br.readLine());
                            System.out.println("Insert artist name:");
                            String anu = br.readLine();
                            System.out.println("Insert music type:");
                            String musicTypeU = br.readLine();

                            Artist newArtistU = new Artist(ida, anu, musicTypeU);
                            admin.getAd().insert(newArtistU);
                            break;
                        case "9": // delete artist
                            System.out.println("Insert artist id");
                            int idad = Integer.parseInt(br.readLine());

                            Artist newArtistd = new Artist(idad, "", "");
                            admin.getAd().delete(newArtistd);
                            break;
                        case "q":
                            System.out.println("Program is closing");
                            break;
                        default:
                            System.out.println("Invalid operation");
                    }//end switch
                }//end while
            }
            else if (po.vreifyAdmin()==2) { // cashier
                Cashier cashier = new Cashier(new TicketDAO());
                System.out.println("Cashier access granted!");
                //todo show operations

                String exitc = "";
                while (!(exitc.equals("q"))){
                    System.out.println("Input the operation number you want to do:\n1.Select all tickets from all concerts  2.Select all tickets from one concert  3.Sell tickets  4.Update ticket  5.Delete ticket  q exit");
                    exitc = br.readLine();
                    switch(exitc) { // enumerate operations
                        case "1":
                            List<Ticket> tl = new ArrayList<>();
                            tl = cashier.getTd().select();
                            for (Ticket t:tl) {
                                System.out.println(t.toString());
                            }
                            break;
                        case "2"://selectById
                            System.out.println("Insert concertId:");
                            int concId = Integer.parseInt(br.readLine());

                            List<Ticket> tlc = new ArrayList<>();
                            tlc = cashier.getTd().selectById(concId);
                            for (Ticket t1:tlc) {
                                System.out.println(t1.toString());
                            }
                            break;
                        case "3": // sellTickets
                            System.out.println("Insert buyer's name:");
                            String buyer = br.readLine();
                            System.out.println("Insert amount of tickets:");
                            int amount = Integer.parseInt(br.readLine());
                            System.out.println("Insert concertId");
                            int concertID = Integer.parseInt(br.readLine());

                            cashier.sellTicket(buyer, amount, concertID);
                            break;
                        case "4": // update ticket
                            System.out.println("Insert ticket id");
                            int idtu = Integer.parseInt(br.readLine());
                            System.out.println("Insert price:");
                            int price = Integer.parseInt(br.readLine());
                            System.out.println("Insert concertId:");
                            int conId = Integer.parseInt(br.readLine());
                            System.out.println("Insert buyer's name");
                            String buyerName = br.readLine();

                            Ticket newT = new Ticket(idtu, price, conId, buyerName);
                            cashier.getTd().update(newT);
                            break;
                        case "5": // delete ticket
                            System.out.println("Insert ticket id");
                            int idtd = Integer.parseInt(br.readLine());

                            Ticket newTd = new Ticket(idtd, 0, 0, "");
                            cashier.getTd().delete(newTd);
                            break;
                        case "q":
                            System.out.println("Program is closing");
                            break;
                        default:
                            System.out.println("Invalid operation");
                    }
                }
                //cashier.sellTicket("Sorin Soce", 4, 2);
            }
            else if(po.vreifyAdmin()==0){
                System.out.println("User not found, try again!");// no user found
                //main(args);
                present();
            }
        }
        catch(Exception e){
            System.out.println("Wrong input, try again!"); //This is what user will see if he/she write a false user
            //main(args); //We call this class again, so user can try it again
            present();
            //You can also print exception in case you want to see it as follows:
            // e.printStackTrace();
        }
    }
}
