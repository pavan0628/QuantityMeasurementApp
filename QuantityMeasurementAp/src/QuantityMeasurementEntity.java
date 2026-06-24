import java.io.Serializable;


public class QuantityMeasurementEntity

        implements Serializable {



    private static final long

            serialVersionUID = 1L;



    private QuantityDTO operandOne;


    private QuantityDTO operandTwo;


    private QuantityDTO result;



    private String operation;



    private boolean error;



    private String errorMessage;




    public QuantityMeasurementEntity(

            String operation,

            QuantityDTO operandOne,

            QuantityDTO result) {



        this.operation = operation;

        this.operandOne = operandOne;

        this.result = result;

        this.error = false;

        this.errorMessage = null;

    }




    public QuantityMeasurementEntity(

            String operation,

            QuantityDTO operandOne,

            QuantityDTO operandTwo,

            QuantityDTO result) {



        this.operation = operation;

        this.operandOne = operandOne;

        this.operandTwo = operandTwo;

        this.result = result;

        this.error = false;

        this.errorMessage = null;

    }




    public QuantityMeasurementEntity(

            String errorMessage) {



        this.error = true;

        this.errorMessage = errorMessage;

    }




    public QuantityDTO getOperandOne() {

        return operandOne;

    }



    public QuantityDTO getOperandTwo() {

        return operandTwo;

    }



    public QuantityDTO getResult() {

        return result;

    }



    public String getOperation() {

        return operation;

    }



    public boolean hasError() {

        return error;

    }



    public String getErrorMessage() {

        return errorMessage;

    }




    @Override
    public String toString() {



        if (error) {


            return "Error : "

                    + errorMessage;

        }



        return operation

                + " -> "

                + result;

    }


}