//QuantityMeasurementApp.java
//UC11: Volume Measurement Equality, Conversion, and Addition (Litre, Millilitre, Gallon)

public class QuantityMeasurementApp {

    public static <U extends IMeasurable>
    void demonstrateEquality(Quantity<U> q1,
                             Quantity<U> q2) {

        System.out.println(q1 + " equals "
                + q2 + " = "
                + q1.equals(q2));
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



    public static void main(String[] args) {


        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(
                        12.0,
                        LengthUnit.INCH);



        demonstrateEquality(
                feet,
                inches);


        demonstrateConversion(
                feet,
                LengthUnit.INCH);



        demonstrateAddition(
                feet,
                inches,
                LengthUnit.FEET);




        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM);


        Quantity<WeightUnit> gram =
                new Quantity<>(
                        1000.0,
                        WeightUnit.GRAM);



        demonstrateEquality(
                kilogram,
                gram);


        demonstrateConversion(
                kilogram,
                WeightUnit.GRAM);



        demonstrateAddition(
                kilogram,
                gram,
                WeightUnit.KILOGRAM);

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE);

        System.out.println(
                litre.equals(ml));

        System.out.println(
                litre.convertTo(
                        VolumeUnit.MILLILITRE));

        System.out.println(
                litre.add(
                        ml,
                        VolumeUnit.LITRE));

    }

}