package SimpleAlgorithm;
/**
 * @title: MazeRecall
 * @Author: Lux_er
 * @Date: 2021/3/21 0021 上午 10:04
 * @Description:
 */
public class MazeRecall {
    public static void main(String args[]){
        //先建立一个二维数组，模拟迷宫
        int[][] map = new int[8][7];
        //使用1表示墙
        //使上下全为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //使左右全为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] +" ");
            }
            System.out.println();
        }
        setWay(map, 1, 1);
        System.out.println("走过的地图");
        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] +" ");
            }
            System.out.println();
        }

    }
    //使用递归回溯给小球找路
    /**
     *@description:
     * @param map
     * @param i i,j表示从地图哪个位置开始出发
     * @param j
     *@return:boolean
     *@author:Administrator
     *@time:2021/3/21 0021 上午 10:26
     * 约定：当map[i][j]为0表示该点还没有走过，1表示为墙，2表示通路可以走，3表示该位置已经走过
     * 但是走不通
     * 当走到map[6][5]时到达终点
     * 走路策略：在走迷宫时，需要确定策略比如下->右->上->左
     */
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5] == 2){
            return true;
        }else{
            if(map[i][j] == 0){//如果当前这个点还没有走过
                //按照策略下->右->上->左走
                map[i][j] = 2;
                if(setWay(map, i+1, j)){//向下走
                    return true;
                }else if(setWay(map, i, j+1)){//向右走
                    return true;
                }else if(setWay(map, i-1, j)){//向上走
                    return true;
                }else if(setWay(map, i, j-1)){//向左走
                    return true;
                }else{
                    //说明该点走不通，死路
                    map[i][j] = 3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}
