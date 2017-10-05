package com.drwho.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.Date;


@Entity
@Table(name = "AppointmentBook")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class AppointmentBook {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private boolean monday;

    @Column(nullable = false)
    private boolean tuesday;

    @Column(nullable = false)
    private boolean wednesday;

    @Column(nullable = false)
    private boolean thursday;

    @Column(nullable = false)
    private boolean friday;

    @Column(nullable = false)
    private boolean saturday;

    @Column(nullable = false)
    private boolean sunday;

    //Não sei o motivo de quando vc adiciona a hora, ela enntra com 3 hrs a menos, tipo vc da um POST com "19:00" no banco ele guarda "16:00"
    @Temporal(value = TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm")
    private Date startTime;

    //Aqui também
    @Temporal(value = TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm")
    private Date endTime;

    @Temporal(value = TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm")
    private Date breakStartTime;

    @Temporal(value = TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm")
    private Date breakEndTime;

    @OneToOne(mappedBy="appointmentBook")
    private Doctor doctor;

    @Column(columnDefinition = "default false")
    private boolean isDeleted;

    public AppointmentBook() {
    }

    public AppointmentBook(boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, boolean sunday, Date startTime, Date endTime, Date breakStartTime, Date breakEndTime, boolean isDeleted/*, Doctor doctor*/) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
        this.startTime = startTime;
        this.endTime = endTime;
        this.breakStartTime = breakStartTime;
        this.breakEndTime = breakEndTime;
        this.isDeleted = isDeleted;
        //this.doctor = doctor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isMonday() {
        return monday;
    }

    public void setMonday(boolean monday) {
        this.monday = monday;
    }

    public boolean isTuesday() {
        return tuesday;
    }

    public void setTuesday(boolean tuesday) {
        this.tuesday = tuesday;
    }

    public boolean isWednesday() {
        return wednesday;
    }

    public void setWednesday(boolean wednesday) {
        this.wednesday = wednesday;
    }

    public boolean isThursday() {
        return thursday;
    }

    public void setThursday(boolean thursday) {
        this.thursday = thursday;
    }

    public boolean isFriday() {
        return friday;
    }

    public void setFriday(boolean friday) {
        this.friday = friday;
    }

    public boolean isSaturday() {
        return saturday;
    }

    public void setSaturday(boolean saturday) {
        this.saturday = saturday;
    }

    public boolean isSunday() {
        return sunday;
    }

    public void setSunday(boolean sunday) {
        this.sunday = sunday;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getBreakStartTime() {
        return breakStartTime;
    }

    public void setBreakStartTime(Date breakStartTime) {
        this.breakStartTime = breakStartTime;
    }

    public Date getBreakEndTime() {
        return breakEndTime;
    }

    public void setBreakEndTime(Date breakEndTime) {
        this.breakEndTime = breakEndTime;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    /*public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }*/

    @Override
    public String toString() {
        return "Appointment Book{" +
                "id=" + id +
                ", Monday='" + monday + '\'' +
                ", Tuesday='" + tuesday + '\'' +
                ", Wednesday='" + wednesday + '\'' +
                ", Thursday='" + thursday + '\'' +
                ", Friday='" + friday + '\'' +
                ", Saturday='" + saturday + '\'' +
                ", Sunday='" + sunday + '\'' +
                ", BreakStartTime='" + breakStartTime + '\'' +
                ", BreakEndTime='" + breakEndTime + '\'' +
                ", StartTime='" + startTime + '\'' +
                ", EndTime='" + endTime + '\'' +
                ", isDeleted='" + isDeleted + '\'' +
                //", Doctor='" + doctor +
                '}';
    }
}