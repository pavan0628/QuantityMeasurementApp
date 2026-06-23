//WeightUnit.java
//UC10 : WeightUnit Enum implementing IMeasurable

public enum WeightUnit implements IMeasurable {

    KILOGRAM(1.0),          //1 kilogram = 1 kilogram

    GRAM(0.001),            //1 gram = 0.001 kilogram

    POUND(0.453592);        //1 pound = 0.453592 kilogram


    private final double conversionFactorToKilogram;


    WeightUnit(double conversionFactorToKilogram) {

        this.conversionFactorToKilogram =
                conversionFactorToKilogram;
    }


    //returns conversion factor to kilogram
    @Override
    public double getConversionFactor() {

        return conversionFactorToKilogram;
    }


    //converts a value in this unit to kilogram(base unit)
    @Override
    public double convertToBaseUnit(double value) {

        return value *
                conversionFactorToKilogram;
    }


    //converts a value from kilogram(base unit) to this unit
    @Override
    public double convertFromBaseUnit(double baseValue) {

        return baseValue /
                conversionFactorToKilogram;
    }


    //returns unit name
    @Override
    public String getUnitName() {

        return name();
    }

}