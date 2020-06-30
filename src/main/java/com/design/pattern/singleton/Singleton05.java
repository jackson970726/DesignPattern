package com.design.pattern.singleton;

/**
 * @Author: Mr.Z
 * @Date: 2020/06/30
 * @Description: 单例模式
 * @version: 1.0
 */
public class Singleton05 {

    private static Singleton05 INSTANCE;

    private Singleton05() {}

    public static Singleton05 getInstance() {
        if (INSTANCE == null) {
            //妄图通过减小同步代码块的方式提高效率，然后不可行
            synchronized (Singleton05.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Singleton05();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton05.getInstance().hashCode());
            }).start();
        }
    }
}
