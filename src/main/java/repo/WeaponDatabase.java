package repo;

import com.lgrr.unitework.models.Weapon;
import lombok.AllArgsConstructor;
import repo.infrestucture.MongoRepo;
import repo.infrestucture.MySqlRepo;
import repo.infrestucture.PostgreSql;

/**
 *
 * @author gera_
 */

@AllArgsConstructor
public class WeaponDatabase {
    private String dbInstace;
    
    private IRepository<Weapon> useRepository(){
        switch (dbInstace) {
            case "mongo" -> {
                System.out.println("Using Mongo");
                return new MongoRepo();
            }
                
             case "Mysql" -> {
                 System.out.println("Using Mysql");
                 return new MySqlRepo();
            }

             case "PostgreSQL" -> {
                 System.out.println("Using PostgreSQL");
                 return new PostgreSql();
            }
            default -> throw new AssertionError();
        }
    }
    
    public IRepository<Weapon> getInstance(){
        return useRepository();
    }
}
