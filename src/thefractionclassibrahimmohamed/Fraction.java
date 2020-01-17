// Ibrahim Mohamed
package thefractionclassibrahimmohamed;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Fraction
{

    private int numerator;
    private int denominator;

    Fraction(int n, int d)
    {
        //setting numerator & denominator as what is passed in
        numerator = n;
        denominator = d;
    }

    public double getDecimal()
    {
        //creates formatter to limit decimal places
        NumberFormat formatter = new DecimalFormat("#0.00");
        
        //converts integers to doubles
        double n = numerator;
        double d = denominator;
        
        //formats decimal value 
        String result = formatter.format(n / d);
        
        //converts String result to double
        double decimal = Double.parseDouble(result);

        return decimal;
    }

    public String toString()
    {
        //converts ints to string fraction
        return numerator + "/" + denominator;
    }

    public void reduce()
    {
        int i = Math.min(Math.abs(numerator), Math.abs(denominator));
        if (i == 0)
        {
            return;
        }
        while ((numerator % i != 0) || (denominator % i != 0))
        {
            i--;
            numerator = numerator / i;
            denominator = denominator / i;
        }

    }

    public String toMixed()
    {
        //check and do this if both numerator and denominator are negative
        if(numerator < 0 && denominator < 0){
            
            //convert both numerator & denominator to positive values
            int pN = numerator * -1, pD= denominator * -1;
            String result = gcd(pN, pD);
            return "-" + result;
        }
        //check and do this if numerator is a negative
        else if(numerator < 0){
            
            //convert numerator to a positive value
            int pN = numerator * -1;
            String result = gcd(pN, denominator);
            return "-" + result;
        }
        
        //check and do this if denominator is a negative
        else if(denominator < 0){
            
            //convert denominator to a positive value
            int pD = denominator * -1;
            String result = gcd(numerator, pD);
            return "-" + result;
        }
        
        //do this if both numerator and denominator are positive values
        else {
            String result = gcd(numerator, denominator);
            return result;
        }
    }
    public String gcd(int n, int d){
        
        //initialize gcd to 0
        int gcd = 0;
        
        if (n > d)
        {
            int whole = n / d;
            int remainder = n % d;
            for (int i = 1; i <= remainder && i <= d; i++)
            {
                if (remainder % i == 0 && d % i == 0)
                {
                    gcd = i;
                }
            }
            if(gcd != 0){
                return whole + " " + (remainder / gcd) + "/"
                    + (d / gcd);                
            }else {
                return whole + " " + remainder + "/"
                    + d;
            }

        } else
        {
            for (int i = 1; i <= n && i <= d; i++)
            {
                if (n % i == 0 && d % i == 0)
                {
                    gcd = i;
                }
            }
            if(gcd != 0){
                return (n / gcd) + "/" + (d / gcd);
            }else {
                return n + "/" + d;
            }
        }
    }
}
