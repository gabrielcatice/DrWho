package com.drwho.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "doctor")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Doctor {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String specialization;

    @OneToOne
    private AppointmentBook appointmentBook;

    public Doctor(){ }

    public Doctor(String name, String cpf, String email, String phoneNumber, String address, String specialization) {
        setName(name);
        setCpf(cpf);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setAddress(address);
        setSpecialization(specialization);
    }

    //Getters and Setters

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getSpecialization() {
        return specialization;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString(){
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", phoneNmber='" + phoneNumber + '\'' +
                ", adreess='" + address + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }

}
