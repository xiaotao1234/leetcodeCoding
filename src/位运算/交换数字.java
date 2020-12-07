package 位运算;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/28 22:15
 */
public class 交换数字 {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];
        return numbers;
    }
}
