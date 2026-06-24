public class QuantityMeasurementServiceImpl

        implements IQuantityMeasurementService {



    private final

    IQuantityMeasurementRepository

            repository;




    public QuantityMeasurementServiceImpl(

            IQuantityMeasurementRepository repository){


        if(repository==null){


            throw new IllegalArgumentException(

                    "Repository cannot be null");

        }


        this.repository=repository;

    }





    private IMeasurable getUnit(

            QuantityDTO dto){



        switch(dto.getMeasurementType()){


            case "LENGTH":

                return LengthUnit.FEET

                        .getUnitByName(

                                dto.getUnit());



            case "WEIGHT":

                return WeightUnit.KILOGRAM

                        .getUnitByName(

                                dto.getUnit());



            case "VOLUME":

                return VolumeUnit.LITRE

                        .getUnitByName(

                                dto.getUnit());



            case "TEMPERATURE":

                return TemperatureUnit.CELSIUS

                        .getUnitByName(

                                dto.getUnit());

        }


        throw new QuantityMeasurementException(

                "Unknown Measurement");

    }






    @Override
    public boolean compare(

            QuantityDTO first,

            QuantityDTO second){



        try{


            Quantity<IMeasurable> q1=

                    new Quantity<>(

                            first.getValue(),

                            getUnit(first));



            Quantity<IMeasurable> q2=

                    new Quantity<>(

                            second.getValue(),

                            getUnit(second));



            boolean result=

                    q1.equals(q2);



            repository.save(

                    new QuantityMeasurementEntity(

                            "COMPARE",

                            first,

                            second,

                            new QuantityDTO(

                                    result ? 1 : 0,

                                    "",

                                    "")));



            return result;

        }


        catch(Exception e){


            throw new QuantityMeasurementException(

                    e.getMessage());

        }

    }







    @Override
    public QuantityDTO convert(

            QuantityDTO source,

            String targetUnit){



        try{


            IMeasurable sourceUnit=

                    getUnit(source);



            Quantity<IMeasurable> quantity=

                    new Quantity<>(

                            source.getValue(),

                            sourceUnit);



            IMeasurable target=

                    sourceUnit.getUnitByName(

                            targetUnit);



            Quantity<IMeasurable> result=

                    quantity.convertTo(

                            target);




            QuantityDTO dto=

                    new QuantityDTO(

                            result.getValue(),

                            target.getUnitName(),

                            target.getMeasurementType());



            repository.save(

                    new QuantityMeasurementEntity(

                            "CONVERT",

                            source,

                            dto));



            return dto;

        }


        catch(Exception e){


            throw new QuantityMeasurementException(

                    e.getMessage());

        }

    }







    @Override
    public QuantityDTO add(

            QuantityDTO first,

            QuantityDTO second,

            String targetUnit){



        try{


            Quantity<IMeasurable> q1=

                    new Quantity<>(

                            first.getValue(),

                            getUnit(first));



            Quantity<IMeasurable> q2=

                    new Quantity<>(

                            second.getValue(),

                            getUnit(second));



            IMeasurable target=

                    getUnit(first)

                            .getUnitByName(

                                    targetUnit);



            Quantity<IMeasurable> result=

                    q1.add(

                            q2,

                            target);



            QuantityDTO dto=

                    new QuantityDTO(

                            result.getValue(),

                            target.getUnitName(),

                            target.getMeasurementType());



            repository.save(

                    new QuantityMeasurementEntity(

                            "ADD",

                            first,

                            second,

                            dto));



            return dto;

        }


        catch(Exception e){


            throw new QuantityMeasurementException(

                    e.getMessage());

        }

    }








    @Override
    public QuantityDTO subtract(

            QuantityDTO first,

            QuantityDTO second,

            String targetUnit){



        try{


            Quantity<IMeasurable> q1=

                    new Quantity<>(

                            first.getValue(),

                            getUnit(first));



            Quantity<IMeasurable> q2=

                    new Quantity<>(

                            second.getValue(),

                            getUnit(second));



            IMeasurable target=

                    getUnit(first)

                            .getUnitByName(

                                    targetUnit);



            Quantity<IMeasurable> result=

                    q1.subtract(

                            q2,

                            target);



            QuantityDTO dto=

                    new QuantityDTO(

                            result.getValue(),

                            target.getUnitName(),

                            target.getMeasurementType());



            repository.save(

                    new QuantityMeasurementEntity(

                            "SUBTRACT",

                            first,

                            second,

                            dto));



            return dto;

        }


        catch(Exception e){


            throw new QuantityMeasurementException(

                    e.getMessage());

        }

    }








    @Override
    public double divide(

            QuantityDTO first,

            QuantityDTO second){



        try{


            Quantity<IMeasurable> q1=

                    new Quantity<>(

                            first.getValue(),

                            getUnit(first));



            Quantity<IMeasurable> q2=

                    new Quantity<>(

                            second.getValue(),

                            getUnit(second));



            double result=

                    q1.divide(

                            q2);



            repository.save(

                    new QuantityMeasurementEntity(

                            "DIVIDE",

                            first,

                            second,

                            new QuantityDTO(

                                    result,

                                    "",

                                    "")));



            return result;

        }


        catch(Exception e){


            throw new QuantityMeasurementException(

                    e.getMessage());

        }

    }


}