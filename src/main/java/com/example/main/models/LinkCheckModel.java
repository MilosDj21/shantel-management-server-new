package com.example.main.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "linkovi_za_proveru")
public class LinkCheckModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String url;
    private String status;
    @Column(name = "vreme_provere")
    private String vremeProvere;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "klijent_id", referencedColumnName = "id")
    private ClientModel klijent;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "korisnik_id", referencedColumnName = "id")
    private UserModel korisnik;

    public LinkCheckModel(){
    }

    public LinkCheckModel(Long id, String url, String status, String vremeProvere) {
        this.id = id;
        this.url = url;
        this.status = status;
        this.vremeProvere = vremeProvere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVremeProvere() {
        return vremeProvere;
    }

    public void setVremeProvere(String vremeProvere) {
        this.vremeProvere = vremeProvere;
    }

    public ClientModel getKlijent() {
        return klijent;
    }

    public void setKlijent(ClientModel klijent) {
        this.klijent = klijent;
    }

    public UserModel getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(UserModel korisnik) {
        this.korisnik = korisnik;
    }
}
