package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/18 9:44
 */
public class 加油站 {
    //用all来统计跑一圈后，在油箱可为负的情况下的剩余油量，若小于0，即代表不管从哪跑，油量总是消耗大于补给的
    //而如果大于等于0，那么在油箱负的最多的位置来看，后续的其他所有位置加起来看， 对他来说都是一个增益的，
    // 因为为了总体满足，需要其他位置有一定剩余油量来补齐这个位置的油量，又因为这个位置为统计所有值后的最小值，
    // 即在这个位置之后，连起来看，后续不管到哪个位置，都是对最小值进行增益的，既然有增益，那么说明其本身（最小值之后到任意位置）
    // 的剩余油量整体来看是始终>0的，因此在最小油量后的一个位置出发，总体都不会再出现为了到达下一个加油站而需要将油量减少到最小
    // 油量之下，即不需要去油箱最小油量之下继续扣取油量，来达到下一个位置
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int all = 0;
        int allmin = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            all = all + gas[i] - cost[i];
            if (all < allmin) {
                allmin = all;
                minIndex = i;
            }
        }
        return all < 0 ? -1 : ((minIndex + 1) % gas.length);
    }
}
