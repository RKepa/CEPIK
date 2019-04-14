package pl.lodz.mto.cepik;

import lombok.Getter;

public enum VehicleType {

    MOPED( "motorower" ),
    MOTORCYCLE( "motocykl" ),
    CAR( "samochód osobowy" ),
    BUS( "autobus" ),
    TRUCK( "samochód ciężarowy" ),
    TRUCK_TRACTOR( "ciągnik siodłowy" ),
    FARM_TRACTOR( "ciągnik rolniczy" ),
    LIGHT_TRAILER( "przyczepa lekka" ),
    SEMITRAILER( "naczepa ciężarowa" ),
    TRUCK_TRAILER( "przyczepa ciężarowa" ),
    AGRICULTURAL_TRAILER( "przyczepa rolnicza" );

    @Getter
    private String name;

    VehicleType(String name) {
        this.name = name;
    }

    public static String getNameFromOrdinal(Integer ordinal) {
        for (VehicleType n : values()) {
            if (n.ordinal() == ordinal) {
                return n.getName();
            }
        }
        return null;
    }
}
