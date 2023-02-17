import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class version {
    public static void main(String[] args) throws Exception {
        int rate = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("What book would you like to read?");
        String filename = scanner.nextLine();
        System.out.println();
        System.out.print("What page would you like to start on?");
        int startpage = scanner.nextInt();
        System.out.println();
        System.out.print("What page would you like to end on?");
        int endpage = scanner.nextInt();
        System.out.println();
        System.out.print("Would you like: 1) input the pages/day or 2) the number of days you need to finish the book? ");
        int choice = scanner.nextInt();
        System.out.println();
        if(choice == 1){
            System.out.println("how many pages out you like to read a day?");
            rate = scanner.nextInt();
            printschedule(filename,rate,startpage, endpage);

        }
        else if (choice == 2){
            System.out.println("How many days do you want to finish the book in?");
            rate = scanner.nextInt();
            rate--;
            rate = (endpage - startpage) / rate;
            printschedule(filename,rate, startpage, endpage);
            
            
        }
        else{
            scanner.close();
            throw new Exception("You can only choose 1 or 2");
        }


        scanner.close();
    }
    public static void printschedule(String filename, int rate, int start, int end) throws Exception{
        int total = end - start;
        int days = total / rate;
        int balance = start;
        int temp = 0;
        File file = new File(filename + ".txt");
        if(!file.createNewFile()){
            throw new Exception("file already exists. Delete before proceding.");
        }
        for(int i = 1; i <= days; i++){
            String string = "for day " + i + ": Read" +  balance + " to " + (balance + rate - 1);
            balance += rate;
           // System.out.println(string);
            temp = i;
            write(file, string);
        }
        if(total % rate != 0){
            String string = "for day " + (temp + 1) + ": Read" +  balance + " to " + (end);
           // System.out.println(string);
            write(file, string);
        }
    }
    public static void write(File file, String string) throws IOException{
        FileWriter filewrite = new FileWriter(file,true);
        filewrite.append(string + "\n");
        filewrite.close();
    }
}
