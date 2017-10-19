package liulihu.study;

/**
 * 简单工厂模式:
 * 简单工厂模式又称为静态方法工厂模式，是由一个工厂对象决定创建哪一个产品类的实例。
 * 客户端需要创建对象、隐藏对象的创建过程，且目标对象类型数量不多的情况下，可以考虑使用简单工厂模式。
 * <p>
 * 工厂方法模式   感觉就是将接口改写为抽象类了。并且为创建类也增加了一个父类。
 */
public class SimpleFactory {


    /**
     * 产品类接口
     */
    interface Iphone {
        /**
         * 打电话
         */
        void call();

        /**
         * 发短信
         */
        void sendMessage();

        /**
         * 上网
         */
        void surfTheInternet();

    }

    /**
     * 产品实体类
     */
    static class IphoneX implements Iphone {

        @Override
        public void call() {
            System.out.println("用X打电话");
        }

        @Override
        public void sendMessage() {
            System.out.println("用X发短信");
        }

        @Override
        public void surfTheInternet() {
            System.out.println("用X上网");
        }
    }

    /**
     * 产品实体类
     */
    static class Iphone8 implements Iphone {

        @Override
        public void call() {
            System.out.println("用Iphone8打电话");
        }

        @Override
        public void sendMessage() {
            System.out.println("用Iphone8发短信");
        }

        @Override
        public void surfTheInternet() {
            System.out.println("用Iphone8上网");
        }
    }

    /**
     * 工厂类
     */
    static final class IphoneFactory {

        /**
         * 创建一个手机产品
         *
         * @param type
         * @return
         */
        static Iphone createIphone(String type) {
            if (type == null) {
                return null;
            }
            Iphone iphone = null;
            if (type.equals("X")) {
                iphone = new IphoneX();
            } else if (type.equals("8")) {
                iphone = new Iphone8();
            }
            return iphone;
        }

    }

    public static void main(String[] args) {
        Iphone iphone = IphoneFactory.createIphone("X");
        iphone.sendMessage();
        iphone.surfTheInternet();
    }
}
