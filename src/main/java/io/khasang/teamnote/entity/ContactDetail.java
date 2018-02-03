package io.khasang.teamnote.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contact_detail")
public class ContactDetail implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tel_number")
    private String telNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "version")
    @Version
    private int version;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    public Contact contact;
    public ContactDetail() {
    }

    public ContactDetail(String telNumber, String email) {
        this.telNumber = telNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "ContactDetail{" +
                "id=" + id +
                ", telNumber='" + telNumber + '\'' +
                ", email='" + email + '\'' +
                ", version=" + version +
                '}';
    }
}
