package cn.nwafulive.zq.bean;

/**
 * @Author ZhangQiong nwsuafzq@hotmail.com
 * @Date 2017/4/1
 * @Time 22:15.
 */
public class Student {
    private String sid;
    private String sname;
    private float score;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Check-Result: {" +
                "ID: '" + sid + '\'' +
                ", Name: '" + sname + '\'' +
                ", Score: " + score +
                '}';
    }
}
