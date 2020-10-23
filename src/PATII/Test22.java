package PATII;

import java.util.*;

/**
 * @author - Lx
 * @date - 2020/10/23 - 0:17
 * @Description:
 * 题目描述
 * 为了用事实说明挖掘机技术到底哪家强，PAT组织了一场挖掘机技能大赛。现请你根据比赛结果统计出技术最强的那个学校。
 *
 * 输入描述:
 * 输入在第1行给出不超过105的正整数N，即参赛人数。随后N行，每行给出一位参赛者的信息和成绩，包括其所代表的学校的编号、及其比赛成绩（百分制），中间以空格分隔。
 *
 *
 * 输出描述:
 * 在一行中给出总得分最高的学校的编号、及其总分，中间以空格分隔。题目保证答案唯一，没有并列。
 *
 * 输入例子:
 * 6
 * 3 65
 * 2 80
 * 1 100
 * 2 70
 * 3 40
 * 3 0
 *
 * 输出例子:
 * 2 150
 */
public class Test22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<Digger> list = new ArrayList<Digger>();
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i = 0;i < N;i++){
            list.add(new Digger(scanner.nextInt(),scanner.nextInt()));
        }
        scanner.close();
        Iterator<Digger> iterator = list.iterator();
        while (iterator.hasNext()){
            Digger digger = iterator.next();
            if(hashMap.containsKey(digger.schoolNum)){
                int current = hashMap.get(digger.schoolNum);
                hashMap.put(digger.schoolNum,current+digger.score);
            }else{
                hashMap.put(digger.schoolNum, digger.score);
            }
        }
        int topNum = 0;
        int topScore = 0;
        for( Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
                if(entry.getValue() > topScore){
                    topScore = entry.getValue();
                    topNum = entry.getKey();
                }
        }
        System.out.print(topNum+" "+topScore);
    }

}
class Digger{
    public int schoolNum;
    public int score;
    public Digger(int num,int score){
        this.schoolNum = num;
        this.score = score;
    }
}