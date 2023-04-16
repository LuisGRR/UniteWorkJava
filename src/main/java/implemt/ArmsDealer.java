package implemt;

import InterfazUnit.IUnitOfWork;
import com.lgrr.unitework.models.Weapon;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import repo.WeaponDatabase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArmsDealer implements IUnitOfWork<Weapon> {

    private final Map<String, List<Weapon>> context;
    private final WeaponDatabase weaponDatabase;

    @Override
    public void registerNew(Weapon weapon) {
        System.out.println("Register for insert in context");
        register(weapon, INSERT);
    }

    @Override
    public void registerModified(Weapon weapon) {
        System.out.println("Register for registerModified in context");

        register(weapon, MODIFY);
    }

    @Override
    public void registerDeleted(Weapon weapon) {
        System.out.println("Register for registerDeleted in context");

        register(weapon, DELETE);
    }

    @Override
    public void commit() {
        if (context == null || context.isEmpty()) {
            return;
        }
        System.out.println("Commit started");
        if (context.containsKey(INSERT)) {
            commitInsert();
        }

        if (context.containsKey(MODIFY)) {
            commitModify();
        }
        if (context.containsKey(DELETE)) {
            commitDelete();
        }
        System.out.println("commit finished");
    }

    private void register(Weapon weapon, String operation) {
        var weaponsToOperate = context.get(operation);
        if (weaponsToOperate == null) {
            weaponsToOperate = new ArrayList<>();
        }
        weaponsToOperate.add(weapon);
        context.put(operation, weaponsToOperate);
    }

    private void commitInsert() {
        var weaponsToBeInserted = context.get(INSERT);
        for (var weapon : weaponsToBeInserted) {
            System.out.println("Inserting a new weapon to sales rack");
            weaponDatabase.getInstance().insert(weapon);
        }
    }

    private void commitModify() {
        var modifiedWeapons = context.get(MODIFY);
        for (var weapon : modifiedWeapons) {
            System.out.println("IScheduling for modification work");
            weaponDatabase.getInstance().modify(weapon);
        }
    }

    private void commitDelete() {
        var deletedWeapons = context.get(DELETE);
        for (var weapon : deletedWeapons) {
            System.out.println("Scrapping");
            weaponDatabase.getInstance().delete(weapon);
        }
    }
}
