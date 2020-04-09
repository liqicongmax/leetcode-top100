package badtest;

/**
 * @author liqicong@myhexin.com
 * @date 2020/3/26 15:36
 */
public class User {
    public Integer age;
    public String name;
    public String sex;

    public User(){}
    public User(int age,String name,String sex){
        this.age=age;
        this.name=name;
        this.sex=sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
