package app.database.entity;

import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String companyName;

    private String salt;

    private String hashedPassword;

    @Embedded
    private Address address;

    public Company(){
    }

    public Company(String companyName, Address address, String password) {
        this.companyName = companyName;
        this.address = address;
        this.salt =  BCrypt.gensalt();
        this.hashedPassword = BCrypt.hashpw(password, this.salt);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getSalt() {
        return salt;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }
}
