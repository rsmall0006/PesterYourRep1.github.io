package com.pester.services;

//import com.pester.entities.LogInUser;
import com.pester.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by octavio on 4/25/17.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    User findFirstByEmailAddress(String emailAddress);
//     findFirstByEmailAddress(String emailAddress);

}
