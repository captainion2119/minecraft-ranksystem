package com.ltnoname.rank_system;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankCommand implements CommandExecutor {

    // /rank <player> <rank>

    private Main main;

    public RankCommand(Main main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if(player.isOp()) {
                if (args.length == 2) {
                    if (Bukkit.getOfflinePlayer(args[0]) != null) {
                        OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
                        for (Rank rank : Rank.values()) {
                            if (rank.name().equalsIgnoreCase(args[1])) {
                                main.getRankManager().setRank(target.getUniqueId(),rank,false);
                                player.sendMessage(ChatColor.GREEN + target.getName() + "'s rank to " + rank.getDisplay() + ChatColor.GREEN + ".");
                                if (target.isOnline()) {
                                    target.getPlayer().sendMessage(ChatColor.GREEN + player.getName() + " set your rank to " + rank.getDisplay() + ChatColor.GREEN + ".");
                                }
                                return false;
                            }
                        }
                        player.sendMessage(ChatColor.RED + "Invalid rank specified!");
                    } else {
                        player.sendMessage(ChatColor.RED + "This player has never been on this server!");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Invalid Usage use /rank <player> <rank>");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You must be an OP to use this!");
            }
        }
        return false;
    }
}
