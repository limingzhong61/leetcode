package lmz.algorithm.other.old.easy.old;

public class FlipLights672 {
    public int flipLights(int n, int presses) {
        if (presses > 2 && n > 2) return 8;
        if (n < 3) return 1 + (presses > 0 ? 1 : 0) * n + (presses > 1 && n > 1 ?  1 : 0);
        else return 1 + 3 * presses;
    }
}
