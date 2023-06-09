package com.example.designapp_final.models;

public class User {
    private String name;
    private String email;
    private String password;

    private byte[] image;

    public User( String email, String password, String name){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public byte[] getImage(){
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setImage(byte[] image){
        this.image = image;
    }

    @Override
    public String toString(){
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public boolean equals(Object o){
        if(o == this){
            return true;
        }

        if(!(o instanceof User)){
            return false;
        }

        User user = (User) o;

        return user.getName().equals(name) &&
                user.getEmail().equals(email) &&
                user.getPassword().equals(password);
    }
}
