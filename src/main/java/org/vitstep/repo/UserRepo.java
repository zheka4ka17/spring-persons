package org.vitstep.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vitstep.models.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
