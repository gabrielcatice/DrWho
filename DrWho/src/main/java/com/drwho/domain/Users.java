package com.drwho.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Users")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Users {
    @Id
    @GeneratedValue
    private long idUser;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    public Users() {
    }

    public Users(String email, String senha) {
        setEmail(email);
        setSenha(senha);
    }

    public long getId() {
        return idUser;
    }

    public void setId(long id) {
        this.idUser = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString(){
        return "Users{" +
                "id=" + idUser +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
