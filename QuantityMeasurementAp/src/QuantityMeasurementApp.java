
// QuantityMeasurementApp.java
//UC4 Extended Unit Support(Yards and Centimeters)

public class QuantityMeasurementApp {

        public enum LengthUnit{
            FEET(1.0),   //1 foot = 1 foot
            INCH(1.0/12.0),
            //1 inch = 1/12 foot
            YARD(3.0), //1 yard= 3feet
            CENTIMETER(0.0328084);  //1cm=0.0328084 feet(since 1cm = 0.393701 in)

            private  final double conversionFactorToFeet;

            LengthUnit(double conversionFactorToFeet){
                this.conversionFactorToFeet=conversionFactorToFeet;
            }

            //return the conversion factor to feet
            public double getConversionFactorToFeet(){
                return conversionFactorToFeet;
            }

        }

        public static class QuantityLength{
            private final double value;
            private final LengthUnit unit;

            public QuantityLength(double value, LengthUnit unit){

                if(unit==null){
                    throw new IllegalArgumentException("Unit type cannot be null");
                }
                this.value=value;
                this.unit=unit;

            }

            //conerts the value into feet for comparision
            private double toFeet(){
                return value * unit.getConversionFactorToFeet();
            }

            private static final double EPSILON = 1e-6;

            //to compare quantitylength objects by converting to feet
            @Override
            public boolean equals(Object obj) {

                if(this==obj) return true;

                if (obj==null) {
                    return false;
                }

                if(this.getClass()!=obj.getClass()) {
                    return false;
                }


                QuantityLength other=(QuantityLength) obj;

                return Math.abs(this.toFeet()-other.toFeet())<EPSILON;

            }

        }






    //main method to demonstrate UC3 functionality
    public static void main(String[] args) {
        QuantityLength yard=new QuantityLength(1.0,LengthUnit.YARD);
        QuantityLength feet=new QuantityLength(3.0, LengthUnit.FEET);

        System.out.println("1 Yard equals 3 feet? "+yard.equals(feet));

        QuantityLength inches =new QuantityLength(36.0, LengthUnit.INCH);
        System.out.println("1 yard equals 36 inches? "+ yard.equals(inches));


        QuantityLength cm=new QuantityLength(1.0, LengthUnit.CENTIMETER);
        QuantityLength inch=new QuantityLength(0.393700787, LengthUnit.INCH);
        System.out.println("Are the two inches measurements equal? "+cm.equals(inch));
    }

}