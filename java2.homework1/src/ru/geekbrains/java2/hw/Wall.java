package ru.geekbrains.java2.hw;

public class Wall extends Barrier {

    private int heigth;

    public Wall(String name, int heigth) {
        super(name);

        this.heigth = heigth;
    }

    public int getHeigth() {
        return heigth;
    }

    @Override
    protected boolean moving(Actions actions) {
        System.out.println("Участок " + super.getName() + " высотой: " + this.heigth);

        actions.jump();

        if (getHeigth() <= actions.getJumpHeight()) {
            System.out.println("Отличный прыжок!");

            return true;
        } else {
            System.out.println("Не допрыгнул...");

            return false;
        }
    }
}
