import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    public void testEuqlity_SameValue(){
        QuantityMeasurementApp.Feet feet1=new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2=new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet1.equals(feet2), "Expected 1.0 ft equal 1.0 ft");

    }

    @Test
    public void testEquality_DifferentValue(){
        QuantityMeasurementApp.Feet feet1=new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2=new QuantityMeasurementApp.Feet(2.0);

        assertFalse(feet1.equals(feet2),"Expected 1.0 ft not equal 2.0 ft");

    }

    @Test
    public void testEquality_NullComparision(){
        QuantityMeasurementApp.Feet feet1=new QuantityMeasurementApp.Feet(1.0);

        assertFalse(feet1.equals(null),"Expected comparison with null to return false ");

    }

    @Test
    public void testEquality_SameReference(){
        QuantityMeasurementApp.Feet feet1=new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet1.equals(feet1),"Expected object to equal itself (reflexive property)");
    }

    @Test
    public void testEquality_NonNumericInput(){
        QuantityMeasurementApp.Feet feet1=new QuantityMeasurementApp.Feet(1.0);
        String nonNumeric="Not a feet object";

        assertFalse(feet1.equals(nonNumeric),"Expected comparison with non numeric");
    }
}