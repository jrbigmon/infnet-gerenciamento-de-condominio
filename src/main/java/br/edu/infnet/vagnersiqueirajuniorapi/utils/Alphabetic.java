package br.edu.infnet.vagnersiqueirajuniorapi.utils;

import java.util.ArrayList;
import java.util.List;

public class Alphabetic {
    public static List<String> list() {
        return new ArrayList<>(
                List.of(
                        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
                        "T", "U", "V", "W", "X", "Y", "Z"
                ));
    }

    public static String get(Integer index) {
        return list().get(index);
    }
}
