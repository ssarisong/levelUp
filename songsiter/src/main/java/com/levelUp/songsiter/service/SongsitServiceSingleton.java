package com.levelUp.songsiter.service;

import lombok.Getter;

public class SongsitServiceSingleton {

    @Getter
    private static final SongsitServiceSingleton instance = new SongsitServiceSingleton();
    private int count = 0;

    private SongsitServiceSingleton() {} //싱글톤일 때, 아무 것도 없는 생성자를 만들어 주면 좋음.

    //@Getter를 통해 요거 생략 가능함.
//    //instance를 주는 static 함수
//    //static 함수: new로 할당하지 않아도 외부에서 사용할 수 있도록 하는 함수
//    public static SongsitServiceSingleton getInstance() {
//        return instance;
//    }

    public  int increase() {
        return ++count;
    }
}
