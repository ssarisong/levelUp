package com.levelUp.songandlupin.point.service;

import com.levelUp.songandlupin.user.entity.UserEntity;
import com.levelUp.songandlupin.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PointService {

    private UserRepository userRepository;

    @Transactional //DB의 값을 수정하는 로직이 있을 때 넣어야 하는 애노테이션
    public int increase(long userId, int point) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("사용자 조회 실패한 id: " + userId)
        );

        userEntity.setPoint(userEntity.getPoint() + point);
        return userEntity.getPoint();
    }

    //값을 수정하는 것이 아니고 조회만 하는 것이기 때문에 @Transactional을 사용하지 않음.
    public int fetchPoint(long userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("사용자 조회 실패한 id: " + userId)
        );

        return userEntity.getPoint();
    }

}
