/**
 * 
 */
package com.online.store.Constants;

/**
 * @author Harikrishnan
 *
 */
public enum StoreEnum {
	SINGLE_ITEM_SAME_DEPARTMENT("Added more than five items from the same Department"),
	TOTAL_COST_MORE_THAN_FIFTY("Total cost of my items is greater than $50 "),	
	SINGLE_ITEM_QTY_MORE_THAN_TEN("Added more than 10 of a single item");
	
	private final String enumVal;

	private StoreEnum(String enumVal) {
        this.enumVal = enumVal;
    }
    public String getEnumVal() {
		return enumVal;
	}

	
    

}
