package com.example.hrida.hussein_abdulreda_final;

public class Restaurant {

    private String phone;
    private String name;
    private String email;
    private String city;


    public Restaurant(String phone, String name, String email, String city) {
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return  name + "\n" +
                "  Phone: " + phone + "\n" +
                "  Email: " + email + "\n" +
                "  Address: " + city;
    }
}
