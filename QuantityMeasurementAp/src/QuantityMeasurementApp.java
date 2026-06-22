
// QuantityMeasurementApp.java
//UC1 : Feet measurement equality
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

    //main method to demonstrate UC1 functionality
    public static void main(String[] args) {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);

        System.out.println("Are the two feet measurements equal? "+feet1.equals(feet2));
    }

}
