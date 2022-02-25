package softtech.softtechspringboot.Service.EntityService;

import org.springframework.stereotype.Service;
import softtech.softtechspringboot.Entity.Product;
import softtech.softtechspringboot.Repository.ProductDao;
import softtech.softtechspringboot.Service.BaseEntityService;

@Service
public class ProductEntityService extends BaseEntityService<Product, ProductDao> {

    public ProductEntityService(ProductDao dao) {
        super(dao);
    }

    public Product getById(Long id) {
        return getDao().getById(id);
    }
}
