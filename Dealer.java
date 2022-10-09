import java.util.Scanner;
import java.util.ArrayList;

public class Dealer {

    double spot;
    ArrayList<String> types = new ArrayList<String>();
    ArrayList<Double> weights = new ArrayList<Double>();
    ArrayList<Double> prices = new ArrayList<Double>();

    Scanner sc = new Scanner(System.in);
    Constants constant = new Constants();
    Calculator calc = new Calculator();
    Constitutional junk = new Constitutional();
    
    public String get_unit() {

        System.out.println("\nGram or Oz?\n");
        String unit = sc.next();

        return unit;
    }

    public double get_weight() {

        System.out.println("\nEnter weight:\n");
        double weight = sc.nextFloat();

        return weight;
    }

    public double get_face() {

        System.out.println("\nEnter face value ($):\n");
        double face = sc.nextFloat();

        return face;
    }

    public double get_price () {

        System.out.println("\nItem price ($):\n");
        double price = sc.nextFloat();

        return price;
    }

    public double get_karat() {
        System.out.println("\nKarat:\n");
        int karat = sc.nextInt();
        double purity = 0;

        if (karat == 24) {
            purity = constant.k24;
        } else if (karat == 22) {
            purity = constant.k22;
        } else if (karat == 18) {
            purity = constant.k18;
        } else if (karat == 14) {
            purity = constant.k14;
        } else if (karat == 10) {
            purity = constant.k10;
        } else if (karat == 9) {
            purity = constant.k9;
        }
        
        return purity;
    }

    public void get_junk_values (String value) {

        if (value.equals("dollar") || value.equals("1")) {
            junk.value = constant.dollar;
            junk.content = constant.dollarContent;
            junk.percent = constant.genPercent;
        } else if (value.equals("90% half dollar") || value.equals("90 half dollar") || value.equals("2")) {
            junk.value = constant.halfDollar;
            junk.content = constant.halfContent90;
            junk.percent = constant.genPercent;
        } else if (value.equals("40% half dollar") || value.equals("40 half dollar") || value.equals("3")) {
            junk.value = constant.halfDollar;
            junk.content = constant.halfContent40;
            junk.percent = constant.half40Percent;
        } else if (value.equals("quarter") || value.equals("4")) {
            junk.value = constant.quarter;
            junk.content = constant.quarterContent;
            junk.percent = constant.genPercent;
        } else if (value.equals("dime") || value.equals("5")) {
            junk.value = constant.dime;
            junk.content = constant.dimeContent;
            junk.percent = constant.genPercent;
        } else if (value.equals("nickel") || value.equals("6")) {
            junk.value = constant.nickel;
            junk.content = constant.nickelContent;
            junk.percent = constant.nickelPercent;
        }

    }

}
