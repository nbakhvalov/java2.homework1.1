package ru.geekbrains.java2.hw3;




/*
*   @Author Nikolay Bakhvalov
*
*   1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
*    Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
*    Посчитать сколько раз встречается каждое слово.
*   2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
*    В этот телефонный справочник с помощью метода add() можно добавлять записи.
*    С помощью метода get() искать номер телефона по фамилии. Следует учесть,
*    что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
*    тогда при запросе такой фамилии должны выводиться все телефоны.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {

    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {

        String[] words = {"Word7", "Word2", "Word6", "Word3", "Word1", "Word4",
                "Word1", "Word4", "Word2", "Word7", "Word2", "Word6",
                "Word3", "Word1", "Word4", "Word1", "Word4", "Word9"};

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);

    }

    private static void task2() {
        Directory directory = new Directory();

        directory.add("Friend1", "1235");
        directory.add("Friend2", "1234");
        directory.add("Friend3", "1237");
        directory.add("Friend4", "1323");
        directory.add("Friend1", "1233");
        directory.add("Friend2", "3214");
        directory.add("Friend3", "6542");
        directory.add("Friend4", "1286");
        directory.add("Friend3", "6664");

        System.out.println(directory.get("Friend1"));
        System.out.println(directory.get("Friend2"));
        System.out.println(directory.get("Friend3"));
        System.out.println(directory.get("Friend4"));
    }
}

class Directory {
    private Map<String, List<String>> directory_hm = new HashMap<>();
    private List<String> phone_number_list;

    public void add(String surname, String phone_number) {
        if (directory_hm.containsKey(surname)) {
            phone_number_list = directory_hm.get(surname);
            phone_number_list.add(phone_number);
            directory_hm.put(surname, phone_number_list);
        } else {
            phone_number_list = new ArrayList<>();
            phone_number_list.add(phone_number);
            directory_hm.put(surname, phone_number_list);
        }
    }

    public List<String> get(String surname) {
        return directory_hm.get(surname);
    }

}

