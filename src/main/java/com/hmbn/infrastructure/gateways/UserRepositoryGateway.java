package com.hmbn.infrastructure.gateways;

import com.hmbn.application.gateways.UserGateway;
import com.hmbn.domain.entity.User;
import com.hmbn.infrastructure.persistence.UserEntity;
import com.hmbn.infrastructure.persistence.UserRepository;

public class UserRepositoryGateway implements UserGateway {
  private final UserRepository userRepository;
  private final UserEntityMapper userEntityMapper;

  public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
    this.userRepository = userRepository;
    this.userEntityMapper = userEntityMapper;
  }

  @Override
  public User createUser(User userDomainObj) {
    UserEntity userEntity = userEntityMapper.toEntity(userDomainObj);
    UserEntity savedEntity = userRepository.save(userEntity);

    return userEntityMapper.toDomainObj(savedEntity);
  }

}
