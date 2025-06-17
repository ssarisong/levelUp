package com.levelUp.songsiter.controller;

import com.levelUp.songsiter.service.SongsitServiceBasic;
import com.levelUp.songsiter.service.SongsitServiceBean;
import com.levelUp.songsiter.service.SongsitServiceSingleton;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SongsitController {

    //싱글톤 사용 전
    @GetMapping("/songsiter/basic")
    public String basic() {
        SongsitServiceBasic songsitService = new SongsitServiceBasic();
        int count = songsitService.increase();
        return "welcome tea: " + count;
    }

    //싱글톤 사용
    @GetMapping("/songsiter/singleton")
    public String singleton() {
        SongsitServiceSingleton songsitService = SongsitServiceSingleton.getInstance();
        int count = songsitService.increase();
        return "welcome tea: " + count;
    }

    //싱글톤이 적용 된 스프링 빈을 불러 옴.
    private SongsitServiceBean songsitServiceBean;

    @GetMapping("/songsiter/bean")
    public String bean() {
        int count = songsitServiceBean.increase();
        return "welcome tea: " + count;
    }
}
