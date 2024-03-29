package hu.java.tutorial.alapok;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//I/O (Input/Output) műveletek végrehajtása Java-ban
public class IO
{
    public static void main(String[] args) throws IOException
    {
        //a Stream az egy adatfolyam
        //2 féle stream van:
        //InPutStream - arra használjuk, hogy egy forrásból beolvassunk adatot
        //OutPutStream - arra használjuk, hogy egy bizonyos forrásba beleírjunk adatot

        //arra használjuk, hogy adatokat olvassunk file-ból
        FileInputStream in = null;
        //file-ba kiírásra használjuk
        FileOutputStream out = null;

        try
        {
            //beolvassuk az input.txt fileból az adatokat, és beleírjuk az output.txt-be
            in = new FileInputStream("input.txt");
            out = new FileOutputStream(new File("output.txt"));

            int c;
            while ((c = in.read()) != -1)
            {
                out.write(c);
            }
        }
        finally
        {
            if (in != null)
            {
                in.close();
            }
            if (out != null)
            {
                out.close();
            }
        }

//        //addig olvasunk be karaktereket a konzolról, ameddig q-t nem írunk
//        InputStreamReader cin = null;
//
//        try
//        {
//            cin = new InputStreamReader(System.in);
//            System.out.println("Írj be egy karaktert, 'q'-t, ha ki akarsz lépni.");
//            char c;
//            do
//            {
//                c = (char) cin.read();
//                System.out.print(c);
//            }
//            while (c != 'q');
//        }
//        finally
//        {
//            if (cin != null)
//            {
//                cin.close();
//            }
//        }

        try(BufferedReader br = new BufferedReader(new FileReader("etterem.txt")))
        {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }

            List<String> lines = Files.readAllLines(Paths.get("etterem.txt"));
            lines.forEach(System.out::println);
        }
        catch (Exception e)
        {
            System.out.println("Hiba");
        }

        //mappa létrehozása
        String dirname = "teszt/almappa";
        File d = new File(dirname);

        //mkdirst() metódus hozza létre a mappa szerekezetet
        boolean mkdirs = d.mkdirs();
        if (mkdirs)
        {
            System.out.println("/teszt/almappa sikeresen létrehozva");
        }
        else
        {
            System.out.println("/teszt/almappa létrehozása sikertelen");
        }
    }
}
