import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //This defines the running total variable.
        double runningTotal = 0;
        //This opens the items.txt file to be read.
        File input = new File("C:\\Users\\samal\\IdeaProjects\\Total Calculation\\src\\items.txt");
        //This tries the following.
        try {
            //This adds a new scanner for the items.txt file.
            Scanner sc = new Scanner(input);
            //This does the following while there are doubles to be read in.
            while (sc.hasNextDouble()) {
                //This adds the next number to the running total.
                runningTotal = runningTotal + sc.nextDouble();
            }
            //If there is an error, the program does the following.
        } catch (FileNotFoundException e) {
            //this prints out an error message.
            System.out.println("The file is not found. Please try again later.");
        }
        //This defines a new file as the output, total.txt.
        File file = new File("total.txt");
        //This tries the following.
        try {
            //This creates a new file.
            file.createNewFile();
            //This does the following if there is an error.
        } catch (IOException e) {
            //This prints out the error message.
            System.out.println(e.getMessage());
        }
        //This uses a decimal format tool to limit future variables to 2 decimal places.
        DecimalFormat decimalLimiter = new DecimalFormat("#.00");
        //This calculates the subtotal to multiple decimal places.
        double notFormattedSubtotal = runningTotal;
        //This calculates the sales tax to multiple decimal places.
        double notFormattedSalesTax = notFormattedSubtotal * 0.053;
        //This calculates the total to multiple decimal places.
        double notFormattedTotal = notFormattedSubtotal + notFormattedSalesTax;
        //This defines the final subtotal as the subtotal to 2 decimal places.
        double subtotal = Double.parseDouble(decimalLimiter.format(notFormattedSubtotal));
        //This defines the final sales tax as the sales tax to 2 decimal places.
        double salesTax = Double.parseDouble(decimalLimiter.format(notFormattedSalesTax));
        //This defines the final total as the total to 2 decimal places.
        double total = Double.parseDouble(decimalLimiter.format(notFormattedTotal));
        //This tries the following.
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            //This adds the subtotal to the file.
            fileWriter.write("Your subtotal is $" + subtotal);
            //This adds a new line.
            fileWriter.write("\n");
            //This adds the tax to the file.
            fileWriter.write("I apologize, but we are legally required to tax you $" + salesTax);
            //This adds a new line.
            fileWriter.write("\n");
            //This adds the total to the file.
            fileWriter.write("Your total comes to $" + total);
            //This does the following if there is an error.
        } catch (IOException e) {
            //This notifies the user that there was an error and asks for money in compensation.
            System.out.println("There was an error while calculating your dues. Please leave your credit card and we will charge you monthly.");
        }
        //This prints out the finishing message to the user.
        System.out.println("We have finished calculating your dues. Please open the file and pay them.");
    }
}