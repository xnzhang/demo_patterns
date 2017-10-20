package liulihu.study

/**
 * 简单工厂模式:
 * 简单工厂模式又称为静态方法工厂模式，是由一个工厂对象决定创建哪一个产品类的实例。
 * 客户端需要创建对象、隐藏对象的创建过程，且目标对象类型数量不多的情况下，可以考虑使用简单工厂模式。
 *
 *
 * 工厂方法模式   感觉就是将接口改写为抽象类了。并且为创建类也增加了一个父类。
 */
object SimpleFactory {

    /**
     * 产品类接口
     */
    internal interface Iphone {
        /**
         * 打电话
         */
        fun call()

        /**
         * 发短信
         */
        fun sendMessage()

        /**
         * 上网
         */
        fun surfTheInternet()

    }

    /**
     * 产品实体类
     */
    internal class IphoneX : Iphone {

        override fun call() {
            println("用X打电话")
        }

        override fun sendMessage() {
            println("用X发短信")
        }

        override fun surfTheInternet() {
            println("用X上网")
        }
    }

    /**
     * 产品实体类
     */
    internal class Iphone8 : Iphone {

        override fun call() {
            println("用Iphone8打电话")
        }

        override fun sendMessage() {
            println("用Iphone8发短信")
        }

        override fun surfTheInternet() {
            println("用Iphone8上网")
        }
    }

    /**
     * 工厂类
     */
    internal object IphoneFactory {

        /**
         * 创建一个手机产品
         *
         * @param type
         * @return
         */
        fun createIphone(type: String?): Iphone? {
            if (type == null) {
                return null
            }
            var iphone: Iphone? = null
            if (type == "X") {
                iphone = IphoneX()
            } else if (type == "8") {
                iphone = Iphone8()
            }
            return iphone
        }

    }

    @JvmStatic
    fun main(args: Array<String>) {
        val iphone = IphoneFactory.createIphone("X")
        iphone?.sendMessage()
        iphone?.surfTheInternet()
    }
}
