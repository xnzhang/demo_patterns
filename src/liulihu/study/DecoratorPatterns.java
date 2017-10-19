package liulihu.study;

/**
 * 装饰模式：
 * 动态地给一个类添加一些额外的职责，并且在添加这些职责时不会影响该类的执行逻辑，
 * 例如通过BufferedInputStream装饰InputStream来添加数据缓冲功能。
 */
public class DecoratorPatterns {

    /**
     * 被装饰者接口
     * 面试
     */
    interface Interview {

        void answer();

    }

    /**
     * 我
     */
    static class Me implements Interview {

        @Override
        public void answer() {
            System.out.println("快了");
        }
    }

    /**
     * 人事面
     */
    static class Hr implements Interview {

        private Interview mInterview;

        public Hr(Interview interview) {
            this.mInterview = interview;
        }

        @Override
        public void answer() {
            addAsk();
            mInterview.answer();
        }

        private void addAsk() {
            System.out.println("今天路上有点堵，到了没？");
        }

    }

    /**
     * 领导问
     */
    static class Manager implements Interview {

        private Interview mInterview;

        public Manager(Interview interview) {
            this.mInterview = interview;
        }

        @Override
        public void answer() {
            addAsk();
            mInterview.answer();
        }

        private void addAsk() {
            System.out.println("今天任务完成没？");
        }

    }

    /**
     * 老板问
     */
    static class Boss implements Interview {
        private Interview mInterview;

        public Boss(Interview interview) {
            this.mInterview = interview;
        }

        @Override
        public void answer() {
            mInterview.answer();
            addAsk();
        }

        private void addAsk() {
            System.out.println("你刚刚说什么？");
        }

    }

    public static void main(String[] args) {
        Me me = new Me();

        new Hr(me).answer();
        new Manager(me).answer();
        new Boss(me).answer();

    }

}
