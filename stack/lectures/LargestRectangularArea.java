package stack.lectures;

import java.util.List;

public class LargestRectangularArea {
    public static int execute(int[] hist) {
        List<Integer> pse = PreviousSmallerElement.execute(hist);
        List<Integer> nse = NextSmallerElement.execute(hist);

        System.out.println(pse);
        System.out.println(nse);

        int res = 0;
        for (int i = 0; i < hist.length; i++) {
            int area = hist[i] * (nse.get(i) - pse.get(i) + 1);
            res = Math.max(res, area);
        }

        return res;
    }

    public static int execute1(int[] hist) {
        int res = 0;
        for (int i = 0; i < hist.length; i++) {
            int pse = 0;
            int nse = hist.length - 1;

            for (int j = i - 1; j >= 0; j--) {
                if (hist[j] < hist[i]) {
                    pse = j + 1;
                    break;
                }
            }

            for (int j = i + 1; j < hist.length; j++) {
                if (hist[j] < hist[i]) {
                    nse = j - 1;
                    break;
                }
            }

            int area = hist[i] * (nse - pse + 1);
            res = Math.max(area, res);
        }

        return res;
    }

    public static int execute2(int[] hist) {
        int res = 0;
        for (int i = 0; i < hist.length; i++) {
            int area = hist[i];

            for (int j = i - 1; j >= 0; j--) {
                if (hist[j] >= hist[i]) {
                    area += hist[i];
                } else {
                    break;
                }
            }

            for (int j = i + 1; j < hist.length; j++) {
                if (hist[j] >= hist[i]) {
                    area += hist[i];
                } else {
                    break;
                }
            }

            res = Math.max(area, res);
        }

        return res;
    }
}