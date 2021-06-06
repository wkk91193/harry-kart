package se.atg.service.harrykart.java.helper;

public class CalculationUtils {

    public static double CalculateTimeBasedonSpeedAndDistance(double speed, double distance){
        return distance / speed;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isNullValue(Object value){
        if(value==null)
            return true;
        else
            return false;
    }

    public static boolean isNullOrEmptyString(String str){
        if(str == null || str.isEmpty())
            return true;
        else
            return false;
    }
}
