package pl.lodz.mto.cepik;

import javax.persistence.AttributeConverter;

public class FuelTypeConverter implements AttributeConverter<String, Integer> {

    @Override
    public Integer convertToDatabaseColumn ( String name ) {
        return FuelType.valueOf ( name ).ordinal ( );
    }

    @Override
    public String convertToEntityAttribute ( Integer ordinal ) {
        return FuelType.getNameFromOrdinal ( ordinal );
    }
}
