package Other.Zuo.Base.Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @title: BestArrange
 * @Author: Lux_er
 * @Date: 2021/4/22 0022 上午 10:42
 * @Description:
 */
public class BestArrange {
    public static class Program{
        // 会议开始时间和结束时间
        public int start;
        public int end;
        
        public Program(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    public static class ProgramComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }
    // 按照会议结束时间来贪心
    public static int bestArrange(Program[] programs,int timePoint){
        Arrays.sort(programs,new ProgramComparator());
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if(timePoint <= programs[i].start){
                result++;
                timePoint = programs[i].end;
            }
        }
        return result;
    }
}
