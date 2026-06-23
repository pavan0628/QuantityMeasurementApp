import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//UC9 : Weight Measurement Equality, Conversion and Addition Test Cases

class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;


    //UC8 Length Test Cases

    @Test
    public void testQuantityLength_Equality() {

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength inches =
                new QuantityMeasurementApp.QuantityLength(
                        12.0,
                        LengthUnit.INCH);

        assertTrue(feet.equals(inches));
    }


    @Test
    public void testQuantityLength_ConvertTo() {

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        assertEquals(12.0,
                feet.convertTo(LengthUnit.INCH),
                EPSILON);
    }


    @Test
    public void testQuantityLength_Add() {

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength inches =
                new QuantityMeasurementApp.QuantityLength(
                        12.0,
                        LengthUnit.INCH);

        QuantityMeasurementApp.QuantityLength result =
                feet.add(inches);

        assertEquals(2.0,
                result.convertTo(LengthUnit.FEET),
                EPSILON);
    }


    //UC9 Equality Test Cases

    @Test
    public void testEquality_KilogramToKilogram_SameValue() {

        QuantityMeasurementApp.QuantityWeight kilogram1 =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight kilogram2 =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        assertTrue(kilogram1.equals(kilogram2));
    }


    @Test
    public void testEquality_KilogramToGram_EquivalentValue() {

        QuantityMeasurementApp.QuantityWeight kilogram =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight gram =
                new QuantityMeasurementApp.QuantityWeight(
                        1000.0,
                        WeightUnit.GRAM);

        assertTrue(kilogram.equals(gram));
    }


    @Test
    public void testEquality_GramToKilogram_EquivalentValue() {

        QuantityMeasurementApp.QuantityWeight gram =
                new QuantityMeasurementApp.QuantityWeight(
                        1000.0,
                        WeightUnit.GRAM);

        QuantityMeasurementApp.QuantityWeight kilogram =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        assertTrue(gram.equals(kilogram));
    }


    @Test
    public void testEquality_PoundToPound_SameValue() {

        QuantityMeasurementApp.QuantityWeight pound1 =
                new QuantityMeasurementApp.QuantityWeight(
                        2.0,
                        WeightUnit.POUND);

        QuantityMeasurementApp.QuantityWeight pound2 =
                new QuantityMeasurementApp.QuantityWeight(
                        2.0,
                        WeightUnit.POUND);

        assertTrue(pound1.equals(pound2));
    }


    @Test
    public void testEquality_WeightVsLength_Incompatible() {

        QuantityMeasurementApp.QuantityWeight kilogram =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        assertFalse(kilogram.equals(feet));
    }


    @Test
    public void testEquality_NullComparison() {

        QuantityMeasurementApp.QuantityWeight kilogram =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        assertFalse(kilogram.equals(null));
    }


    @Test
    public void testEquality_SameReference() {

        QuantityMeasurementApp.QuantityWeight kilogram =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        assertTrue(kilogram.equals(kilogram));
    }


    @Test
    public void testEquality_NullUnit() {

        assertThrows(IllegalArgumentException.class,

                () -> new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        null));
    }


    //UC9 Conversion Test Cases

    @Test
    public void testConversion_KilogramToPound() {

        QuantityMeasurementApp.QuantityWeight kilogram =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        assertEquals(2.204624,
                kilogram.convertTo(WeightUnit.POUND),
                EPSILON);
    }


    @Test
    public void testConversion_PoundToKilogram() {

        QuantityMeasurementApp.QuantityWeight pound =
                new QuantityMeasurementApp.QuantityWeight(
                        2.204624,
                        WeightUnit.POUND);

        assertEquals(1.0,
                pound.convertTo(WeightUnit.KILOGRAM),
                EPSILON);
    }


    @Test
    public void testConversion_RoundTrip() {

        QuantityMeasurementApp.QuantityWeight kilogram =
                new QuantityMeasurementApp.QuantityWeight(
                        1.5,
                        WeightUnit.KILOGRAM);

        double grams =
                kilogram.convertTo(
                        WeightUnit.GRAM);

        QuantityMeasurementApp.QuantityWeight converted =
                new QuantityMeasurementApp.QuantityWeight(
                        grams,
                        WeightUnit.GRAM);

        assertEquals(1.5,
                converted.convertTo(
                        WeightUnit.KILOGRAM),
                EPSILON);
    }


    //UC9 Addition Test Cases

    @Test
    public void testAddition_SameUnit_KilogramPlusKilogram() {

        QuantityMeasurementApp.QuantityWeight kilogram1 =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight kilogram2 =
                new QuantityMeasurementApp.QuantityWeight(
                        2.0,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight result =
                kilogram1.add(kilogram2);

        assertEquals(3.0,
                result.convertTo(
                        WeightUnit.KILOGRAM),
                EPSILON);
    }


    @Test
    public void testAddition_CrossUnit_KilogramPlusGram() {

        QuantityMeasurementApp.QuantityWeight kilogram =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight gram =
                new QuantityMeasurementApp.QuantityWeight(
                        1000.0,
                        WeightUnit.GRAM);

        QuantityMeasurementApp.QuantityWeight result =
                kilogram.add(gram);

        assertEquals(2.0,
                result.convertTo(
                        WeightUnit.KILOGRAM),
                EPSILON);
    }


    @Test
    public void testAddition_CrossUnit_PoundPlusKilogram() {

        QuantityMeasurementApp.QuantityWeight pound =
                new QuantityMeasurementApp.QuantityWeight(
                        2.204624,
                        WeightUnit.POUND);

        QuantityMeasurementApp.QuantityWeight kilogram =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight result =
                pound.add(kilogram);

        assertEquals(4.409248,
                result.convertTo(
                        WeightUnit.POUND),
                EPSILON);
    }


    @Test
    public void testAddition_ExplicitTargetUnit_Kilogram() {

        QuantityMeasurementApp.QuantityWeight kilogram =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight gram =
                new QuantityMeasurementApp.QuantityWeight(
                        1000.0,
                        WeightUnit.GRAM);

        QuantityMeasurementApp.QuantityWeight result =
                kilogram.add(
                        gram,
                        WeightUnit.GRAM);

        assertEquals(2000.0,
                result.convertTo(
                        WeightUnit.GRAM),
                EPSILON);
    }


    @Test
    public void testAddition_Commutativity() {

        QuantityMeasurementApp.QuantityWeight kilogram =
                new QuantityMeasurementApp.QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight gram =
                new QuantityMeasurementApp.QuantityWeight(
                        1000.0,
                        WeightUnit.GRAM);

        assertEquals(
                kilogram.add(gram)
                        .convertTo(WeightUnit.KILOGRAM),

                gram.add(kilogram)
                        .convertTo(WeightUnit.KILOGRAM),

                EPSILON);
    }


    @Test
    public void testAddition_WithZero() {

        QuantityMeasurementApp.QuantityWeight kilogram =
                new QuantityMeasurementApp.QuantityWeight(
                        5.0,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight zeroGram =
                new QuantityMeasurementApp.QuantityWeight(
                        0.0,
                        WeightUnit.GRAM);

        QuantityMeasurementApp.QuantityWeight result =
                kilogram.add(zeroGram);

        assertEquals(5.0,
                result.convertTo(
                        WeightUnit.KILOGRAM),
                EPSILON);
    }


    @Test
    public void testAddition_NegativeValues() {

        QuantityMeasurementApp.QuantityWeight kilogram =
                new QuantityMeasurementApp.QuantityWeight(
                        5.0,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight gram =
                new QuantityMeasurementApp.QuantityWeight(
                        -2000.0,
                        WeightUnit.GRAM);

        QuantityMeasurementApp.QuantityWeight result =
                kilogram.add(gram);

        assertEquals(3.0,
                result.convertTo(
                        WeightUnit.KILOGRAM),
                EPSILON);
    }


    @Test
    public void testAddition_LargeValues() {

        QuantityMeasurementApp.QuantityWeight kilogram1 =
                new QuantityMeasurementApp.QuantityWeight(
                        1e6,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight kilogram2 =
                new QuantityMeasurementApp.QuantityWeight(
                        1e6,
                        WeightUnit.KILOGRAM);

        QuantityMeasurementApp.QuantityWeight result =
                kilogram1.add(kilogram2);

        assertEquals(2e6,
                result.convertTo(
                        WeightUnit.KILOGRAM),
                EPSILON);
    }

}