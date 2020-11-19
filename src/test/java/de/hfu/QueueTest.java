package de.hfu;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class QueueTest {
	private Queue queue;
	@Before
	public void erzeugeQueue() {
		queue = new Queue(3);
	}
	
	@Test(expected=IllegalArgumentException.class, timeout=1000)
	public void testQueue() {
		new Queue(0);
	}
	@Test
	public void testQueueEnqueue() {
		queue.enqueue(5);
		assertEquals("5 sollte wieder ausgegeben werden",5,queue.dequeue());
		queue.enqueue(5);
		queue.enqueue(5);
		assertEquals("5 sollte wieder ausgegeben werden",5,queue.dequeue());
		queue.enqueue(5);
		queue.enqueue(5);
		queue.enqueue(5);
		queue.enqueue(10);
		assertEquals("5 sollte wieder ausgegeben werden",5,queue.dequeue());
		assertEquals("5 sollte wieder ausgegeben werden",5,queue.dequeue());
		assertEquals("10 sollte wieder ausgegeben werden",10,queue.dequeue());
	}
	@Test(expected=IllegalStateException.class, timeout=1000)
	public void testEmptyQueue() {
		queue.dequeue();
	}
}
