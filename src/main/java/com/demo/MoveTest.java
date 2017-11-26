package com.demo;

import com.demo.api.Move;
import com.demo.module.MoveModule;
import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;

import java.util.List;
import java.util.Set;

public class MoveTest {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MoveModule());


        final List<Move> instance = Lists.newArrayList(injector.getInstance(new Key<Set<Move>>(){}));
        for (Move move : instance) {
            move.move();
        }

    }


}
