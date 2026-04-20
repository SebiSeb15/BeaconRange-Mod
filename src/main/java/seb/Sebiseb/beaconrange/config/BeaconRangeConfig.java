package seb.Sebiseb.beaconrange.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.nio.file.*;

public class BeaconRangeConfig {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH = FabricLoader.getInstance()
            .getConfigDir().resolve("beaconrange.json");

    // Valeurs par défaut
    public int level1 = 20;
    public int level2 = 30;
    public int level3 = 40;
    public int level4 = 50;

    private static BeaconRangeConfig instance;

    public static BeaconRangeConfig get() {
        if (instance == null) load();
        return instance;
    }

    public int getRangeForLevel(int level) {
        return switch (level) {
            case 1 -> instance.level1;
            case 2 -> instance.level2;
            case 3 -> instance.level3;
            case 4 -> instance.level4;
            default -> 20;
        };
    }

    public static void load() {
        if (Files.exists(CONFIG_PATH)) {
            try (Reader reader = Files.newBufferedReader(CONFIG_PATH)) {
                instance = GSON.fromJson(reader, BeaconRangeConfig.class);
            } catch (IOException e) {
                System.err.println("[BeaconRange] Erreur de lecture du fichier config : " + e.getMessage());
                instance = new BeaconRangeConfig();
            }
        } else {
            instance = new BeaconRangeConfig();
            save(); // Génère le fichier avec les valeurs par défaut
        }
    }

    public static void save() {
        try (Writer writer = Files.newBufferedWriter(CONFIG_PATH)) {
            GSON.toJson(instance, writer);
        } catch (IOException e) {
            System.err.println("[BeaconRange] Erreur de sauvegarde de la config : " + e.getMessage());
        }
    }
}