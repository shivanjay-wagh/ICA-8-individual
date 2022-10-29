import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author  Shivanjay Wagh
 * @version 1.0
 * @since   2022-1--28
 */
public class urinals {

    public static boolean goodString(String str) {  // checks to see if valid string
        if(str==null||str.length()==0||str.length()>=21||str.contains(" ")){
            return false;
        }
        for (int i=0; i<str.length()-1;i++){
            if (str.charAt(i)=='1' && str.charAt(i+1)=='1') {
                return false;
            }
        }
        return true;
    }

    public static int countUrinals(String str)
    {
        StringBuilder stringBuilder = new StringBuilder(str);
        int empty_Urinal = 0;
        if(stringBuilder.charAt(0) == '0' && stringBuilder.charAt(1) == '0') {
            stringBuilder.setCharAt(0, '1');
            empty_Urinal = empty_Urinal + 1;
        }
        for(int j = 1; j< str.length() -1; j++)
        {
            if(stringBuilder.charAt(j-1) == '0' && stringBuilder.charAt(j) == '0' &&
                    stringBuilder.charAt(j+1) == '0')
            {
                stringBuilder.setCharAt(j, '1');
                empty_Urinal = empty_Urinal + 1;
            }
        }
        if(stringBuilder.charAt(stringBuilder.length()-1) == '0' && stringBuilder.charAt(stringBuilder.length()-2) == '0')
        {
            stringBuilder.setCharAt(stringBuilder.length()-1, '1');
            empty_Urinal = empty_Urinal +1;
        }
        return empty_Urinal;
    }

    public  String file_reader() throws IOException {
        StringBuilder sb = new StringBuilder();
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL fileURL = classLoader.getResource("urinal.dat");
        if(fileURL != null)
        {
            File file = new File(fileURL.getFile());
            InputStream in = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + System.lineSeparator());
            }

        }
        return sb.toString();

    }

    public static void main(String[] args) throws IOException {
        urinals url = new urinals();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Manually Enter the String\n2. Provide file as Input ");
        int choice = scanner.nextInt();
        if(choice==1){
            System.out.println("Enter the string containing only 0s and 1s");
            String str = scanner.next();
            if (urinals.goodString(str)){
                System.out.println("Empty Urinals:"+urinals.countUrinals(str));
            } else {
                System.out.println("Inout String is Invalid!");
            }

        } else {
            StringBuilder stringBuilder = new StringBuilder();
            String[] str = url.file_reader().split(System.lineSeparator());
            for (String s: str){
                stringBuilder.append(urinals.countUrinals(s)+ System.lineSeparator());
            }
            Path path = Paths.get("resources/rule.txt");
            try {
                Files.write(path, Collections.singleton(stringBuilder.toString()),
                        StandardCharsets.UTF_8);
                System.out.println("Output has been generated successfully");
            }
            // Catch block to handle the exception
            catch (IOException ex) {
                System.out.print("Invalid Path");
            }
        }
    }
}
