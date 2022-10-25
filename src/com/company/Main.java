package com.company;

import ibcsutils.ReadViaURL;

public class Main
{
// The word list is not in alphabetical order anymore, see screenshot in wpp
    public static void main(String[] args)
    {
        String addr = "https://www-personal.umich.edu/~jlawler/wordlist";

        // read, remove punctuation and digits, to lowercase
        String[] words = ReadViaURL.readWords(addr, true, true, true);

        //String[] test = {"beo", "bra", "bye", "hi", "no", "yes"};
        String key = "bra";

        // sequential search
        /*
        System.out.println("Sequential search");

        boolean foundS = false;

        int i = 0;
        while (!foundS && i != words.length - 1)
        {
            for (; i < words.length; i++)
            {
                if (words[i].compareTo(key) == 0)
                {
                    foundS = true;
                    System.out.print("index: " + i + ", ");
                }
            }
        }
        System.out.println(foundS);

*/
        // binary search
        System.out.println();
        System.out.println("Binary search");

        boolean foundB = false;
        int min = 0, max = words.length - 1;

        while (!foundB && min <= max)
        {
            int half = (min + max) / 2;
            int compare = words[half].compareTo(key);

            if (compare == 0)
                foundB = true;
            else if(compare > 0)
                max = half - 1;
            else
                min = half + 1;
            System.out.println(words[half] + " " + half);
        }
        System.out.println(foundB);

    }
}
