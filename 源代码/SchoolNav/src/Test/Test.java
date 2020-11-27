package Test;

import Bean.Dist;
import Bean.GraphMartix;
import Bean.Position;
import Utils.PathCalculator;
import Utils.PositionIniter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Piweiii
 * @Date: 2020/09/08/21:12
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        PositionIniter psit = new PositionIniter();
        List<Position> positions = psit.initPos();
        GraphMartix graphMartix = new GraphMartix(positions);
        PathCalculator pclr = new PathCalculator();
        List<Dist> dists = pclr.Dijkstra(graphMartix,3,0);
        for (int i = 0; i < graphMartix.Vex.size(); i++) {
            Position temp = graphMartix.Vex.get(i);
            System.out.println("ID:"+temp.getId());
            System.out.println("名称:"+temp.getName());
            System.out.println("介绍:"+temp.getIntro());
        }
        for (int i = 0; i < graphMartix.NodeCount; i++) {
            for (int j = 0; j < graphMartix.NodeCount; j++) {
                if(j == graphMartix.NodeCount - 1){
                    System.out.println(graphMartix.arcs[i][j]);
                }else {
                    System.out.print(graphMartix.arcs[i][j]+" ");
                }
            }
        }
        System.out.println("dist数组初始化测试");
        for (int i = 0; i < dists.size(); i++) {
            System.out.println("pre:"+dists.get(i).getPreSopt()+
                               " this:"+dists.get(i).getThisSopt()+
                               " weight:"+dists.get(i).getWeight());
        }

    }
}
