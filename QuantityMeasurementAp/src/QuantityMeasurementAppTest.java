import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;


    // Test 1
    @Test
    public void testQuantityEntity_SingleOperandConstruction() {

        QuantityDTO input =
                new QuantityDTO(
                        10,
                        "FEET",
                        "LENGTH");

        QuantityDTO result =
                new QuantityDTO(
                        120,
                        "INCH",
                        "LENGTH");

        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity(
                        "CONVERT",
                        input,
                        result);

        assertFalse(entity.hasError());

        assertEquals(
                "CONVERT",
                entity.getOperation());

        assertEquals(
                input,
                entity.getOperandOne());

        assertEquals(
                result,
                entity.getResult());

    }


    // Test 2
    @Test
    public void testQuantityEntity_BinaryOperandConstruction() {

        QuantityDTO first =
                new QuantityDTO(
                        10,
                        "FEET",
                        "LENGTH");

        QuantityDTO second =
                new QuantityDTO(
                        5,
                        "FEET",
                        "LENGTH");

        QuantityDTO result =
                new QuantityDTO(
                        15,
                        "FEET",
                        "LENGTH");

        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity(
                        "ADD",
                        first,
                        second,
                        result);

        assertFalse(entity.hasError());

        assertEquals(
                "ADD",
                entity.getOperation());

        assertEquals(
                second,
                entity.getOperandTwo());

    }


    // Test 3
    @Test
    public void testQuantityEntity_ErrorConstruction() {

        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity(
                        "Invalid Operation");

        assertTrue(entity.hasError());

        assertEquals(
                "Invalid Operation",
                entity.getErrorMessage());

    }


    // Test 4
    @Test
    public void testQuantityEntity_ToString_Success() {

        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity(

                        "CONVERT",

                        new QuantityDTO(
                                1,
                                "FEET",
                                "LENGTH"),

                        new QuantityDTO(
                                12,
                                "INCH",
                                "LENGTH"));

        assertEquals(

                "CONVERT -> 12.0 INCH",

                entity.toString());

    }


    // Test 5
    @Test
    public void testQuantityEntity_ToString_Error() {

        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity(

                        "Failure");

        assertEquals(

                "Error : Failure",

                entity.toString());

    }


    // Test 6
    @Test
    public void testRepositorySingleton() {

        QuantityMeasurementCacheRepository first =

                QuantityMeasurementCacheRepository
                        .getInstance();

        QuantityMeasurementCacheRepository second =

                QuantityMeasurementCacheRepository
                        .getInstance();

        assertSame(
                first,
                second);

    }


    // Test 7
    @Test
    public void testService_NullRepository() {

        assertThrows(

                IllegalArgumentException.class,

                () -> new QuantityMeasurementServiceImpl(

                        null));

    }


    // Test 8
    @Test
    public void testController_NullService() {

        assertThrows(

                IllegalArgumentException.class,

                () -> new QuantityMeasurementController(

                        null));

    }


    // Test 9
    @Test
    public void testService_CompareEquality_SameUnit_Success() {

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityDTO first =

                new QuantityDTO(
                        10,
                        "FEET",
                        "LENGTH");

        QuantityDTO second =

                new QuantityDTO(
                        10,
                        "FEET",
                        "LENGTH");

        assertTrue(

                service.compare(

                        first,

                        second));

    }


    // Test 10
    @Test
    public void testService_CompareEquality_DifferentUnit_Success() {

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityDTO first =

                new QuantityDTO(

                        1,

                        "FEET",

                        "LENGTH");

        QuantityDTO second =

                new QuantityDTO(

                        12,

                        "INCH",

                        "LENGTH");

        assertTrue(

                service.compare(

                        first,

                        second));

    }


    // Test 11
    @Test
    public void testService_Convert_Success() {

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityDTO source =

                new QuantityDTO(

                        1,

                        "FEET",

                        "LENGTH");

        QuantityDTO result =

                service.convert(

                        source,

                        "INCH");

        assertEquals(

                12,

                result.getValue(),

                EPSILON);

    }


    // Test 12
    @Test
    public void testService_Add_Success() {

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityDTO first =

                new QuantityDTO(

                        1,

                        "FEET",

                        "LENGTH");

        QuantityDTO second =

                new QuantityDTO(

                        12,

                        "INCH",

                        "LENGTH");

        QuantityDTO result =

                service.add(

                        first,

                        second,

                        "FEET");

        assertEquals(

                2,

                result.getValue(),

                EPSILON);

    }


    // Test 13
    @Test
    public void testService_Subtract_Success() {

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityDTO first =

                new QuantityDTO(

                        2,

                        "FEET",

                        "LENGTH");

        QuantityDTO second =

                new QuantityDTO(

                        12,

                        "INCH",

                        "LENGTH");

        QuantityDTO result =

                service.subtract(

                        first,

                        second,

                        "FEET");

        assertEquals(

                1,

                result.getValue(),

                EPSILON);

    }


    // Test 14
    @Test
    public void testService_Divide_Success() {

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityDTO first =

                new QuantityDTO(

                        2,

                        "FEET",

                        "LENGTH");

        QuantityDTO second =

                new QuantityDTO(

                        1,

                        "FEET",

                        "LENGTH");

        assertEquals(

                2,

                service.divide(

                        first,

                        second),

                EPSILON);

    }

    // Test 15
    @Test
    public void testController_Compare() {

        IQuantityMeasurementRepository repository =

                QuantityMeasurementCacheRepository
                        .getInstance();

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(
                        repository);

        QuantityMeasurementController controller =

                new QuantityMeasurementController(
                        service);

        QuantityDTO first =

                new QuantityDTO(
                        1,
                        "FEET",
                        "LENGTH");

        QuantityDTO second =

                new QuantityDTO(
                        12,
                        "INCH",
                        "LENGTH");

        assertTrue(

                controller.performComparison(

                        first,

                        second));

    }


    // Test 16
    @Test
    public void testController_Convert() {

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityMeasurementController controller =

                new QuantityMeasurementController(
                        service);

        QuantityDTO dto =

                new QuantityDTO(
                        1,
                        "FEET",
                        "LENGTH");

        QuantityDTO result =

                controller.performConversion(
                        dto,
                        "INCH");

        assertEquals(

                12,

                result.getValue(),

                EPSILON);

    }


    // Test 17
    @Test
    public void testController_Addition() {

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityMeasurementController controller =

                new QuantityMeasurementController(
                        service);

        QuantityDTO first =

                new QuantityDTO(
                        1,
                        "FEET",
                        "LENGTH");

        QuantityDTO second =

                new QuantityDTO(
                        12,
                        "INCH",
                        "LENGTH");

        QuantityDTO result =

                controller.performAddition(

                        first,

                        second,

                        "FEET");

        assertEquals(

                2,

                result.getValue(),

                EPSILON);

    }


    // Test 18
    @Test
    public void testController_Subtraction() {

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityMeasurementController controller =

                new QuantityMeasurementController(
                        service);

        QuantityDTO first =

                new QuantityDTO(
                        2,
                        "FEET",
                        "LENGTH");

        QuantityDTO second =

                new QuantityDTO(
                        12,
                        "INCH",
                        "LENGTH");

        QuantityDTO result =

                controller.performSubtraction(

                        first,

                        second,

                        "FEET");

        assertEquals(

                1,

                result.getValue(),

                EPSILON);

    }


    // Test 19
    @Test
    public void testController_Division() {

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityMeasurementController controller =

                new QuantityMeasurementController(
                        service);

        QuantityDTO first =

                new QuantityDTO(
                        2,
                        "FEET",
                        "LENGTH");

        QuantityDTO second =

                new QuantityDTO(
                        1,
                        "FEET",
                        "LENGTH");

        assertEquals(

                2,

                controller.performDivision(

                        first,

                        second),

                EPSILON);

    }


    // Test 20
    @Test
    public void testService_Compare() {

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityDTO first =

                new QuantityDTO(
                        1,
                        "FEET",
                        "LENGTH");

        QuantityDTO second =

                new QuantityDTO(
                        12,
                        "INCH",
                        "LENGTH");

        assertTrue(

                service.compare(

                        first,

                        second));

    }


    // Test 21
    @Test
    public void testTemperatureComparison() {

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityDTO celsius =

                new QuantityDTO(

                        0,

                        "CELSIUS",

                        "TEMPERATURE");

        QuantityDTO fahrenheit =

                new QuantityDTO(

                        32,

                        "FAHRENHEIT",

                        "TEMPERATURE");

        assertTrue(

                service.compare(

                        celsius,

                        fahrenheit));

    }


    // Test 22
    @Test
    public void testTemperatureConversion() {

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityDTO source =

                new QuantityDTO(

                        0,

                        "CELSIUS",

                        "TEMPERATURE");

        QuantityDTO result =

                service.convert(

                        source,

                        "KELVIN");

        assertEquals(

                273.15,

                result.getValue(),

                EPSILON);

    }


    // Test 23
    @Test
    public void testEntity_OperationType_Tracking() {

        QuantityMeasurementEntity entity =

                new QuantityMeasurementEntity(

                        "ADD",

                        new QuantityDTO(
                                1,
                                "FEET",
                                "LENGTH"),

                        new QuantityDTO(
                                2,
                                "FEET",
                                "LENGTH"));

        assertEquals(

                "ADD",

                entity.getOperation());

    }


    // Test 24
    @Test
    public void testEntity_HasNoError() {

        QuantityMeasurementEntity entity =

                new QuantityMeasurementEntity(

                        "CONVERT",

                        new QuantityDTO(
                                1,
                                "FEET",
                                "LENGTH"),

                        new QuantityDTO(
                                12,
                                "INCH",
                                "LENGTH"));

        assertFalse(

                entity.hasError());

    }


    // Test 25
    @Test
    public void testRepository_NotNull() {

        assertNotNull(

                QuantityMeasurementCacheRepository
                        .getInstance());

    }


    // Test 26
    @Test
    public void testController_InstanceCreation() {

        QuantityMeasurementController controller =

                new QuantityMeasurementController(

                        new QuantityMeasurementServiceImpl(

                                QuantityMeasurementCacheRepository
                                        .getInstance()));

        assertNotNull(

                controller);

    }


    // Test 27
    @Test
    public void testService_InstanceCreation() {

        QuantityMeasurementServiceImpl service =

                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        assertNotNull(

                service);

    }


    // Test 28
    @Test
    public void testEntity_ResultGetter() {

        QuantityDTO result =

                new QuantityDTO(

                        12,

                        "INCH",

                        "LENGTH");

        QuantityMeasurementEntity entity =

                new QuantityMeasurementEntity(

                        "CONVERT",

                        new QuantityDTO(
                                1,
                                "FEET",
                                "LENGTH"),

                        result);

        assertEquals(

                result,

                entity.getResult());

    }

    // Test 29
    @Test
    public void testEntity_ToString_Success() {

        QuantityDTO input =

                new QuantityDTO(

                        1,

                        "FEET",

                        "LENGTH");

        QuantityDTO result =

                new QuantityDTO(

                        12,

                        "INCH",

                        "LENGTH");

        QuantityMeasurementEntity entity =

                new QuantityMeasurementEntity(

                        "CONVERT",

                        input,

                        result);

        assertEquals(

                "CONVERT -> 12.0 INCH",

                entity.toString());

    }


    // Test 30
    @Test
    public void testEntity_ToString_Error() {

        QuantityMeasurementEntity entity =

                new QuantityMeasurementEntity(

                        "Invalid Operation");

        assertEquals(

                "Error : Invalid Operation",

                entity.toString());

    }


    // Test 31
    @Test
    public void testController_PerformComparison_False() {

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityMeasurementController controller =

                new QuantityMeasurementController(

                        service);

        QuantityDTO first =

                new QuantityDTO(

                        1,

                        "FEET",

                        "LENGTH");

        QuantityDTO second =

                new QuantityDTO(

                        10,

                        "INCH",

                        "LENGTH");

        assertFalse(

                controller.performComparison(

                        first,

                        second));

    }


    // Test 32
    @Test
    public void testService_Convert_Length() {

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityDTO dto =

                new QuantityDTO(

                        1,

                        "FEET",

                        "LENGTH");

        QuantityDTO result =

                service.convert(

                        dto,

                        "INCH");

        assertEquals(

                12,

                result.getValue(),

                EPSILON);

    }


    // Test 33
    @Test
    public void testService_Add_Length() {

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityDTO first =

                new QuantityDTO(

                        1,

                        "FEET",

                        "LENGTH");

        QuantityDTO second =

                new QuantityDTO(

                        1,

                        "FEET",

                        "LENGTH");

        QuantityDTO result =

                service.add(

                        first,

                        second,

                        "FEET");

        assertEquals(

                2,

                result.getValue(),

                EPSILON);

    }


    // Test 34
    @Test
    public void testService_Subtract_Length() {

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityDTO first =

                new QuantityDTO(

                        3,

                        "FEET",

                        "LENGTH");

        QuantityDTO second =

                new QuantityDTO(

                        1,

                        "FEET",

                        "LENGTH");

        QuantityDTO result =

                service.subtract(

                        first,

                        second,

                        "FEET");

        assertEquals(

                2,

                result.getValue(),

                EPSILON);

    }


    // Test 35
    @Test
    public void testService_Divide_Length() {

        IQuantityMeasurementService service =

                new QuantityMeasurementServiceImpl(

                        QuantityMeasurementCacheRepository
                                .getInstance());

        QuantityDTO first =

                new QuantityDTO(

                        10,

                        "FEET",

                        "LENGTH");

        QuantityDTO second =

                new QuantityDTO(

                        5,

                        "FEET",

                        "LENGTH");

        assertEquals(

                2,

                service.divide(

                        first,

                        second),

                EPSILON);

    }


    // Test 36
    @Test
    public void testEntity_GetOperandOne() {

        QuantityDTO dto =

                new QuantityDTO(

                        1,

                        "FEET",

                        "LENGTH");

        QuantityMeasurementEntity entity =

                new QuantityMeasurementEntity(

                        "CONVERT",

                        dto,

                        dto);

        assertEquals(

                dto,

                entity.getOperandOne());

    }


    // Test 37
    @Test
    public void testEntity_GetOperandTwo() {

        QuantityDTO first =

                new QuantityDTO(

                        1,

                        "FEET",

                        "LENGTH");

        QuantityDTO second =

                new QuantityDTO(

                        2,

                        "FEET",

                        "LENGTH");

        QuantityMeasurementEntity entity =

                new QuantityMeasurementEntity(

                        "ADD",

                        first,

                        second,

                        second);

        assertEquals(

                second,

                entity.getOperandTwo());

    }


    // Test 38
    @Test
    public void testEntity_GetOperation() {

        QuantityMeasurementEntity entity =

                new QuantityMeasurementEntity(

                        "ADD",

                        new QuantityDTO(

                                1,

                                "FEET",

                                "LENGTH"),

                        new QuantityDTO(

                                2,

                                "FEET",

                                "LENGTH"));

        assertEquals(

                "ADD",

                entity.getOperation());

    }


    // Test 39
    @Test
    public void testEntity_GetErrorMessage() {

        QuantityMeasurementEntity entity =

                new QuantityMeasurementEntity(

                        "Sample Error");

        assertEquals(

                "Sample Error",

                entity.getErrorMessage());

    }


    // Test 40
    @Test
    public void testEntity_HasError() {

        QuantityMeasurementEntity entity =

                new QuantityMeasurementEntity(

                        "Error");

        assertTrue(

                entity.hasError());

    }


    // Test 41
    @Test
    public void testRepository_SingletonAgain() {

        assertSame(

                QuantityMeasurementCacheRepository
                        .getInstance(),

                QuantityMeasurementCacheRepository
                        .getInstance());

    }


    // Test 42
    @Test
    public void testController_NotNull() {

        QuantityMeasurementController controller =

                new QuantityMeasurementController(

                        new QuantityMeasurementServiceImpl(

                                QuantityMeasurementCacheRepository
                                        .getInstance()));

        assertNotNull(

                controller);

    }

}
