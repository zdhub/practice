package coding;

// 第一种优雅的方式，静态内部类
public class Singleton1 {
    private Singleton1() {
    }

    public static Singleton1 GetSingleton() {
        return Inner.instance;
    }

    private static class Inner {
        private static final Singleton1 instance = new Singleton1();
    }
}