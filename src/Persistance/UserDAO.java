package Persistance;

import Model.Artist;
import Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Base64.Encoder;
import java.util.Base64;
import java.util.List;

public class UserDAO extends AbsDAO<User>{
    @Override
    public void insert(User user) throws SQLException {
        try (Connection con = Model.ConnectDB.startCon()) { //resource management
            String inst = "insert into user (username, password, isAdmin)" + " values (?, ?, ?)";
            PreparedStatement preparedS = con.prepareStatement(inst);

            Encoder encoder = Base64.getEncoder();
            String originalPassword = user.getPassword();
            String encodedPassword = encoder.encodeToString(originalPassword.getBytes());

            preparedS.setString(1, user.getUsername());
            preparedS.setString(2, encodedPassword);//here the password is encrypted
            preparedS.setBoolean(3, user.isAdmin());
            preparedS.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<User> select() throws SQLException {
        List<User> ul = new ArrayList<>();
        try (Connection con = Model.ConnectDB.startCon()) { //resource management
            Statement statement;
            statement = con.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from user");

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                boolean isAdmin = resultSet.getBoolean("isAdmin");
                User u = new User(id, username, password, isAdmin);
                ul.add(u);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ul;
    }

    @Override
    public void update(User user) throws SQLException {
        try (Connection con = Model.ConnectDB.startCon()) { //resource management
            String inst = "update user set username =?, password =?, isAdmin =? where id =?";
            PreparedStatement preparedS = con.prepareStatement(inst);

            Encoder encoder = Base64.getEncoder();
            String originalPassword = user.getPassword();
            String encodedPassword = encoder.encodeToString(originalPassword.getBytes());

            preparedS.setString(1, user.getUsername());
            preparedS.setString(2, encodedPassword);
            preparedS.setBoolean(3, user.isAdmin());
            preparedS.setInt(4, user.getId());
            preparedS.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(User user) throws SQLException {
        try (Connection con = Model.ConnectDB.startCon()) { //resource management
            String inst = "delete from user where id =?";
            PreparedStatement preparedS = con.prepareStatement(inst);

            preparedS.setInt(1, user.getId());
            preparedS.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
