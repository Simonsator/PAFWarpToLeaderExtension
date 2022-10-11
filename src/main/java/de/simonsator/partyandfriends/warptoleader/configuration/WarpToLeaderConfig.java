package de.simonsator.partyandfriends.warptoleader.configuration;

import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;

/**
 * @author 00pfl
 * @version 1.0 09.06.2017.
 */
public class WarpToLeaderConfig extends ConfigurationCreator {
	public WarpToLeaderConfig(File pFile, PAFExtension pPlugin) throws IOException {
		super(pFile, pPlugin, true);
		readFile();
		loadDefaults();
		saveFile();
		process();
	}

	private void loadDefaults() {
		set("Commands.Party.WarpToLeader.Names", "leaderwarp", "unite");
		set("Commands.Party.WarpToLeader.CommandUsage", "&8/&5Party leaderwarp  &8- &7Teleports all players to the party leader");
		set("Commands.Party.WarpToLeader.Permission", "");
		set("Commands.Party.WarpToLeader.Priority", 10);
		set("Messages.WarpedToLeader", "&bYou were warped to the party leader.");
		set("Messages.TeleportedToYou", "&bAll party members were teleported to you.");
	}
}
