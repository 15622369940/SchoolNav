package Utils;

import Bean.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Piweiii
 * @Date: 2020/09/07/16:40
 * @Description:
 */
public class PositionIniter {
    int NodeCount = 10;
    String[] postionName = {"新食堂",
                            "十二舍",
                            "西操场",
                            "图书馆",
                            "致用楼",
                            "超市",
                            "致高楼",
                            "二十三舍",
                            "勤学楼",
                            "博学楼"};
    String[] postionIntro = {"新食堂提供各种各样的美食，价格便宜。",
                             "男生宿舍，休养生息。",
                             "你可以在这里锻炼身体。",
                             "你可以在这里借阅书籍，自习，喝咖啡与休息。",
                             "你可以在这里上公共课，借用教室展开社团活动。",
                             "你可以采购生活的必需品。",
                             "你可以在这里上选修课，借用模拟法庭。",
                             "女生宿舍，休养生息。",
                             "你可以在这里找到信息学部的老师，借用实验室。",
                             "你可以在这里上专业课，享受有空调的教室。"};
    int[] numbers = {1,2,3,4,5,6,7,8,9,10};
    public List<Position> initPos(){
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < NodeCount; i++) {
            Position position = new Position();
            position.setId(numbers[i]);
            position.setName(postionName[i]);
            position.setIntro(postionIntro[i]);
            positions.add(position);
        }
        return positions;
    }
}
