//UC13: Centralized Arithmetic Logic to Enforce DRY in Quantity Operations
public class Quantity<U extends IMeasurable> {


    private final double value;
    private final U unit;

    private static final double EPSILON = 1e-6;


    //UC13: Arithmetic Operations Enum (ADD, SUBTRACT, DIVIDE)
    private enum ArithmeticOperation {


        ADD {


            @Override
            double compute(double first,
                           double second) {

                return first + second;

            }

        },


        SUBTRACT {


            @Override
            double compute(double first,
                           double second) {

                return first - second;

            }

        },


        DIVIDE {


            @Override
            double compute(double first,
                           double second) {


                if (Double.compare(second, 0.0) == 0) {

                    throw new ArithmeticException(
                            "Division by zero");

                }


                return first / second;

            }

        };



        abstract double compute(double first,
                                double second);

    }






    /**
     * Subtracts another quantity from this quantity.
     */
    public Quantity<U> subtract(Quantity<U> other) {

        return subtract(other, this.unit);

    }

    /**
     * Divides this quantity by another quantity.
     */
    public double divide(Quantity<U> other) {


        if (other == null) {
            throw new IllegalArgumentException(
                    "Quantity cannot be null");
        }


        double firstBase =
                unit.convertToBaseUnit(value);


        double secondBase =
                other.unit.convertToBaseUnit(other.value);



        if (Double.compare(secondBase,0.0)==0) {

            throw new ArithmeticException(
                    "Division by zero");

        }


        return firstBase / secondBase;

    }

    /**
     * Subtracts another quantity from this quantity.
     */
    public Quantity<U> subtract(Quantity<U> other,
                                U targetUnit) {

        if (other == null) {
            throw new IllegalArgumentException(
                    "Quantity cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }


        double firstBase =
                unit.convertToBaseUnit(value);

        double secondBase =
                other.unit.convertToBaseUnit(other.value);


        double resultBase =
                firstBase - secondBase;


        double result =
                targetUnit.convertFromBaseUnit(resultBase);


        result = Math.round(result * 100.0)
                / 100.0;


        return new Quantity<>(
                result,
                targetUnit);

    }

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


    ///UC13: Addition using centralized arithmetic helper
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

    //UC13: Validates arithmetic operands and target unit
    private void validateArithmeticOperands(
            Quantity<U> other,
            U targetUnit,
            boolean targetRequired) {


        if (other == null) {

            throw new IllegalArgumentException(
                    "Quantity cannot be null");

        }


        if (targetRequired &&
                targetUnit == null) {


            throw new IllegalArgumentException(
                    "Target unit cannot be null");

        }


        if (unit.getClass() !=
                other.unit.getClass()) {


            throw new IllegalArgumentException(
                    "Incompatible quantities");

        }

    }
    //UC13: Performs arithmetic in base units using centralized helper logic
    private double performBaseArithmetic(
            Quantity<U> other,

            ArithmeticOperation operation) {



        double firstBase =

                unit.convertToBaseUnit(
                        value);



        double secondBase =

                other.unit.convertToBaseUnit(
                        other.value);



        return operation.compute(

                firstBase,

                secondBase);

    }


    @Override
    public String toString() {

        return value +

                " " +

                unit.getUnitName();
    }

}