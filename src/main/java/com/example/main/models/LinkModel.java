package com.example.main.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "linkovi")
public class LinkModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String url;
    private Double cena;
    @Column(name = "vreme_placanja")
    private String vremePlacanja;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "klijent_id", referencedColumnName = "id")
    private ClientModel klijent;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "korisnik_id", referencedColumnName = "id")
    private UserModel korisnik;

    public LinkModel() {
    }

    public LinkModel(Long id, String url, Double cena, String vremePlacanja) {
        this.id = id;
        this.url = url;
        this.cena = cena;
        this.vremePlacanja = vremePlacanja;
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

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public String getVremePlacanja() {
        return vremePlacanja;
    }

    public void setVremePlacanja(String vremePlacanja) {
        this.vremePlacanja = vremePlacanja;
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