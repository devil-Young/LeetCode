package DesignPattern.创建型模式.原型;

/**
 * @Author: Young
 * @Date: 2025/12/22 22:41
 */
public class Student implements Cloneable{
    private int id;
    private String name;
    private int score;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // 复制新对象并返回:
//    因为clone()的方法签名是定义在Object中，返回类型也是Object，所以要强制转型
    public Object clone() {
//        Student std = new Student();
//        std.id = this.id;
//        std.name = this.name;
//        std.score = this.score;
//        return std;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

//    使用原型模式更好的方式是定义一个copy()方法，返回明确的类型
    public Student copy() {
        Student std = new Student();
        std.id = this.id;
        std.name = this.name;
        std.score = this.score;
        return std;
    }


    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setId(123);
        student1.setName("Bob");
        student1.setScore(88);

        Student Student2 = (Student)student1.clone();
        System.out.println(student1);
        System.out.println(Student2);
        System.out.println(student1 == Student2);
    }
}
