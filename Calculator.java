public class Calculator {

    public double getMetalContent (double weight, double purity) {

        return weight * purity;
    }

    public double face2Weight (double face, Dealer dealer) {

        double num = face / dealer.junk.value;
        double weight = getMetalContent(num, dealer.junk.content);

        return weight;
    }

    public double per2Dec (int percent) {

        return percent / 100;
    }

    public double getItemOz (double spot, double price, double weight) {

        double itemOz = price * (spot / (spot * weight));

        return itemOz;
    }

    public double getOverSpot (double spot, double price, double weight) {

        double overSpot = getItemOz(spot, price, weight) - spot;

        return overSpot;
    }

    public double gram2oz (Dealer dealer, double gram) {

        double oz = gram * dealer.constant.oz;

        return oz;
    }

    public double oz2Gram (Dealer dealer, double oz) {

        double gram = oz * dealer.constant.gram;

        return gram;
    }

}
