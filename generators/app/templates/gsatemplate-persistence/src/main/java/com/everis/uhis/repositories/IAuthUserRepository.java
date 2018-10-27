package com.everis.<%= appName %>.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.everis.<%= appName %>.entities.AuthUserEntity;

@Repository
public interface IAuthUserRepository extends PagingAndSortingRepository<AuthUserEntity, Long>
{

    AuthUserEntity findByUsername(String username);
}
