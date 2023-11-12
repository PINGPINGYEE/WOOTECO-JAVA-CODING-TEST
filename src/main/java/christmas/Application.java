package christmas;

import christmas.domain.dateManage.Day;
import christmas.view.InputView;

import static christmas.domain.dateManage.Day.calculateDay;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        int date = inputView.readDate();

        // TODO: 추가적인 프로그램 구현
    }
}
