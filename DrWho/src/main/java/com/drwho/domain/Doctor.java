
package com.drwho.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@PrimaryKeyJoinColumn(name = "idUser")
@Table(name = "doctor")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Doctor extends Users{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cpf;

    @Column
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String specialization;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private AppointmentBook appointmentBook;

    public Doctor(){ }

    public Doctor(String email, String senha, String name, String cpf, String phoneNumber, String address, String specialization) {
        super(email, senha);
        setName(name);
        setCpf(cpf);
        setPhoneNumber(phoneNumber);
        setAddress(address);
        setSpecialization(specialization);
    }

    //Getters and Setters

    public String getName() { return name; }

    public String getCpf() { return cpf; }

    public String getPhoneNumber() { return phoneNumber; }

    public String getAddress() { return address; }

    public String getSpecialization() { return specialization; }

    public void setName(String name) { this.name = name; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public void setAddress(String address) { this.address = address; }

    public void setSpecialization(String specialization) { this.specialization = specialization; }

    @Override
    public String toString(){
        return "Doctor{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", phoneNmber='" + phoneNumber + '\'' +
                ", adreess='" + address + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }

}
