package model;

/**
 * Created by Davido17 on 8/8/2018.
 */

public class Contact {

    private String username;
    private String phonenumber;
    private int id;

public Contact(int i, String string, String cursorString){

    }

    public Contact(String username, String phonenumber, int id) {
        this.username = username;
        this.phonenumber = phonenumber;
        this.id = id;
    }

    public Contact(String username, String phonenumber) {
        this.username = username;
        this.phonenumber = phonenumber;
    }

    public Contact() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int i) {
        this.id = id;
    }
}
