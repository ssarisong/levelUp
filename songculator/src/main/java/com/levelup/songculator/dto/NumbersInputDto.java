package com.levelup.songculator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor //모든 변수를 생성하는 생성자를 자동으로 만들어줌.
public class NumbersInputDto {
    private int n1;
    private int n2;
}
