package repo.infrestucture;

import com.lgrr.unitework.models.Weapon;
import repo.IRepository;

/**
 *
 * @author gera_
 */
public class MySqlRepo implements IRepository<Weapon>{

    @Override
    public void insert(Weapon entity) {
        System.out.println("Insert MysqlBD");
    }

    @Override
    public void delete(Weapon entity) {
        System.out.println("Delete MysqlBD");
    }

    @Override
    public void modify(Weapon entity) {
        System.out.println("Modify MysqlBD");
    }

    @Override
    public Weapon findById(String id) {
        System.out.println("FindById MysqlDB");
        return null;
    }
   
}
