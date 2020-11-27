package Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Piweiii
 * @Date: 2020/09/07/16:36
 * @Description:
 */
public class Position {
    int Id; //地标Id
    String name;    //地标名称
    String intro;   //地标介绍

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
