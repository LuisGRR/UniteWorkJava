package repo.infrestucture;

import com.lgrr.unitework.models.Weapon;
import repo.IRepository;


/**
 *
 * @author gera_
 */
public class PostgreSql implements IRepository<Weapon>{

    @Override
    public void insert(Weapon entity) {
        System.out.println("Insert PostgreSQLBD");
    }

    @Override
    public void delete(Weapon entity) {
        System.out.println("Delete PostgreSQLBD");
    }

    @Override
    public void modify(Weapon entity) {
        System.out.println("Modify PostgreSQLBD");
    }

    @Override
    public Weapon findById(String id) {
        System.out.println("FindById PostgreSQLDB");
        return null;
    }
    
}
