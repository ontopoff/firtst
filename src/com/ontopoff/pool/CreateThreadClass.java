package com.ontopoff.pool;

public class CreateThreadClass extends ObjectFactory<Thread> {
    @Override
    public Thread createObject() {
        return new Thread();
    }
}
