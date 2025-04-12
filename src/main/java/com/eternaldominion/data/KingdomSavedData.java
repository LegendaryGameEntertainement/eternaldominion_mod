package com.eternaldominion.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class KingdomSavedData extends SavedData {
    private final Map<UUID, String> kingdomMap = new HashMap<>();

    public static KingdomSavedData get(ServerLevel level) {
        return level.getDataStorage().computeIfAbsent(KingdomSavedData::load, KingdomSavedData::new, "eternaldominion_kingdoms");
    }

    public void setKingdom(UUID uuid, String kingdom) {
        kingdomMap.put(uuid, kingdom);
        setDirty();
    }

    public String getKingdom(UUID uuid) {
        return kingdomMap.getOrDefault(uuid, "None");
    }

    public static KingdomSavedData load(CompoundTag tag) {
        KingdomSavedData data = new KingdomSavedData();
        ListTag list = tag.getList("kingdoms", Tag.TAG_COMPOUND);
        for (Tag entry : list) {
            CompoundTag compound = (CompoundTag) entry;
            data.kingdomMap.put(compound.getUUID("uuid"), compound.getString("kingdom"));
        }
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag tag) {
        ListTag list = new ListTag();
        for (Map.Entry<UUID, String> entry : kingdomMap.entrySet()) {
            CompoundTag compound = new CompoundTag();
            compound.putUUID("uuid", entry.getKey());
            compound.putString("kingdom", entry.getValue());
            list.add(compound);
        }
        tag.put("kingdoms", list);
        return tag;
    }
}
