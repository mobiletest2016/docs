import java.io.*;

public class Code {
    public static void main(String[] args) throws IOException {
        String newFile = enc(args[0]);
        System.out.println("Enc: " + newFile);
//        String newFile2 = dec(args[0]);
//        System.out.println("Dec: " + newFile2);
    }

    private static String dec(String filename) throws IOException {
        String newFile = filename.replace(".pdf", "_.pdf");
        InputStream in = new FileInputStream(filename);
        OutputStream out = new FileOutputStream(newFile);
        int b;
	byte[] data = new byte[1024];
        while((b = in.read(data)) != -1) {
	    for(int i = 0; i < b; i++)
		    data[i]--;
            out.write(data, 0, b);
        }
        out.close();
        in.close();
        return newFile;
    }

    private static String enc(String filename) throws IOException {
        String newFile = filename.replace(".pdf", "_.pdf");
        InputStream in = new FileInputStream(filename);
        OutputStream out = new FileOutputStream(newFile);
        int b;
	byte[] data = new byte[1024];
        while((b = in.read(data)) != -1) {
	    for(int i = 0; i < b; i++)
		    data[i]++;
            out.write(data, 0, b);
        }
        out.close();
        in.close();
        return newFile;
    }
}
