package io.evenX86.github.bytecode.reflect;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2020-02-09 5:46 下午
 */
public class SonClass extends FatherClass{
    private String sonName;
    protected int sonAge;
    public String sonBirthDay;

    private String MSG = "son";
    // String 以及基础类型 无法修改
    private final String FIN_MSG = "fin_son";
    // static属性无法修改， Can not set static final java.lang.Long
    private static final Long FIN_LON = 123L;

    @Override
    public String toString() {
        return "SonClass{" +
                "sonName='" + sonName + '\'' +
                ", sonAge=" + sonAge +
                ", sonBirthDay='" + sonBirthDay + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", fatherAge=" + fatherAge +
                "} " + super.toString();
    }

    private void privateMethod(String name, int age) {
        System.out.println(name  + " : " + age);
    }

    public String getMSG() {
        return MSG;
    }

    public String getFIN_MSG(){
        return FIN_MSG;
    }

    public Long getFIN_LON() {
        return FIN_LON;
    }
}
