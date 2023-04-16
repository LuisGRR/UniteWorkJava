package com.lgrr.unitework;

import com.lgrr.unitework.models.Weapon;
import implemt.ArmsDealer;
import java.util.HashMap;
import repo.WeaponDatabase;

/**
 *
 * @author gera_
 */
public class Unitework {

    public static void main(String[] args) {
        // create some weapons
        var enchantedHammer = new Weapon(1, "enchanted hammer");
        var brokenGreatSword = new Weapon(2, "broken great sword");
        var silverTrident = new Weapon(3, "silver trident");

        // create repository
        var weaponRepository = new ArmsDealer(new HashMap<>(), new WeaponDatabase("PostgreSQL"));
        weaponRepository.registerNew(enchantedHammer);
        weaponRepository.registerModified(silverTrident);
        weaponRepository.registerDeleted(brokenGreatSword);
        weaponRepository.commit();
    }
}
