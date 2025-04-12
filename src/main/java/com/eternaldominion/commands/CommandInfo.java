package com.eternaldominion.commands;

import com.eternaldominion.data.KingdomSavedData;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;

public class CommandInfo {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("info")
                .requires(source -> source.hasPermission(2))
                .then(Commands.argument("player", StringArgumentType.word())
                        .executes(ctx -> {
                            String name = StringArgumentType.getString(ctx, "player");
                            MinecraftServer server = ctx.getSource().getServer();
                            ServerPlayer target = server.getPlayerList().getPlayerByName(name);

                            if (target != null) {
                                String kingdom = KingdomSavedData.get(target.serverLevel()).getKingdom(target.getUUID());
                                ctx.getSource().sendSystemMessage(Component.literal("Infos de " + name + " :"));
                                ctx.getSource().sendSystemMessage(Component.literal(" - Royaume : " + kingdom));
                                return 1;
                            } else {
                                ctx.getSource().sendSystemMessage(Component.literal("Joueur non trouvé."));
                                return 0;
                            }
                        })
                )
        );
    }
}
