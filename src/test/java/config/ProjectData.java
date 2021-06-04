package config;

import org.aeonbits.owner.ConfigFactory;

public class ProjectData {
    public static final BrowserStackConfig browserStackConfig =
            ConfigFactory.create(BrowserStackConfig.class, System.getProperties());
    public static final IosConfig iosConfig =
            ConfigFactory.create(IosConfig.class, System.getProperties());
    public static final AndroidConfig androidConfig =
            ConfigFactory.create(AndroidConfig.class, System.getProperties());
}
