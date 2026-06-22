import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {


    //feet tests
    @Test
    public void testFeetEuqlity_SameValue(){
        QuantityMeasurementApp.Feet feet1=new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2=new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet1.equals(feet2), "Expected 1.0 ft equal 1.0 ft");

    }

    @Test
    public void testFeetEquality_DifferentValue(){
        QuantityMeasurementApp.Feet feet1=new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2=new QuantityMeasurementApp.Feet(2.0);

        assertFalse(feet1.equals(feet2),"Expected 1.0 ft not equal 2.0 ft");

    }

    @Test
    public void testFeetEquality_NullComparision(){
        QuantityMeasurementApp.Feet feet1=new QuantityMeasurementApp.Feet(1.0);

        assertFalse(feet1.equals(null),"Expected comparison with null to return false ");

    }

    @Test
    public void testFeetEquality_SameReference(){
        QuantityMeasurementApp.Feet feet1=new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet1.equals(feet1),"Expected object to equal itself (reflexive property)");
    }

    @Test
    public void testFeetEquality_NonNumericInput(){
        QuantityMeasurementApp.Feet feet1=new QuantityMeasurementApp.Feet(1.0);
        String nonNumeric="Not a feet object";

        assertFalse(feet1.equals(nonNumeric),"Expected comparison with non numeric");
    }

    //Inches tests

    @Test
    public void testInchesEuqlity_SameValue(){
        QuantityMeasurementApp.Inches inches1=new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches inches2=new QuantityMeasurementApp.Inches(1.0);

        assertTrue(inches1.equals(inches2), "Expected 1.0 inch equal 1.0 inch");

    }

    @Test
    public void testInchesEquality_DifferentValue(){
        QuantityMeasurementApp.Inches inches1=new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches inches2=new QuantityMeasurementApp.Inches(2.0);

        assertFalse(inches1.equals(inches2),"Expected 1.0 inch not equal 2.0 inch");

    }

    @Test
    public void testInchesEquality_NullComparision(){
        QuantityMeasurementApp.Inches inches1=new QuantityMeasurementApp.Inches(1.0);

        assertFalse(inches1.equals(null),"Expected comparison with null to return false ");

    }

    @Test
    public void testInchesEquality_SameReference(){
        QuantityMeasurementApp.Inches inches1=new QuantityMeasurementApp.Inches(1.0);

        assertTrue(inches1.equals(inches1),"Expected object to equal itself (reflexive property)");
    }

    @Test
    public void testInchesEquality_NonNumericInput(){
        QuantityMeasurementApp.Inches inches1=new QuantityMeasurementApp.Inches(1.0);
        String nonNumeric="Not a inch object";

        assertFalse(inches1.equals(nonNumeric),"Expected comparison with non numeric");
    }
}