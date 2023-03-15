package Persistance;

import Model.Ticket;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExportT implements ExportTicket{
    @Override
    public void expotTickets(int givenId) {
        List<Ticket> tl = new ArrayList<>();
        try (Connection con = Model.ConnectDB.startCon()) { //resource management
            Statement statement;
            statement = con.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from ticket where concertId =" + givenId);

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                int price = resultSet.getInt("price");
                int concertId = resultSet.getInt("concertId");
                String name = resultSet.getString("name");

                Ticket t = new Ticket(id, price, concertId, name);
                tl.add(t);
            }
            //aici am lista de tickete construita
            //export
            File csvfile = new File("export.csv");
            try {
                PrintWriter out = new PrintWriter(csvfile);
                for (Ticket h:tl) {
                    out.print(h.toString() + "\n");
                }
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
