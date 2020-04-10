package domain;

import java.util.List;

class Winner {
    private static final int LAST_COMMA_LOCATION = 2;
    private List<Car> cars;

    Winner(List<Car> cars) {
        this.cars = cars;
    }

    private int getMaxCarPosition() {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }

    void printWinner() {
        StringBuilder winner = new StringBuilder();
        int max = getMaxCarPosition();

        for (Car car : cars) {
            if (car.isMaxPosition(max)) {
                winner.append(car.getName()).append(", ");
            }
        }
        winner.delete(winner.length() - LAST_COMMA_LOCATION, winner.length());
        System.out.println(winner.append("가 최종 우승했습니다."));
    }
}
