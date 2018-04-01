package io.github.evenX86.builder;

import org.junit.Test;

import static org.junit.Assert.*;

public class BuilderCommonExampleTest {
    @Test
    public void getFixedArgs1() throws Exception {
        BuilderCommonExample builderCommonExample = new BuilderCommonExample.Builder("1","2","3","4")
                .unFixedArgs1("5")
                .unFixedArgs2("6")
                .unFixedArgs3("7")
                .builder();
        assertEquals("1",builderCommonExample.getFixedArgs1());

    }

    @Test
    public void getUnFixedargs1() throws Exception {
    }

}