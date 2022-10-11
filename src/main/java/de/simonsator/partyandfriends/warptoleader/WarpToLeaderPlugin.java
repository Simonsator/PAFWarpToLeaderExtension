package de.simonsator.partyandfriends.warptoleader;

import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.party.command.PartyCommand;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;
import de.simonsator.partyandfriends.warptoleader.commands.party.subcommands.WarpCommand;
import de.simonsator.partyandfriends.warptoleader.configuration.WarpToLeaderConfig;

import java.io.File;
import java.io.IOException;

/**
 * @author Simonsator
 * @version 1.0 09.06.2017.
 */
@SuppressWarnings("unused")
public class WarpToLeaderPlugin extends PAFExtension {
	@Override
	public void onEnable() {
		try {
			ConfigurationCreator config = new WarpToLeaderConfig(new File(getConfigFolder(), "config.yml"), this);
			PartyCommand.getInstance().addCommand(new WarpCommand(config.getStringList("Commands.Party.WarpToLeader.Names"),
					config.getInt("Commands.Party.WarpToLeader.Priority"), config.getString("Commands.Party.WarpToLeader.CommandUsage"),
					config.getString("Commands.Party.WarpToLeader.Permission"), config));
			registerAsExtension();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
