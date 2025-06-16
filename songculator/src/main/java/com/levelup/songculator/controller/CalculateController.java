package com.levelup.songculator.controller;

import com.levelup.songculator.dto.NumbersInputDto;
import com.levelup.songculator.service.CalculateService;
import com.levelup.songculator.service.MinusServiceImpl;
import com.levelup.songculator.service.PlusServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class CalculateController {

    private final Map<String, CalculateService> calculateServiceMap;

    //파라미터로 요청값을 받음 (공개)
    /*@GetMapping("/songculator")
    public int calculate(@RequestParam int n1, @RequestParam int n2) {
        return plusService.calculate(new NumbersInputDto(n1, n2));
    }*/

    //바디값(Json)으로 요청값을 받음 (비밀)
    /*@GetMapping("/songculator")
    public int calculate(@RequestBody NumbersInputDto numbersInputDto) {
        return plusService.calculate(numbersInputDto);
    }*/

    //더하기, 빼기, 곱하기, 나누기 한 번에 다 나오게 할 때
    /*@GetMapping("/songculator")
    public void calculate(@RequestBody NumbersInputDto numbersInputDto) {
        for (CalculateService calculateService : calculateServiceMap.values()) {
            System.out.println(calculateService.calculate(numbersInputDto));
        }
    }*/

    //사용자가 더하기, 빼기, 곱하기, 나누기 중에 입력할 때 (선택)
    @GetMapping("/songculator")
    public int calculate(@RequestParam String buho, @RequestBody NumbersInputDto numbersInputDto) {
        switch (buho) {
            case "더하기":
                return calculateServiceMap.get("plusServiceImpl").calculate(numbersInputDto);
            case "빼기":
                return calculateServiceMap.get("minusServiceImpl").calculate(numbersInputDto);
            case "곱하기":
                return calculateServiceMap.get("multipleServiceImpl").calculate(numbersInputDto);
            case "나누기":
                return calculateServiceMap.get("divideServiceImpl").calculate(numbersInputDto);
            default:
                throw new IllegalArgumentException("지원하지 않는 연산입니다.");
        }
    }
}
