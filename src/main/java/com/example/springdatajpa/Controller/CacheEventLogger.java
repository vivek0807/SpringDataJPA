package com.example.springdatajpa.Controller;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

public class CacheEventLogger implements CacheEventListener<Object, Object> {

    // ...

    @Override
    public void onEvent(
            CacheEvent<? extends Object, ? extends Object> cacheEvent) {
        //log.info( cacheEvent.getKey(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
    }
}