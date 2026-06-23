import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//UC8 : Refactoring Unit Enum to Standalone Test Cases

class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;


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


    @Test
    public void testQuantityLength_AddWithTargetUnit() {

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength inches =
                new QuantityMeasurementApp.QuantityLength(
                        12.0,
                        LengthUnit.INCH);

        QuantityMeasurementApp.QuantityLength result =
                feet.add(inches,
                        LengthUnit.YARD);

        assertEquals(0.666667,
                result.convertTo(LengthUnit.YARD),
                EPSILON);
    }


    @Test
    public void testQuantityLength_NullUnit() {

        assertThrows(IllegalArgumentException.class,

                () -> new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        null));
    }


    @Test
    public void testQuantityLength_InvalidValue() {

        assertThrows(IllegalArgumentException.class,

                () -> new QuantityMeasurementApp.QuantityLength(
                        Double.NaN,
                        LengthUnit.FEET));
    }

}