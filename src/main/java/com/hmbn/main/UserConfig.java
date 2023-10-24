package com.hmbn.main;

import com.hmbn.application.gateways.UserGateway;
import com.hmbn.application.usecases.CreateUserInteractor;
import com.hmbn.infrastructure.gateways.UserEntityMapper;
import com.hmbn.infrastructure.gateways.UserRepositoryGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hmbn.infrastructure.controllers.UserDTOMapper;
import com.hmbn.infrastructure.persistence.UserRepository;

@Configuration
public class UserConfig {
  @Bean
  CreateUserInteractor createUserCase(UserGateway userGateway) {
    return new CreateUserInteractor(userGateway);
  }

  @Bean
  UserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
    return new UserRepositoryGateway(userRepository, userEntityMapper);
  }

  @Bean
  UserEntityMapper userEntityMapper() {
    return new UserEntityMapper();
  }

  @Bean
  UserDTOMapper userDTOMapper() {
    return new UserDTOMapper();
  }
}
