package domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Program {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int RANGE = 10;
    private static final int MIN_FORWARD = 4;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String[] names;
        int times;
        Car[] cars;

        names = inputNames();
        if (!checkNameLength(names)) {
            System.out.println("이름은 5자 이하로 해주세요");
            return;
        }

        cars = makeCars(names);
        times = inputTimes();

        System.out.println(" ");
        System.out.println("실행 결과");

        while (times != 0) {
            for (Car car : cars) {
                moveCars(car, randomNumber());
                car.printResult();
            }
            times--;
            System.out.println(" ");
        }
    }

    private static String[] inputNames() throws Exception {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return br.readLine().split(",");
    }

    private static int inputTimes() throws Exception {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(br.readLine());
    }

    private static boolean checkNameLength(String[] names) {
        for (String name : names) {
            if (name.length() > MAX_NAME_LENGTH) {
                return false;
            }
        }
        return true;
    }

    private static int randomNumber() {
        return new Random().nextInt(RANGE);
    }

    private static Car[] makeCars(String[] names) {
        Car[] cars = new Car[names.length];

        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
        return cars;
    }

    private static void moveCars(Car car, int random) {
        if (random >= MIN_FORWARD) {
            car.forward();
        }
    }
}