package Utils;

import Bean.Dist;
import Bean.GraphMartix;
import Bean.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Piweiii
 * @Date: 2020/09/07/20:29
 * @Description:
 */
public class PathCalculator {
    public List<Dist> Dijkstra(GraphMartix graphMartix,int start,int end){
        List<Dist> dists = new ArrayList<>();
        //以起点行，初始化dist数组
        for (int i = 0; i < graphMartix.NodeCount; i++) {
            Dist tempDist = new Dist();
            tempDist.setPreSopt(start);
            tempDist.setThisSopt(i);
            tempDist.setWeight(graphMartix.arcs[start][i]);
            dists.add(tempDist);
        }
        //准备一个selectedPositon数组，加入那些使Dist数组不断变化的结点
        List<Position> selectedPositons = new ArrayList<>();
        //首先加入起点
        selectedPositons.add(graphMartix.Vex.get(start));
        /*
        之前用顶点表对应的邻接矩阵初始化了Dist数组，现在Dist数组长度就是顶点表长度
        所以，当selectedPosition集合大小小于Dist数组时，证明Dijkstra算法没有完成
        需要继续添加顶点，演化Dist数组
         */
        while (selectedPositons.size() < dists.size()){
            //每次开始寻找最小权，都先将min和minWeight做一个初始化
            int min = 0; int minWeight = 9999999;
            //遍历整个Dist数组，才能找到最小权
            for (int i = 0; i < dists.size(); i++) {
                /*
                该循环的条件是：当该点的权值小于最小权，
                并且该点不在selectedPosition数组中，
                将其选作下一个待加入selectedPosition集合的元素，
                方法是改变min的下标。
                 */
                if(dists.get(i).getWeight() < minWeight &&
                        !selectedPositons.contains(graphMartix.Vex.get(i))){
                    min = i;
                    minWeight = dists.get(i).getWeight();
                }
            }
            /*
            退出for循环，证明找到了在之前演化之后的Dist数组中，最小的一个权值
            将该权值对应的顶点加入到selectedPosition中，表明将从该点，继续
            演化Dist数组
             */
            selectedPositons.add(graphMartix.Vex.get(min));
            for (int i = 0; i < dists.size(); i++) {
                if(dists.get(i).getWeight()
                        > minWeight + graphMartix.arcs[min][i]){
                    dists.get(i).setPreSopt(min);
                    dists.get(i).setWeight(minWeight + graphMartix.arcs[min][i]);
                }
            }
/*            //打印Dist数组的演化过程
            for (int i = 0; i < dists.size(); i++) {
                System.out.print("("+dists.get(i).getPreSopt()+
                        ","+dists.get(i).getThisSopt()+")"+
                        dists.get(i).getWeight()+"  ");
            }
            System.out.println();*/
        }
        List<Position> rightWay = new ArrayList<>();
        int from = start,
            toWhere = end;
        rightWay.add(graphMartix.Vex.get(toWhere));
        while (from != toWhere){
            rightWay.add(graphMartix.Vex.get(dists.get(toWhere).getPreSopt()));
            toWhere = dists.get(toWhere).getPreSopt();
        }
        for (int i = rightWay.size() - 1; i >= 0; i--) {

            if(i == 0){
                System.out.println(rightWay.get(i).getName());
            }else {
                System.out.print(rightWay.get(i).getName()+"-->");
            }

        }
        return dists;
    }
}
