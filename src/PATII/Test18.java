package PATII;

import java.util.*;

/**
 * @author - Lx
 * @date - 2020/10/22 - 20:55
 * @Description:
 * 题目描述
 * 某城镇进行人口普查，得到了全体居民的生日。现请你写个程序，找出镇上最年长和最年轻的人。
 *
 * 这里确保每个输入的日期都是合法的，但不一定是合理的——假设已知镇上没有超过200岁的老人，而今天是2014年9月6日，所以超过200
 * 岁的生日和未出生的生日都是不合理的，应该被过滤掉。
 *
 * 输入描述:
 * 输入在第一行给出正整数N，取值在(0, 105]；随后N行，每行给出1个人的姓名（由不超过5个英文字母组成的字符串）、以及
 * 按“yyyy/mm/dd”（即年/月/日）格式给出的生日。题目保证最年长和最年轻的人没有并列。
 *
 *
 * 输出描述:
 * 在一行中顺序输出有效生日的个数、最年长人和最年轻人的姓名，其间以空格分隔。
 *
 * 输入例子:
 * 5
 * John 2001/05/12
 * Tom 1814/09/06
 * Ann 2121/01/30
 * James 1814/09/05
 * Steve 1967/11/20
 *
 * 输出例子:
 * 3 Tom John
 */
public class Test18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<Man> list = new ArrayList<Man>();
        for(int i = 0;i < N;i++){
            String name = scanner.next();
            String[] str = scanner.next().split("\\/");
            int birth = Integer.parseInt(str[0])*10000+Integer.parseInt(str[1])*100
                    +Integer.parseInt(str[2]);
            if(birth > 20140906 || birth < 18140906){
                continue;
            }
            list.add(new Man(name,birth));
        }
        list.sort(new Comparator<Man>() {
            @Override
            public int compare(Man o1, Man o2) {
                if(o1.getBirth() > o2.getBirth()){
                    return -1;
                }else if(o1.getBirth() == o2.getBirth()){
                    return 0;
                }else {
                    return 1;
                }
            }
        });
        Man oldest = list.get(list.size()-1);
        Man youngest = list.get(0);
        System.out.println(list.size()+" "+oldest.getName()+" "+youngest.getName());
    }
}
class Man{
    private String name;
    private int birth;
    public Man(String name,int birth){
        this.name = name;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }
}