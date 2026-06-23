import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//UC7: Addition with Target Unit Specification test cases

class QuantityMeasurementAppTest {

    private static final double EPSILON=1e-6;

    @Test
    public void testAddition_ExplicitTargetUnit_Feet(){

        QuantityMeasurementApp.QuantityLength feet= new QuantityMeasurementApp.QuantityLength(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength inches= new QuantityMeasurementApp.QuantityLength(12.0, QuantityMeasurementApp.LengthUnit.INCH);

        QuantityMeasurementApp.QuantityLength result= feet.add(inches, QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(2.0, result.convertTo(QuantityMeasurementApp.LengthUnit.FEET), EPSILON);
    }


    @Test
    public void testAddition_ExplicitTargetUnit_Inches(){

        QuantityMeasurementApp.QuantityLength feet=
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength inches=
                new QuantityMeasurementApp.QuantityLength(
                        12.0,
                        QuantityMeasurementApp.LengthUnit.INCH);

        QuantityMeasurementApp.QuantityLength result=
                feet.add(
                        inches,
                        QuantityMeasurementApp.LengthUnit.INCH);

        assertEquals(
                24.0,
                result.convertTo(
                        QuantityMeasurementApp.LengthUnit.INCH),
                EPSILON);
    }


    @Test
    public void testAddition_ExplicitTargetUnit_Yards(){

        QuantityMeasurementApp.QuantityLength feet=
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength inches=
                new QuantityMeasurementApp.QuantityLength(
                        12.0,
                        QuantityMeasurementApp.LengthUnit.INCH);

        QuantityMeasurementApp.QuantityLength result=
                feet.add(
                        inches,
                        QuantityMeasurementApp.LengthUnit.YARD);

        assertEquals(
                0.666667,
                result.convertTo(
                        QuantityMeasurementApp.LengthUnit.YARD),
                EPSILON);
    }


    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters(){

        QuantityMeasurementApp.QuantityLength inch1=
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.INCH);

        QuantityMeasurementApp.QuantityLength inch2=
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.INCH);

        QuantityMeasurementApp.QuantityLength result=
                inch1.add(
                        inch2,
                        QuantityMeasurementApp.LengthUnit.CENTIMETER);

        assertEquals(
                5.08,
                result.convertTo(
                        QuantityMeasurementApp.LengthUnit.CENTIMETER),
                EPSILON);
    }


    @Test
    public void testAddition_ExplicitTargetUnit_Commutativity(){

        QuantityMeasurementApp.QuantityLength feet=
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength inches=
                new QuantityMeasurementApp.QuantityLength(
                        12.0,
                        QuantityMeasurementApp.LengthUnit.INCH);

        assertEquals(

                feet.add(
                                inches,
                                QuantityMeasurementApp.LengthUnit.YARD)

                        .convertTo(
                                QuantityMeasurementApp.LengthUnit.YARD),

                inches.add(
                                feet,
                                QuantityMeasurementApp.LengthUnit.YARD)

                        .convertTo(
                                QuantityMeasurementApp.LengthUnit.YARD),

                EPSILON);
    }


    @Test
    public void testAddition_ExplicitTargetUnit_WithZero(){

        QuantityMeasurementApp.QuantityLength feet=
                new QuantityMeasurementApp.QuantityLength(
                        5.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength zero=
                new QuantityMeasurementApp.QuantityLength(
                        0.0,
                        QuantityMeasurementApp.LengthUnit.INCH);

        QuantityMeasurementApp.QuantityLength result=
                feet.add(
                        zero,
                        QuantityMeasurementApp.LengthUnit.YARD);

        assertEquals(
                1.666667,
                result.convertTo(
                        QuantityMeasurementApp.LengthUnit.YARD),
                EPSILON);
    }


    @Test
    public void testAddition_ExplicitTargetUnit_NegativeValues(){

        QuantityMeasurementApp.QuantityLength feet=
                new QuantityMeasurementApp.QuantityLength(
                        5.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength negativeFeet=
                new QuantityMeasurementApp.QuantityLength(
                        -2.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength result=
                feet.add(
                        negativeFeet,
                        QuantityMeasurementApp.LengthUnit.INCH);

        assertEquals(
                36.0,
                result.convertTo(
                        QuantityMeasurementApp.LengthUnit.INCH),
                EPSILON);
    }


    @Test
    public void testAddition_ExplicitTargetUnit_NullTargetUnit(){

        QuantityMeasurementApp.QuantityLength feet=
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp.QuantityLength inches=
                new QuantityMeasurementApp.QuantityLength(
                        12.0,
                        QuantityMeasurementApp.LengthUnit.INCH);

        assertThrows(
                IllegalArgumentException.class,

                ()->feet.add(
                        inches,
                        null));
    }

}