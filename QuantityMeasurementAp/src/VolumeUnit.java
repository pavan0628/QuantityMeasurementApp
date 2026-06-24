//VolumeUnit.java


public enum VolumeUnit implements IMeasurable {

    LITRE(1.0),
    MILLILITRE(0.001),
    GALLON(3.78541);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    //UC15 : Returns measurement type
    @Override
    public String getMeasurementType() {

        return "VOLUME";

    }


    //UC15 : Returns unit instance by name
    @Override
    public IMeasurable getUnitByName(

            String unitName) {

        return VolumeUnit.valueOf(

                unitName);

    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }

    @Override
    public String getUnitName() {
        return name();
    }
}