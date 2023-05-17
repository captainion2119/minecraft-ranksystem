package com.ltnoname.rank_system;

import org.bukkit.ChatColor;

public enum Rank {

    OWNER(ChatColor.DARK_RED + "OWNER",new String[]{"worldedit.help"}),
    ADMIN(ChatColor.RED + "ADMIN",new String[]{"worldedit.help"}),
    MEMBER(ChatColor.BLUE + "MEMBER",new String[]{}),
    GUEST(ChatColor.GREEN + "GUEST",new String[]{});

    private String display;
    private String[] permissions;

    Rank(String display, String[] permissions) {
        this.display = display;
        this.permissions = permissions;
    }

    public String getDisplay() { return display; }
    public String[] getPermissions() { return permissions; }

}
