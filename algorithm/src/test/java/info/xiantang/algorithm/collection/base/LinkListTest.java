package info.xiantang.algorithm.collection.base;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkListTest {


    @Test
    public void testHeadAdd() {
        LinkList<Object> linkList = new LinkList<>();
        linkList.add(1);
        int head1 = (Integer) linkList.head();
        assertEquals(head1, 1);
        linkList.add(2);
        int head2 = (Integer) linkList.head();
        assertEquals(head2, 2);
        linkList.add(3);
        int head3 = (Integer) linkList.head();
        assertEquals(head3, 3);

    }
}
