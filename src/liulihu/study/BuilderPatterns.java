package liulihu.study;

/**
 * 构建模式:
 * 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 * <p>
 * 使用场景
 * 1、相同的方法，不同的执行顺序，产生不同的事件结果时；
 * 2、多个部件或零件，都可以装配到一个对象中，但是产生的运行结果又不相同时；
 * 3、产品类非常复杂，或者产品类中的调用顺序不同产生了不同的效能，这个时候使用建造者模式非常合适；
 */
public class BuilderPatterns {

    /**
     * 抽象产品类
     */
    static abstract class Computer {

        protected int mCpuCore = 1;
        protected int mRamSize = 0;
        protected String mOs = "Dos";

        public abstract void setmCpuCore(int mCpuCore);

        public abstract void setmRamSize(int mRamSize);

        public abstract void setmOs(String mOs);

        @Override
        public String toString() {
            return "Computer{" +
                    "mCpuCore=" + mCpuCore +
                    ", mRamSize=" + mRamSize +
                    ", mOs='" + mOs + '\'' +
                    '}';
        }

    }

    /**
     * 具体的产品类
     */
    static class AppleComputer extends Computer {

        @Override
        public void setmCpuCore(int core) {
            mCpuCore = core;
        }

        @Override
        public void setmRamSize(int size) {
            mRamSize = size;
        }

        @Override
        public void setmOs(String os) {
            mOs = os;
        }

    }

    /**
     * 抽象的构建类
     */
    static abstract class Builder {
        /**
         * 构建CPU
         *
         * @param core
         */
        public abstract void buildCPU(int core);

        /**
         * 构建内存
         *
         * @param gb
         */
        public abstract void buildRAM(int gb);

        /**
         * 构建系统
         *
         * @param os
         */
        public abstract void buildOS(String os);

        /**
         * 创建电脑
         *
         * @return
         */
        public abstract Computer create();

    }

    /**
     * 具体的构建类
     */
    static class ApplePCBuilder extends Builder {

        /**
         * 初始创建一个AppleComputer
         */
        private AppleComputer appleComputer = new AppleComputer();

        @Override
        public void buildCPU(int core) {
            appleComputer.setmCpuCore(core);
        }

        @Override
        public void buildRAM(int gb) {
            appleComputer.setmRamSize(gb);
        }

        @Override
        public void buildOS(String os) {
            appleComputer.setmOs(os);
        }

        @Override
        public Computer create() {
            return appleComputer;
        }

    }

    /**
     * 这个类就比较陌生了哈
     */
    static class Director {

        Builder mBuilder = null;

        public Director(Builder builder) {
            this.mBuilder = builder;
        }

        /**
         * 构建对象
         *
         * @param cpu
         * @param ram
         * @param os
         */
        public void construct(int cpu, int ram, String os) {
            mBuilder.buildCPU(cpu);
            mBuilder.buildRAM(ram);
            mBuilder.buildOS(os);
        }

    }

    /**
     * 构建过程
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.构建器
        ApplePCBuilder applePCBuilder = new ApplePCBuilder();
        //2.Director
        Director director = new Director(applePCBuilder);
        //3.封装构建过程，2核，2gb内存，MAC系统
        director.construct(4, 2, "MAC OS");
        //4.构建电脑完成
        System.out.println("构建的电脑：" + applePCBuilder.create().toString());

    }

}
