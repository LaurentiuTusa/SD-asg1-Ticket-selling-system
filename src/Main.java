import Business_logic.Admin;
import Business_logic.Cashier;
import Business_logic.TestClass;
import Business_logic.UserN;
import Model.*;
import Persistance.*;
import Presentation.Presentation;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.*;
import java.util.Base64.Encoder;
import java.sql.*;
import java.sql.Timestamp;
import java.time.*;

public class Main {
    public static void main(String[] args) throws SQLException {

/*        Connection connection = null;
        try {
        connection = Model.ConnectDB.startCon();

            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from artist");

            int id;
            String name;
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name").trim();
                System.out.println("ID : " + id
                        + " Artist name : " + name);
            }*/

           // Insert into cashier (old user) table
          /*  Encoder encoder = Base64.getEncoder();
            String originalPassword = "alex";
            String encodedPassword = encoder.encodeToString(originalPassword.getBytes());

            System.out.println("\n" + encodedPassword);

            String inst = "insert into cashier (Username, Password)" + " values (?, ?)";
            PreparedStatement preparedS = connection.prepareStatement(inst);

            preparedS.setString(1, "alex");
            preparedS.setString(2, encodedPassword);

            preparedS.execute();*/

            // Insert admin into user table
          /*  Encoder encoder = Base64.getEncoder();
            String originalPassword = "lau";
            String encodedPassword = encoder.encodeToString(originalPassword.getBytes());

            System.out.println("\n" + encodedPassword);

            String inst = "insert into user (username, Password, isAdmin)" + " values (?, ?, ?)";
            PreparedStatement preparedS = connection.prepareStatement(inst);

            preparedS.setString(1, "lau");
            preparedS.setString(2, encodedPassword);
            preparedS.setBoolean(3, true);
            preparedS.execute();*/

/*            Statement s = connection.createStatement();
            ResultSet r = s.executeQuery("select * from user");
            String cname;
            String cpassword;
            boolean isAdmin;

            while(r.next()){
                cname = r.getString("username");
                cpassword = r.getString("password").trim();
                isAdmin = r.getBoolean("isAdmin");
                System.out.println("Username : " + cname
                        + " cashier password : " + cpassword
                        + " isAdmin : " + isAdmin);
            }*/

            // Insert users
/*            System.out.println("\nInsert prin userDAO:\n");
            User u = new User(14, "asd", "asd", false);
            UserDAO udaoi = new UserDAO();
            udaoi.insert(u);*/
            //Delete users
/*            System.out.println("\nDelete prin UserDAO:\n");
            User d = new User(3, "i", "", true);
            UserDAO udaod = new UserDAO();
            udaod.delete(d);*/
            // Update artist
/*            System.out.println("\nUpdate prin UserDAO:\n");
            User u = new User(4, "az", "az", false);
            UserDAO udaou = new UserDAO();
            udaou.update(u);*/
            //Select users
/*            System.out.println("\nSelect prin UserDAO:\n");
            List<User> test = new ArrayList<>();
            UserDAO udao = new UserDAO();
            test = udao.select();
            for (User usr: test) {
                System.out.println(usr.toString());
            }*/
            //-------------------/

            //Insert concerts nu merge
/*            System.out.println("\nInsert prin concertDAO:\n");
            Date d = new Date(99999999);
            d.setHours(13);
            d.setMinutes(0);
            d.setSeconds(0);
            Concert co = new Concert(14, "SolidGear", 8, d);
            ConcertDAO cdaoi = new ConcertDAO();
            cdaoi.insert(co);*/

            //Select concerts
/*            System.out.println("\nSelect prin ConcertDAO:\n");
            List<Concert> test = new ArrayList<>();
            ConcertDAO cdao = new ConcertDAO();
            test = cdao.select();
            for (Concert c: test) {
                System.out.println(c.toString());
            }*/
            //------------/
            //Select ticket
/*                        System.out.println("\nSelect prin TDAO:\n");
            List<Ticket> test = new ArrayList<>();
            TicketDAO tdao = new TicketDAO();
            test = tdao.select();
            for (Ticket t: test) {
                System.out.println(t.toString());
            }*/

            //-------------------/
            // Insert artist prin ArtistDAO
/*            System.out.println("\nInsert prin artistDAO:\n");
            Artist a = new Artist(15, "Ian", "TRAP");
            ArtistDAO adai = new ArtistDAO();
            adai.insert(a);*/
            // Update artist prin ArtistDAO
/*            System.out.println("\nUpdate prin artistDAO:\n");
            Artist u = new Artist(3, "Steve-Aoki", "EDM");
            ArtistDAO adau = new ArtistDAO();
            adau.update(u);*/
            //Delete artist prin ArtistDAO
/*            System.out.println("\nDelete prin artistDAO:\n");
            Artist d = new Artist(5, "i", "");
            ArtistDAO adad = new ArtistDAO();
            adad.delete(d);*/
            // Select artisti prin ArtistDAO
/*            System.out.println("\nSelect prin artistDAO:\n");
            List<Artist> test = new ArrayList<>();
            ArtistDAO adao = new ArtistDAO();
            test = adao.select();
            for (Artist art: test) {
                System.out.println(art.toString());
            }*/

            /////////ACI O FOST TOT
            Presentation p = new Presentation();
            p.present();

           /* po.setUsername("az");
            po.setPassword("az");
            System.out.println("New user is (1=admin// 2=cashier// 0=nimeni) " + po.vreifyAdmin());

            if (po.vreifyAdmin()==1){ // admin
                Admin admin = new Admin(new UserDAO(), new ArtistDAO(), new ConcertDAO());
                // continua aici
                admin.setSearchId(1);
                //admin.export();
            }
            else if (po.vreifyAdmin()==2) { // cashier
                Cashier cashier = new Cashier(new TicketDAO());
                //continua aici
                cashier.sellTicket("Sorin Soce", 4, 2);
            }
            else if(po.vreifyAdmin()==0)
                System.out.println("User not found");

            TestClass f = new TestClass();
            f.setUp();
            f.testAdd();
            f.testAmount(3, 10, 7);*/



/*            s.close();
            r.close();
            resultSet.close();
            statement.close();
            connection.close();
        }*/
/*        catch (Exception exception) {
            System.out.println(exception);
        }*/
    }
}
