package com.willfp.demoextension;

import com.willfp.ecoenchants.EcoEnchantsPlugin;
import com.willfp.ecoenchants.enchantments.EcoEnchant;
import com.willfp.ecoenchants.extensions.Extension;
import org.bukkit.Bukkit;

public class Main extends Extension {
    public static final EcoEnchant NIGHT_VISION = new NightVision();
    public static final EcoEnchant WATER_BREATHING = new WaterBreathing();
    public static final EcoEnchant SPEED = new Speed();
    public static final EcoEnchant JUMP_BOOST = new JumpBoost();

    // Called when the extension is loaded/enabled
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(NIGHT_VISION, EcoEnchantsPlugin.getInstance());
        Bukkit.getPluginManager().registerEvents(WATER_BREATHING, EcoEnchantsPlugin.getInstance());
        Bukkit.getPluginManager().registerEvents(SPEED, EcoEnchantsPlugin.getInstance());
        Bukkit.getPluginManager().registerEvents(JUMP_BOOST, EcoEnchantsPlugin.getInstance());
    }

    // Called when the extension is unloaded/disabled
    public void onDisable() {

    }
}
