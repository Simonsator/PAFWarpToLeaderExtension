package de.simonsator.partyandfriends.velocity.warptoleader;

import de.simonsator.partyandfriends.velocity.api.PAFExtension;
import de.simonsator.partyandfriends.velocity.party.command.PartyCommand;
import de.simonsator.partyandfriends.velocity.utilities.ConfigurationCreator;
import de.simonsator.partyandfriends.velocity.warptoleader.commands.party.subcommands.WarpCommand;
import de.simonsator.partyandfriends.velocity.warptoleader.configuration.WarpToLeaderConfig;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * @author Simonsator
 * @version 1.0 09.06.2017.
 */
@SuppressWarnings("unused")
public class WarpToLeaderPlugin extends PAFExtension {
	public WarpToLeaderPlugin(Path folder) {
		super(folder);
	}

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

	@Override
	public String getName() {
		return "WarpToLeaderExtension";
	}
}
