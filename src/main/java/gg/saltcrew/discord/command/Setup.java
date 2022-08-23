package gg.saltcrew.discord.command;

import gg.saltcrew.discord.util.BotConstants;
import org.javacord.api.entity.message.MessageFlag;
import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.javacord.api.listener.interaction.SlashCommandCreateListener;

public class Setup implements SlashCommandCreateListener {

    @Override
    public void onSlashCommandCreate(SlashCommandCreateEvent event) {
        SlashCommandInteraction slashCommandInteraction = event.getSlashCommandInteraction();
        if (!slashCommandInteraction.getCommandName().equalsIgnoreCase(BotConstants.COMMAND_SETUP)) {
            return;
        }

        slashCommandInteraction.createImmediateResponder()
                .setContent("Pong!")
                .setFlags(MessageFlag.EPHEMERAL)
                .respond();
    }
}
