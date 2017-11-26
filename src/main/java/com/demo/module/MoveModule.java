package com.demo.module;

import com.demo.api.Move;
import com.demo.impl.LeftMove;
import com.demo.impl.RightMove;
import com.google.common.collect.Maps;
import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.multibindings.Multibinder;

import java.util.Map;

public class MoveModule extends AbstractModule {
    protected void configure() {
        final Binder binder = binder();

        // 关键地方binder里面注入一个对象 MapBinder<String, Move> mapBinder
        MapBinder<String, Move> mapBinder  = MapBinder.newMapBinder(binder, String.class, Move.class);

        Map<String, Class<? extends Move>> map = Maps.newHashMap();
        map.put("left", LeftMove.class);
        map.put("right", RightMove.class);
        for (Map.Entry<String, Class<? extends Move>> entry : map.entrySet()) {
            mapBinder.addBinding(entry.getKey()).to(entry.getValue()).asEagerSingleton();
        }


        // binder关联类定义
        final Multibinder<Move> moveMultibinder = Multibinder.newSetBinder(binder, Move.class);

        // binder关联类实现，MoveInject内部通过Inject注入binder对象里面的mapBinder对象
        moveMultibinder.addBinding().to(MoveInject.class);
    }
}
