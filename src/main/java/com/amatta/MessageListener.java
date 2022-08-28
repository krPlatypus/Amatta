package com.amatta;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class MessageListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        //TextChannel textChannel = event.getGuild().getTextChannelsByName("amongus", true).get(0);
        Message msg = event.getMessage();
        try{
            String[] commands = msg.getContentRaw().split(" ");
            if(commands.length >= 2){
                String command = commands[0];
                Integer price = Integer.parseInt(commands[1]);
                if (command.equals("!경매")) {
                    EmbedBuilder eb = new EmbedBuilder();
                    eb.setTitle(String.format("%sG 경매 입찰가", price), null);

                    eb.setColor(Color.darkGray);
                    //eb.setColor(new Color(0xF40C0C));
                    //eb.setColor(new Color(255, 0, 54));

                    //eb.setDescription("Text");

                    Auction four = new Auction(4, price);
                    Auction eight = new Auction(8, price);

                    eb.addField("4인", four.toString(), true);
                    eb.addField("8인", eight.toString(), true);

                    eb.addBlankField(false);
                    eb.setFooter(null);

                    //eb.setAuthor("name", null, "https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/zekroBot_Logo_-_round_small.png");

                    //eb.setFooter("Text", "https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/zekroBot_Logo_-_round_small.png");

                    //eb.setImage("https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/logo%20-%20title.png");

                    //eb.setThumbnail("https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/logo%20-%20title.png");

                    msg.getChannel().sendMessageEmbeds(eb.build()).queue();
                }
            }
        }catch (Exception e){

        }

    }
}
