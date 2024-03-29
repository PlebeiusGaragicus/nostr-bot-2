/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nostr.bot.util;

import java.io.IOException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.extern.java.Log;
import nostr.base.BaseConfiguration;

/**
 *
 * @author eric
 */
@Log
@Data
@EqualsAndHashCode(callSuper = false)
abstract class BotBaseConfiguration extends BaseConfiguration {

    private final String prefix;

    public BotBaseConfiguration(String file, @NonNull String prefix) throws IOException {
        super(file);
        this.prefix = prefix;
    }

    @Override
    protected String getProperty(String key) {
        return this.properties.getProperty(this.prefix + "." + key);
    }

    protected String getProperty(String otherPrefix, String key) {
        return this.properties.getProperty(otherPrefix + "." + key);
    }

}
