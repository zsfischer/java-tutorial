package hu.java.tutorial.alapok;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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
            out = new FileOutputStream("output.txt");

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

        //addig olvasunk be karaktereket a konzolról, ameddig q-t nem írunk
        InputStreamReader cin = null;

        try
        {
            cin = new InputStreamReader(System.in);
            System.out.println("Írj be egy karaktert, 'q'-t, ha ki akarsz lépni.");
            char c;
            do
            {
                c = (char) cin.read();
                System.out.print(c);
            }
            while (c != 'q');
        }
        finally
        {
            if (cin != null)
            {
                cin.close();
            }
        }

        //mappa létrehozása
        String dirname = "/teszt/almappa";
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
