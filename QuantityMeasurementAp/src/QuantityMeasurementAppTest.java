import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


//UC12: Subtraction and Division Operations on Quantity Measurements Test Cases
//Tests subtraction, division, precision, immutability,
//cross-category prevention and error handling scenarios

class QuantityMeasurementAppTest {


    private static final double EPSILON =
            1e-6;

    @Test
    public void testSubtraction_SameUnit_FeetMinusFeet() {


        Quantity<LengthUnit> feet1 =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> feet2 =
                new Quantity<>(
                        5.0,
                        LengthUnit.FEET);



        Quantity<LengthUnit> result =
                feet1.subtract(feet2);



        assertEquals(
                5.0,
                result.getValue(),
                EPSILON);

    }



    @Test
    public void testSubtraction_SameUnit_LitreMinusLitre() {


        Quantity<VolumeUnit> litre1 =
                new Quantity<>(
                        10.0,
                        VolumeUnit.LITRE);


        Quantity<VolumeUnit> litre2 =
                new Quantity<>(
                        3.0,
                        VolumeUnit.LITRE);



        Quantity<VolumeUnit> result =
                litre1.subtract(litre2);



        assertEquals(
                7.0,
                result.getValue(),
                EPSILON);

    }




    @Test
    public void testSubtraction_CrossUnit_FeetMinusInches() {


        Quantity<LengthUnit> feet =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> inches =
                new Quantity<>(
                        6.0,
                        LengthUnit.INCH);



        Quantity<LengthUnit> result =
                feet.subtract(inches);



        assertEquals(
                9.5,
                result.getValue(),
                EPSILON);

    }




    @Test
    public void testSubtraction_CrossUnit_InchesMinusFeet() {


        Quantity<LengthUnit> inches =
                new Quantity<>(
                        120.0,
                        LengthUnit.INCH);


        Quantity<LengthUnit> feet =
                new Quantity<>(
                        5.0,
                        LengthUnit.FEET);



        Quantity<LengthUnit> result =
                inches.subtract(feet);



        assertEquals(
                60.0,
                result.getValue(),
                EPSILON);

    }




    @Test
    public void testSubtraction_ExplicitTargetUnit_Feet() {


        Quantity<LengthUnit> feet =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> inches =
                new Quantity<>(
                        6.0,
                        LengthUnit.INCH);



        Quantity<LengthUnit> result =
                feet.subtract(
                        inches,
                        LengthUnit.FEET);



        assertEquals(
                9.5,
                result.getValue(),
                EPSILON);

    }




    @Test
    public void testSubtraction_ExplicitTargetUnit_Inches() {


        Quantity<LengthUnit> feet =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> inches =
                new Quantity<>(
                        6.0,
                        LengthUnit.INCH);



        Quantity<LengthUnit> result =
                feet.subtract(
                        inches,
                        LengthUnit.INCH);



        assertEquals(
                114.0,
                result.getValue(),
                EPSILON);

    }




    @Test
    public void testSubtraction_ExplicitTargetUnit_Millilitre() {


        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        5.0,
                        VolumeUnit.LITRE);


        Quantity<VolumeUnit> litre2 =
                new Quantity<>(
                        2.0,
                        VolumeUnit.LITRE);



        Quantity<VolumeUnit> result =
                litre.subtract(
                        litre2,
                        VolumeUnit.MILLILITRE);



        assertEquals(
                3000.0,
                result.getValue(),
                EPSILON);

    }




    @Test
    public void testSubtraction_ResultingInNegative() {


        Quantity<LengthUnit> feet1 =
                new Quantity<>(
                        5.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> feet2 =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);



        Quantity<LengthUnit> result =
                feet1.subtract(feet2);



        assertEquals(
                -5.0,
                result.getValue(),
                EPSILON);

    }




    @Test
    public void testSubtraction_ResultingInZero() {


        Quantity<LengthUnit> feet =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> inches =
                new Quantity<>(
                        120.0,
                        LengthUnit.INCH);



        Quantity<LengthUnit> result =
                feet.subtract(inches);



        assertEquals(
                0.0,
                result.getValue(),
                EPSILON);

    }




    @Test
    public void testSubtraction_WithZeroOperand() {


        Quantity<LengthUnit> feet =
                new Quantity<>(
                        5.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> zero =
                new Quantity<>(
                        0.0,
                        LengthUnit.INCH);



        Quantity<LengthUnit> result =
                feet.subtract(zero);



        assertEquals(
                5.0,
                result.getValue(),
                EPSILON);

    }




    @Test
    public void testSubtraction_WithNegativeValues() {


        Quantity<LengthUnit> feet =
                new Quantity<>(
                        5.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> negative =
                new Quantity<>(
                        -2.0,
                        LengthUnit.FEET);



        Quantity<LengthUnit> result =
                feet.subtract(negative);



        assertEquals(
                7.0,
                result.getValue(),
                EPSILON);

    }




    @Test
    public void testSubtraction_NonCommutative() {


        Quantity<LengthUnit> first =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> second =
                new Quantity<>(
                        5.0,
                        LengthUnit.FEET);



        Quantity<LengthUnit> result1 =
                first.subtract(second);


        Quantity<LengthUnit> result2 =
                second.subtract(first);



        assertNotEquals(
                result1.getValue(),
                result2.getValue(),
                EPSILON);

    }




    @Test
    public void testSubtraction_NullOperand() {


        Quantity<LengthUnit> feet =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);



        assertThrows(
                IllegalArgumentException.class,

                () -> feet.subtract(null));

    }




    @Test
    public void testSubtraction_NullTargetUnit() {


        Quantity<LengthUnit> feet1 =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> feet2 =
                new Quantity<>(
                        5.0,
                        LengthUnit.FEET);



        assertThrows(
                IllegalArgumentException.class,

                () -> feet1.subtract(
                        feet2,
                        null));

    }

    @Test
    public void testDivision_SameUnit_FeetDividedByFeet() {


        Quantity<LengthUnit> feet1 =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> feet2 =
                new Quantity<>(
                        2.0,
                        LengthUnit.FEET);



        double result =
                feet1.divide(feet2);



        assertEquals(
                5.0,
                result,
                EPSILON);

    }




    @Test
    public void testDivision_SameUnit_LitreDividedByLitre() {


        Quantity<VolumeUnit> litre1 =
                new Quantity<>(
                        10.0,
                        VolumeUnit.LITRE);


        Quantity<VolumeUnit> litre2 =
                new Quantity<>(
                        5.0,
                        VolumeUnit.LITRE);



        double result =
                litre1.divide(litre2);



        assertEquals(
                2.0,
                result,
                EPSILON);

    }




    @Test
    public void testDivision_CrossUnit_FeetDividedByInches() {


        Quantity<LengthUnit> inches =
                new Quantity<>(
                        24.0,
                        LengthUnit.INCH);


        Quantity<LengthUnit> feet =
                new Quantity<>(
                        2.0,
                        LengthUnit.FEET);



        double result =
                inches.divide(feet);



        assertEquals(
                1.0,
                result,
                EPSILON);

    }




    @Test
    public void testDivision_CrossUnit_KilogramDividedByGram() {


        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        2.0,
                        WeightUnit.KILOGRAM);


        Quantity<WeightUnit> gram =
                new Quantity<>(
                        2000.0,
                        WeightUnit.GRAM);



        double result =
                kilogram.divide(gram);



        assertEquals(
                1.0,
                result,
                EPSILON);

    }




    @Test
    public void testDivision_RatioGreaterThanOne() {


        Quantity<LengthUnit> feet1 =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> feet2 =
                new Quantity<>(
                        2.0,
                        LengthUnit.FEET);



        double result =
                feet1.divide(feet2);



        assertEquals(
                5.0,
                result,
                EPSILON);

    }




    @Test
    public void testDivision_RatioLessThanOne() {


        Quantity<LengthUnit> feet1 =
                new Quantity<>(
                        5.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> feet2 =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);



        double result =
                feet1.divide(feet2);



        assertEquals(
                0.5,
                result,
                EPSILON);

    }




    @Test
    public void testDivision_RatioEqualToOne() {


        Quantity<LengthUnit> feet =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> inches =
                new Quantity<>(
                        120.0,
                        LengthUnit.INCH);



        double result =
                feet.divide(inches);



        assertEquals(
                1.0,
                result,
                EPSILON);

    }




    @Test
    public void testDivision_NonCommutative() {


        Quantity<LengthUnit> first =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> second =
                new Quantity<>(
                        5.0,
                        LengthUnit.FEET);



        double result1 =
                first.divide(second);


        double result2 =
                second.divide(first);



        assertNotEquals(
                result1,
                result2,
                EPSILON);

    }




    @Test
    public void testDivision_ByZero() {


        Quantity<LengthUnit> feet =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> zero =
                new Quantity<>(
                        0.0,
                        LengthUnit.FEET);



        assertThrows(
                ArithmeticException.class,

                () -> feet.divide(zero));

    }




    @Test
    public void testDivision_WithLargeRatio() {


        Quantity<WeightUnit> large =
                new Quantity<>(
                        1000000.0,
                        WeightUnit.KILOGRAM);


        Quantity<WeightUnit> small =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM);



        double result =
                large.divide(small);



        assertEquals(
                1000000.0,
                result,
                EPSILON);

    }




    @Test
    public void testDivision_WithSmallRatio() {


        Quantity<WeightUnit> small =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM);


        Quantity<WeightUnit> large =
                new Quantity<>(
                        1000000.0,
                        WeightUnit.KILOGRAM);



        double result =
                small.divide(large);



        assertEquals(
                0.000001,
                result,
                EPSILON);

    }




    @Test
    public void testDivision_NullOperand() {


        Quantity<LengthUnit> feet =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);



        assertThrows(
                IllegalArgumentException.class,

                () -> feet.divide(null));

    }




    @Test
    public void testDivision_AllMeasurementCategories() {


        Quantity<LengthUnit> length =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);


        Quantity<WeightUnit> weight =
                new Quantity<>(
                        10.0,
                        WeightUnit.KILOGRAM);


        Quantity<VolumeUnit> volume =
                new Quantity<>(
                        10.0,
                        VolumeUnit.LITRE);



        assertEquals(
                2.0,
                length.divide(
                        new Quantity<>(
                                5.0,
                                LengthUnit.FEET)),
                EPSILON);



        assertEquals(
                2.0,
                weight.divide(
                        new Quantity<>(
                                5.0,
                                WeightUnit.KILOGRAM)),
                EPSILON);



        assertEquals(
                2.0,
                volume.divide(
                        new Quantity<>(
                                5.0,
                                VolumeUnit.LITRE)),
                EPSILON);

    }




    @Test
    public void testDivision_PrecisionHandling() {


        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE);


        Quantity<VolumeUnit> ml =
                new Quantity<>(
                        1000.0,
                        VolumeUnit.MILLILITRE);



        double result =
                litre.divide(ml);



        assertEquals(
                1.0,
                result,
                EPSILON);

    }
    @Test
    public void testSubtraction_WithLargeValues() {


        Quantity<WeightUnit> large =
                new Quantity<>(
                        1000000.0,
                        WeightUnit.KILOGRAM);


        Quantity<WeightUnit> small =
                new Quantity<>(
                        500000.0,
                        WeightUnit.KILOGRAM);



        Quantity<WeightUnit> result =
                large.subtract(small);



        assertEquals(
                500000.0,
                result.getValue(),
                EPSILON);

    }



    @Test
    public void testSubtraction_WithSmallValues() {


        Quantity<LengthUnit> first =
                new Quantity<>(
                        0.001,
                        LengthUnit.FEET);


        Quantity<LengthUnit> second =
                new Quantity<>(
                        0.0005,
                        LengthUnit.FEET);



        Quantity<LengthUnit> result =
                first.subtract(second);



        assertEquals(
                0.0,
                result.getValue(),
                EPSILON);

    }



    @Test
    public void testSubtraction_AllMeasurementCategories() {


        Quantity<LengthUnit> length =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);


        Quantity<WeightUnit> weight =
                new Quantity<>(
                        10.0,
                        WeightUnit.KILOGRAM);


        Quantity<VolumeUnit> volume =
                new Quantity<>(
                        5.0,
                        VolumeUnit.LITRE);



        assertEquals(
                5.0,
                length.subtract(
                                new Quantity<>(
                                        5.0,
                                        LengthUnit.FEET))
                        .getValue(),
                EPSILON);



        assertEquals(
                5.0,
                weight.subtract(
                                new Quantity<>(
                                        5.0,
                                        WeightUnit.KILOGRAM))
                        .getValue(),
                EPSILON);



        assertEquals(
                3.0,
                volume.subtract(
                                new Quantity<>(
                                        2.0,
                                        VolumeUnit.LITRE))
                        .getValue(),
                EPSILON);

    }



    @Test
    public void testSubtraction_ChainedOperations() {


        Quantity<LengthUnit> result =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET)

                        .subtract(
                                new Quantity<>(
                                        2.0,
                                        LengthUnit.FEET))

                        .subtract(
                                new Quantity<>(
                                        1.0,
                                        LengthUnit.FEET));



        assertEquals(
                7.0,
                result.getValue(),
                EPSILON);

    }



    @Test
    public void testSubtraction_Immutability() {


        Quantity<LengthUnit> original =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> other =
                new Quantity<>(
                        5.0,
                        LengthUnit.FEET);



        Quantity<LengthUnit> result =
                original.subtract(other);



        assertNotSame(
                original,
                result);



        assertEquals(
                10.0,
                original.getValue(),
                EPSILON);

    }



    @Test
    public void testSubtraction_PrecisionAndRounding() {


        Quantity<LengthUnit> first =
                new Quantity<>(
                        1.33,
                        LengthUnit.FEET);


        Quantity<LengthUnit> second =
                new Quantity<>(
                        0.11,
                        LengthUnit.FEET);



        Quantity<LengthUnit> result =
                first.subtract(second);



        assertEquals(
                1.22,
                result.getValue(),
                EPSILON);

    }



    @Test
    public void testDivision_Associativity() {


        Quantity<LengthUnit> a =
                new Quantity<>(
                        12.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> b =
                new Quantity<>(
                        3.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> c =
                new Quantity<>(
                        2.0,
                        LengthUnit.FEET);



        double result1 =
                a.divide(b) / c.getValue();



        double result2 =
                a.getValue() /
                        (b.divide(c));



        assertNotEquals(
                result1,
                result2,
                EPSILON);

    }



    @Test
    public void testSubtractionAndDivision_Integration() {


        Quantity<LengthUnit> result =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET)

                        .subtract(
                                new Quantity<>(
                                        2.0,
                                        LengthUnit.FEET));



        double ratio =
                result.divide(
                        new Quantity<>(
                                4.0,
                                LengthUnit.FEET));



        assertEquals(
                2.0,
                ratio,
                EPSILON);

    }



    @Test
    public void testSubtractionAddition_Inverse() {


        Quantity<LengthUnit> original =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> added =
                original.add(
                        new Quantity<>(
                                5.0,
                                LengthUnit.FEET));



        Quantity<LengthUnit> result =
                added.subtract(
                        new Quantity<>(
                                5.0,
                                LengthUnit.FEET));



        assertEquals(
                original.getValue(),
                result.getValue(),
                EPSILON);

    }



    @Test
    public void testDivision_Immutability() {


        Quantity<LengthUnit> original =
                new Quantity<>(
                        10.0,
                        LengthUnit.FEET);


        Quantity<LengthUnit> other =
                new Quantity<>(
                        5.0,
                        LengthUnit.FEET);



        original.divide(other);



        assertEquals(
                10.0,
                original.getValue(),
                EPSILON);

    }





}