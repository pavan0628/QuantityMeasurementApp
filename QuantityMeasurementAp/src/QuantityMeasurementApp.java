public class QuantityMeasurementApp {



    public static void main(

            String[] args){



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




        boolean result =


                controller.performComparison(

                        first,

                        second);




        System.out.println(

                result);

    }

}