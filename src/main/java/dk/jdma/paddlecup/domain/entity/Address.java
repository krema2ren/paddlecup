package dk.jdma.paddlecup.domain.entity;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Audited
public class Address implements Serializable {

    private static final long serialVersionUID = -3377463799194104944L;

    public Address() {
        super();
    }

    @Basic
    private String city;

    @Basic
    private String street;

    @Basic
    private String number;

    @Basic
    private String zip;

    @Basic
    private String country;

    private String id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
