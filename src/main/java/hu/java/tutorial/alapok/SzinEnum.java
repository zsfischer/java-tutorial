package hu.java.tutorial.alapok;

import java.util.Arrays;

//Enum =  felsoroló
//Enum-okat használunk arra, hogy (logikailag összetartozó) konstansok gyűjteményét egy helyen kezeljük
//enum kulcsszóval definiáljuk őket
public enum SzinEnum
{
    RED("piros"),
    BLUE("kék"),
    YELLOW("sárga"),
    ORANGE("narancssárga"),
    PURPLE("lila");

    private String ertek;

    SzinEnum(String ertek)
    {
        this.ertek = ertek;
    }

    public String getErtek()
    {
        return ertek;
    }

    public static void main(String[] args)
    {
        System.out.println(SzinEnum.BLUE);
        System.out.println(SzinEnum.ORANGE.getErtek());
        System.out.println(Arrays.toString(SzinEnum.values()));
        Arrays.stream(SzinEnum.values()).forEach(szinEnum -> System.out.println(szinEnum.getErtek()));
    }
}
