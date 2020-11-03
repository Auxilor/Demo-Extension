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

public class NightVision extends EcoEnchant {
    public NightVision() {
        super("night_vision", EnchantmentType.NORMAL, Main.class);
    }

    @EventHandler
    public void onEquip(ArmorEquipEvent event) {
        final Player player = event.getPlayer();

        Bukkit.getScheduler().runTaskLater(EcoEnchantsPlugin.getInstance(), () -> {
            if (!EnchantChecks.helmet(player, Main.NIGHT_VISION)) {
                if (player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                    if (player.getPotionEffect(PotionEffectType.NIGHT_VISION).getDuration() >= 1639) {
                        player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                    }
                }
            }

            int level = EnchantChecks.getHelmetLevel(player, Main.NIGHT_VISION);

            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000000, level-1, false, false, true));
        }, 1);
    }
}
