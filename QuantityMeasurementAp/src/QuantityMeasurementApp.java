//UC12: Subtraction and Division Operations on Quantity Measurements
//Demonstrates subtraction and division for Length, Weight and Volume
//Supports implicit and explicit target units
//Validates immutability, cross-unit arithmetic and error handling

public class QuantityMeasurementApp {

    public static <U extends IMeasurable>
    void demonstrateEquality(Quantity<U> q1,
                             Quantity<U> q2) {

        System.out.println(q1 + " equals "
                + q2 + " = "
                + q1.equals(q2));
    }

    public static <U extends IMeasurable>
    void demonstrateSubtraction(

            Quantity<U> first,

            Quantity<U> second,

            U targetUnit){



        Quantity<U> result =

                first.subtract(
                        second,
                        targetUnit);



        System.out.println(

                first

                        +" - "

                        +second

                        +" = "

                        +result

        );


    }


    public static <U extends IMeasurable>
    void demonstrateConversion(Quantity<U> quantity,
                               U targetUnit) {

        System.out.println(quantity
                + " converted to "
                + targetUnit.getUnitName()
                + " = "
                + quantity.convertTo(targetUnit));
    }


    public static <U extends IMeasurable>
    void demonstrateAddition(Quantity<U> q1,
                             Quantity<U> q2,
                             U targetUnit) {

        System.out.println(q1
                + " + "
                + q2
                + " = "
                + q1.add(q2,
                targetUnit));
    }
    public static <U extends IMeasurable>
    void demonstrateDivision(

            Quantity<U> first,

            Quantity<U> second){



        double result =

                first.divide(second);



        System.out.println(

                first

                        +" / "

                        +second

                        +" = "

                        +result

        );

    }



    public static void main(String[] args) {



        Quantity<LengthUnit> feet =

                new Quantity<>(
                        10,
                        LengthUnit.FEET);


        Quantity<LengthUnit> inch =

                new Quantity<>(
                        6,
                        LengthUnit.INCH);


        demonstrateSubtraction(

                feet,
                inch,
                LengthUnit.FEET);



        demonstrateDivision(

                feet,

                new Quantity<>(
                        2,
                        LengthUnit.FEET)

        );
        Quantity<WeightUnit> kg =

                new Quantity<>(
                        10,
                        WeightUnit.KILOGRAM);



        Quantity<WeightUnit> gram =

                new Quantity<>(
                        5000,
                        WeightUnit.GRAM);



        demonstrateSubtraction(

                kg,
                gram,
                WeightUnit.KILOGRAM);



        demonstrateDivision(

                kg,

                new Quantity<>(
                        5,
                        WeightUnit.KILOGRAM)

        );
        Quantity<VolumeUnit> litre =

                new Quantity<>(
                        5,
                        VolumeUnit.LITRE);



        Quantity<VolumeUnit> ml =

                new Quantity<>(
                        500,
                        VolumeUnit.MILLILITRE);



        demonstrateSubtraction(

                litre,
                ml,
                VolumeUnit.LITRE);



        demonstrateDivision(

                litre,

                new Quantity<>(
                        10,
                        VolumeUnit.LITRE)

        );

    }

}