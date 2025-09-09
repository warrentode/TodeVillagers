package com.github.warrentode.todevillagers.datagen.loot_tables;

import com.github.warrentode.todevillagers.block.ModBlocks;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class BlockLootTablesGen extends VanillaBlockLoot {

    public BlockLootTablesGen() {
        super();
    }

    @Override
    protected void generate() {
        this.add(ModBlocks.GLASS_KILN_BLOCK.get(),
                this::createNameableBlockEntityTable);
        this.add(ModBlocks.CERAMICS_TABLE.get(),
                this::createNameableBlockEntityTable);
        this.add(ModBlocks.WHEEL_CART.get(),
                this::createNameableBlockEntityTable);

        List<Block> blockList = ForgeRegistries.BLOCKS.getValues().stream()
                .filter(item -> item.getDescriptionId().contains(MODID))
                .filter(item -> !item.getDescriptionId().contains("glass_kiln"))
                .filter(item -> !item.getDescriptionId().contains("ceramics_table"))
                .filter(item -> !item.getDescriptionId().contains("wheel_cart"))
                .toList();

        blockList.forEach(this::dropSelf);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getValues().stream()
                .filter(block -> MODID.equals(Objects.requireNonNull(
                                ForgeRegistries.BLOCKS.getKey(block))
                        .getNamespace())).collect(Collectors.toSet());
    }
}