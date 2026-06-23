import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//UC5: Unit-to-Unit conversion test cases

class QuantityMeasurementAppTest {

    private static final double EPSILON=1e-6;

    @Test
    public void testConversion_FeetToInches(){
        double result =QuantityMeasurementApp.convert(1.0,QuantityMeasurementApp.LengthUnit.FEET,QuantityMeasurementApp.LengthUnit.INCH);
        assertEquals(12.0,result,EPSILON);
    }

    @Test
    public void testConversion_InchesToFeet() {
        double result = QuantityMeasurementApp.convert(24.0, QuantityMeasurementApp.LengthUnit.INCH, QuantityMeasurementApp.LengthUnit.FEET);
        assertEquals(2.0, result, EPSILON);
    }

    @Test
    public void testConversion_YardsToInches() {
        double result = QuantityMeasurementApp.convert(1.0, QuantityMeasurementApp.LengthUnit.YARD, QuantityMeasurementApp.LengthUnit.INCH);
        assertEquals(36.0, result, EPSILON);
    }

    @Test
    public void testConversion_InchesToYards() {
        double result = QuantityMeasurementApp.convert(72.0, QuantityMeasurementApp.LengthUnit.INCH, QuantityMeasurementApp.LengthUnit.YARD);
        assertEquals(2.0, result, EPSILON);
    }

    @Test
    public void testConversion_CentimetersToInches() {
        double result = QuantityMeasurementApp.convert(2.54, QuantityMeasurementApp.LengthUnit.CENTIMETER, QuantityMeasurementApp.LengthUnit.INCH);
        assertEquals(1.0, result, EPSILON);
    }

    @Test
    public void testConversion_FeetToYard() {
        double result = QuantityMeasurementApp.convert(6.0, QuantityMeasurementApp.LengthUnit.FEET, QuantityMeasurementApp.LengthUnit.YARD);
        assertEquals(2.0, result, EPSILON);
    }

    @Test
    public void testConversion_RoundTrip_PreservesValue() {
        double value = 5.0;
        double converted = QuantityMeasurementApp.convert(value, QuantityMeasurementApp.LengthUnit.FEET, QuantityMeasurementApp.LengthUnit.INCH);
        double roundTrip = QuantityMeasurementApp.convert(converted, QuantityMeasurementApp.LengthUnit.INCH, QuantityMeasurementApp.LengthUnit.FEET);
        assertEquals(value, roundTrip, EPSILON);
    }

    @Test
    public void testConversion_ZeroValue() {
        double result = QuantityMeasurementApp.convert(0.0, QuantityMeasurementApp.LengthUnit.FEET, QuantityMeasurementApp.LengthUnit.INCH);
        assertEquals(0.0, result, EPSILON);
    }

    @Test
    public void testConversion_NegativeValue() {
        double result = QuantityMeasurementApp.convert(-1.0, QuantityMeasurementApp.LengthUnit.FEET, QuantityMeasurementApp.LengthUnit.INCH);
        assertEquals(-12.0, result, EPSILON);
    }

    @Test
    public void testConversion_InvalidUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.convert(1.0, null, QuantityMeasurementApp.LengthUnit.INCH);
        });
    }

    @Test
    public void testConversion_NaNOrInfinite_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityMeasurementApp.QuantityLength(Double.NaN, QuantityMeasurementApp.LengthUnit.FEET);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityMeasurementApp.QuantityLength(Double.POSITIVE_INFINITY, QuantityMeasurementApp.LengthUnit.FEET);
        });
    }

}