package de.simonsator.partyandfriends.velocity.warptoleader;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import de.simonsator.partyandfriends.velocity.VelocityExtensionLoadingInfo;
import de.simonsator.partyandfriends.velocity.main.PAFPlugin;

import java.nio.file.Path;

@Plugin(id = "warptoleaderextension", name = "WarpToLeaderExtension", version = "1.0.2-RELEASE",
		url = "https://www.spigotmc.org/resources/party-leaderwarp-extension-for-party-and-friends.70835/",
		description = "An add-on for party and friends to add /party leaderwarp"
		, authors = {"JT122406", "Simonsator"}, dependencies = {@Dependency(id = "partyandfriends")})
public class WarpToLeaderLoader {

	private final Path folder;


	@Inject
	public WarpToLeaderLoader(@DataDirectory final Path pFolder) {
		folder = pFolder;
	}

	@Subscribe
	public void onProxyInitialization(ProxyInitializeEvent event) {
		PAFPlugin.loadExtension(new VelocityExtensionLoadingInfo(new WarpToLeaderPlugin(folder),
				"warptoleaderextension",
				"WarpToLeaderExtension",
				"1.0.2-RELEASE", "JT122406, Simonsator"));
	}

}
