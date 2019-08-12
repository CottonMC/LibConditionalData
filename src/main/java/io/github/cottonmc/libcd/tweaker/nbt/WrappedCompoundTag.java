package io.github.cottonmc.libcd.tweaker.nbt;

import net.minecraft.nbt.CompoundTag;

import java.util.UUID;

/**
 * A wrapper for the CompoundTag class, since that's obfuscated.
 */
public class WrappedCompoundTag {
	private CompoundTag underlying;

	public WrappedCompoundTag(CompoundTag underlying) {
		this.underlying = underlying;
	}

	/**
	 * @return A new, empty tag.
	 */
	public static WrappedCompoundTag create() {
		return new WrappedCompoundTag(new CompoundTag());
	}

	/**
	 * @return The underlying compound tag. Only call from Java.
	 */
	public CompoundTag getUnderlying() {
		return underlying;
	}

	/**
	 * @return an array of all the keys in the tag.
	 */
	public String[] getKeys() {
		return underlying.getKeys().toArray(new String[0]);
	}

	/**
	 * @param key The key to check.
	 * @return The type of the key.
	 */
	public String getType(String key) {
		//TODO: inverse
		int val = underlying.getType(key);
		switch (val) {
			case 1:
				return "byte";
			case 2:
				return "short";
			case 3:
				return "int";
			case 4:
				return "long";
			case 5:
				return "float";
			case 6:
				return "double";
			case 7:
				return "byte array";
			case 8:
				return "string";
			case 9:
				return "list";
			case 10:
				return "compound";
			case 11:
				return "int array";
			case 12:
				return "long array";
			default:
				return "unknown";
		}
	}

	/**
	 * @param key The key to check for.
	 * @return Whether the tag has this key.
	 */
	public boolean hasTag(String key) {
		return underlying.containsKey(key);
	}

	/**
	 * @param key The key to check for.
	 * @param type The type to check for. Must match the values in {@link WrappedCompoundTag#getType(String)} exactly.
	 * @return Whether the tag has this key, and the key has this type.
	 */
	public boolean hasTag(String key, String type) {
		return underlying.containsKey(key) && getType(key).equals(type);
	}

	/**
	 * @param key The key to check for.
	 * @param type The type to check for, as its raw int. You can use {@link net.fabricmc.fabric.api.util.NbtType} for this.
	 * @return Whether the tag has this key, and the key has this type.
	 */
	public boolean hasTag(String key, int type) {
		return underlying.containsKey(key, type);
	}

	/**
	 * @param key The tag to get.
	 * @return The string form of this tag.
	 */
	public String getTag(String key) {
		return underlying.getTag(key).toString();
	}

	public byte getByte(String key) {
		return underlying.getByte(key);
	}

	public void putByte(String key, byte value) {
		underlying.putByte(key, value);
	}

	public boolean getBoolean(String key) {
		return underlying.getBoolean(key);
	}

	public void putBoolean(String key, boolean value) {
		underlying.putBoolean(key, value);
	}

	public short getShort(String key) {
		return underlying.getShort(key);
	}

	public void putShort(String key, short value) {
		underlying.putShort(key, value);
	}

	public int getInt(String key) {
		return underlying.getInt(key);
	}

	public void putInt(String key, int value) {
		underlying.putInt(key, value);
	}

	public long getLong(String key) {
		return underlying.getLong(key);
	}

	public void putLong(String key, long value) {
		underlying.putLong(key, value);
	}

	public String getUuid(String key) {
		return underlying.getUuid(key).toString();
	}

	public void putUuid(String key, String value) {
		underlying.putUuid(key, UUID.fromString(value));
	}

	public float getFloat(String key) {
		return underlying.getFloat(key);
	}

	public void putFloat(String key, float value) {
		underlying.putFloat(key, value);
	}

	public double getDouble(String key) {
		return underlying.getDouble(key);
	}

	public void putDouble(String key, double value) {
		underlying.putDouble(key, value);
	}

	public byte[] getByteArray(String key) {
		return underlying.getByteArray(key);
	}

	public void putByteArray(String key, byte[] value) {
		underlying.putByteArray(key, value);
	}

	public String getString(String key) {
		return underlying.getString(key);
	}

	public void putString(String key, String value) {
		underlying.putString(key, value);
	}

	//TODO: list

	public WrappedCompoundTag getCompound(String key) {
		return new WrappedCompoundTag(underlying.getCompound(key));
	}

	public void putCompound(String key, WrappedCompoundTag value) {
		underlying.put(key, value.getUnderlying());
	}

	public int[] getIntArray(String key) {
		return underlying.getIntArray(key);
	}

	public void putIntArray(String key, int[] value) {
		underlying.putIntArray(key, value);
	}

	public long[] getLongArray(String key) {
		return underlying.getLongArray(key);
	}

	public void putLongArray(String key, long[] value) {
		underlying.putLongArray(key, value);
	}

	public void remove(String key) {
		underlying.remove(key);
	}

	public String toString() {
		return underlying.toString();
	}

	public boolean isEmpty() {
		return underlying.isEmpty();
	}
}
