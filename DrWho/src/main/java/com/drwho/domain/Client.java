package com.drwho.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@PrimaryKeyJoinColumn(name = "idUser")
@Table(name = "client")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Client extends Users{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    public Client(){ }

    public Client(String email, String senha, String name, String cpf, String phoneNumber, String address) {
        super(email, senha);
        this.name = name;
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public  String toString(){
        return  "Client {" +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address +
                '}';
    }

}
