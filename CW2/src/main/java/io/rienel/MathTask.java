package io.rienel;

/**
 * todo armotozov
 *
 * @author Artem Motozov
 * @since 2022.09.24
 */
public class MathTask implements Runnable {

    public int a;
    public int b;
    public double sum;

    @Override
    public void run() {
        for (int i = a; i <= b; i++) {
            sum += Math.pow(i, 2.0/3.0);
        }
    }
}
