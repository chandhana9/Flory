package bot.discord.dbsk;

import discord.*;
import bot.discord.api.*;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionAddEvent;

//DBSK v1.0.1

/* GUIDE ON HOW TO USE THIS STARTER KIT
 * 
 * Hello! This is a starter kit made by FrankWhoee on GitHub! Here's the link to my profile: https://github.com/FrankWhoee
 * This starter kit is not meant to do everything for you, but merely to provide some starting ground to begin your adventure.
 * You can use this kit however you like, and feel free to dive into the Discord.java file to change and make your bot even better!
 * I encourage you to play around with the JDA class in there, after you are familiar with Java and JDA. This starter kit is made for
 * BNSS Coding Club members, but anyone can use this.
 * 
 * INSTRUCTIONS FOR NON-BNSS CODING CLUB MEMBERS:
 * Some of the constants are set specifically for BNSS Coding Club, but if you are not part of that, then you should
 * go to the Constants.java file in the package discord, and change Line 9. It's the id for the text channel where messages are sent
 * by default, and it's the id for a channel in our own server, so you'll have to create your own server and text channel, copy the id
 * of the text channel and replace 485449484705202186 with your own id.
 * 
 * INSTRUCTIONS FOR EVERYONE:
 * Since you'll be creating your own bot, you need to have your own token. Here are the steps to do so:
 * 
 * PREREQUISITE(S):
 * -You must have a Discord account.
 * 
 * 1. Go to the website: https://discordapp.com/developers/applications/
 * 2. Go to the Applications tab on the top of the page and click 'Create an application'
 * 3. Customise your application, then go to the Bot section by clicking on 'Bot' on the menu on the left
 * 4. Click 'Add Bot' and confirm by clicking 'Yes, do it!'
 * 5. Click 'Click to Reveal Token' and copy it. 
 * 6. Go to the token.json file in your DBSK folder, and replace Insert token. with your token.
 * 
 * WARNING:
 * NEVER reveal your token to anyone but your people who you are collaborating with. Do not post it online where anyone can see the token!
 * */

public class App 
{
	//Declare the variable discord, making it static so we can use it in other methods.
	public static Discord discord;
    public static void main( String[] args ){    	
    	//Initialise the Discord Bot with your token.
    	discord = new Discord(Constants.TOKEN);
		
    	//Set name
    	discord.setName("Discord Bot Starter Kit");
    	
        //Send a message.
        discord.sendMessage(discord.getStatusMessage());
        discord.sendMessage("Hello World");

        //Set up Music
        Music.setDiscord(discord);
        Music.configureMusic();

    }
    
    public static void messageEvent(MessageReceivedEvent evt) {
    	//When a message is sent, this method will be called.
    	//evt contains all the information you need about the message.
        Message objMsg = evt.getMessage();
        MessageChannel objMsgCh = evt.getChannel();

        if(!objMsg.getContentRaw().startsWith(Constants.PREFIX)){
            return;
        }

        String command = objMsg.getContentRaw().substring(1);
        try{
            command = objMsg.getContentRaw().substring(1,objMsg.getContentRaw().indexOf(" "));
        }catch(Exception e){}
        String input = "";
        try{
            input =  objMsg.getContentRaw().substring(objMsg.getContentRaw().indexOf(" "));
        }catch(Exception e){}
        
        if(command.equals(Constants.PREFIX + "repeat")){
            for(int i = 0; i < 5; i++){
                discord.sendMessage("@Kieran Ross My name jeff");
            }
        }else if(command.equals(Constants.PREFIX + "ping")){
            discord.sendMessage("pong");
        }
        if(objMsg.getContentRaw().equals(Constants.PREFIX + "repeat")){
            for(int i = 0; i < 5; i++){
                discord.sendMessage("get it");
            }
        }else if(objMsg.getContentRaw().equals(Constants.PREFIX + "weather")){
            API api = new API();
            try{
                discord.sendMessage(api.getWeather("Vancouver","Ca",0));
            }catch(Exception e){
                
            }
        }else if(objMsg.getContentRaw().equals(Constants.PREFIX + "ping")){
                discord.sendMessage("pong");
        }else if (command.equals("spongebob")){
            String output = "";
            for(int i = 0; i < input.length(); i ++){
                output+= input.substring(i, i+1)+ " ";
            }
            discord.sendMessage(output);
        }
    }    
   
    
    public static void emojiEvent(MessageReactionAddEvent evt) {
    	//When an emoji is added to a message, this method will be called.
    	//evt contains all the information you need about the emoji.
    }
}
