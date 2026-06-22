
// QuantityMeasurementApp.java
//UC3 : Generic QuantityLength clss using DRY principle
// Refactors Feet and inches into a single class with unit abstraction
public class QuantityMeasurementApp {

        public enum LengthUnit{
            FEET(1.0),   //1 foot = 1 foot
            INCH(1.0/12.0); //1 inch = 1/12 foot

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

            //to compare quantitylength objects by converting to feet
            @Override
            public boolean equals(Object obj) {

                if(this==obj) return true;

                if (obj==null) return false;

                if(this.getClass()!=obj.getClass()) return false;


                QuantityLength other=(QuantityLength) obj;

                return Double.compare(this.toFeet(), other.toFeet())==0;

            }

        }




    //Inches class represnting a measurent in inches
    public static class Inches{
        private final double value;

        public Inches(double value){
            this.value=value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this==obj) return true;
            if (obj==null) return false;
            if (this.getClass() != obj.getClass()) return false;
            Inches other=(Inches) obj;
            return Double.compare(this.value,other.value)==0;

        }
    }



    //main method to demonstrate UC3 functionality
    public static void main(String[] args) {
        QuantityLength q1=new QuantityLength(1.0,LengthUnit.FEET);
        QuantityLength q2=new QuantityLength(12.0, LengthUnit.INCH);

        System.out.println("Are the two feet measurements equal? "+q1.equals(q2));

        QuantityLength q3=new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q4=new QuantityLength(1.0, LengthUnit.INCH);

        System.out.println("Are the two inches measurements equal? "+q3.equals(q4));
    }

}