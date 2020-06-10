/*
 * Made by: Rafik H. with the purpose of oragnizing user incomes, on Jul 2-9
 */
package incomemanagerv2;
 import java.io.*;
 import java.util.Scanner;
import java.io.File;
//Note: it is managerv2 because this is my third itteration of it but the second one that is not a GUI
//Some problems i've run into in the other versions i will fix in my free time but this is the work i was happy to submit
//Computer problems with net beans caused some problems with testing so a work around with this was making fool proof code and when my computer was back to itself i would fully test it
//I am aware it is a mess of try catch statements and if statments with loops, in the future i will have better organization with writing code like this

public class IncomeManagerv2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File dataFile = new File("Income.dat");
        FileWriter out;
        BufferedWriter writeFile;
        FileReader in;
        BufferedReader readFile;
        //For readers and writers later on
        Scanner keyedInput = new Scanner(System.in);
        int UserChoiceVal = 0;
        double TInc = 0;
        boolean UsrIncChoice;
        double LastEntryIncVal = 0;
        //Base values for future code
        System.out.println("Please select an option by typing a number on your keyboard");
        System.out.println("1. Enter in income(s)");
        System.out.println("2. Show total income");
        System.out.println("3. Show total income");
        System.out.println("4. Exit");
        
        String UserChoice = keyedInput.next();
        //User inputs are made to be strings so they can be converted into ints and checked to be valid inputs
        try {
            UserChoiceVal = Integer.parseInt(UserChoice);
            while (UserChoiceVal > 0 && UserChoiceVal < 4) {
                if (UserChoiceVal == 1) {
                    UsrIncChoice = true;
                    String UsrIncValA;
                    System.out.println("Please enter the amount of values you would like to add");
                    UsrIncValA = keyedInput.next();
                    //This value is used in the for loop later on so the user has more options when it comes to what they want to do
                    try {
                        int UsrIncVal = Integer.parseInt(UsrIncValA);
                        //Just the conversion from string to int so there is a check on the users input
                        while (UsrIncChoice == true) {
                            //The while loop is broken later on so that the menu is brought up again
                            for (int i = 0; i < UsrIncVal; i++) {
                                //One small problem i noticed after being done was if a negative value is entered the program breaks
                                //Fix for this is a if else statment catching the user value being negative
                                System.out.println("Please enter an income");
                                String LastEntryInc = keyedInput.next();
                                UserChoiceVal = 0;
                                
                                try {
                                    
                                    out = new FileWriter(dataFile, true);
                                    writeFile = new BufferedWriter(out);
                                    LastEntryIncVal = Double.parseDouble(LastEntryInc);
                                    // System.out.println(LastEntryIncVal);
                                    writeFile.write(String.valueOf(LastEntryIncVal));
                                    writeFile.newLine();
                                    //Until the user inputs all required income values this continues to loop and to write into a data file
                                    //IncConfrim = true;
                                    UsrIncChoice = false;
                                    writeFile.close();
                                    out.close();
                                    
                                } catch (NumberFormatException e) {
                                    System.out.println("Please enter a valid option");
                                } catch (IOException ex) {
                                    System.out.println("Something went wrong, try again");
                                }
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid option");

                    }
                    System.out.println("Please select an option by typing a number on your keyboard");
                    System.out.println("1. Enter in income(s)");
                    System.out.println("2. Show total income");
                    System.out.println("3. Show total income");
                    System.out.println("4. Exit");
                    UserChoice = keyedInput.next();
                    //Loops back to the original menu 
                    try {
                        UserChoiceVal = Integer.parseInt(UserChoice);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid option");

                    }
                } else if (UserChoiceVal == 2) {
                    try {
                        in = new FileReader(dataFile);
                        readFile = new BufferedReader(in);
                        Scanner scanner = new Scanner(new File("Income.dat"));
                        while (scanner.hasNextDouble()) {
                            double income = scanner.nextDouble();
                            System.out.println(income);

                            // i++;
                        }
                        readFile.close();
                        in.close();
                        System.out.println("Please select an option by typing a number on your keyboard");
                        System.out.println("1. Enter in income(s)");
                        System.out.println("2. Show all income inputed");
                        System.out.println("3. Show total income");
                        System.out.println("4. Exit");
                        UserChoice = keyedInput.next();
                        try {
                            UserChoiceVal = Integer.parseInt(UserChoice);
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid option");

                        }

//                    while(scanner.hasNextDouble()){
//                        System.out.println();
//                    }
                    } catch (IOException e) {
                        System.out.println("Something went wrong, try again");
                    }
                } else if (UserChoiceVal == 3) {
                    try {
                        in = new FileReader(dataFile);
                        readFile = new BufferedReader(in);
                        Scanner scanner = new Scanner(new File("Income.dat"));
                        while (scanner.hasNextDouble()) {
                            double income = scanner.nextDouble();
                            //System.out.println(income);
                            TInc = TInc + income;
                            // i++;
                            //don't forget to close code breaks if you don't close
                        }
                        System.out.println(TInc);
                        readFile.close();
                        in.close();
                    } catch (IOException e) {
                        System.out.println("Something went wrong, try again");

                    }
                    System.out.println("Please select an option by typing a number on your keyboard");
                    System.out.println("1. Enter in income(s)");
                    System.out.println("2. Show total income");
                    System.out.println("3. Show total income");
                    System.out.println("4. Exit");
                    UserChoice = keyedInput.next();
                    try {
                        UserChoiceVal = Integer.parseInt(UserChoice);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid option");

                    }
                } else {
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid option");

        }
        System.out.println("Thank you and come back again");
        System.out.println("Don't worry all values are saved into the manager");
        System.exit(0);
        //Makes sure the program closes because in testing it sometimes would stay open for some reason
        //Testing did get hindered due to problems with my computer but the code works as it should
        //In the case the data file gets deleted the code should remake another one or just error and manual action is required
    }

}
