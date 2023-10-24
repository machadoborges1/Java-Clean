package com.hmbn.application.usecases;

import com.hmbn.application.gateways.UserGateway;
import com.hmbn.domain.entity.User;

public class CreateUserInteractor {
  private final UserGateway userGateway;

  public CreateUserInteractor(UserGateway createUser) {
    this.userGateway = createUser;
  }

  public User createUser(User user) {
    return userGateway.createUser(user);
  }
}
