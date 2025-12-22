package 面试.动态线程池;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SwitchableBlockingQueue<E>
        extends AbstractQueue<E>
        implements BlockingQueue<E> {

    private volatile BlockingQueue<E> delegate;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public SwitchableBlockingQueue(BlockingQueue<E> initialQueue) {
        this.delegate = Objects.requireNonNull(initialQueue);
    }

    public BlockingQueue<E> getDelegate() {
        return delegate;
    }

    /**
     * 在线切换队列（无损）
     */
    public void switchQueue(BlockingQueue<E> newQueue) {
        lock.writeLock().lock();
        try {
            BlockingQueue<E> old = this.delegate;
            old.drainTo(newQueue);
            this.delegate = newQueue;
        } finally {
            lock.writeLock().unlock();
        }
    }

    /* ================= Queue ================= */

    @Override
    public boolean offer(E e) {
        lock.readLock().lock();
        try {
            return delegate.offer(e);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public E poll() {
        lock.readLock().lock();
        try {
            return delegate.poll();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public E peek() {
        lock.readLock().lock();
        try {
            return delegate.peek();
        } finally {
            lock.readLock().unlock();
        }
    }

    /* ================= BlockingQueue ================= */

    @Override
    public void put(E e) throws InterruptedException {
        lock.readLock().lock();
        try {
            delegate.put(e);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public boolean offer(E e, long timeout, TimeUnit unit)
            throws InterruptedException {
        lock.readLock().lock();
        try {
            return delegate.offer(e, timeout, unit);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public E take() throws InterruptedException {
        lock.readLock().lock();
        try {
            return delegate.take();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public E poll(long timeout, TimeUnit unit)
            throws InterruptedException {
        lock.readLock().lock();
        try {
            return delegate.poll(timeout, unit);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public int remainingCapacity() {
        return delegate.remainingCapacity();
    }

    @Override
    public int drainTo(Collection<? super E> c) {
        return delegate.drainTo(c);
    }

    @Override
    public int drainTo(Collection<? super E> c, int maxElements) {
        return delegate.drainTo(c, maxElements);
    }

    /* ================= Collection ================= */

    @Override
    public Iterator<E> iterator() {
        return delegate.iterator();
    }

    @Override
    public int size() {
        return delegate.size();
    }
}