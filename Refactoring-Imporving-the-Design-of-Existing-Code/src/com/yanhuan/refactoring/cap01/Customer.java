package com.yanhuan.refactoring.cap01;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 顾客
 *
 * @author YanHuan
 * @date 2020-08-15 13:40
 */
public class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    /**
     * 生成详单（原方法）
     *
     * @return 详单数据
     */
    public String statement() {
        //总金额
        double totalAmount = 0;

        //常客积分
        int frequentRenterPoints = 0;

        Enumeration<Rental> rentalEnumeration = rentals.elements();

        String result = "Rental Record for " + getName() + "\n";

        while (rentalEnumeration.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = rentalEnumeration.nextElement();

            //determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
                default:
                    break;
            }

            //add frequent renter points 增加常客积分
            frequentRenterPoints++;

            //add bonus for a two day new release rental  租期大于一天新发行电影增加1积分
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            //show figures for this rental 显示此影片租金数据
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";

            //计算总金额
            totalAmount += thisAmount;
        }

        //add footer lines
        result += "Amount owed is" + totalAmount + "\n";
        result += "You earned" + frequentRenterPoints + "frequent renter points";
        return result;
    }

    /**
     * 生成详单（改造后的方法）
     * <p>
     * 这次重构存在一个问题，那就是性能。原本代码只执行while循环一次，
     * 新版本要执行三次。如果while循环耗时很多，就可能大大降低程序的性能。
     * 但也只是可能，真实情况需要评测才能知道。所以重构时不必担心这些优化时才需要担心。
     *
     * @return 详单数据
     */
    public String htmlStatement() {

        Enumeration<Rental> rentalEnumeration = rentals.elements();

        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        while (rentalEnumeration.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = rentalEnumeration.nextElement();
            //计算金额
            thisAmount = each.getCharge();
            //show figures for this rental 显示此影片租金数据
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(thisAmount).append("\n");
        }

        //add footer lines
        result.append("Amount owed is").append(getTotalCharge()).append("\n");
        result.append("You earned").append(getTotalFrequentRenterPoints()).append("frequent renter points");
        return result.toString();
    }

    /**
     * 计算总金额
     *
     * @return 总金额
     */
    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentalEnumeration = rentals.elements();
        while (rentalEnumeration.hasMoreElements()) {
            Rental each = rentalEnumeration.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    /**
     * 计算总积分
     *
     * @return 总积分
     */
    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> rentalEnumeration = rentals.elements();
        while (rentalEnumeration.hasMoreElements()) {
            Rental each = rentalEnumeration.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

}
