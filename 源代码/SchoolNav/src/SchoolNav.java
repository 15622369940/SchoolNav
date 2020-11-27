import Bean.GraphMartix;
import Bean.Position;
import Utils.PathCalculator;
import Utils.PositionIniter;

import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Piweiii
 * @Date: 2020/09/07/16:39
 * @Description:
 */
public class SchoolNav {
    public static void main(String[] args) {
        PositionIniter psit = new PositionIniter();
        List<Position> positions = psit.initPos();
        GraphMartix graphMartix = new GraphMartix(positions);
        PathCalculator pclr = new PathCalculator();
        Scanner sc = new Scanner(System.in);
        int choice = 0,
            start = 0,
            end = 0;
        while (true){
            System.out.println("=================欢迎使用河海大学校园导航系统==================");
            System.out.println("|****************   0.退出系统            ****************|");
            System.out.println("|****************   1.查询所有地点         ****************|");
            System.out.println("|****************   2.输入地点名称查询信息  ****************|");
            System.out.println("|****************   3.查询某两点的最短路径  ****************|");
            System.out.println("==========================================================");
            System.out.println("输入功能序号：");
            choice = sc.nextInt();
            switch (choice){
                case 0:
                    System.out.println("感谢您的使用");
                    return;
                case 1:
                    getAllPosition(graphMartix);
                    break;
                case 2:
                    getInfo(graphMartix);
                    break;
                case 3:
                    System.out.println("输入起点：");
                    String from = sc.next();
                    System.out.println("输入终点：");
                    String toWhere = sc.next();
                    start = convert(graphMartix,from);
                    end = convert(graphMartix,toWhere);
                    pclr.Dijkstra(graphMartix,start,end);
            }
        }
    }
    public static void getAllPosition(GraphMartix graphMartix){
        System.out.println("所有地点的信息如下：");
        for (int i = 0; i < graphMartix.Vex.size(); i++) {
            Position temp = graphMartix.Vex.get(i);
            System.out.println("ID:"+temp.getId());
            System.out.println("名称:"+temp.getName());
            System.out.println("介绍:"+temp.getIntro());
        }
        return;
    }

    public static void getInfo(GraphMartix graphMartix){
        String Name = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("输入你要查询的地点名称：");
        Name = sc.next();
        int mark = 0;
        Position temp = new Position();
        for (int i = 0; i < graphMartix.Vex.size(); i++) {
            temp = graphMartix.Vex.get(i);
            if (temp.getName().equals(Name)){
                mark = 1;
                break;
            }
        }
        if(mark == 1){
            System.out.println("您查找的地点是："+temp.getName());
            System.out.println("ID:"+temp.getId());
            System.out.println("名称:"+temp.getName());
            System.out.println("介绍:"+temp.getIntro());
            return;
        }else {
            System.out.println("未找到指定地点，请检查输入是否正确");
            System.out.println("您的输入是："+Name);
            return;
        }
    }

    public static int convert(GraphMartix graphMartix,String Name){
        Position temp = new Position();
        for (int i = 0; i < graphMartix.Vex.size(); i++) {
            temp = graphMartix.Vex.get(i);
            if(temp.getName().equals(Name)){
                return i;
            }
        }
        return -1;
    }
}
