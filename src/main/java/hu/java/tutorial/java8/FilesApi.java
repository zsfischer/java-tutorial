package hu.java.tutorial.java8;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesApi
{
    @SuppressWarnings("unused")
    public static void main(String[] args) throws IOException
    {
        byte[] content = Files.readAllBytes(Paths.get("tstfile.txt"));
        System.out.println(new String(content));

        boolean isDir = Files.isDirectory(Paths.get("src"));

        Files.readAllLines(Paths.get("tstfile.txt")).forEach(System.out::println);

        Files.write(Paths.get("tstfile_out.txt"), "Hellow Java8 World out!".getBytes());

        // copy with "try with resources"
        try (ByteArrayOutputStream out = new ByteArrayOutputStream())
        {
            Files.copy(Paths.get("tstfile.txt"), out);
            System.out.println(new String(out.toByteArray()));
        }

        // Files.createDirectory(dir, attrs)
        // Files.createFile(path, attrs)
    }
}
