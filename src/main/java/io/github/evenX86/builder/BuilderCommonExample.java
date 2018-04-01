package io.github.evenX86.builder;

/**
 *
 * 使用builder模式在参数过长切参数顺序不固定的情况
 * 参考Effective Java
 */
public class BuilderCommonExample {
    private String fixedArgs1; //必须参数1
    private String fixedArgs2; //必须参数1
    private String fixedArgs3; //必须参数1
    private String fixedArgs4; //必须参数1
    private String unFixedargs1; //非必须参数1
    private String unFixedargs2; //非必须参数2
    private String unFixedargs3; //非必须参数3

    public BuilderCommonExample(Builder builder) {
        this.fixedArgs1 = builder.fixedArgs1;
        this.fixedArgs2 = builder.fixedArgs2;
        this.fixedArgs3 = builder.fixedArgs3;
        this.fixedArgs4 = builder.fixedArgs4;
        this.unFixedargs1 = builder.unFixedArgs1;
        this.unFixedargs2 = builder.unFixedArgs2;
        this.unFixedargs3 = builder.unFixedArgs3;
    }

    static class Builder{
        private final String fixedArgs1; //必须参数1
        private final String fixedArgs2; //必须参数1
        private final String fixedArgs3; //必须参数1
        private final String fixedArgs4; //必须参数1
        private String unFixedArgs1; //非必须参数1
        private String unFixedArgs2; //非必须参数2
        private String unFixedArgs3; //非必须参数3

        public Builder(String fixedArgs1, String fixedArgs2, String fixedArgs3, String fixedArgs4) {
            this.fixedArgs1 = fixedArgs1;
            this.fixedArgs2 = fixedArgs2;
            this.fixedArgs3 = fixedArgs3;
            this.fixedArgs4 = fixedArgs4;
        }

        public Builder unFixedArgs1(String args) {
            unFixedArgs1 = args;
            return this;
        }
        public Builder unFixedArgs2(String args) {
            unFixedArgs2 = args;
            return this;

        }
        public Builder unFixedArgs3(String args) {
            unFixedArgs3 = args;
            return this;
        }

        public BuilderCommonExample builder() {
            return new BuilderCommonExample(this);
        }
    }

    public String getFixedArgs1() {
        return fixedArgs1;
    }

    public String getFixedArgs2() {
        return fixedArgs2;
    }

    public String getFixedArgs3() {
        return fixedArgs3;
    }

    public String getFixedArgs4() {
        return fixedArgs4;
    }

    public String getUnFixedargs1() {
        return unFixedargs1;
    }

    public String getUnFixedargs2() {
        return unFixedargs2;
    }

    public String getUnFixedargs3() {
        return unFixedargs3;
    }
}
