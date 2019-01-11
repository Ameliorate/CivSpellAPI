package pw.amel.civspell.builtin;

import org.bukkit.configuration.ConfigurationSection;
import pw.amel.civspell.spell.CastData;
import pw.amel.civspell.spell.Effect;

/**
 * Simple test spell that makes a sound and some particles.
 */
public class NopEffect implements Effect {
    public NopEffect(ConfigurationSection config) {
        this.isFancy = config.getBoolean("isFancy", false);
    }

    private boolean isFancy;

    @Override
    public void cast(CastData d) {
        if (isFancy) {
            d.player.sendMessage("§3The spell wooshes away, doing nothing.");
            d.player.getEyeLocation().getWorld().playEffect(d.player.getLocation(), org.bukkit.Effect.EXPLOSION_HUGE, null, 10);
            d.player.getEyeLocation().getWorld().playEffect(d.player.getLocation(), org.bukkit.Effect.GHAST_SHOOT, null, 10);
        }
    }
}
