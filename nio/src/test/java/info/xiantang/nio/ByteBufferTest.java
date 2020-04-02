package info.xiantang.nio;

import com.google.common.primitives.Bytes;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ByteBufferTest {

    @Test
    public void testByteBufferReadAndAdd() {
        // position:0 // limit:1024
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        assertEquals(0, buffer.position());
        assertEquals(1024, buffer.limit());
        assertEquals(1024,buffer.remaining());
        buffer.put("test".getBytes());
        assertEquals(4, buffer.position());
        assertEquals(1024, buffer.limit());
        buffer.flip();
        List<Byte> bytes = new ArrayList<>();
        while (buffer.hasRemaining()) {
            bytes.add(buffer.get());
        }
        assertEquals(0,buffer.remaining());
        assertEquals("test", new String(Bytes.toArray(bytes)));
        assertEquals(4, buffer.position());
        assertEquals(4, buffer.limit());
    }



}
