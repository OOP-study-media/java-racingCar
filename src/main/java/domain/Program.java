package domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Program {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int LAST_COMMA_LOCATION = 2;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String[] names = inputNames();
        int times;
        Car[] cars;

        if (!checkNameLength(names)) {
            System.out.println("이름은 5자 이하로 해주세요");
            return;
        }
        times = inputTimes();
        cars = makeCars(names);

        System.out.println("실행 결과");

        while (times != 0) {
            for (Car car : cars) {
                car.moveCars();
                car.printResult();
            }
            times--;
            System.out.println(" ");
        }
        printWinner(cars, getMaxCarPosition(cars));
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

    private static Car[] makeCars(String[] names) {
        Car[] cars = new Car[names.length];

        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
        return cars;
    }

    private static int getMaxCarPosition(Car[] cars) {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }

    private static void printWinner(Car[] cars, int max) {
        StringBuilder winner = new StringBuilder();
        for (Car car : cars) {
            if (car.getPosition() == max) {
                winner.append(car.getName()).append(", ");
            }
        }
        winner.delete(winner.length() - LAST_COMMA_LOCATION, winner.length());
        System.out.println(winner.append("가 최종 우승했습니다."));
    }

}