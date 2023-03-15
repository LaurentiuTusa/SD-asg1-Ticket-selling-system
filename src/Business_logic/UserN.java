package Business_logic;

import Model.User;
import Persistance.UserDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class UserN {
    private String username;
    private String password;
    private UserDAO v;

    public UserN(UserDAO v) {
        this.v = v;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int vreifyAdmin() throws SQLException {
        List<User> l = new ArrayList<>();
        l = v.select();
        for (User user: l) {
            if (user.getUsername().equals(this.getUsername())){

                Base64.Encoder encoder = Base64.getEncoder();
                String originalPassword = this.getPassword();
                String encodedPassword = encoder.encodeToString(originalPassword.getBytes());

                if (user.getPassword().equals(encodedPassword)){
                    if (user.isAdmin()){
                        return 1;//is admin
                    }
                    else return 2;//is cashier
                }
            }
        }
        //System.out.println("No user with name: " + this.getUsername() + " was found");
        return 0;//wrong input
    }
}
