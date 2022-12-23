import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Sunshine {
    static Scanner inputDevice;
    public static void main(String[] args) {
        init();
        String strDate = getDate();
        formatDate(strDate);
        double iMinutes = input();
        double cHours = Calcs1(iMinutes);
        double cMinutes = Calcs2(iMinutes);
        double cCost = Calcs3(cMinutes,iMinutes, cHours);
        output(cHours, cMinutes, cCost);
    }

    public static void output(double cHours, double cMinutes, double cCost) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        String formattedDate = today.format(dateTimeFormatter);
        System.out.println("Current Date: " + formattedDate);
        System.out.println(CompanyMotto.getMotto());
        System.out.format("%12s%12s    %12s\n","Hours","Minutes","Rental Cost");
        DecimalFormat df = new DecimalFormat("$#,###.##");
        System.out.format("%12.0f%12.0f    %12s\n", cHours, cMinutes,
                df.format(cCost));

    }

    public static double Calcs1(double iMinutes) {
        double cHours = iMinutes/60;
        return cHours;
    }

    public static double Calcs2(double iMinutes) {
        double cMinutes = iMinutes%60;
        return cMinutes;
    }

    public static double Calcs3(double cMinutes,double iMinutes,double cHours) {
        double cCost = ((cHours-cHours%1)*40)+iMinutes%60;
        return cCost;
    }
    public static String getDate(){
        String enteredDate;
        System.out.print("Enter the rental date MM/DD/YYYY: ");
        enteredDate = inputDevice.nextLine();
        return enteredDate;
    }

    public static String formatDate(String enteredDate){
        String enteredPattern = "MM/DD/YYYY";
        String newPattern = "MMM dd, yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(enteredPattern);
        try{
            Date d = sdf.parse(enteredDate);
            sdf.applyPattern(newPattern);
            String newDateString = sdf.format(d);
            System.out.println("Rental date: " + newDateString);
        }
        catch (ParseException pe){
            System.out.println("Invalid date entered");
        }
        return enteredDate;


    }


    public static double input() {
        double iMinutes = 0;
        System.out.print("Enter the rental time in minutes: ");
        String iData = inputDevice.nextLine();
        try {
            iMinutes = Double.parseDouble(iData);
        }
        catch(Exception e){
            System.out.println("Invalid - entry must be numeric, defaulted to 60 minutes");
            iMinutes = 60;
        }
        return iMinutes;
    }

    public static void init(){
        System.out.println("init");
        inputDevice = new Scanner(System.in);
    }
}
