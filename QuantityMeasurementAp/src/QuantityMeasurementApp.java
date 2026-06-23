
// QuantityMeasurementApp.java
//UC4 Extended Unit Support(Yards and Centimeters)

//QuantityMeasurementApp.java
//UC6: Addition of two Length Units(Same Category)
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

            public QuantityLength add(QuantityLength other){
                if(other==null){
                    throw new IllegalArgumentException("Operand cannot be null");
                }
                double sumInFeet=this.toFeet()+other.toFeet();
                double sumInTargetUnit=sumInFeet/this.unit.getConversionFactorToFeet();
                return new QuantityLength(sumInTargetUnit,this.unit);
            }
            @Override
            public String toString() {
                return value+" "+unit.name();
            }
        }







    public static void main(String[] args) {
            QuantityLength feet=new QuantityLength(1.0, LengthUnit.FEET);
            QuantityLength inches=new QuantityLength(12.0, LengthUnit.INCH);
            QuantityLength result=feet.add(inches);
            System.out.println("1 foot + 12 Inches = "+result); //expected 2.0 feet


        }

}