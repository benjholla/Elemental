package com.benjholla.elemental.atlas.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.benjholla.elemental.atlas.Activator;
import com.benjholla.elemental.atlas.log.Log;

public class ElementalPreferences extends AbstractPreferenceInitializer {

	private static boolean initialized = false;
	
	/**
	 * Enable/disable coalescing of basic blocks
	 */
	public static final String COALESCING_BASIC_BLOCKS = "COALESCE_BASIC_BLOCKS";
	public static final Boolean COALESCING_BASIC_BLOCKS_DEFAULT = true;
	private static boolean coalescingBasicBlocksValue = COALESCING_BASIC_BLOCKS_DEFAULT;
	
	/**
	 * Configures coalescing basic blocks
	 */
	public static void enableCoalescingBasicBlocks(boolean enabled){
		IPreferenceStore preferences = Activator.getDefault().getPreferenceStore();
		preferences.setValue(COALESCING_BASIC_BLOCKS, enabled);
		loadPreferences();
	}
	
	/**
	 * Returns true if coalescing basic blocks is enabled
	 * @return
	 */
	public static boolean isCoalescingBasicBlocksEnabled(){
		if(!initialized){
			loadPreferences();
		}
		return coalescingBasicBlocksValue;
	}
	
	/**
	 * Enable/disable whitespace basic block delimiters
	 */
	public static final String INCLUDE_WHITESPACE_BASIC_BLOCK_DELIMITERS = "INCLUDE_WHITESPACE_BASIC_BLOCK_DELIMITERS";
	public static final Boolean INCLUDE_WHITESPACE_BASIC_BLOCK_DELIMITERS_DEFAULT = true;
	private static boolean includeWhitespaceBasicBlocksDelimitersValue = INCLUDE_WHITESPACE_BASIC_BLOCK_DELIMITERS_DEFAULT;
	
	/**
	 * Configures including whitespace basic block delimiters
	 */
	public static void enableIncludeWhitespaceBasicBlockDelimiters(boolean enabled){
		IPreferenceStore preferences = Activator.getDefault().getPreferenceStore();
		preferences.setValue(INCLUDE_WHITESPACE_BASIC_BLOCK_DELIMITERS, enabled);
		loadPreferences();
	}
	
	/**
	 * Returns true if whitespace basic block delimiters are enabled
	 * @return
	 */
	public static boolean isIncludeWhitespaceBasicBlockDelimitersEnabled(){
		if(!initialized){
			loadPreferences();
		}
		return includeWhitespaceBasicBlocksDelimitersValue;
	}
	
	/**
	 * Enable/disable coalescing of basic blocks
	 */
	public static final String LIMIT_MAX_BASIC_BLOCK_INSTRUCTIONS = "LIMIT_MAX_BASIC_BLOCK_INSTRUCTIONS";
	public static final Boolean LIMIT_MAX_BASIC_BLOCK_INSTRUCTIONS_DEFAULT = true;
	private static boolean limitMaxBasicBlocksValue = LIMIT_MAX_BASIC_BLOCK_INSTRUCTIONS_DEFAULT;
	
	/**
	 * Configures limiting max basic blocks instructions
	 */
	public static void enableLimitMaxBasicBlockInstructions(boolean enabled){
		IPreferenceStore preferences = Activator.getDefault().getPreferenceStore();
		preferences.setValue(LIMIT_MAX_BASIC_BLOCK_INSTRUCTIONS, enabled);
		loadPreferences();
	}
	
	/**
	 * Returns true if limiting max basic blocks instructions is enabled
	 * @return
	 */
	public static boolean isLimitMaxBasicBlockInstructionsEnabled(){
		if(!initialized){
			loadPreferences();
		}
		return limitMaxBasicBlocksValue;
	}
	
	/**
	 * Merge renaming prefix
	 */
	public static final String MAX_BASIC_BLOCK_INSTRUCTIONS = "MAX_BASIC_BLOCK_INSTRUCTIONS";
	public static final int MAX_BASIC_BLOCK_INSTRUCTIONS_DEFAULT = 20;
	private static int maxBasicBlocksValue = MAX_BASIC_BLOCK_INSTRUCTIONS_DEFAULT;
	
	/**
	 * Configures max number of basic block instructions to coalesce into a basic block
	 */
	public static void setMergeRenamingPrefix(int maxInstructions){
		IPreferenceStore preferences = Activator.getDefault().getPreferenceStore();
		preferences.setValue(MAX_BASIC_BLOCK_INSTRUCTIONS, maxInstructions);
		loadPreferences();
	}
	
	/**
	 * Returns the max number of basic block instructions
	 * @return
	 */
	public static int getMaxBasicBlockInstructions(){
		if(!initialized){
			loadPreferences();
		}
		return maxBasicBlocksValue;
	}
	
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore preferences = Activator.getDefault().getPreferenceStore();
		preferences.setDefault(COALESCING_BASIC_BLOCKS, COALESCING_BASIC_BLOCKS_DEFAULT);
		preferences.setDefault(INCLUDE_WHITESPACE_BASIC_BLOCK_DELIMITERS, INCLUDE_WHITESPACE_BASIC_BLOCK_DELIMITERS_DEFAULT);
		preferences.setDefault(LIMIT_MAX_BASIC_BLOCK_INSTRUCTIONS, LIMIT_MAX_BASIC_BLOCK_INSTRUCTIONS_DEFAULT);
		preferences.setDefault(MAX_BASIC_BLOCK_INSTRUCTIONS, MAX_BASIC_BLOCK_INSTRUCTIONS_DEFAULT);
	}
	
	/**
	 * Restores the default preferences
	 */
	public static void restoreDefaults(){
		IPreferenceStore preferences = Activator.getDefault().getPreferenceStore();
		preferences.setValue(COALESCING_BASIC_BLOCKS, COALESCING_BASIC_BLOCKS_DEFAULT);
		preferences.setValue(INCLUDE_WHITESPACE_BASIC_BLOCK_DELIMITERS, INCLUDE_WHITESPACE_BASIC_BLOCK_DELIMITERS_DEFAULT);
		preferences.setValue(LIMIT_MAX_BASIC_BLOCK_INSTRUCTIONS, LIMIT_MAX_BASIC_BLOCK_INSTRUCTIONS_DEFAULT);
		preferences.setValue(MAX_BASIC_BLOCK_INSTRUCTIONS, MAX_BASIC_BLOCK_INSTRUCTIONS_DEFAULT);
		loadPreferences();
	}
	
	/**
	 * Loads or refreshes current preference values
	 */
	public static void loadPreferences() {
		try {
			IPreferenceStore preferences = Activator.getDefault().getPreferenceStore();
			coalescingBasicBlocksValue = preferences.getBoolean(COALESCING_BASIC_BLOCKS);
			includeWhitespaceBasicBlocksDelimitersValue = preferences.getBoolean(INCLUDE_WHITESPACE_BASIC_BLOCK_DELIMITERS);
			limitMaxBasicBlocksValue = preferences.getBoolean(LIMIT_MAX_BASIC_BLOCK_INSTRUCTIONS);
			maxBasicBlocksValue = preferences.getInt(MAX_BASIC_BLOCK_INSTRUCTIONS);
		} catch (Exception e){
			Log.warning("Error accessing Atlas for Elemental preferences, using defaults...", e);
		}
		initialized = true;
	}
}