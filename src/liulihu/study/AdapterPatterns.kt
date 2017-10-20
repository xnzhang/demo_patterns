package liulihu.study

/**
 * 适配器模式:
 * 适配器模式把一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作
 */
object AdapterPatterns {

    /**
     * 目标接口5伏
     */
    internal interface Volt5 {

        fun volt5(): Int

    }

    /**
     * 需要被装换的220伏类
     */
    open class Volt220 {

        fun volt220(): Int {
            return 220
        }

    }

    /**
     * 转换为兼容5伏的类
     * 像这样以类集成的方式就是类适配器模式
     */
    class ClassAdapter : Volt220(), Volt5 {
        override fun volt5(): Int {
            return 5
        }

    }

    /**
     * 转换为兼容5伏的类
     * 像这样以注入组合的方式就是对象适配器模式
     */
    class ObjectAdapter(volt222: Volt220) : Volt5 {

        var mVolt220: Volt220? = null

        init {
            mVolt220 = volt222
        }

        override fun volt5(): Int {
            return 5
        }

        fun getVolt220(): Int? {
            return mVolt220?.volt220()
        }

    }

    @JvmStatic
    fun main(args: Array<String>) {

        var classAdapter = ClassAdapter()
        System.out.println("类适配器模式将兼容两种电压为：${classAdapter.volt5()}V和${classAdapter.volt220()}V")

        val objectAdapter = ObjectAdapter(Volt220())
        System.out.println("对象适配器模式将兼容两种电压为：${objectAdapter.volt5()}V和${objectAdapter.getVolt220()}V")

    }

}