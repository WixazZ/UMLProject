package com.example.project;

public final class User {

    private static User instance;
    private String id;

    private String firstName;
    private String lastName;
    private String phone;
    private String birthday;

    private String username;
    private String password;



    public static User getInstance(){
        if(instance == null)
            instance = new User();
        return instance;
    }

    // getter and setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    public String getBirthday(){
        return birthday;
    }
}
