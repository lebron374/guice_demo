package com.demo.module;

import com.demo.api.Move;
import com.google.inject.Inject;

import java.util.Map;

public class MoveInject implements Move {

    Map<String, Move> map;

    //需要在一个上下文当中找到Map<String, Move> map定义
    @Inject
    public MoveInject(Map<String, Move> map) {
        this.map = map;
    }

    public void move() {
        for(Map.Entry<String, Move> entry : map.entrySet()) {
            entry.getValue().move();
        }
    }
}
