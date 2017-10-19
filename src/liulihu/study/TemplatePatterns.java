package liulihu.study;

/**
 * 模板方法模式
 * 定义一个操作中的算法的框架，而将一些步骤延迟到子类中。
 * 使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
 * 说白了就是抽父类   但比直接抽父类要多一个调用方法
 */
public class TemplatePatterns {

    /**
     * 抽象模板类
     * 三个模板方法  最后一个调用类
     */
    static abstract class AbstractAsk {

        protected void askOne() {
            System.out.println("先介绍下自己!");
        }

        protected void askTwo() {
            System.out.println("独立开发是怎么自学的?");
        }

        protected void askThree() {
            System.out.println("你又什么想了解的吗？");
        }

        public final void ask() {
            System.out.println("你好!");
            askOne();
            askTwo();
            askThree();
        }

    }

    static class Hr extends AbstractAsk {

        @Override
        protected void askTwo() {
//            super.askTwo();
            System.out.println("今天天气怎么样？");
        }
    }

    static class Manager extends AbstractAsk {
        @Override
        protected void askThree() {
//            super.askThree();
            System.out.println("对于技术部你有什么想了解的吗？");
        }
    }


    public static void main(String[] args) {
        Hr hr = new Hr();
        hr.ask();

        new Manager().ask();
    }

}
