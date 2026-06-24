//IMeasurable.java

@FunctionalInterface
interface SupportsArithmetic {

    boolean isSupported();

}


public interface IMeasurable {


    SupportsArithmetic supportsArithmetic =
            () -> true;


    //returns conversion factor to base unit
    double getConversionFactor();


    //converts a value in this unit to base unit
    double convertToBaseUnit(double value);


    //converts a value from base unit to this unit
    double convertFromBaseUnit(double baseValue);


    //returns unit name
    String getUnitName();



    //returns true if arithmetic is supported
    default boolean supportsArithmetic() {

        return supportsArithmetic.isSupported();

    }



    //validates arithmetic support
    default void validateOperationSupport(

            String operation) {

        //default implementation

    }

}