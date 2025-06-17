package com.levelUp.songsiter.service;

import org.springframework.stereotype.Service;

@Service
public class SongsitServiceBean {

    int count = 0;

    public int increase() {
        return ++count;
    }
}
