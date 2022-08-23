package gg.saltcrew.discord;

import gg.saltcrew.discord.command.Setup;
import gg.saltcrew.discord.util.BotConstants;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.interaction.SlashCommand;
import org.javacord.api.interaction.SlashCommandOption;
import org.javacord.api.interaction.SlashCommandOptionType;

import java.util.Arrays;

public class Saltcrew {

    public final static String DISCORD_TOKEN = System.getProperty("DISCORD_TOKEN");

    public static void main(String[] args) {
        DiscordApi discordApi = new DiscordApiBuilder().setToken(DISCORD_TOKEN).login().join();

        // Commands
        SlashCommand setupCommand = SlashCommand.with(BotConstants.COMMAND_SETUP, "Setup the bot for the given server.",
                        Arrays.asList(
                                SlashCommandOption.create(SlashCommandOptionType.CHANNEL, "pug-text-channel", "Text channel for pug commands to work.", true)
                        )
                )
                .createGlobal(discordApi)
                .join();

        // Command Listeners
        discordApi.addSlashCommandCreateListener(new Setup());
    }
}
