package io.github.evenX86.java.base;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-10-26 9:22 PM
 */
public class MyAppClassLoader extends ClassLoader {

    public MyAppClassLoader(ClassLoader parent) {
        super(parent);
    }



    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("/Users/xuyifei/Study/javademo/CLPreparation.class");
        try {
            byte[] bytes = getClassBytes(file);
            Class<?> clazz = defineClass(name,bytes,0,bytes.length);
            return clazz;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private byte[] getClassBytes(File file) throws Exception {
        // 这里要读入.class的字节，因此要使用字节流
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);

        while (true) {
            int i = fc.read(by);
            if (i == 0 || i == -1) {
                break;
            }
            by.flip();
            wbc.write(by);
            by.clear();
        }
        fis.close();
        return baos.toByteArray();
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyAppClassLoader myAppClassLoader = new MyAppClassLoader(null);
        Class<?>clazz = Class.forName("CLPreparation",true, myAppClassLoader);
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());

    }
}
