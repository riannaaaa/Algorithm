package Leet.优先队列.移除石子使总数最小;

import java.util.PriorityQueue;

public class leet1962 {
    public int minStoneSum(int[] piles, int k) {
        int sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int i = 0; i < piles.length; i++) {
            queue.add(piles[i]);
            sum += piles[i];
        }
        int allCut = 0, max = 0;
        while (k > 0) {
            max = queue.poll();
            allCut += max/2;
            max = max - max/2;
            queue.add(max);
            k--;
        }
        return sum - allCut;
    }
}
