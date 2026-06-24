import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class QuantityMeasurementCacheRepository

        implements IQuantityMeasurementRepository {



    private static

    QuantityMeasurementCacheRepository

            repository;



    private final

    List<QuantityMeasurementEntity>

            measurements;



    private static final String FILE_NAME=

            "quantity.dat";





    private QuantityMeasurementCacheRepository(){


        measurements=

                new ArrayList<>();


        loadFromDisk();

    }





    public static

    QuantityMeasurementCacheRepository

    getInstance(){



        if(repository==null){


            repository=

                    new QuantityMeasurementCacheRepository();

        }


        return repository;

    }





    @Override
    public void save(


            QuantityMeasurementEntity entity){



        measurements.add(entity);


        saveToDisk(entity);


    }





    @Override
    public List<QuantityMeasurementEntity>

    getAllMeasurements(){



        return measurements;

    }






    private void saveToDisk(

            QuantityMeasurementEntity entity){



        try{


            File file=

                    new File(FILE_NAME);



            ObjectOutputStream output;



            if(file.exists()){


                output=

                        new AppendableObjectOutputStream(

                                new FileOutputStream(

                                        file,

                                        true));

            }


            else{


                output=

                        new ObjectOutputStream(

                                new FileOutputStream(

                                        file));

            }



            output.writeObject(entity);


            output.close();



        }


        catch(Exception e){


            e.printStackTrace();

        }


    }






    private void loadFromDisk(){



        File file=

                new File(FILE_NAME);



        if(!file.exists()){


            return;

        }



        try{


            ObjectInputStream input=

                    new ObjectInputStream(

                            new FileInputStream(

                                    file));



            while(true){


                try{


                    QuantityMeasurementEntity entity=

                            (QuantityMeasurementEntity)

                                    input.readObject();



                    measurements.add(entity);

                }


                catch(EOFException e){


                    break;

                }


            }



            input.close();

        }


        catch(Exception e){


            e.printStackTrace();

        }


    }


}