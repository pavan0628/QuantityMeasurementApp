//WeightUnit.java
//UC9 : Standalone WeightUnit Enum with Conversion Responsibility

public enum WeightUnit {

    KILOGRAM(1.0),      //1 kilogram = 1 kilogram
    GRAM(0.001),        //1 gram = 0.001 kilogram
    POUND(0.453592);    //1 pound = 0.453592 kilogram


    private final double conversionFactorToKilogram;


    WeightUnit(double conversionFactorToKilogram) {
        this.conversionFactorToKilogram = conversionFactorToKilogram;
    }


    //returns conversion factor to kilogram
    public double getConversionFactorToKilogram() {
        return conversionFactorToKilogram;
    }


    //converts a value in this unit to kilogram(base unit)
    public double convertToBaseUnit(double value) {
        return value * conversionFactorToKilogram;
    }


    //converts a value from kilogram(base unit) to this unit
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactorToKilogram;
    }

}