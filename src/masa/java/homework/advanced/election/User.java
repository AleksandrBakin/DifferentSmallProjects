package masa.java.homework.advanced.election;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class User implements Serializable {
    //protected static Map<String,User> users;
    protected String name;
    protected String login;
    protected String password;

    public static final int PASS_MIN_LENGTH = 8;
    public static final int PASS_MAX_LENGTH = 32;
    public static final int LOGIN_MIN_LENGTH = 8;
    public static final int LOGIN_MAX_LENGTH = 32;

    //static { users = new TreeMap<>(); }
    // protected?
    User (String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
        //        users.put(this.login, this);
        //        if((name != null)&&(name.length()>=NAME_MIN_LENGTH)) {
        //            this.name = name;
        //        } else {
        //            throw new IllegalArgumentException("Incorrect name!");
        //        }
        //        if((login != null)&&(login.length()>=LOGIN_MIN_LENGTH)&&(login.length()<=LOGIN_MAX_LENGTH)) {
        //            this.login = login;
        //        } else {
        //            throw new IllegalArgumentException("Incorrect login!");
        //        }
        //        if((password != null)&&(password.length()>=PASS_MIN_LENGTH)&&(password.length()<=PASS_MAX_LENGTH)) {
        //            this.password = password;
        //        } else {
        //            throw new IllegalArgumentException("Incorrect password!");
        //        }
        //        users.put(this.login, this);
    }

    String getName() { return name; }

    boolean enter (String login, String password) {
        if(this.login.equals(login)) return this.password.equals(password);
        else return false;
    }
}