package StudentApplication.SpringJPAHibernate.Controllers;

import StudentApplication.SpringJPAHibernate.Model.User;
import StudentApplication.SpringJPAHibernate.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepoObj;
    @PostMapping("/signup")
    public User save(@RequestBody User userObj){

        User userResponse = userRepoObj.save(userObj);
        System.out.println(userResponse);

        return userResponse;
    };

    @DeleteMapping("/deleterow")
    public void deleteUser(@RequestBody User userObj)  {
        userRepoObj.delete(userObj);
    }

//    @DeleteMapping("/deleterowbyid")
//    public void deleteUserbyId(int id)  {
//        userRepoObj.deleteById(id);
//    }

    @GetMapping("/allusers")
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userRepoObj.findAll().forEach(users::add);
        return users;
    }


    @GetMapping("/")
    public String index() {
        return "Hello!!!";
    }


}

