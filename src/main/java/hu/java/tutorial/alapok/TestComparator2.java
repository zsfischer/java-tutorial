package hu.java.tutorial.alapok;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestComparator2 implements Comparator<String>
{
    @Override
    public int compare(String test1, String test2)
    {
        return test2.compareTo(test1);
    }
}
