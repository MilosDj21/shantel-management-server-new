package com.example.main.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "klijenti")
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "kontakt_osoba")
    private String kontaktOsoba;
    private String email;
    private String napomena;
    @Column(name = "vreme_izmene")
    private String vremeIzmene;

    /*@OneToMany(mappedBy = "klijent")
    private List<LinkModel> linkovi = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "korisnik_id", referencedColumnName = "id")
    private UserModel korisnik;
    */

    public ClientModel() {
    }

    public ClientModel(Long id, String kontaktOsoba, String email, String napomena, String vremeIzmene) {
        this.id = id;
        this.kontaktOsoba = kontaktOsoba;
        this.email = email;
        this.napomena = napomena;
        this.vremeIzmene = vremeIzmene;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKontaktOsoba() {
        return kontaktOsoba;
    }

    public void setKontaktOsoba(String kontaktOsoba) {
        this.kontaktOsoba = kontaktOsoba;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public String getVremeIzmene() {
        return vremeIzmene;
    }

    public void setVremeIzmene(String vremeIzmene) {
        this.vremeIzmene = vremeIzmene;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientModel clientModel = (ClientModel) o;
        return Objects.equals(id, clientModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
