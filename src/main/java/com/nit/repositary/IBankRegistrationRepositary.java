package com.nit.repositary;

import com.nit.Entity.UserRegister;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBankRegistrationRepositary extends JpaRepository<UserRegister, Long> {
   Optional<UserRegister> findByEmailID(String emailID);
}
