package ru.library.entity;

public class User {

    public static final String TABLE_NAME = "Users";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String ID = "uId";


    private String login;
    private String password;
    private String uId;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public User() {}

    public String getLogin() {
        return login;
    }
    public void setLogin(String login ) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User that = (User) obj;
        if (!login.equals(that.login)) return false;
        return true;
    }

    @Override
    public String toString() {
        return  "Login:  " + this.login + ", password: " + password;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((login == null) ? 0 : login.hashCode()) + ((password == null) ? 0 : password.hashCode()) ;
        return result;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }
}
