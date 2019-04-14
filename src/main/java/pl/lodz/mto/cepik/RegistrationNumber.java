package pl.lodz.mto.cepik;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.Calendar;

@Entity
@Table(name = "RegistrationNumbers")
@ToString
@EqualsAndHashCode
public class RegistrationNumber {

    @Id()
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private String id = getRegistrationNumber() + "_" + getRegistrationDate();

    @Getter
    @Column(name = "RegistrationNumber", nullable = false)
    @Pattern(regexp = "[A-Z0-9]+")
    @Length(min = 4, max = 8, message = "Numer rejestracyjny musi mieć miniumum 4 znaki i maksimum 8 znaków.")
    private String registrationNumber;

    @Getter
    @Column(name = "RegistrationDate", nullable = false)
    @PastOrPresent(message = "Data rejestracji nie może być przyszła")
    private Date registrationDate;

    public RegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        registrationDate = new Date( Calendar.getInstance().getTimeInMillis() );
    }

    public RegistrationNumber() {
        super();
    }
}
