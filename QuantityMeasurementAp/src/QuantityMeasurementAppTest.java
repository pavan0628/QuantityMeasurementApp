import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


//UC10 : Generic Quantity Test Cases

class QuantityMeasurementAppTest {


    private static final double EPSILON =
            1e-6;



    @Test
    public void testGenericQuantity_LengthOperations_Equality() {


        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> inches =
                new Quantity<>(
                        12.0,
                        LengthUnit.INCH);


        assertTrue(
                feet.equals(inches));

    }



    @Test
    public void testGenericQuantity_WeightOperations_Equality() {


        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM);


        Quantity<WeightUnit> gram =
                new Quantity<>(
                        1000.0,
                        WeightUnit.GRAM);



        assertTrue(
                kilogram.equals(gram));

    }



    @Test
    public void testGenericQuantity_LengthOperations_Conversion() {


        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET);



        Quantity<LengthUnit> result =
                feet.convertTo(
                        LengthUnit.INCH);



        assertEquals(
                12.0,
                result.getValue(),
                EPSILON);

    }



    @Test
    public void testGenericQuantity_WeightOperations_Conversion() {


        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM);



        Quantity<WeightUnit> result =
                kilogram.convertTo(
                        WeightUnit.GRAM);



        assertEquals(
                1000.0,
                result.getValue(),
                EPSILON);

    }




    @Test
    public void testGenericQuantity_LengthOperations_Addition() {


        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> inches =
                new Quantity<>(
                        12.0,
                        LengthUnit.INCH);



        Quantity<LengthUnit> result =
                feet.add(
                        inches,
                        LengthUnit.FEET);



        assertEquals(
                2.0,
                result.getValue(),
                EPSILON);

    }




    @Test
    public void testGenericQuantity_WeightOperations_Addition() {


        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM);


        Quantity<WeightUnit> gram =
                new Quantity<>(
                        1000.0,
                        WeightUnit.GRAM);



        Quantity<WeightUnit> result =
                kilogram.add(
                        gram,
                        WeightUnit.KILOGRAM);



        assertEquals(
                2.0,
                result.getValue(),
                EPSILON);

    }




    @Test
    public void testCrossCategoryPrevention_LengthVsWeight() {


        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET);


        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM);



        assertFalse(
                feet.equals(kilogram));

    }




    @Test
    public void testGenericQuantity_ConstructorValidation_NullUnit() {


        assertThrows(
                IllegalArgumentException.class,

                () -> new Quantity<>(
                        1.0,
                        null));

    }




    @Test
    public void testGenericQuantity_ConstructorValidation_InvalidValue() {


        assertThrows(
                IllegalArgumentException.class,

                () -> new Quantity<>(
                        Double.NaN,
                        LengthUnit.FEET));

    }




    @Test
    public void testImmutability_GenericQuantity() {


        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> inches =
                new Quantity<>(
                        12.0,
                        LengthUnit.INCH);



        Quantity<LengthUnit> result =
                feet.add(inches);



        assertNotSame(
                feet,
                result);

    }


}