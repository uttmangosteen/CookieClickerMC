package io.github.uttmangosteen.cookieclickermc;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {
    public static JavaPlugin config, plugin;
    @Override
    public void onEnable() {
        config = this;
        saveDefaultConfig();
        plugin = this;
        Timer.perSecond();
        Objects.requireNonNull(getCommand("cc")).setExecutor(new Command());
        new Event(this);
    }
    @Override
    public void onDisable() {
    }
}
