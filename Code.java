import java.io.*;

public class Code {
    public static void main(String[] args) throws IOException {
        String newFile = enc(args[0]);
        System.out.println("Enc: " + newFile);
//        String newFile2 = dec(args[0]);
//        System.out.println("Dec: " + newFile2);
    }

    private static String dec(String filename) throws IOException {
        String newFile = getNewFileName(filename);
        InputStream in = new FileInputStream(filename);
        OutputStream out = new FileOutputStream(newFile);
        int b;
        byte[] data = new byte[1024];
        while ((b = in.read(data)) != -1) {
            for (int i = 0; i < b; i++)
                data[i]--;
            out.write(data, 0, b);
        }
        out.close();
        in.close();
        return newFile;
    }

    private static String enc(String filename) throws IOException {
        String newFile = getNewFileName(filename);
        InputStream in = new FileInputStream(filename);
        OutputStream out = new FileOutputStream(newFile);
        int b;
        byte[] data = new byte[1024];
        while ((b = in.read(data)) != -1) {
            for (int i = 0; i < b; i++)
                data[i]++;
            out.write(data, 0, b);
        }
        out.close();
        in.close();
        return newFile;
    }

    private static String getNewFileName(String filename) {
        String extn = filename.substring(filename.lastIndexOf('.'));
        String filename_ = filename.substring(0, filename.lastIndexOf('.'));

        return filename_ + "_" + extn;
    }
}
