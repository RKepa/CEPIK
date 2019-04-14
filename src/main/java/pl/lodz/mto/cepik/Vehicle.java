package pl.lodz.mto.cepik;

        import de.kyrychenko.utils.vin.VIN;
        import lombok.EqualsAndHashCode;
        import lombok.Getter;
        import lombok.Setter;
        import lombok.ToString;
        import org.hibernate.validator.constraints.Length;
        import org.hibernate.validator.constraints.Range;

        import javax.persistence.Entity;
        import javax.persistence.Table;
        import javax.persistence.Id;
        import javax.persistence.Column;
        import javax.persistence.Convert;
        import javax.persistence.OneToMany;
        import javax.persistence.CascadeType;
        import javax.persistence.JoinColumn;
        import javax.persistence.ForeignKey;
        import java.util.ArrayList;
        import java.util.List;


@Entity
@Table ( name = "Vehicles" )
@ToString
@EqualsAndHashCode
public abstract class Vehicle {

    @Id
    @Getter
    @VIN
    @Column ( name = "VIN", nullable = false, updatable = false )
    @Length ( min = 17, max = 17, message = "VIN musi mieć 17 znaków" )
    private String vin;

    @Getter
    @Column ( nullable = false, updatable = false )
    @Convert ( converter = VehicleTypeConverter.class )
    private VehicleType vehicleType;

    @Getter
    @Column ( nullable = false, updatable = false )
    @Length ( min = 2, max = 30, message = "Marka nie może mieć mniej niż 2 znaki i więcej niż 30" )
    private String brand;

    @Getter
    @Column ( nullable = false, updatable = false )
    @Length ( min = 1, max = 30, message = "Model nie może mieć mniej niż 1 znak i więcej niż 30" )
    private String model;

    @Getter
    @Column ( updatable = false, nullable = false )
    @Length ( min = 1920, max = 2019, message = "Rok produkcji nie może być mniejszy niż 1920 i większy niż 2019" )
    private int yearOfProduction;

    @Setter
    @Getter
    @Column ( nullable = false )
    private boolean ocPolisy = true;

    @Setter
    @Getter
    @Column ( nullable = false )
    private boolean technicalExamination = true;

    //May be null if engine is electric or vehicleType is LIGHT_TRAILER, SEMITRAILER, TRUCK_TRAILER, AGRICULTURAL_TRAILER
    @Setter
    @Getter
    @Column
    @Range ( min = 200, max = 15000, message = "Pojemność silnika nie może być mniejsza niż 200 ccm i większa niż 15000 ccm" )
    private int engineCapacity;

    //May be null if vehicleType is LIGHT_TRAILER, SEMITRAILER, TRUCK_TRAILER or AGRICULTURAL_TRAILER
    @Setter
    @Getter
    @Column
    @Range ( min = 1, max = 1200, message = "Moc silnika nie może być mniejsza niż 1 kW i większa niż 1200 kW" )
    private int enginePower;

    //May be null if vehicleType is LIGHT_TRAILER, SEMITRAILER, TRUCK_TRAILER or AGRICULTURAL_TRAILER
    @Setter
    @Getter
    @Column
    @Convert ( converter = FuelTypeConverter.class )
    private FuelType fuelType;

    @Setter
    @Getter
    @Column ( nullable = false )
    @Range ( min = 0, max = 60, message = "Liczba miejsc siedzących nie może być mniejsza niż 0 i większa niż 60" )
    private int numberOfSeats = 5;

    @Setter
    @Getter
    @Column ( nullable = false )
    @Range ( min = 30, max = 44000, message = "Masa pojazdu nie może być mniejsza niż 30 kg i większa niż 44000 kg" )
    private int ownWeight;

    @Setter
    @Getter
    @Column ( nullable = false )
    @Range ( min = 80, max = 44000, message = "Dopuszczalna masa całkowita nie może być mniejsza niż 80 kg i większa niż 44000 kg" )
    private int permissibleGrossWeight;

    @Getter
    @Column ( nullable = false )
    private int maximumLoadCapacity = permissibleGrossWeight - ownWeight;

    @Getter
    @Column ( nullable = false )
    @Range ( min = 1, max = 4, message = "Liczba osi nie może być mniejsza niż 1 i większa niż 4" )
    private int numberOfAxles;

    @Getter
    @OneToMany ( cascade = CascadeType.ALL )
    @JoinColumn ( referencedColumnName = "VIN", name = "VehicleId", foreignKey = @ForeignKey ( name = "FK_Vin" ), nullable = false, updatable = false )
    private List < RegistrationNumber > registrationNumbers = new ArrayList <> ( );

    void addRegistrationNumber ( RegistrationNumber registrationNumber ) {
        registrationNumbers.add ( registrationNumber );
    }

    public Vehicle ( String vin , VehicleType vehicleType , String brand , String model , int yearOfProduction , boolean ocPolisy , boolean technicalExamination , int engineCapacity , int enginePower , FuelType fuelType , int numberOfSeats , int ownWeight , int permissibleGrossWeight , int numberOfAxles , RegistrationNumber registrationNumber ) {
        this.vin = vin;
        this.vehicleType = vehicleType;
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.ocPolisy = ocPolisy;
        this.technicalExamination = technicalExamination;
        this.engineCapacity = engineCapacity;
        this.enginePower = enginePower;
        this.fuelType = fuelType;
        this.numberOfSeats = numberOfSeats;
        this.ownWeight = ownWeight;
        this.permissibleGrossWeight = permissibleGrossWeight;
        this.numberOfAxles = numberOfAxles;
        addRegistrationNumber ( registrationNumber );
    }

    public Vehicle ( ) {
        super ( );
    }
}

