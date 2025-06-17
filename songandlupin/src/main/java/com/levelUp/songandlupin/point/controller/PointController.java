package com.levelUp.songandlupin.point.controller;

import com.levelUp.songandlupin.point.service.PointService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PointController {

    private final PointService pointService;

    @PostMapping("/point")
    public int increasePoint(@RequestParam Long userId, @RequestParam int point) {
        return pointService.increase(userId, point);
    }

    @GetMapping("/point")
    public int fetchPoint(@RequestParam Long userId) {
        return pointService.fetchPoint(userId);
    }
}
