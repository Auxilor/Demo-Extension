package com.willfp.demoextension;

import com.willfp.ecoenchants.EcoEnchantsPlugin;
import com.willfp.ecoenchants.enchantments.EcoEnchant;
import com.willfp.ecoenchants.enchantments.util.EnchantChecks;
import com.willfp.ecoenchants.events.armorequip.ArmorEquipEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Speed extends EcoEnchant {
    public Speed() {
        super("speed", EnchantmentType.NORMAL, Main.class);
    }

    @EventHandler
    public void onEquip(ArmorEquipEvent event) {
        final Player player = event.getPlayer();

        Bukkit.getScheduler().runTaskLater(EcoEnchantsPlugin.getInstance(), () -> {
            if (!EnchantChecks.boots(player, Main.SPEED)) {
                if (player.hasPotionEffect(PotionEffectType.SPEED)) {
                    if (player.getPotionEffect(PotionEffectType.SPEED).getDuration() >= 1639) {
                        player.removePotionEffect(PotionEffectType.SPEED);
                    }
                }
            }

            int level = EnchantChecks.getBootsLevel(player, Main.SPEED);

            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000000, level-1, false, false, true));
        }, 1);
    }
}
