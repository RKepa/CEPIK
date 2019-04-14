package pl.lodz.mto.cepik;

import javax.persistence.AttributeConverter;

public class VehicleTypeConverter implements AttributeConverter<String, Integer> {

    @Override
    public Integer convertToDatabaseColumn ( String name ) {
        return VehicleType.valueOf ( name ).ordinal ( );
    }

    @Override
    public String convertToEntityAttribute ( Integer ordinal ) {
        return VehicleType.getNameFromOrdinal ( ordinal );
    }
}
