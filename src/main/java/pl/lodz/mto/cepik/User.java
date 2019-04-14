package pl.lodz.mto.cepik;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="Users")
public class User {

    private static final long serialVersionUID = -3971574841155585167L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_uzytkownika")
    int id;

    @Column(name="Name")
    @Length(min=3,max=20, message="Imie nie może mieć mniej niż 3 znaki i więcej niż 20")
    String name;

    @Column(name="LastName")
    @Length(min=3,max=20, message="Nazwisko nie może mieć mniej niż 3 znaki i więcej niż 20")
    String lastName;

    @Column (name="Address")
    @Length(min= 10, max=300, message="Adres  nie może być krótszy niż 10 znaków")
    String adress;

    @Column(name="Active")
    boolean active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (active ? 1231 : 1237);
        result = prime * result + ((adress == null) ? 0 : adress.hashCode());
        result = prime * result + id;
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (active != other.active)
            return false;
        if (adress == null) {
            if (other.adress != null)
                return false;
        } else if (!adress.equals(other.adress))
            return false;
        if (id != other.id)
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", lastName=" + lastName + ", adress=" + adress + ", active="
                + active + "]";
    }

    public User(String name, String lastName, String address, boolean active) {
        this.name = name;
        this.lastName = lastName;
        this.adress = address;
        this.active = active;
    }

    public User() {
        super();
    }
}

