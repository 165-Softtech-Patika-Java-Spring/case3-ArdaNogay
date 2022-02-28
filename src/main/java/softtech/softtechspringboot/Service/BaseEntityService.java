package softtech.softtechspringboot.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import softtech.softtechspringboot.Entity.User;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<Entity extends BaseEntity,Dao extends JpaRepository> {

    private final Dao dao;

    public Entity save(Entity entity){
        return (Entity) dao.save(entity);
    }

    public List<Entity> findAll(){
        return dao.findAll();
    }

    public Optional<Entity> findById(Long id){
        return dao.findById(id);
    }

    public void delete(Entity entity){
        dao.delete(entity);
    }

    public boolean existById(Long id){
        return dao.existsById(id);
    }

    public Dao getDao(){
        return dao;
    }
}
