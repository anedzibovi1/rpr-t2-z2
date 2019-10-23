package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

    private double pocetnaTacka;
    private double krajnaTacka;
    private boolean ukljucivanjePT;
    private boolean ukljucivanjeKT;

    public Interval() {
        pocetnaTacka = 0;
        krajnaTacka = 0;
        ukljucivanjePT = false;
        ukljucivanjeKT = false;
    }

    Interval(double v, double v1, boolean b, boolean b1) {
        if(v>v1) throw new IllegalArgumentException("Krajnja tacka je manja od pocetne!");
        pocetnaTacka = v;
        krajnaTacka = v1;
        ukljucivanjePT = b;
        ukljucivanjeKT = b1;
    }

    boolean isNull() {
        return pocetnaTacka == 0 && krajnaTacka == 0 && !ukljucivanjeKT && !ukljucivanjePT;
    }

    boolean isIn(double v) {
        return (ukljucivanjePT || !(pocetnaTacka <= v)) && (ukljucivanjeKT || !(krajnaTacka <= v)) && !(pocetnaTacka > v) && !(krajnaTacka < v);
    }

    Interval intersect(Interval interval) {
        Interval novi = new Interval();
        if(pocetnaTacka >= interval.pocetnaTacka) {
            novi.pocetnaTacka = pocetnaTacka;
            novi.ukljucivanjePT = ukljucivanjePT;
        }
        else if(pocetnaTacka < interval.pocetnaTacka) {
            novi.pocetnaTacka = interval.pocetnaTacka;
            novi.ukljucivanjePT = interval.ukljucivanjePT;
        }
        if(krajnaTacka <= interval.krajnaTacka) {
            novi.krajnaTacka = krajnaTacka;
            novi.ukljucivanjeKT = ukljucivanjeKT;
        }
        else if(krajnaTacka > interval.krajnaTacka) {
            novi.krajnaTacka = interval.krajnaTacka;
            novi.ukljucivanjeKT = interval.ukljucivanjeKT;
        }
        return novi;
    }

    static Interval intersect(Interval i, Interval i2) {
        Interval novi = new Interval();
        if(i.pocetnaTacka >= i2.pocetnaTacka) {
            novi.pocetnaTacka = i.pocetnaTacka;
            novi.ukljucivanjePT = i.ukljucivanjePT;
        }
        else if(i.pocetnaTacka < i2.pocetnaTacka) {
            novi.pocetnaTacka = i2.pocetnaTacka;
            novi.ukljucivanjePT = i2.ukljucivanjePT;
        }
        if(i.krajnaTacka <= i2.krajnaTacka) {
            novi.krajnaTacka = i.krajnaTacka;
            novi.ukljucivanjeKT = i.ukljucivanjeKT;
        }
        else if(i.krajnaTacka > i2.krajnaTacka) {
            novi.krajnaTacka = i2.krajnaTacka;
            novi.ukljucivanjeKT = i2.ukljucivanjeKT;
        }
        return novi;
    }


    public String toString() {
        String s;
        if(ukljucivanjePT) s = "[";
        else s = "(";
        if(pocetnaTacka == 0 && krajnaTacka == 0) {
            if(ukljucivanjeKT) s += "]";
            else s +=")";
            return s;
        }
        s += pocetnaTacka + "," + krajnaTacka;
        if(ukljucivanjeKT) s += "]";
        else s +=")";
        return s;
    }

    boolean equals(Interval i) {
        return ukljucivanjeKT == i.ukljucivanjeKT && ukljucivanjePT == i.ukljucivanjePT && pocetnaTacka == i.pocetnaTacka && krajnaTacka == i.krajnaTacka;
    }




}
