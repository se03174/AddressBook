package com.example.addressbook;

public class Address {
    //member variable----------
    private String name;
    private String phone;
    private String email;


    //constructor method---- 메뉴- 코드 -제너레이트 -컨스트럭트  생성자 생성

    public Address(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }


    //getter / setter method--------- alt +insert 코드 자동생성

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //custom method-------------멤버 변수말고 클래스 기능을 쓰고싶다 전번,이름 한번에 넘기는것
    public String getInfo() {
        return  this.name + "-" +this.phone + "-" + this.email;

    }





}
