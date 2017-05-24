/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package walshconjecture;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author chris
 */
public class WalshConjecture {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    /**
     *
     * @author christopher1
     */
    public static void main(String[] args) {
        //Colatz Conjecture Program

        System.out.println("Welcome to the Colatz Conjecture Program!");
        try {
            Calculate();
            Run();

        } catch (Exception e) {
            System.out.println("That's not what we expected. Try again.");
            Run();
            //Calculate();

        }
    }

    public static void Run() {
        boolean running = true;
        Scanner sc = new Scanner(System.in);

        while (running == true) {

            System.out.println("Enter 1 to calculate another number.");
            System.out.println("Or if you would like to exit the program enter 0.");
            long r = sc.nextInt();
            if (r == 0) {
                End();
            } else if (r >= 0) {
                Calculate();
            }

        }

    }

    public static void Calculate() {
        boolean calculate = true;
        BigInteger n = new BigInteger("0");
        Scanner sc = new Scanner(System.in);
        long counter = 0;
        try {
            while (calculate == true) {

                System.out.println("Please enter an integer of your choosing:");
                n = sc.nextBigInteger();
                BigInteger one = new BigInteger("1");
                BigInteger three;
                BigInteger two;
                BigInteger zero;
                zero = BigInteger.valueOf(0);
                two = BigInteger.valueOf(2);
                three = BigInteger.valueOf(3);
                while (n.compareTo(one) > 0) {

                    if (n.mod(two).equals(BigInteger.ONE)) {
                        BigInteger odd = new BigInteger("0");
                        odd = n.multiply(three).add(one);
                        //odd = n.divide(three);
                        n = odd;
                        System.out.println(odd);
                    } else if (n.mod(two).equals(BigInteger.ZERO)) {
                        BigInteger even = new BigInteger("0");
                        even = n.divide(two);
                        //even = n.multiply(two).add(BigInteger.ONE);
                        n = even;
                        System.out.println(even);
                    }
                    if (n.equals(BigInteger.ONE)) {
                        calculate = false;

                    }
                    counter++;
                }

            }
        } catch (Exception e) {

            System.out.println("That's not a number. Try again.");
            Calculate();
        }

        System.out.println("It took: " + counter + " steps to get to 1.");
        counter = 0;
    }

    public static void End() {
        System.exit(0);
    }

}
