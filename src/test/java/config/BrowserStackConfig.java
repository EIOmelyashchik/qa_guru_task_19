package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/browserstack.properties"
})
public interface BrowserStackConfig extends Config {
    @Key("url")
    String url();

    @Key("sessions_url")
    String sessionsUrl();

    @Key("bsLogin")
    String bsLogin();

    @Key("bsPassword")
    String bsPassword();
}
