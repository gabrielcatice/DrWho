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
    private String dayOfWeek;

    //Não sei o motivo de quando vc adiciona a hora, ela enntra com 3 hrs a menos, tipo vc da um POST com "19:00" no banco ele guarda "16:00"
    @Temporal(value = TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm")
    private Date startTime;

    //Aqui também
    @Temporal(value = TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm")
    private Date endTime;

    @OneToOne
    private Doctor doctor;

    public AppointmentBook() {
    }

    public AppointmentBook(String dayOfWeek, Date startTime, Date endTime) {
        setDayOfWeek(dayOfWeek);
        setStartTime(startTime);
        setEndTime(endTime);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Date getStartTime() { return startTime; }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString(){
        return "Appointment Book{" +
                "id=" + id +
                ", DayOfWeek='" + dayOfWeek + '\'' +
                ", StartTime='" + startTime + '\'' +
                ", EndTime='" + endTime + '\'' +
                '}';
    }
}

