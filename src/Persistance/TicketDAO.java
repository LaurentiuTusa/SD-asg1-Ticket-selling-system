package Persistance;

import Business_logic.TestClass;
import Model.Artist;
import Model.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO extends AbsDAO<Ticket>{

    @Override
    public void insert(Ticket ticket) throws SQLException {
        try (Connection con = Model.ConnectDB.startCon()) { //resource management
            String inst = "insert into ticket (price, concertId, name)" + " values (?, ?, ?)";
            PreparedStatement preparedS = con.prepareStatement(inst);

            preparedS.setInt(1, ticket.getPrice());
            preparedS.setInt(2, ticket.getConcertId());
            preparedS.setString(3, ticket.getName());
            preparedS.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Ticket> select() throws SQLException {
        List<Ticket> tl = new ArrayList<>();
        try (Connection con = Model.ConnectDB.startCon()) { //resource management
            Statement statement;
            statement = con.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from ticket");

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                int price = resultSet.getInt("price");
                int concertId = resultSet.getInt("concertId");
                String name = resultSet.getString("name");

                Ticket t = new Ticket(id, price, concertId, name);
                tl.add(t);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tl;
    }

    public List<Ticket> selectById(int cId) throws SQLException {
        List<Ticket> tl = new ArrayList<>();
        try (Connection con = Model.ConnectDB.startCon()) { //resource management
            Statement statement;
            statement = con.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from ticket where concertId= " + cId);

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                int price = resultSet.getInt("price");
                int concertId = resultSet.getInt("concertId");
                String name = resultSet.getString("name");

                Ticket t = new Ticket(id, price, concertId, name);
                tl.add(t);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tl;
    }

    @Override
    public void update(Ticket ticket) throws SQLException {
        try (Connection con = Model.ConnectDB.startCon()) { //resource management
            String inst = "update ticket set price =?, concertId =?, name =? where id =?";
            PreparedStatement preparedS = con.prepareStatement(inst);

            preparedS.setInt(1, ticket.getPrice());
            preparedS.setInt(2, ticket.getConcertId());
            preparedS.setString(3, ticket.getName());
            preparedS.setInt(4, ticket.getId());
            preparedS.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Ticket ticket) throws SQLException {
        try (Connection con = Model.ConnectDB.startCon()) { //resource management
            String inst = "delete from ticket where id =?";
            PreparedStatement preparedS = con.prepareStatement(inst);

            preparedS.setInt(1, ticket.getId());
            preparedS.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean check(int concertId, int amount) throws SQLException {
        try (Connection con = Model.ConnectDB.startCon()) { //resource management
            // search the concert by concertId and return its limit

            Statement statement;
            statement = con.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from concerts");
            int lim1 = 0;
            while(resultSet.next()) {
                int searchId = resultSet.getInt("id");
                if(searchId==concertId)
                    lim1 = resultSet.getInt("limit");
            }

            // then COUNT in tickets all the tickets with the specified concertId
            Statement statement1;
            statement1 = con.createStatement();
            ResultSet resultSet1;
            resultSet1 = statement1.executeQuery("select * from ticket");
            int count = 0;
            while (resultSet1.next()) {
                int searchId = resultSet1.getInt("concertId");
                if(searchId==concertId)
                    count++;
            }

            // verify amount <= limit - cnt
            TestClass te = new TestClass();
            te.testAmount(amount, lim1, count);

            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
