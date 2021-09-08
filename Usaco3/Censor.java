import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Censor {
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("censor.in"));
            String fullStr = scanner.nextLine();
            String censor = scanner.nextLine();
            int length = censor.length();
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < fullStr.length(); i++) {
                builder.append(fullStr.charAt(i));
                if(builder.length() >= censor.length()) {
                    if(builder.subSequence(builder.length() - censor.length(),builder.length()).equals(censor)) {
                        builder.replace(builder.length() - censor.length(),builder.length(),"");
                    }
                }
            }
            System.out.println(builder);
        } catch(Exception e) {
            System.out.println("builder");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("censor.out");
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Censor censor = new Censor();
        censor.read();
    }
}
