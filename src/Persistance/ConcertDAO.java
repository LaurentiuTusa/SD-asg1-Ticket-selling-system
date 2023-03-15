package Persistance;

import Model.Concert;
import Model.User;

import java.sql.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConcertDAO extends AbsDAO<Concert>{

    @Override
    public void insert(Concert concert) throws SQLException {
        try (Connection con = Model.ConnectDB.startCon()) { //resource management
            String inst = "insert into concerts (name, limit, time) values (?, ?, ?)";
            PreparedStatement preparedS = con.prepareStatement(inst);

            preparedS.setString(1, concert.getName());
            preparedS.setInt(2, concert.getLimit());
            preparedS.setTimestamp(3, concert.getTime());
            preparedS.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Concert> select() throws SQLException {
        List<Concert> cl = new ArrayList<>();
        try (Connection con = Model.ConnectDB.startCon()) { //resource management
            Statement statement;
            statement = con.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from concerts");

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int limit = resultSet.getInt("limit");
                Timestamp time = resultSet.getTimestamp("time");
                Concert c = new Concert(id, name, limit, time);
                cl.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cl;
    }

    @Override
    public void update(Concert concert) throws SQLException {
        try (Connection con = Model.ConnectDB.startCon()) { //resource management
            String inst = "update concerts set name =?, limit =?, time=? where id =?";
            PreparedStatement preparedS = con.prepareStatement(inst);

            preparedS.setString(1, concert.getName());
            preparedS.setInt(2, concert.getLimit());
            preparedS.setTimestamp(3, concert.getTime());
            preparedS.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Concert concert) throws SQLException {
        try (Connection con = Model.ConnectDB.startCon()) { //resource management
            String inst = "delete from concerts where id =?";
            PreparedStatement preparedS = con.prepareStatement(inst);

            preparedS.setInt(1, concert.getId());
            preparedS.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
