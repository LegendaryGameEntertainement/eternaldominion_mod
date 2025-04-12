package com.eternaldominion.commands;

import com.eternaldominion.data.KingdomSavedData;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class CommandJoinKingdom {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("join")
                .then(Commands.argument("kingdom", StringArgumentType.word())
                        .suggests((context, builder) -> {
                            builder.suggest("OverWorld");
                            builder.suggest("Nether");
                            builder.suggest("Ender");
                            return builder.buildFuture();
                        })
                        .executes(ctx -> {
                            ServerPlayer player = ctx.getSource().getPlayerOrException();
                            String kingdom = StringArgumentType.getString(ctx, "kingdom");
                            KingdomSavedData data = KingdomSavedData.get(player.serverLevel());
                            data.setKingdom(player.getUUID(), kingdom);
                            player.sendSystemMessage(Component.literal("Tu as rejoint le royaume : " + kingdom));
                            return 1;
                        })
                )
        );
    }
}
