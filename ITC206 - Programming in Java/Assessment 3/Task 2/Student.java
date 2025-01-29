import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;;

public class exam {

    public static void main(String[] args) {
        File file = new File ("Java1.txt");
        PrintWriter output = new PrintWriter(file);
        output.println("ITC206BI");
        output.println("ITC206BDD");
        output.println("ITC538BD");
        output.close();
        Scanner input = new Scanner(file);
        while (input.hasNext()){
            String s1 = input.nextLine();
            System.out.println(s1);
        }
        input.close();
    }
}