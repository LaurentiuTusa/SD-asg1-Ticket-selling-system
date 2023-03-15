package Persistance;

import Model.Artist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO extends AbsDAO<Artist>{

    @Override
    public void insert(Artist artist) throws SQLException {
        try (Connection con = Model.ConnectDB.startCon()) { //resource management
            String inst = "insert into artist (name, type)" + " values (?, ?)";
            PreparedStatement preparedS = con.prepareStatement(inst);

            preparedS.setString(1, artist.getName());
            preparedS.setString(2, artist.getType());
            preparedS.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Artist> select() throws SQLException {
        List<Artist> al = new ArrayList<>();
        try (Connection con = Model.ConnectDB.startCon()) { //resource management
            Statement statement;
            statement = con.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from artist");

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                Artist a = new Artist(id, name, type);
                al.add(a);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return al;
    }

    @Override
    public void update(Artist artist) throws SQLException {
        try (Connection con = Model.ConnectDB.startCon()) { //resource management
            String inst = "update artist set name =?, type =? where id =?";
            PreparedStatement preparedS = con.prepareStatement(inst);

            preparedS.setString(1, artist.getName());
            preparedS.setString(2, artist.getType());
            preparedS.setInt(3, artist.getId());
            preparedS.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Artist artist) throws SQLException {
        try (Connection con = Model.ConnectDB.startCon()) { //resource management
            String inst = "delete from artist where id =?";
            PreparedStatement preparedS = con.prepareStatement(inst);

            preparedS.setInt(1, artist.getId());
            preparedS.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
