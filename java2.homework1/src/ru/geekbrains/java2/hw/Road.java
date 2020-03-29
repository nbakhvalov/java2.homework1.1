package ru.geekbrains.java2.hw;

public class Road extends Barrier {
    private int length;

    public Road(String name, int length) {
        super(name);

        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    protected boolean moving(Actions actions) {
        System.out.println("Участок " + super.getName() + " длинной: " + this.length);

        actions.run();

        if (getLength() <= actions.getRunDistance()) {
            System.out.println("Отлично пробежал!");

            return true;
        } else {
            System.out.println("Не добежал...");

            return false;
        }
    }
}