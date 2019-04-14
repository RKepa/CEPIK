package pl.lodz.mto.cepik;

import lombok.Getter;

public enum FuelType {
    PETROL( "benzyna" ),
    DIESEL( "olej napędowy" ),
    LPG( "LPG" ),
    CNG( "CNG" ),
    HYDROGEN( "wodór" ),
    ELECTRICITY( "energia elektryczna" );

    @Getter
    private String name;

    FuelType(String name) {
        this.name = name;
    }

    public static String getNameFromOrdinal(Integer ordinal) {
        for (FuelType n : values()) {
            if (n.ordinal() == ordinal) {
                return n.getName();
            }
        }
        return null;
    }
}
