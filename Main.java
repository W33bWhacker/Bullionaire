
import java.util.Scanner;

public class Main {

    static String capitalize(String str) {

        String str1 = str.substring(0,1).toUpperCase();
        String str2 = str.substring(1);
        str = str1 + str2;
        
        return str;
    }

    static String checkMetalName (Metal metal) {

        if (metal.name.equals("1")) {
            metal.name = "gold";
        } else if (metal.name.equals("2")) {
            metal.name = "silver";
        } else if (metal.name.equals("3")) {
            metal.name = "platinum";
        } else if (metal.name.equals("4")) {
            metal.name = "palladium";
        } else if (metal.name.equals("5")) {
            metal.name = "rhodium";
        } else if (metal.name.equals("6")) {
            metal.name = "copper";
        }

        return metal.name;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Metal metal = new Metal();
        Dealer dealer = new Dealer();


        System.out.println("""
        ____   __ __  _      _      ____  ___   ____    ____  ____  ____     ___ 
       |    \\ |  |  || |    | |    |    |/   \\ |    \\  /    ||    ||    \\   /  _]
       |  o  )|  |  || |    | |     |  ||     ||  _  ||  o  | |  | |  D  ) /  [_ 
       |     ||  |  || |___ | |___  |  ||  O  ||  |  ||     | |  | |    / |    _]
       |  O  ||  :  ||     ||     | |  ||     ||  |  ||  _  | |  | |    \\ |   [_ 
       |     ||     ||     ||     | |  ||     ||  |  ||  |  | |  | |  .  \\|     |
       |_____| \\__,_||_____||_____||____|\\___/ |__|__||__|__||____||__|\\_||_____|
       """);

       try {
        Thread.sleep(2000);
        } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        }
       
       System.out.println("""

                     ||``````````````````````````````````````````||
                     || Compare Seller Values of Precious Metals ||
                     ||__________________________________________||
        """);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("""
        Choose Precious Metal:

        1. Gold
        2. Silver
        3. Platinum
        4. Palladium
        5. Rhodium
        6. Copper ... if you're into that.\n""");

        String choice = sc.next();
        choice.toLowerCase();
        metal.name = choice;
        checkMetalName(metal);

        System.out.println("\nNumber of comparisons:\n");

        int comparisons = sc.nextInt();
        int counter = 0;

        while (counter < comparisons) {
            
            if (metal.name.equals("silver")){

                System.out.println("""

                Bullion Type: 

                1. Coin, Round, Bar
                2. Junk (Constitutional)
                3. Jewelry
                4. Other
                """);

            } else if (metal.name.equals("gold") || metal.name.equals("platinum")) {

                System.out.println("""

                Bullion Type: 

                1. Coin, Round, Bar
                2. Jewelry
                3. Other
                """);

            } else if (metal.name.equals("palladium")) {

                System.out.println("""

                Bullion Type: 

                1. Coin, Bar
                2. Other
                """);  

            } else if (metal.name.equals("rhodium")) {

                System.out.println("""

                Bullion Type: 

                1. Bar
                2. Other
                """);  

            } else if (metal.name.equals("copper")) {

                System.out.println("""

                Bullion Type: 

                1. Round, Bar
                2. Pennies
                3. Other
                """);  

            }

            String type = sc.next();
            type.toLowerCase();
            metal.type = type;

            if (metal.name.equals("gold") || metal.name.equals("platinum")) {

                if (metal.type.equals("coin") || metal.type.equals("1") || metal.type.equals("round") || metal.type.equals("bar") || metal.type.equals("other") || metal.type.equals("3")){
                    
                    metal.unit = dealer.get_unit();
                    metal.weight = dealer.get_weight();

                } else if (metal.type.equals("jewelry") || metal.type.equals("2")) {

                    metal.unit = dealer.get_unit();

                    double jewel_weight = dealer.get_weight();

                    metal.purity = dealer.get_karat();
                    metal.weight = dealer.calc.getMetalContent(jewel_weight, metal.purity);
                }

            } else if (metal.name.equals("silver")) {

                if (metal.type.equals("coin") || metal.type.equals("1") || metal.type.equals("round") || metal.type.equals("bar")){
                    
                    metal.unit = "oz";
                    metal.weight = dealer.get_weight();

                } else if (metal.type.equals("junk") || metal.type.equals("2")){

                    System.out.println("""

                    Denomination:
                    
                    1. Dollar
                    2. 90% Half Dollar
                    3. 40% Half Dollar
                    4. Quarter
                    5. Dime
                    6. Nickel
                    7. Combo (excludes less than 90% silver content)
                    """);

                    String denom = sc.next();
                    denom.toLowerCase();

                    dealer.get_junk_values(denom);

                    if (denom.equals("combo") || denom.equals("7")) {

                        double coin_weight = dealer.get_weight();

                        metal.weight = dealer.calc.getMetalContent(coin_weight, dealer.constant.genPercent);

                    } else {

                        System.out.println("\nWeight or Face?\n");
                        String amount = sc.next();
                        amount.toLowerCase();

                        if (amount.equals("weight")) {

                            metal.unit = dealer.get_unit();

                            double coin_weight = dealer.get_weight();
    
                            metal.weight = dealer.calc.getMetalContent(coin_weight, dealer.junk.percent);
    
                        } else if (amount.equals("face")) {

                            double face = dealer.get_face();

                            metal.unit = "oz";
                            metal.weight = dealer.calc.face2Weight(face, dealer);
    
                        }

                    }

                } else if (metal.type.equals("jewelry") || metal.type.equals("3")) {

                    metal.unit = dealer.get_unit();

                    double jewel_weight = dealer.get_weight();

                    System.out.println("Purity (%): ");
                    int percent = sc.nextInt();

                    double purity = dealer.calc.per2Dec(percent);

                    metal.weight = dealer.calc.getMetalContent(jewel_weight, purity);

                } else if (metal.type.equals("other") || metal.type.equals("4")) {

                    metal.unit = dealer.get_unit();
                    metal.weight = dealer.get_weight();
                }

            } else if (metal.name.equals("palladium")) {

                if (metal.type.equals("coin") || metal.type.equals("1") || metal.type.equals("bar")){
                    
                    metal.unit = dealer.get_unit();
                    metal.weight = dealer.get_weight();

                } else if (metal.type.equals("other") || metal.type.equals("2")) {

                    metal.unit = dealer.get_unit();
                    metal.weight = dealer.get_weight();

                }

            } else if (metal.name.equals("rhodium")) {

                if (metal.type.equals("1") || metal.type.equals("bar")){
                    
                    metal.unit = "oz";
                    metal.weight = dealer.get_weight();

                } else if (metal.type.equals("other") || metal.type.equals("2")) {

                    metal.unit = dealer.get_unit();
                    metal.weight = dealer.get_weight();
                }

            } else if (metal.name.equals("copper")) {

                if (metal.type.equals("round") || metal.type.equals("1") || metal.type.equals("bar")){
                    
                    metal.unit = "oz";
                    metal.weight = dealer.get_weight();

                } else if (metal.type.equals("pennies") || metal.type.equals("2")) {

                    metal.unit = dealer.get_unit();

                    double penny_weight = dealer.get_weight();
                    metal.weight = dealer.calc.getMetalContent(penny_weight, dealer.constant.pennyPercent);

                } else if (metal.type.equals("other") || metal.type.equals("2")) {

                    metal.unit = dealer.get_unit();
                    metal.weight = dealer.get_weight();

                }

            }

            double price = dealer.get_price();
            dealer.prices.add(price);
            metal.price = price;
            dealer.types.add(metal.type);

            if (metal.unit.equals("gram")) {

                metal.weight = dealer.calc.gram2oz(dealer, metal.weight);
                dealer.weights.add(metal.weight);

            } else {

                dealer.weights.add(metal.weight);

            }

            counter++;

        }

        System.out.println("\nCurrent market price of " + capitalize(metal.name) + " ($):\n");
        double spot = sc.nextFloat();
        dealer.spot = spot;

        //double price = spot / metal.weight;

        System.out.println("\n" + capitalize(metal.name) + ":");
        for (int i = 0; i < dealer.weights.size(); i++) {

            System.out.printf("\t" + capitalize(dealer.types.get(i)) + ": $" + String.format("%.2f", dealer.prices.get(i)) + ", " + String.format("%.2f", dealer.weights.get(i)) + " Troy Oz");
            System.out.printf(", $" + String.format("%.2f", dealer.calc.getItemOz(spot, dealer.prices.get(i), dealer.weights.get(i))) + " per Oz, $" + String.format("%.2f", dealer.calc.getOverSpot(spot, dealer.prices.get(i), dealer.weights.get(i))) + " Over spot\n");
            System.out.println("\n");

        }

        sc.close();

    }

}