package dev.enjarai.healthymobs;

import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HealthyMobs implements ModInitializer {
	public static final String MOD_ID = "healthy-mobs";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final TagKey<EntityType<?>> MORE_HEALTHY = TagKey.of(RegistryKeys.ENTITY_TYPE, id("more_healthy"));
	public static final TagKey<EntityType<?>> LESS_HEALTHY = TagKey.of(RegistryKeys.ENTITY_TYPE, id("less_healthy"));

	@Override
	public void onInitialize() {
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}