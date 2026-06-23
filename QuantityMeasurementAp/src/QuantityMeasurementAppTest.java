import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//UC6: Addition of two length units test cases

class QuantityMeasurementAppTest {

    private static final double EPSILON=1e-6;

    @Test
    public void testAddition_SameUnit_FeetPlusFeet(){
        QuantityMeasurementApp.QuantityLength q1=new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2=new QuantityMeasurementApp.QuantityLength(2.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength result=q1.add(q2);
        assertEquals(3.0, result.convertTo(QuantityMeasurementApp.LengthUnit.FEET), EPSILON);
    }

    @Test
    public void testAddition_SameUnit_InchPlusInch() {
        QuantityMeasurementApp.QuantityLength q1 = new QuantityMeasurementApp.QuantityLength(6.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength q2 = new QuantityMeasurementApp.QuantityLength(6.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength result = q1.add(q2);
        assertEquals(12.0, result.convertTo(QuantityMeasurementApp.LengthUnit.INCH), EPSILON);
    }

    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength inches = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength result = feet.add(inches);
        assertEquals(2.0, result.convertTo(QuantityMeasurementApp.LengthUnit.FEET), EPSILON);
    }

    @Test
    public void testAddition_CrossUnit_InchPlusFeet() {
        QuantityMeasurementApp.QuantityLength inches = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength result = inches.add(feet);
        assertEquals(24.0, result.convertTo(QuantityMeasurementApp.LengthUnit.INCH), EPSILON);
    }

    @Test
    public void testAddition_CrossUnit_YardPlusFeet() {
        QuantityMeasurementApp.QuantityLength yard = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(3.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength result = yard.add(feet);
        assertEquals(2.0, result.convertTo(QuantityMeasurementApp.LengthUnit.YARD), EPSILON);
    }

    @Test
    public void testAddition_CrossUnit_CentimeterPlusInch() {
        QuantityMeasurementApp.QuantityLength cm = new QuantityMeasurementApp.QuantityLength(2.54, QuantityMeasurementApp.LengthUnit.CENTIMETER);
        QuantityMeasurementApp.QuantityLength inch = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength result = cm.add(inch);
        assertEquals(5.08, result.convertTo(QuantityMeasurementApp.LengthUnit.CENTIMETER), EPSILON);
    }

    @Test
    public void testAddition_Commutativity() {
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength inches = new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH);
        assertEquals(feet.add(inches).convertTo(QuantityMeasurementApp.LengthUnit.FEET),
                inches.add(feet).convertTo(QuantityMeasurementApp.LengthUnit.FEET), EPSILON);
    }

    @Test
    public void testAddition_WithZero() {
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(5.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength zeroInches = new QuantityMeasurementApp.QuantityLength(0.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength result = feet.add(zeroInches);
        assertEquals(5.0, result.convertTo(QuantityMeasurementApp.LengthUnit.FEET), EPSILON);
    }

    @Test
    public void testAddition_NegativeValues() {
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(5.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength negativeFeet = new QuantityMeasurementApp.QuantityLength(-2.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength result = feet.add(negativeFeet);
        assertEquals(3.0, result.convertTo(QuantityMeasurementApp.LengthUnit.FEET), EPSILON);
    }

    @Test
    public void testAddition_NullSecondOperand() {
        QuantityMeasurementApp.QuantityLength feet = new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> feet.add(null));
    }

}