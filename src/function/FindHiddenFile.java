package function;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.stream.Stream;

/**
 * Created by xiaomingniu on 27/05/15.
 */
public class FindHiddenFile {
    public static void main(String[] args) {
        FindHiddenFile findHiddenFile = new FindHiddenFile();
        findHiddenFile.runPriorJava8();
        findHiddenFile.runInJava8();

    }

    private void runPriorJava8() {
        File[] files = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        for(File f : files) {
            System.out.println(f.getName());
        }
    }


    private void runInJava8() {
        File[] files = new File(".").listFiles(File::isHidden);

        //todo
        for(File f : files) {
            System.out.println(f.getName());
        }

    }
}
