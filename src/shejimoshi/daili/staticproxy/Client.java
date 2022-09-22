package shejimoshi.daili.staticproxy;

public class Client {

    public static void main(String[] args) {
        //创建目标对象(被代理对象)
        TeacherDao teacherDao = new TeacherDao();

        //创建代理对象，同时将目标对象传递给代理对象
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);

        //通过代理对象，调用到目标对象的方法
        teacherDaoProxy.teach();
    }

}
