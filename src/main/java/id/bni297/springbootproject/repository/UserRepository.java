package id.bni297.springbootproject.repository;

import id.bni297.springbootproject.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public boolean checkExist(Long id){
        return users.stream().anyMatch(user -> user .getId() != null && user.getId().equals(id));
    }

    private Long generateNewId(){
        return (long) (users.size()+1);
    }

    public User save(User user){
        if(checkExist(user.getId())){
            users.remove(user);
            users.add(user);
        }
        else{
            user.setId(generateNewId());
            users.add(user);
        }
        return user;

    }

    public List<User> findAll() {
        return users;
    }

    //update
    public Optional<User> updateData(Long id, User updateUser) {
        return findById(id).map(user -> {
            user.setName(updateUser.getName());
            user.setEmail(updateUser.getEmail());
            return user;
        });
    }


    public Optional<User>findById(Long id){
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }





}
