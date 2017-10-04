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

    @Column
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String specialization;

    @OneToOne
    @JoinColumn(name="appointment_book_id")
    private AppointmentBook appointmentBook;

    public Doctor(){ }

    public Doctor(String name, String cpf, String email, String phoneNumber, String address, String specialization, AppointmentBook appointmentBook) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.specialization = specialization;
        this.appointmentBook = appointmentBook;
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

    public AppointmentBook getAppointmentBook() {
        return appointmentBook;
    }

    public void setAppointmentBook(AppointmentBook appointmentBook) {
        this.appointmentBook = appointmentBook;
    }

    @Override
    public String toString(){
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", specialization='" + specialization + '\'' +
                ", appointmentBook='" + appointmentBook + '\'' +
                '}';
    }

}
