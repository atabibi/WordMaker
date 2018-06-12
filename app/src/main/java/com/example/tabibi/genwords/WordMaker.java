package com.example.tabibi.genwords;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class WordMaker {
    public static ArrayList<String> getWords(String str, int n){
        switch (n) {
            case 1:
                return getWordsWith1Char(str);
            case 2:
                return getWordsWith2Char(str);
            case 3:
                return getWordsWith3Char(str);
            case 4:
                return getWordsWith4Char(str);
            case 5:
                return getWordsWith5Char(str);
            case 6:
                return getWordsWith6Char(str);
        }

        return new ArrayList<>();
    }


    private static ArrayList<String> getWordsWith6Char(String str) {
        ArrayList<String> words = new ArrayList<String>();

        for (int k1=0;k1 < str.length();k1++) {
            for (int k2=0;k2 < str.length();k2++) {
                if (k1 == k2)
                    continue;
                for (int k3=0;k3 < str.length();k3++) {
                    if (k3==k1 || k3==k2)
                        continue;
                    for (int k4=0;k4 < str.length();k4++) {
                        if (k4==k1 || k4==k2 || k4==k3)
                            continue;
                        for (int k5=0;k5 < str.length();k5++) {
                            if (k5 == k1 || k5 == k2 || k5 == k3 || k5 == k4)
                                continue;
                            for (int k6=0;k6 < str.length();k6++) {
                                if (k6 == k1 || k6 == k2 || k6 == k3 || k6 == k4 || k6 == k5)
                                    continue;
                                words.add("" + str.charAt(k1) + str.charAt(k2) + str.charAt(k3) + str.charAt(k4) + str.charAt(k5)+ str.charAt(k6));
                            }
                        }
                    }
                }
            }
        }

        return words;
    }

    private static ArrayList<String> getWordsWith5Char(String str) {
        ArrayList<String> words = new ArrayList<>();

        for (int k1=0;k1 < str.length();k1++) {
            for (int k2=0;k2 < str.length();k2++) {
                if (k1 == k2)
                    continue;
                for (int k3=0;k3 < str.length();k3++) {
                    if (k3==k1 || k3==k2)
                        continue;
                    for (int k4=0;k4 < str.length();k4++) {
                        if (k4==k1 || k4==k2 || k4==k3)
                            continue;
                        for (int k5=0;k5 < str.length();k5++) {
                            if (k5 == k1 || k5 == k2 || k5 == k3 || k5 == k4)
                                continue;
                            words.add("" + str.charAt(k1) + str.charAt(k2)+ str.charAt(k3)+ str.charAt(k4)+ str.charAt(k5));
                        }
                    }
                }
            }
        }

        return words;
    }

    private static ArrayList<String> getWordsWith4Char(String str) {
        ArrayList<String> words = new ArrayList<>();

        for (int k1=0;k1 < str.length();k1++) {
            for (int k2=0;k2 < str.length();k2++) {
                if (k1 == k2)
                    continue;
                for (int k3=0;k3 < str.length();k3++) {
                    if (k3==k1 || k3==k2)
                        continue;
                    for (int k4=0;k4 < str.length();k4++) {
                        if (k4==k1 || k4==k2 || k4==k3)
                            continue;
                        words.add("" + str.charAt(k1) + str.charAt(k2)+ str.charAt(k3)+ str.charAt(k4));
                    }
                }
            }
        }

        return words;
    }

    private static ArrayList<String> getWordsWith3Char(String str) {
        ArrayList<String> words = new ArrayList<>();


        for (int k1=0;k1 < str.length();k1++) {
            for (int k2=0;k2 < str.length();k2++) {
                if (k1 == k2)
                    continue;
                for (int k3=0;k3 < str.length();k3++) {
                    if (k3==k1 || k3==k2)
                        continue;
                    words.add("" + str.charAt(k1) + str.charAt(k2)+ str.charAt(k3));
                }
            }
        }

        return words;
    }

    private static ArrayList<String> getWordsWith2Char(String str) {
        ArrayList<String> words = new ArrayList<>();

        for (int k1=0;k1 < str.length();k1++) {
            for (int k2=0;k2 < str.length();k2++) {
                if (k1 == k2)
                    continue;

                words.add("" + str.charAt(k1) + str.charAt(k2));
            }
        }

        return words;
    }

    private static ArrayList<String> getWordsWith1Char(String str) {
        ArrayList<String> words = new ArrayList<>();

        for (int k1=0;k1 < str.length();k1++) {
            words.add("" + str.charAt(k1));
        }

        return words;
    }

}
