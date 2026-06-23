
// QuantityMeasurementApp.java
//UC4 Extended Unit Support(Yards and Centimeters)

//QuantityMeasurementApp.java
//UC5: Unit-to-Unit conversion (Same Measurement Type)
public class QuantityMeasurementApp {

        public enum LengthUnit{
            FEET(1.0),   //1 foot = 1 foot
            INCH(1.0/12.0),
            //1 inch = 1/12 foot
            YARD(3.0), //1 yard= 3feet
            CENTIMETER(1.0/30.48);  //1cm=0.0328084 feet(since 1cm = 0.393701 in)

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
            private static final double EPSILON = 1e-6;

            public QuantityLength(double value, LengthUnit unit){
                if(!Double.isFinite(value)){
                    throw new IllegalArgumentException("Value must be finite");
                }

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
            //converts this quantitylength to a target unit
            public double convertTo(LengthUnit targetUnit){
                if(targetUnit==null){
                    throw new IllegalArgumentException("Target unit cannot be null");
                }
                double valueInFeet=this.toFeet();
                return valueInFeet/targetUnit.getConversionFactorToFeet();
            }

            @Override
            public String toString() {
                return value+" "+unit.name();
            }
        }

        //Static API for direct conversion without instantiating QuantityLength.
        public static double convert(double value, LengthUnit source, LengthUnit target){
            QuantityLength q=new QuantityLength(value,source);
            return q.convertTo(target);
        }






    //main method to demonstrate UC3 functionality
    public static void main(String[] args) {
        System.out.println("1 foot in inches = "+convert(1.0,LengthUnit.FEET,LengthUnit.INCH));
        System.out.println("3 yards in feet = "+convert(3.0,LengthUnit.YARD,LengthUnit.FEET));
        System.out.println("36 inches in yards = "+convert(36.0, LengthUnit.INCH,LengthUnit.YARD));
        System.out.println("1 cm in inches = "+ convert(1.0,LengthUnit.CENTIMETER,LengthUnit.INCH));
        System.out.println("0 feet in inches = "+ convert(0.0, LengthUnit.FEET,LengthUnit.FEET));

        }

}