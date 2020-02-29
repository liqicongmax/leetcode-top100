package badtest;

/**
 * @author liqicong@myhexin.com
 * @date 2020/2/29 11:11
 */
public class PeopleStaticProxy extends People {
    private People people;
    public PeopleStaticProxy(People people){
        super();
        this.people=people;
    }
    public void eatBreakFastThenWork(){
        System.out.println(people.name+"qia le zao fan");
        people.work();
    }
}
