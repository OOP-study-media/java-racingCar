package domain;

class Car {
    private final String name;
    private int position = 0;

    Car(String name) {
        this.name = name;
    }

    void forward() {
        position++;
    }

    void printResult() {
        String result = name + ":" +
                "-".repeat(Math.max(0, position));

        System.out.println(result);
    }
}
