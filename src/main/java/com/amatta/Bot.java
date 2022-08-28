package com.amatta;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;

public class Bot {
    public static void main(String[] args) {
        new Bot().run();
    }

    private void run() {
        JDABuilder builder = JDABuilder.createDefault("OTUzNzgwMTYxODA1OTUxMDI2.YjJi_g.BzMeiDlpiOQ1_qAdF_zgdSAeaPI");
        configureMemoryUsage(builder);
        builder.setAutoReconnect(true);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.addEventListeners(new MessageListener());
        try {
            builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public void configureMemoryUsage(JDABuilder builder) {
        // Disable cache for member activities (streaming/games/spotify)
        builder.disableCache(CacheFlag.ACTIVITY);

        // Only cache members who are either in a voice channel or owner of the guild
        builder.setMemberCachePolicy(MemberCachePolicy.VOICE.or(MemberCachePolicy.OWNER));

        // Disable member chunking on startup
        builder.setChunkingFilter(ChunkingFilter.NONE);

        // Consider guilds with more than 50 members as "large".
        // Large guilds will only provide online members in their setup and thus reduce bandwidth if chunking is disabled.
        builder.setLargeThreshold(50);
        // Set activity (like "playing Something")
        builder.setActivity(Activity.watching("일 하는중"));
    }
}
