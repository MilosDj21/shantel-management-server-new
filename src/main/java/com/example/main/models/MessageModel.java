package com.example.main.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "poruke")
public class MessageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String poruka;
    private String status;
    @Column(name = "vreme_poruke")
    private String vremePoruke;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "link_za_proveru_id", referencedColumnName = "id")
    private LinkCheckModel linkZaProveru;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVremePoruke() {
        return vremePoruke;
    }

    public void setVremePoruke(String vremePoruke) {
        this.vremePoruke = vremePoruke;
    }

    public LinkCheckModel getLinkZaProveru() {
        return linkZaProveru;
    }

    public void setLinkZaProveru(LinkCheckModel linkZaProveru) {
        this.linkZaProveru = linkZaProveru;
    }
}
