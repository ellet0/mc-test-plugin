package com.ahmedhnewa.mymctestplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public final class MyMcTestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return super.onCommand(sender, command, label, args);
    }

    public void sendReq() {
        // We also could run this task using kotlin Coroutines, but this is project is just for testing
        Bukkit.getServer().getScheduler().runTaskAsynchronously(getPlugin(MyMcTestPlugin.class), () -> {
            try {
                URL url = new URL("http://localhost:3000/");
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                URLConnection connection = url.openConnection();
//                connection.setRequestMethod("GET");
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                connection.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null)
                    System.out.println(inputLine);
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void read() {
        URL resource = /*MyMcTestPlugin.class.*/getClassLoader().getResource("plugin.yml");
        if (resource != null) {
            File file = new File(resource.getFile());
            if (!file.exists()) return;
            try {
                System.out.println(new BufferedReader(new FileReader(file)).readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("resource is null");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
