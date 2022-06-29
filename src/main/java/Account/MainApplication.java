package Account;

import Account.Exceptions.UserCredentialsInvalidException;
import Account.Exceptions.UserDoesNotExistException;

import java.util.*;

public class MainApplication {
    private Map <String, User> users;

    public MainApplication(){
        this.users = new TreeMap<>();

    }
    public MainApplication(List<User> user){
        this.users = new TreeMap<>();

    }


    public User signup(){
        return null;
    }

    public User signIn(String email, String password) throws UserCredentialsInvalidException, UserDoesNotExistException {
        if(!users.containsKey(email))
            throw new UserDoesNotExistException("User with email does not exist: " + email);

        User user = users.get(email);

        if(!user.validatePassword(password))
            throw new UserCredentialsInvalidException("User password is incorrect");

        return user;
    }
}
