//QuantityMeasurementApp.java
//UC9 : Weight Measurement Equality, Conversion and Addition

public class QuantityMeasurementApp {

    //UC8 : QuantityLength Class
    public static class QuantityLength {

        private final double value;
        private final LengthUnit unit;

        private static final double EPSILON = 1e-6;

        public QuantityLength(double value, LengthUnit unit) {

            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Value must be finite");
            }

            if (unit == null) {
                throw new IllegalArgumentException("Unit type cannot be null");
            }

            this.value = value;
            this.unit = unit;
        }

        //converts current quantity into feet
        private double toFeet() {
            return unit.convertToBaseUnit(value);
        }

        //compares quantitylength objects by converting to feet
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

            QuantityLength other = (QuantityLength) obj;

            return Math.abs(this.toFeet() - other.toFeet()) < EPSILON;
        }

        //converts this quantitylength to target unit
        public double convertTo(LengthUnit targetUnit) {

            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null");
            }

            double valueInFeet = this.toFeet();

            return targetUnit.convertFromBaseUnit(valueInFeet);
        }

        //utility method used by add methods
        private QuantityLength addInternal(QuantityLength other,
                                           LengthUnit targetUnit) {

            double sumInFeet = this.toFeet() + other.toFeet();

            double sumInTargetUnit =
                    targetUnit.convertFromBaseUnit(sumInFeet);

            return new QuantityLength(sumInTargetUnit,
                    targetUnit);
        }

        //returns sum in first operand unit
        public QuantityLength add(QuantityLength other) {

            if (other == null) {
                throw new IllegalArgumentException("Operand cannot be null");
            }

            return addInternal(other, this.unit);
        }

        //returns sum in specified target unit
        public QuantityLength add(QuantityLength other,
                                  LengthUnit targetUnit) {

            if (other == null) {
                throw new IllegalArgumentException("Operand cannot be null");
            }

            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null");
            }

            return addInternal(other, targetUnit);
        }

        @Override
        public String toString() {
            return value + " " + unit.name();
        }

    }


    //UC9 : QuantityWeight Class
    public static class QuantityWeight {

        private final double value;
        private final WeightUnit unit;

        private static final double EPSILON = 1e-6;


        public QuantityWeight(double value,
                              WeightUnit unit) {

            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Value must be finite");
            }

            if (unit == null) {
                throw new IllegalArgumentException("Unit type cannot be null");
            }

            this.value = value;
            this.unit = unit;
        }


        //converts current quantity into kilogram
        private double toKilogram() {
            return unit.convertToBaseUnit(value);
        }


        //compares quantityweight objects by converting to kilogram
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

            QuantityWeight other =
                    (QuantityWeight) obj;

            return Math.abs(this.toKilogram()
                    - other.toKilogram()) < EPSILON;
        }


        //converts this quantityweight to target unit
        public double convertTo(WeightUnit targetUnit) {

            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null");
            }

            double valueInKilogram =
                    this.toKilogram();

            return targetUnit.convertFromBaseUnit(
                    valueInKilogram);
        }


        //utility method used by add methods
        private QuantityWeight addInternal(
                QuantityWeight other,
                WeightUnit targetUnit) {

            double sumInKilogram =
                    this.toKilogram()
                            + other.toKilogram();


            double sumInTargetUnit =
                    targetUnit.convertFromBaseUnit(
                            sumInKilogram);


            return new QuantityWeight(
                    sumInTargetUnit,
                    targetUnit);

        }


        //returns sum in first operand unit
        public QuantityWeight add(
                QuantityWeight other) {

            if (other == null) {
                throw new IllegalArgumentException("Operand cannot be null");
            }

            return addInternal(
                    other,
                    this.unit);

        }


        //returns sum in specified target unit
        public QuantityWeight add(
                QuantityWeight other,
                WeightUnit targetUnit) {


            if (other == null) {
                throw new IllegalArgumentException("Operand cannot be null");
            }


            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null");
            }


            return addInternal(
                    other,
                    targetUnit);

        }


        @Override
        public String toString() {
            return value + " " + unit.name();
        }

    }


    public static void main(String[] args) {

        QuantityWeight kilogram =
                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityWeight gram =
                new QuantityWeight(
                        1000.0,
                        WeightUnit.GRAM);


        QuantityWeight result =
                kilogram.add(
                        gram,
                        WeightUnit.GRAM);


        System.out.println(
                "Result = "
                        + result);

    }

}