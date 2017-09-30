
package com.drwho.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cascade;
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

    @Temporal(value = TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm")
    private Date startTime;

    @Temporal(value = TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm")
    private Date endTime;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Doctor doctor;

    public AppointmentBook() { }

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
                ", Doctor='" + doctor + '\'' +
                '}';
    }
}
