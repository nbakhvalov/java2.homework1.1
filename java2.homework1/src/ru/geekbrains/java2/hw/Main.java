package ru.geekbrains.java2.hw;

import java.util.Random;
/*
*   Author Nikolay Bakhvalov
*
*
*    1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
*    Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
*
*    2. Создайте два класса: беговая дорожка и стена, при прохождении через которые,
*    участники должны выполнять соответствующие действия (бежать или прыгать),
*    результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
*
*    3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
*
*    4. У препятствий есть длина (для дорожки) или высота (для стены),
*    а участников ограничения на бег и прыжки. Если участник не смог пройти одно из препятствий,
*    то дальше по списку он препятствий не идет.
*
 */


public class Main {
    public static void main(String[] args) {


        Random rnd = new Random();
        Actions[] actions = new Actions[3];

        int distance = rnd.nextInt(10);
        int heigth = rnd.nextInt(10);
        actions[0] = new Human("Жора", distance, heigth);

        distance = rnd.nextInt(10);
        heigth = rnd.nextInt(10);
        actions[1] = new Robot("Бендер", distance, heigth);

        distance = rnd.nextInt(10);
        heigth = rnd.nextInt(10);
        actions[2] = new Cat("Матроскин", distance, heigth);

        Barrier[] barriers = new Barrier[7];

        boolean isRoad;
        for (int i = 1; i < barriers.length; i++) {
            distance = rnd.nextInt(10);
            isRoad = rnd.nextBoolean();
            if (isRoad) {
                barriers[i] = new Road("Беговая дорожка " + i, distance);
            } else {
                barriers[i] = new Wall("Стена " + i, distance);
            }
        }

        for (int i = 0; i < actions.length; i++) {
            boolean result = true;
            for (int j = 1; j < barriers.length; j++) {


                result = barriers[j].moving(actions[i]);

                if (!result) {
                    break;
                }
            }

            if (result) {
                System.out.println("Отлично, продолжаем!");
            } else {
                System.out.println("Запорол...");
            }
        }
    }
}