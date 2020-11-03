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

public class WaterBreathing extends EcoEnchant {
    public WaterBreathing() {
        super("water_breathing", EnchantmentType.NORMAL, Main.class);
    }

    @EventHandler
    public void onEquip(ArmorEquipEvent event) {
        final Player player = event.getPlayer();

        Bukkit.getScheduler().runTaskLater(EcoEnchantsPlugin.getInstance(), () -> {
            if (!EnchantChecks.helmet(player, Main.WATER_BREATHING)) {
                if (player.hasPotionEffect(PotionEffectType.WATER_BREATHING)) {
                    if (player.getPotionEffect(PotionEffectType.WATER_BREATHING).getDuration() >= 1639) {
                        player.removePotionEffect(PotionEffectType.WATER_BREATHING);
                    }
                }
            }

            int level = EnchantChecks.getHelmetLevel(player, Main.WATER_BREATHING);

            player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 1000000000, level-1, false, false, true));
        }, 1);
    }
}
