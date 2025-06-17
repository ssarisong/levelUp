package com.levelUp.songandlupin.user.repository;

import com.levelUp.songandlupin.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JPA에서 지원하는 모든 DB 기능을 다 가져와서 쓸 수 있게 함.
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
