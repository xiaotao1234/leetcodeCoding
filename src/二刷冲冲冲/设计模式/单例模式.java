package 二刷冲冲冲.设计模式;

/**
 * @author xt
 * @version 1.0
 * @date 2020/12/3 22:34
 */
public class 单例模式 {
    class singleTon {
        private singleTon(){}

        //懒汉模式
        singleTon singleTon;
        public singleTon getSingleTon() {
            if (singleTon == null) {
                singleTon = new singleTon();
            }
            return singleTon;
        }

        //饿汉模式
        singleTon singleTon1 = new singleTon();
        public singleTon getSingleTon1() {
            return singleTon1;
        }

        //双重检查锁
        singleTon singleTon2 = new singleTon();
        public singleTon getSingleTon2() {
            if (singleTon2 == null) {
                synchronized (singleTon.class) {
                    if (singleTon2 == null) {
                        singleTon2 = new singleTon();
                    }
                }
            }
            return singleTon2;
        }


    }


    //静态内部类单例

    public 单例模式 singleTon(){
        return singleTonHolder.singleTon;//静态内部类在使用时才会进行加载，且加载过程受到虚拟机保护，线程安全，懒加载
    }

    private static class singleTonHolder{
        public static 单例模式 singleTon = new 单例模式();
    }
}
