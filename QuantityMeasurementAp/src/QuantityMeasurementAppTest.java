import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    public void testEquality_YardToYard_SameValue() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        assertTrue(q1.equals(q2), "Expected 1 yard to equal 1 yard");
    }

    @Test
    public void testEquality_YardToYard_DifferentValue() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.YARD);
        assertFalse(q1.equals(q2), "Expected 1 yard not to equal 2 yards");
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        QuantityMeasurementApp.QuantityLength yard = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertTrue(yard.equals(feet), "Expected 1 yard to equal 3 feet");
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        QuantityMeasurementApp.QuantityLength yard = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength inches = new QuantityMeasurementApp.QuantityLength(36.0, QuantityMeasurementApp.LengthUnit.INCH);
        assertTrue(yard.equals(inches), "Expected 1 yard to equal 36 inches");
    }

    @Test
    public void testEquality_CentimetersToInches_EquivalentValue() {
        QuantityMeasurementApp.QuantityLength cm = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.CENTIMETER);
        QuantityMeasurementApp.QuantityLength inch = new QuantityMeasurementApp.QuantityLength(0.393701, QuantityMeasurementApp.LengthUnit.INCH);
        assertTrue(cm.equals(inch), "Expected 1 cm to equal 0.393701 inches");
    }

    @Test
    public void testEquality_CentimetersToFeet_NonEquivalentValue() {
        QuantityMeasurementApp.QuantityLength cm = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.CENTIMETER);
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertFalse(cm.equals(feet), "Expected 1 cm not to equal 1 foot");
    }

    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {
        QuantityMeasurementApp.QuantityLength yard = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength inches = new QuantityMeasurementApp.QuantityLength(36.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(yard.equals(feet) && feet.equals(inches) && yard.equals(inches),
                "Expected transitive property: 1 yard = 3 feet = 36 inches");
    }

    @Test
    public void testEquality_InvalidUnit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new QuantityMeasurementApp.QuantityLength(1.0, null);
        });
        assertEquals("Unit type cannot be null", exception.getMessage());
    }

    @Test
    public void testEquality_YardSameReference() {
        QuantityMeasurementApp.QuantityLength yard = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        assertTrue(yard.equals(yard), "Expected yard object to equal itself");
    }

    @Test
    public void testEquality_YardNullComparison() {
        QuantityMeasurementApp.QuantityLength yard = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        assertFalse(yard.equals(null), "Expected yard object not to equal null");
    }
}