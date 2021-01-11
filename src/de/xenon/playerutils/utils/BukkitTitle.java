package de.xenon.playerutils.utils;
import net.minecraft.server.v1_16_R3.*;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class BukkitTitle {
    public static void sendTitle(Player player, String title, String subtitle, int fadein, int stay, int fadeout) {
        PlayerConnection connection = (((CraftPlayer)player).getHandle()).playerConnection;
        IChatMutableComponent iChatMutableComponent1 = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\" }");
        IChatMutableComponent iChatMutableComponent2 = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\" }");
        PacketPlayOutTitle titleTime = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, (IChatBaseComponent)iChatMutableComponent1, fadein, stay, fadeout);
        PacketPlayOutTitle subTitleTime = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, (IChatBaseComponent)iChatMutableComponent2);
        PacketPlayOutTitle titlePacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, (IChatBaseComponent)iChatMutableComponent1);
        PacketPlayOutTitle subTitlePacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, (IChatBaseComponent)iChatMutableComponent2);
        connection.sendPacket((Packet)titleTime);
        connection.sendPacket((Packet)subTitleTime);
        connection.sendPacket((Packet)titlePacket);
        connection.sendPacket((Packet)subTitlePacket);
    }
}
