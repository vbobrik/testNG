

import java.util.List;

public interface DAO {
    //initialize user list (read all json files and add into list)
    // void initialize(String userObject) throws FileNotFoundException;

    //get specific User by id
    //  User getById(String id);

    //get all users
    List<Client> getAll();

    //get users from unique cities (key - city, value - user list)
    //  Map<String, List<User>> getUnique();
}
