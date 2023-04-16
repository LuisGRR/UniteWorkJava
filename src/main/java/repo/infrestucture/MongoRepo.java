package repo.infrestucture;

import com.lgrr.unitework.models.Weapon;
import repo.IRepository;

/**
 *
 * @author gera_
 */
public class MongoRepo implements IRepository<Weapon>{

    @Override
    public void insert(Weapon entity) {
        System.out.println("Insert mongoBD");
    }

    @Override
    public void delete(Weapon entity) {
        System.out.println("Delete mongoBD");
    }

    @Override
    public void modify(Weapon entity) {
        System.out.println("Modify mongoBD");
    }

    @Override
    public Weapon findById(String id) {
        System.out.println("FindById mongoDB");
        return null;
    }
   
}
