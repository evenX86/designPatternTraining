package io.github.evenX86.concurrent;

import io.github.evenX86.EasyUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-10-25 6:09 PM
 */
public class ConcurrentModificationTest {

    @Test( )
    public void testConcurrentException(){
        final List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);
        ints.add(6);
        ints.add(7);
        ints.add(8);
        ints.add(9);

        List<String> strs = ints
                .stream()
                .map(EasyUtils::toString)
                .collect(Collectors.toList());

        System.out.println(strs);
        System.out.println(ints);

    }

    @Test( )
    public void testConcurrentExceptionParallel(){
        final List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);
        ints.add(6);
        ints.add(7);
        ints.add(8);
        ints.add(9);

        ints.parallelStream()
                .map(a -> addSomething( a, ints ))
                .collect(Collectors.toList());

    }

    @Test( )
    public void testConcurrentException2(){
        final List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);
        ints.add(6);
        ints.add(7);
        ints.add(8);
        ints.add(9);

        Collections.unmodifiableList(ints).stream()
                .map(a -> addSomething( a, ints ))
                .collect(Collectors.toList());

    }

    @Test( )
    public void testConcurrentException21(){
        final List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);
        ints.add(6);
        ints.add(7);
        ints.add(8);
        ints.add(9);

        List<Integer> ints2 = new ArrayList<>();
        for( int i:  Collections.unmodifiableList(ints)){
            final int a = addSomething(i, ints);
            ints2.add(a);
        }
    }

    @Test( )
    public void testConcurrentException3(){
        final List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);
        ints.add(6);
        ints.add(7);
        ints.add(8);
        ints.add(9);

        final List<Integer> unmdfInts = Collections.unmodifiableList(ints);
        unmdfInts.stream()
                .map(a -> addSomething( a, unmdfInts ))
                .collect(Collectors.toList());

    }

    private int addSomething(int current, List<Integer> ints) {
        ints.add(1);
        return current;
    }
}
