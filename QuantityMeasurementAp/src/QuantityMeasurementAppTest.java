import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


// UC14 : Temperature Measurement Test Cases

class QuantityMeasurementAppTest {


    private static final double EPSILON =
            1e-6;




    @Test
    public void testTemperatureEquality_CelsiusToCelsius_SameValue() {

        Quantity<TemperatureUnit> first =
                new Quantity<>(
                        0.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> second =
                new Quantity<>(
                        0.0,
                        TemperatureUnit.CELSIUS);

        assertEquals(first, second);

    }



    @Test
    public void testTemperatureEquality_CelsiusToFahrenheit() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        0.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(
                        32.0,
                        TemperatureUnit.FAHRENHEIT);

        assertEquals(celsius, fahrenheit);

    }



    @Test
    public void testTemperatureEquality_NegativeForty() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        -40.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(
                        -40.0,
                        TemperatureUnit.FAHRENHEIT);

        assertEquals(celsius, fahrenheit);

    }



    @Test
    public void testTemperatureEquality_CelsiusToKelvin() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        0.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> kelvin =
                new Quantity<>(
                        273.15,
                        TemperatureUnit.KELVIN);

        assertEquals(celsius, kelvin);

    }



    @Test
    public void testTemperatureConversion_CelsiusToFahrenheit() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        100.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> result =
                celsius.convertTo(
                        TemperatureUnit.FAHRENHEIT);

        assertEquals(
                212.0,
                result.getValue(),
                EPSILON);

    }



    @Test
    public void testTemperatureConversion_FahrenheitToCelsius() {

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(
                        32.0,
                        TemperatureUnit.FAHRENHEIT);

        Quantity<TemperatureUnit> result =
                fahrenheit.convertTo(
                        TemperatureUnit.CELSIUS);

        assertEquals(
                0.0,
                result.getValue(),
                EPSILON);

    }



    @Test
    public void testTemperatureConversion_CelsiusToKelvin() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        0.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> result =
                celsius.convertTo(
                        TemperatureUnit.KELVIN);

        assertEquals(
                273.15,
                result.getValue(),
                EPSILON);

    }



    @Test
    public void testTemperatureConversion_KelvinToCelsius() {

        Quantity<TemperatureUnit> kelvin =
                new Quantity<>(
                        273.15,
                        TemperatureUnit.KELVIN);

        Quantity<TemperatureUnit> result =
                kelvin.convertTo(
                        TemperatureUnit.CELSIUS);

        assertEquals(
                0.0,
                result.getValue(),
                EPSILON);

    }



    @Test
    public void testTemperatureConversion_RoundTrip() {

        Quantity<TemperatureUnit> original =
                new Quantity<>(
                        50.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> converted =
                original.convertTo(
                        TemperatureUnit.FAHRENHEIT);

        Quantity<TemperatureUnit> result =
                converted.convertTo(
                        TemperatureUnit.CELSIUS);

        assertEquals(
                original.getValue(),
                result.getValue(),
                EPSILON);

    }



    @Test
    public void testTemperatureUnsupportedOperation_Add() {

        Quantity<TemperatureUnit> first =
                new Quantity<>(
                        100.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> second =
                new Quantity<>(
                        50.0,
                        TemperatureUnit.CELSIUS);

        assertThrows(
                UnsupportedOperationException.class,

                () -> first.add(second));

    }



    @Test
    public void testTemperatureUnsupportedOperation_Subtract() {

        Quantity<TemperatureUnit> first =
                new Quantity<>(
                        100.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> second =
                new Quantity<>(
                        50.0,
                        TemperatureUnit.CELSIUS);

        assertThrows(
                UnsupportedOperationException.class,

                () -> first.subtract(second));

    }



    @Test
    public void testTemperatureUnsupportedOperation_Divide() {

        Quantity<TemperatureUnit> first =
                new Quantity<>(
                        100.0,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> second =
                new Quantity<>(
                        50.0,
                        TemperatureUnit.CELSIUS);

        assertThrows(
                UnsupportedOperationException.class,

                () -> first.divide(second));

    }



    @Test
    public void testTemperatureVsLengthIncompatibility() {

        Quantity<TemperatureUnit> temperature =
                new Quantity<>(
                        100.0,
                        TemperatureUnit.CELSIUS);

        Quantity<LengthUnit> length =
                new Quantity<>(
                        100.0,
                        LengthUnit.FEET);

        assertNotEquals(
                temperature,
                length);

    }



    @Test
    public void testTemperatureVsWeightIncompatibility() {

        Quantity<TemperatureUnit> temperature =
                new Quantity<>(
                        50.0,
                        TemperatureUnit.CELSIUS);

        Quantity<WeightUnit> weight =
                new Quantity<>(
                        50.0,
                        WeightUnit.KILOGRAM);

        assertNotEquals(
                temperature,
                weight);

    }



    @Test
    public void testTemperatureSupportsArithmetic_ReturnsFalse() {

        assertFalse(
                TemperatureUnit.CELSIUS
                        .supportsArithmetic());

    }



    @Test
    public void testLengthSupportsArithmetic_ReturnsTrue() {

        assertTrue(
                LengthUnit.FEET
                        .supportsArithmetic());

    }



    @Test
    public void testTemperatureValidateOperationSupport() {

        assertThrows(
                UnsupportedOperationException.class,

                () -> TemperatureUnit.CELSIUS
                        .validateOperationSupport(
                                "ADD"));

    }



    @Test
    public void testTemperatureConversion_AbsoluteZero() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        -273.15,
                        TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> result =
                celsius.convertTo(
                        TemperatureUnit.KELVIN);

        assertEquals(
                0.0,
                result.getValue(),
                EPSILON);

    }

}