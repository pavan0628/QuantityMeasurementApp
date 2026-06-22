
// QuantityMeasurementApp.java
//UC2 : Feet and Inches measurement equality
//This class is responsible for comparing two numerical values measured in feet
public class QuantityMeasurementApp {

    /**
     *Inner class representing a measurement in feet
     * Encapsulates the value and ensures immutability
     */
    public static class Feet{
        private final double value; // Encapsulated measurement value

        /**
         * constructor to initialize the feet measurement.
         * @param value numerical value in feet
         */
        public Feet(double value){
            this.value=value;
        }


        @Override
        public boolean equals(Object obj) {

            if(this==obj) return true;

            if (obj==null) return false;

            if(this.getClass()!=obj.getClass()) return false;


            Feet other=(Feet) obj;

            return Double.compare(this.value, other.value)==0;

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

    //static method to check equality of two feet values.
    public static boolean areFeetEqual(double value1,double value2){
        Feet feet1=new Feet(value1);
        Feet feet2=new Feet(value2);

        return feet1.equals(feet2);
    }

    //static method to check equality of two inch values.
    public static boolean areInchEqual(double value1,double value2){
        Inches inches1=new Inches(value1);
        Inches inches2=new Inches(value2);

        return inches1.equals(inches2);
    }

    //main method to demonstrate UC2 functionality
    public static void main(String[] args) {

        System.out.println("Are the two feet measurements equal? "+areFeetEqual(1.0,3.0));
        System.out.println("Are the two inches measurements equal? "+areInchEqual(2.0,2.0));
    }

}
