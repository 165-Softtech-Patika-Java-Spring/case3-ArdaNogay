package softtech.softtechspringboot.Service.EntityService;

import org.springframework.stereotype.Service;
import softtech.softtechspringboot.Entity.User;
import softtech.softtechspringboot.Repository.UserDao;
import softtech.softtechspringboot.Service.BaseEntityService;

import java.util.List;


@Service
public class UserEntityService extends BaseEntityService<User,UserDao>{

    public UserEntityService(UserDao dao) {
        super(dao);
    }

    public User getById(Long id){
        return getDao().getById(id);
    }

    public User findByName(String name){
        return getDao().findByName(name);
    }

    public User findByPhoneNumber(String phoneNumber){
        return getDao().findByPhoneNumber(phoneNumber);
    }

    public List<String> findNames(){
        return getDao().findNames();
    }
    public  List<String> findPhoneNumbers(){
        return getDao().findPhoneNumbers();
    }
    public  List<String> findEmails(){
        return getDao().findEmails();
    }
}
