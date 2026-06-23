//LengthUnit.java
//UC8 : Standalone LengthUnit Enum with Conversion Responsibility

public enum LengthUnit {

    FEET(1.0),                //1 foot = 1 foot
    INCH(1.0 / 12.0),         //1 inch = 1/12 foot
    YARD(3.0),                //1 yard = 3 feet
    CENTIMETER(1.0 / 30.48);  //1 centimeter = 1/30.48 foot


    private final double conversionFactorToFeet;


    LengthUnit(double conversionFactorToFeet) {
        this.conversionFactorToFeet = conversionFactorToFeet;
    }


    //returns conversion factor to feet
    public double getConversionFactorToFeet() {
        return conversionFactorToFeet;
    }


    //converts a value in this unit to feet(base unit)
    public double convertToBaseUnit(double value) {
        return value * conversionFactorToFeet;
    }


    //converts a value from feet(base unit) to this unit
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactorToFeet;
    }

}