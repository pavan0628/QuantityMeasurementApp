//QuantityDTO.java
//UC15 : Data Transfer Object


import java.io.Serializable;

public class QuantityDTO implements Serializable {

    private final double value;

    private final String unit;

    private final String measurementType;



    public QuantityDTO(double value,
                       String unit,
                       String measurementType) {

        this.value = value;
        this.unit = unit;
        this.measurementType = measurementType;
    }



    public double getValue() {

        return value;
    }



    public String getUnit() {

        return unit;
    }



    public String getMeasurementType() {

        return measurementType;
    }



    @Override
    public String toString() {

        return value +

                " " +

                unit;
    }

}