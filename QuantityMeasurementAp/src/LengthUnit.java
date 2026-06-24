//LengthUnit.java


public enum LengthUnit implements IMeasurable {

    FEET(1.0),                 //1 foot = 1 foot

    INCH(1.0 / 12.0),          //1 inch = 1/12 foot

    YARD(3.0),                 //1 yard = 3 feet

    CENTIMETER(1.0 / 30.48);   //1 centimeter = 1/30.48 foot


    private final double conversionFactorToFeet;


    LengthUnit(double conversionFactorToFeet) {
        this.conversionFactorToFeet =
                conversionFactorToFeet;
    }
    //UC15 : Returns measurement type
    @Override
    public String getMeasurementType() {

        return "LENGTH";

    }


    //UC15 : Returns unit instance by name
    @Override
    public IMeasurable getUnitByName(

            String unitName) {

        return LengthUnit.valueOf(

                unitName);

    }

    //returns conversion factor to feet
    @Override
    public double getConversionFactor() {

        return conversionFactorToFeet;
    }


    //converts a value in this unit to feet(base unit)
    @Override
    public double convertToBaseUnit(double value) {

        return value *
                conversionFactorToFeet;
    }


    //converts a value from feet(base unit) to this unit
    @Override
    public double convertFromBaseUnit(double baseValue) {

        return baseValue /
                conversionFactorToFeet;
    }


    //returns unit name
    @Override
    public String getUnitName() {

        return name();
    }



}