//Quantity.java
//UC10 : Generic Quantity Class using IMeasurable Interface

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    private static final double EPSILON = 1e-6;


    public Quantity(double value,
                    U unit) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException(
                    "Value must be finite");
        }

        if (unit == null) {
            throw new IllegalArgumentException(
                    "Unit type cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }


    //converts current quantity into base unit
    private double toBaseUnit() {

        return unit.convertToBaseUnit(value);
    }


    //compares quantity objects by converting to base unit
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Quantity<?> other =
                (Quantity<?>) obj;


        //prevents length vs weight comparison
        if (this.unit.getClass()
                != other.unit.getClass()) {

            return false;
        }

        return Math.abs(
                this.toBaseUnit()
                        - other.toBaseUnit())

                < EPSILON;
    }


    @Override
    public int hashCode() {

        return Double.hashCode(
                toBaseUnit());
    }


    //converts quantity to target unit
    public Quantity<U> convertTo(
            U targetUnit) {

        if (targetUnit == null) {

            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        double valueInBaseUnit =
                this.toBaseUnit();


        double convertedValue =
                targetUnit.convertFromBaseUnit(
                        valueInBaseUnit);


        return new Quantity<>(

                convertedValue,

                targetUnit);
    }


    //utility method used by add methods
    private Quantity<U> addInternal(

            Quantity<U> other,

            U targetUnit) {


        double sumInBaseUnit =

                this.toBaseUnit()

                        + other.toBaseUnit();


        double sumInTargetUnit =

                targetUnit.convertFromBaseUnit(

                        sumInBaseUnit);


        return new Quantity<>(

                sumInTargetUnit,

                targetUnit);
    }


    //returns sum in first operand unit
    public Quantity<U> add(

            Quantity<U> other) {


        if (other == null) {

            throw new IllegalArgumentException(

                    "Operand cannot be null");
        }


        return addInternal(

                other,

                this.unit);
    }


    //returns sum in specified target unit
    public Quantity<U> add(

            Quantity<U> other,

            U targetUnit) {


        if (other == null) {

            throw new IllegalArgumentException(

                    "Operand cannot be null");
        }


        if (targetUnit == null) {

            throw new IllegalArgumentException(

                    "Target unit cannot be null");
        }


        return addInternal(

                other,

                targetUnit);
    }


    public double getValue() {

        return value;
    }


    public U getUnit() {

        return unit;
    }


    @Override
    public String toString() {

        return value +

                " " +

                unit.getUnitName();
    }

}