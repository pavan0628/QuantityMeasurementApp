//IMeasurable.java
//UC10 : Common Interface for all Measurement Units

public interface IMeasurable {

    //returns conversion factor to base unit
    double getConversionFactor();


    //converts a value in this unit to base unit
    double convertToBaseUnit(double value);


    //converts a value from base unit to this unit
    double convertFromBaseUnit(double baseValue);


    //returns unit name
    String getUnitName();

}