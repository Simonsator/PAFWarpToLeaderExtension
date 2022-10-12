package de.simonsator.partyandfriends.velocity.warptoleader.commands.party.subcommands;

import de.simonsator.partyandfriends.velocity.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.velocity.api.party.PartyManager;
import de.simonsator.partyandfriends.velocity.api.party.PlayerParty;
import de.simonsator.partyandfriends.velocity.api.party.abstractcommands.LeaderNeededCommand;
import de.simonsator.partyandfriends.velocity.utilities.ConfigurationCreator;

import java.util.List;

import static de.simonsator.partyandfriends.velocity.main.Main.getInstance;

public class WarpCommand extends LeaderNeededCommand {
	private final ConfigurationCreator CONFIG;

	public WarpCommand(List<String> pCommands, int pPriority, String pHelpText, String pPermission, ConfigurationCreator pConfig) {
		super(pCommands, pPriority, pHelpText, pPermission);
		CONFIG = pConfig;
	}

	@Override
	public void onCommand(OnlinePAFPlayer pPlayer, String[] args) {
		PlayerParty party = PartyManager.getInstance().getParty(pPlayer);
		if (!isInParty(pPlayer, party)) {
			return;
		}
		if (!party.isLeader(pPlayer)) {
			pPlayer.sendMessage(PREFIX
					+ getInstance().getMessages().getString("Party.Command.General.ErrorNotPartyLeader"));
			return;
		}
		for (OnlinePAFPlayer players : party.getPlayers()) {
			if (players.teleportTo(pPlayer))
				players.sendMessage(PREFIX + CONFIG.getString(("Messages.WarpedToLeader")));
		}
		pPlayer.sendMessage(PREFIX + CONFIG.getString("Messages.TeleportedToYou"));
	}
}
