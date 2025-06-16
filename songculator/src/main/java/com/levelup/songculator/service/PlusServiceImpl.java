package com.levelup.songculator.service;

import com.levelup.songculator.dto.NumbersInputDto;
import org.springframework.stereotype.Service;

@Service
public class PlusServiceImpl implements CalculateService {

    @Override
    public int calculate(NumbersInputDto numbersInputDto) {
        return numbersInputDto.getN1() + numbersInputDto.getN2();
    }
}
