package com;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/9
 * Description:
 */
public class ReentrantLockDemo {


}

class Ticket{
    private Lock lock = new ReentrantLock();
    private int count = 100;
    public void sail() {

    }
}
