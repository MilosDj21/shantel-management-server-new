package com.example.main.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "korisnici")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String status;
    private String ime;
    private String prezime;
    private String username;
    private String password;

    @Column(name = "ui_tema")
    private String uiTema;

    /*@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "korisnik")
    private SessionModel sesija;

    @OneToMany(mappedBy = "korisnik")
    private List<RequestModel> zahtevi = new ArrayList<>();

    @OneToMany(mappedBy = "korisnik")
    private List<ClientModel> klijenti = new ArrayList<>();
    */

    public UserModel() {
    }

    public UserModel(Long id, String status, String ime, String prezime, String username, String password, String uiTema) {
        this.id = id;
        this.status = status;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.uiTema = uiTema;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUiTema() {
        return uiTema;
    }

    public void setUiTema(String uiTema) {
        this.uiTema = uiTema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(id, userModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
