package medium.PeekingIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * 题目：https://leetcode-cn.com/problems/peeking-iterator/
 * 官方题解：https://leetcode-cn.com/problems/peeking-iterator/solution/ding-duan-die-dai-qi-by-leetcode-solutio-8toa/
 * @author: jefferyqjy
 * @datetime: 2021/10/5 11:45
 */
public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer nextElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        this.nextElement = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer element = nextElement;
        this.nextElement = iterator.hasNext() ? iterator.next() : null;
        return element;
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        Iterator<Integer> iterator = list.iterator();
        System.out.println(iterator.next());
    }
}
