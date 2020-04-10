package domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Program {
    private static final int MAX_NAME_LENGTH = 5;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String[] names;
    private static int times;

    public static void main(String[] args) throws Exception {
        if (!setupNames() || !setupTimes()) {
            return;
        }
        List<Car> cars = makeCars(names);
        playGame(cars, times);
        new Winner(cars).printWinner();
    }

    private static void playGame(List<Car> cars, int times) {
        System.out.println("실행 결과");
        while (times != 0) {
            for (Car car : cars) {
                car.moveCars();
                car.printResult();
            }
            times--;
            System.out.println(" ");
        }
    }

    private static boolean setupNames() throws Exception {
        names = inputNames();
        return checkNameLength(names);
    }

    private static boolean setupTimes() throws Exception {
        String inputTimes = inputTimes();
        if (!checkTimes(inputTimes)) {
            return false;
        }
        times = Integer.parseInt(inputTimes);
        return true;
    }

    private static String[] inputNames() throws Exception {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return br.readLine().split(",");
    }

    private static String inputTimes() throws Exception {
        System.out.println("시도할 회수는 몇회인가요?");
        return br.readLine();
    }

    private static boolean checkNameLength(String[] names) {
        for (String name : names) {
            if (name.length() > MAX_NAME_LENGTH) {
                System.out.println("이름은 5자 이하로 해주세요");
                return false;
            }
            if (name.length() == 0) {
                System.out.println("이름은 1글자 이상이어야 합니다");
                return false;
            }
        }
        return true;
    }

    private static boolean checkTimes(String times) {
        int value;
        try {
            value = Integer.parseInt(times);
        } catch (Exception e) {
            return false;
        }
        return value >= 0;
    }

    private static List<Car> makeCars(String[] names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}