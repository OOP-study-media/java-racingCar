package domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Program {
    private static final int MAX_NAME_LENGTH = 5;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] names;
        int times;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        names = br.readLine().split(",");
        if (!nameLengthCheck(names)) {
            return;
        }

        System.out.println("시도할 회수는 몇회인가요?");
        times = Integer.parseInt(br.readLine());

    }

    private static boolean nameLengthCheck(String[] names) {
        for (String name : names) {
            if (name.length() > MAX_NAME_LENGTH) {
                return false;
            }
        }
        return true;
    }

}
