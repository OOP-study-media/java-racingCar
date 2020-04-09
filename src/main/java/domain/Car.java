package domain;

import java.util.Random;

class Car {
    private static final int RANGE = 10;
    private static final int MIN_FORWARD = 4;
    private final String name;
    private int position = 0;

    Car(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    int getPosition() {
        return position;
    }

    void moveCars() {
        if (randomNumber() >= MIN_FORWARD) {
            position++;
        }
    }

    private int randomNumber() {
        return new Random().nextInt(RANGE);
    }

    void printResult() {
        String result = name + ":" + "-".repeat(Math.max(0, position));
        System.out.println(result);
    }
}
