package liulihu.study;

import java.util.HashMap;
import java.util.Map;

/**
 * 原型模式:
 * 1、类初始化需要消化非常多的资源，这个资源包括数据、硬件资源等，通过原型拷贝避免这些消耗；
 * 2、通过 new 产生一个对象需要非常繁琐的数据准备或访问权限，则可以使用原型模式；
 * 3、一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，可以考虑使用原型模式拷贝多个对象供调用者使用，即保护性拷贝
 */
public class PrototypePatterns {

    /**
     * 实现一个提供的借口
     */
    static class APIDocument implements Cloneable {

        private String methodName;

        private HashMap<String, String> apiParam = new HashMap<>();

        public String getMethodName() {
            return methodName;
        }

        public void setMethodName(String methodName) {
            this.methodName = methodName;
        }

        public Map<String, String> getApiParam() {
            return apiParam;
        }

        public void setApiParam(HashMap<String, String> apiParam) {
            this.apiParam = apiParam;
        }


        /**
         * 这里重载父类方法
         * 必要参数拷贝
         *
         * @return
         * @throws CloneNotSupportedException
         */
        @Override
        protected APIDocument clone() throws CloneNotSupportedException {
            APIDocument cloneAPIDocument = (APIDocument) super.clone();
            cloneAPIDocument.methodName = this.methodName;
            cloneAPIDocument.apiParam = (HashMap<String, String>) this.apiParam.clone();
            return cloneAPIDocument;
        }

        /**
         * 添加字段
         *
         * @param key
         * @param value
         */
        public void addParam(String key, String value) {
            apiParam.put(key, value);
        }

        /**
         * 打印方法文档
         */
        public void showAPI() {
            System.out.println("Api->" + methodName + ":");
            for (Map.Entry<String, String> entry : apiParam.entrySet()) {
                System.out.println("key=" + entry.getKey() + "--valeu=" + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        APIDocument apiDocument = new APIDocument();
        apiDocument.setMethodName("请求列表");
        apiDocument.addParam("page", "1");
        apiDocument.addParam("versioncode", "100");
        apiDocument.addParam("token", "abc");

        try {
            APIDocument clone = apiDocument.clone();
            clone.addParam("stamp", "2017-10-19");
            clone.showAPI();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        apiDocument.showAPI();
    }

}
