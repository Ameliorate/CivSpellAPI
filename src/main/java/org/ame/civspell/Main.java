package org.ame.civspell;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        SpellManager.addSpell("nop", new NopSpell());
        this.getCommand("givescroll").setExecutor(new CommandGiveScroll(this));
        getServer().getPluginManager().registerEvents(new Scroll(this), this);
        System.out.println("CivSpellAPI Enabled.");
    }

    @Override
    public void onDisable() {
        System.out.println("CivSpellAPI Disabled.");
    }

    private class NopSpell implements Spell {

        @Override
        public void cast(PlayerInteractEvent event) {
            System.out.println("NOP");
        }

        @Override
        public boolean canBeScroll() {
            return true;
        }

        @Override
        public boolean canBePage() {
            return true;
        }

        @Override
        public boolean canBeMemorized() {
            return true;
        }
    }
}
