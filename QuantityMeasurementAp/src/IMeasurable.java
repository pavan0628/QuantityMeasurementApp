//IMeasurable.java

public interface IMeasurable {


    //returns conversion factor to base unit
    double getConversionFactor();


    //converts a value in this unit to base unit
    double convertToBaseUnit(double value);


    //converts a value from base unit to this unit
    double convertFromBaseUnit(double baseValue);


    //returns unit name
    String getUnitName();





    default void validateOperationSupport(
            String operation) {

        //default implementation

    }


    //UC14
    default boolean supportsArithmetic() {

        return true;

    }




    default String getMeasurementType(){

        return "";

    }


    default IMeasurable getUnitByName(

            String unitName){

        return null;

    }

}