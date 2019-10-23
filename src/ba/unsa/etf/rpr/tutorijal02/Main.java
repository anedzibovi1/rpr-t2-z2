package ba.unsa.etf.rpr.tutorijal02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Unesite pocetnu tacku i da li je ukljucena (true ili false)");
        Scanner scanner = new Scanner(System.in);
        double pocetnaTacka = scanner.nextDouble();
        boolean ukljucenaPT = scanner.nextBoolean();
        System.out.println("Unesite krajnju tacku i da li je ukljucena (true ili false)");
        double krajnjaTacka = scanner.nextDouble();
        boolean ukljucenaKT = scanner.nextBoolean();
        Interval interval1 = new Interval(pocetnaTacka, krajnjaTacka, ukljucenaPT, ukljucenaKT);

        boolean nulti = interval1.isNull();
        if(nulti) System.out.println("Interval jeste nulti");
        else System.out.println("Interval nije nulti");

        System.out.println("Unesite tacku");
        double nekaTacka = scanner.nextDouble();
        if(interval1.isIn(nekaTacka)) System.out.println("Tacka jeste unutar intervala");
        else System.out.println("Tacka nije unutar intervala");

        Interval interval2 = new Interval();
        Interval interval3 = new Interval(1.1, 2.5, true, false);

        System.out.println(interval1.toString());
        System.out.println(interval2.toString());
        System.out.println(interval3.toString());
        if(interval1.equals(interval2)) System.out.println("Interval1 je jednak intervalu interval2");
        else System.out.println("Interval1 nije jednak intervalu interval2");
        if(interval1.equals(interval3)) System.out.println("Interval1 je jednak intervalu interval3");
        else System.out.println("Interval1 nije jednak intervalu interval3");

        Interval i1 = interval3.intersect(new Interval(2.2, 2.6, true, true));
        System.out.println(i1.toString());

        Interval i2 = Interval.intersect(interval1, interval3);
        System.out.println(i2.toString());

    }
}
