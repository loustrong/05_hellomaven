package javabean;

/**
 * 项目名称：JSTLStudy 
 * 类名称：Person 
 * 类描述：一个只有getter和setter方法的JavaBean或者说一个pojo(简单的Java对象(Plain Old Java Objects))类，
 * 作为一个vo（数据传输对象）。定义了四个变量age、name、sex和home。 
 */
 
public class Person {

    private String age;

    private String home;

    private String name;

    private String sex;

    public String getAge() {
        return age;
    }

    public String getHome() {
        return home;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setHome(String home) {
        this.home = home;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
}