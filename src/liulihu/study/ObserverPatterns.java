package liulihu.study;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式
 */
public class ObserverPatterns {

    /**
     * 定义一个Coder类作为一个具体的观察者
     * {@link java.util.Observer#update(Observable, Object)}
     * 方法用于接收收到的消息
     */
    static class Coder implements Observer {

        private String name;

        public Coder(String name) {
            this.name = name;
        }

        @Override
        public void update(Observable o, Object arg) {
            System.out.println("嘿嘿" + name + ",你就是喊破喉咙都没有人来救你的。"
                    + name + ":" + arg);
        }

    }

    /**
     * 定义一个被观察者AndroidWeekly
     * <p>
     * 被观察者操作步骤为
     * 1：点阅：{@link java.util.Observable#addObserver(Observer)}
     * 2: 发送通知：{@linkplain #postAndroidWeeklyMsg(String)}
     */
    static class AndroidWeekly extends Observable {

        public void postAndroidWeeklyMsg(String content) {
            setChanged();//设置状态改变
            notifyObservers(content);//设置通知
        }
    }

    public static void main(String[] args) {
        //1.创建被观察者
        AndroidWeekly androidWeekly = new AndroidWeekly();
        //2.创建观察者
        Coder coder1 = new Coder("琉璃琥");
        Coder coder2 = new Coder("红叶秋");
        Coder coder3 = new Coder("蓝色叶");
        //3.订阅
        androidWeekly.addObserver(coder1);
        androidWeekly.addObserver(coder2);
        androidWeekly.addObserver(coder3);
        //4.发送通知
        androidWeekly.postAndroidWeeklyMsg("破喉咙");
    }

}
