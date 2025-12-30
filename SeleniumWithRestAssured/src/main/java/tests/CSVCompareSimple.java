package tests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.reactivex.rxjava3.internal.jdk8.SingleFlattenStreamAsFlowable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CSVCompareSimple {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        String file1 = "src/main/java/org/example/file1.csv";
        String file2 = "src/main/java/org/example/file2.csv";

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1));
             BufferedReader br2 = new BufferedReader(new FileReader(file2))) {

            String line1, line2;
            int lineNum = 1;
            boolean areEqual = true;

            while ((line1 = br1.readLine()) != null & (line2 = br2.readLine()) != null) {
                if (!line1.equals(line2)) {
                    System.out.println("Difference at line " + lineNum);
                    System.out.println("File1: " + line1);
                    System.out.println("File2: " + line2);
                    areEqual = false;
                }
                lineNum++;
            }

            if (areEqual) {
                System.out.println("✅ Both CSV files are identical.");
            } else {
                System.out.println("❌ Files differ.");
            }
        }
    }
}

/**
 * compare each column values
 */
class CSVReaderByField{


    public static void main(String[] args) {
        String file1 = "src/main/java/org/example/file1.csv";
        String file2 = "src/main/java/org/example/file2.csv";
        
        try(CSVReader reader1= new CSVReader(new FileReader(file1));
            CSVReader reader2= new CSVReader(new FileReader(file2));){
            List<String[]> c1 =  reader1.readAll();
            List<String[]> c2 = reader2.readAll();
            boolean isSame = true;

            if(c1.size() != c2.size()) isSame= false;

            for (int i = 0; i < Math.min(c1.size(),c2.size()); i++) {
                if(!Arrays.equals(c1.get(i),c2.get(i))){
                    System.out.println("Difference at line " + i+1);
                    System.out.println("File1: " + Arrays.toString(c1.get(i)));
                    System.out.println("File2: " + Arrays.toString(c2.get(i)));
                    isSame= false;
                }

            }
            if(!isSame){
                System.out.println("File is not same");
            }else System.out.println("File is same");


        } catch (CsvException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class CompareCSVByContentInside{
    public static void main(String[] args) throws IOException {
        String file1 = "src/main/java/org/example/file1.csv";
        String file2 = "src/main/java/org/example/file2.csv";

        List<String> lines1 = Files.readAllLines(Paths.get(file1));
        List<String> lines2 = Files.readAllLines(Paths.get(file2));

        boolean isSame =true;

        if(lines1.size()!= lines2.size()) isSame= false;

        Set<String> set1 = new HashSet<String>(lines1);
        Set<String> set2 = new HashSet<String>(lines2);

        if(set1.equals(set2))
            System.out.println("Files are equal");
        else
        {
            System.out.println("Files are not equal");
            System.out.println("Content of file 1 not present in file 2 :"+diff(set1,set2));
            System.out.println("Content of file 2 not present in file 1 :"+diff(set2,set1));
        }
    }

    private static Set<String> diff(Set<String> a, Set<String> b) {
        Set<String> diff = new HashSet<>(a);
        diff.removeAll(b);
        return diff;
    }
}