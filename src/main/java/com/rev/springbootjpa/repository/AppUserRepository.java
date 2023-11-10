package com.rev.springbootjpa.repository;

import com.rev.springbootjpa.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
    @Query("from AppUser u WHERE u.uname=:uname AND u.upassword=:upassword")
    AppUser findUserByUserNameAndPassword(@Param("uname") String uname, @Param("upassword") String upassword);
}
