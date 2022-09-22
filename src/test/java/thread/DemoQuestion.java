package thread;

/**
 * 线程间访问共享变量之间问题
 * */
public class DemoQuestion {
    private String name;
    private int age;

    public static void main(String[] args) {
        DemoQuestion demoQuestion = new DemoQuestion();
        for (int i = 0; i < 5; i++) {
            // int j = i;
            new Thread(() ->{
                // demoQuestion.setAge(j);
                demoQuestion.setName(Thread.currentThread().getName() + "的数据");
                System.out.println("=================");
                System.out.println(Thread.currentThread().getName() + "--->" + demoQuestion.getName());
                // System.out.println(Thread.currentThread().getName() + "--->" + demoQuestion.getAge());
            },"t" + i).start();
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

