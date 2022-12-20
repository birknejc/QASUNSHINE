import java.util.Scanner;
import java.text.DecimalFormat;

public class Sunshine {
    static Scanner inputDevice;
    public static void main(String[] args) {
        init();
        double iMinutes = input();
        double cHours = Calcs1(iMinutes);
        double cMinutes = Calcs2(iMinutes);
        double cCost = Calcs3(cMinutes,iMinutes, cHours);
        output(cHours, cMinutes, cCost);
    }

    public static void output(double cHours, double cMinutes, double cCost) {
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
