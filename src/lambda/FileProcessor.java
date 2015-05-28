package lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by xiaomingniu on 28/05/15.
 */
public class FileProcessor {

    public static void main(String[] args) {
        try {
            System.out.println(processFile());
            System.out.println(processFile((BufferedReader br) -> br.readLine() + br.readLine() + br.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //only process first line
    public static String processFile() throws IOException {
        System.out.println("==before lambda");
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }


    //improve: reuse the processFile method
    @FunctionalInterface
    interface BufferProcessor {
        String process(BufferedReader b) throws IOException;
    }

    public static String processFile(BufferProcessor bufferProcessor) throws IOException {
        System.out.println("==after lambda");
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return bufferProcessor.process(br);
        }
    }
}
