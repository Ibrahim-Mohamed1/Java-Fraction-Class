// Ibrahim Mohamed

package thefractionclassibrahimmohamed;

import static java.lang.System.exit;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TestFraction
{

    public static void main(String[] args)
    {
        //creating an array with 5 fractions
        int[][] myFracs = {{1, 25}, {-65, 95}, {150, 35}, {-40, 230},{4, 80}};
        
        //initializing user choice to run while loop
        int choice = 0;

        //doing what user wants done
        while (choice < 5)
        {
            //getting user choice selection
            choice = Choice();

            switch (choice)
            {
                case 1:
                    //Answers array
                    ArrayList<String> string = new ArrayList<String>();

                    for (int i = 0; i < myFracs.length; i++)
                    {
                        //sets numerator & denominator that are getting passed
                        int n = myFracs[i][0];
                        int d = myFracs[i][1];

                        //setting up fraction class with parameters
                        Fraction fracObj = new Fraction(n, d);

                        /*picking which method to run from fraction class & storing 
                          return value*/
                        String toString = fracObj.toString();

                        //adding answer to answer array
                        string.add(toString);
                    }

                    //printing answer                    
                    JOptionPane.showConfirmDialog(null, string, "Answers",
                            JOptionPane.DEFAULT_OPTION);
                    break;
                case 2:
                    //loop to send fractions in array individually
                    for (int i = 0; i < myFracs.length; i++)
                    {
                        //sets numerator & denominator that are getting passed                                        
                        int n = myFracs[i][0];
                        int d = myFracs[i][1];

                        //setting up fraction class with parameters                                        
                        Fraction fracObj = new Fraction(n, d);

                        //picking which method to run from fraction class               
                        fracObj.reduce();
                    }
                    break;
                case 3:
                    //Answers array
                    ArrayList<String> mix = new ArrayList<String>();

                    //loop to send fractions in array individually                    
                    for (int i = 0; i < myFracs.length; i++)
                    {
                        //sets numerator & denominator that are getting passed                                        
                        int n = myFracs[i][0];
                        int d = myFracs[i][1];

                        //setting up fraction class with parameters                                                            
                        Fraction fracObj = new Fraction(n, d);

                        /*picking which method to run from fraction class & storing 
                          return value*/
                        String mixedNumber = fracObj.toMixed();

                        //adding answer to answer array                        
                        mix.add(mixedNumber);
                    }

                    //printing answer                    
                    JOptionPane.showConfirmDialog(null, mix, "Answers",
                            JOptionPane.DEFAULT_OPTION);
                    break;
                case 4:
                    //Answers array
                    ArrayList<Double> decimal = new ArrayList<Double>();

                    //loop to send fractions in array individually                    
                    for (int i = 0; i < myFracs.length; i++)
                    {
                        //sets numerator & denominator that are getting passed                    
                        int n = myFracs[i][0];
                        int d = myFracs[i][1];

                        //setting up fraction class with parameters                    
                        Fraction fracObj = new Fraction(n, d);

                        /*picking which method to run from fraction class & storing 
                          return value*/
                        double getDecimal = fracObj.getDecimal();

                        //adding answer to answer array                        
                        decimal.add(getDecimal);
                    }

                    //printing answer
                    JOptionPane.showConfirmDialog(null, decimal, "Answers",
                            JOptionPane.DEFAULT_OPTION);
                    break;
                case 0:
                    //ends program
                    exit(0);
                    break;
            }
        }
    }

    public static int Choice()
    {
        //Choice array
        String[] options =
            {"Quit", "toString()", "reduce()","toMixed()", "getDecimal()"};

        //getting users choice on what to do with fractions
        int choice = JOptionPane.showOptionDialog(null, "Which method would you "
                + "like to test?", "Choose a method", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        return choice;
    }
}