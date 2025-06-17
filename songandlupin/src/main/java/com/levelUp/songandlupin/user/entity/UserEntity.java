package com.levelUp.songandlupin.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserEntity {

    @Id //id한테 넣는 애노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동으로 값이 지정 될 필드
    private Long id;
    private String username;
    private int point;
}
