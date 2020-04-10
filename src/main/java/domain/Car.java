package domain;

import java.util.Random;

class Car {
    private static final int RANGE = 10;
    private static final int MIN_FORWARD = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveCars() {
        if (randomNumber() >= MIN_FORWARD) {
            position++;
        }
    }

    private int randomNumber() {
        return new Random().nextInt(RANGE);
    }

    public void printResult() {
        String result = name + ":" + "-".repeat(Math.max(0, position));
        System.out.println(result);
    }

    public boolean isMaxPosition(int max) {
        return position == max;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
