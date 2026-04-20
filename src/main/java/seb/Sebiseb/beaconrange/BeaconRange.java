package seb.Sebiseb.beaconrange;

import net.fabricmc.api.ModInitializer;
import seb.Sebiseb.beaconrange.config.BeaconRangeConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeaconRange implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("beaconrange");

    @Override
    public void onInitialize() {
        BeaconRangeConfig.load();
        LOGGER.info("[BeaconRange] Chargé !");
    }

}
