package io.github.uttmangosteen.cookieclickermc;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static JavaPlugin config, plugin;
    @Override
    public void onEnable() {
        config = this;
        saveDefaultConfig();
        plugin = this;
        Timer.perSecond();
        getCommand("cc").setExecutor(new Command());
        new Event(this);
    }
    @Override
    public void onDisable() {
    }
}
