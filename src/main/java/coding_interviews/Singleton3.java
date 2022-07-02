package coding_interviews;

public class Singleton3 {
    // 1.volatile 修饰
    private volatile static Singleton3 singleton3;

    private Singleton3() {
    }

    public static Singleton3 GetSingleton() {
        if (singleton3 == null) {  //2.减少不必要的同步等待

            synchronized (Singleton3.class) { //3.加锁
                if (singleton3 == null) {
                    // 4.创建对象
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }
}
