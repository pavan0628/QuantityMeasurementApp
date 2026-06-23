import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


//UC11: Volume Measurement Equality, Conversion, and Addition (Litre, Millilitre, Gallon) Test Cases

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
    @Test
    public void testEquality_LitreToLitre_SameValue() {

        Quantity<VolumeUnit> v1 =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        assertTrue(v1.equals(v2));
    }


    @Test
    public void testEquality_LitreToMillilitre_EquivalentValue() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE);

        assertTrue(litre.equals(ml));
    }


    @Test
    public void testEquality_GallonToLitre_EquivalentValue() {

        Quantity<VolumeUnit> gallon =
                new Quantity<>(1.0,
                        VolumeUnit.GALLON);

        Quantity<VolumeUnit> litre =
                new Quantity<>(3.78541,
                        VolumeUnit.LITRE);

        assertTrue(gallon.equals(litre));
    }


    @Test
    public void testConversion_LitreToMillilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                litre.convertTo(
                        VolumeUnit.MILLILITRE);

        assertEquals(1000.0,
                result.getValue(),
                EPSILON);
    }


    @Test
    public void testConversion_GallonToLitre() {

        Quantity<VolumeUnit> gallon =
                new Quantity<>(1.0,
                        VolumeUnit.GALLON);

        Quantity<VolumeUnit> result =
                gallon.convertTo(
                        VolumeUnit.LITRE);

        assertEquals(3.78541,
                result.getValue(),
                EPSILON);
    }


    @Test
    public void testAddition_LitrePlusMillilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                litre.add(ml);

        assertEquals(2.0,
                result.getValue(),
                EPSILON);
    }


    @Test
    public void testAddition_ExplicitTargetUnit_Millilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                litre.add(
                        ml,
                        VolumeUnit.MILLILITRE);

        assertEquals(2000.0,
                result.getValue(),
                EPSILON);
    }


    @Test
    public void testEquality_VolumeVsLength_Incompatible() {

        Quantity<VolumeUnit> volume =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        Quantity<LengthUnit> length =
                new Quantity<>(1.0,
                        LengthUnit.FEET);

        assertFalse(volume.equals(length));
    }


    @Test
    public void testVolumeUnitEnum_LitreConstant() {

        assertEquals(1.0,
                VolumeUnit.LITRE.getConversionFactor(),
                EPSILON);
    }


    @Test
    public void testVolumeUnitEnum_GallonConstant() {

        assertEquals(3.78541,
                VolumeUnit.GALLON.getConversionFactor(),
                EPSILON);
    }

}