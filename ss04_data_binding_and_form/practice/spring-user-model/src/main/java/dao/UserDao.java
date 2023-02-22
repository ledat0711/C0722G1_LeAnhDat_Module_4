package dao;

import com.codegym.model.Login;
import com.codegym.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User("john", "123456", "John", "john@codegym.vn", 10));
        users.add(new User("micheal", "678901", "Micheal", "micheal@codegym.vn", 14));
        users.add(new User("valhein", "0078675", "Valhein", "valhein@codegym.vn", 16));
    }

    public static User checkLogin(Login login) {
        for (User userDatabase : users) {
            if ((userDatabase.getAccount().equals(login.getAccount()))
                    && (userDatabase.getPassword().equals(login.getPassword()))) {
                return userDatabase;
            }
        }
        return null;
    }
}
