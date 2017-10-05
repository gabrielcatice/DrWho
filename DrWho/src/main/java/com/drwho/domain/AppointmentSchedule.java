package com.drwho.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.Date;

@Entity
@Table(name = "appointment_schedule")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class AppointmentSchedule {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private Client client;

    @OneToOne
    private Doctor doctor;

    @Temporal(value = TemporalType.DATE)

    private Date dateSchedule;

    @Column(columnDefinition = "default false")
    private boolean isDeleted;

    public AppointmentSchedule(Client client, Doctor doctor, Date dateSchedule, boolean isDeleted) {
        this.client = client;
        this.doctor = doctor;
        this.dateSchedule = dateSchedule;
        this.isDeleted = isDeleted;
    }

    public AppointmentSchedule(){

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getDateSchedule() {
        return dateSchedule;
    }

    public void setDateSchedule(Date dateSchedule) {
        this.dateSchedule = dateSchedule;
    }
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString(){
        return "Appointment Schedule {" +
                ", id=" + id +
                ", client" + client + '\'' +
                ", doctor" + doctor + '\'' +
                ", dateSchedule" + dateSchedule + '\'' +
                ", isDeleted='" + isDeleted + '\'' +
                '}';
    }
}
