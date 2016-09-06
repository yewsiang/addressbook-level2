package seedu.addressbook.data.tag;

import java.util.ArrayList;

public class TaggingList {
	private ArrayList<Tagging> allTaggings;
	
	public TaggingList() {
		allTaggings = new ArrayList<Tagging>();
	}
	
	public ArrayList<Tagging> getTaggings() {
		return allTaggings;
	}
	
	public void addAddTagging(Tag toAdd, String name) {
		Tagging newTagging = new Tagging(toAdd, name, true);
		allTaggings.add(newTagging);
	}
	
	public void addDeleteTagging(Tag toRemove, String name) {
		Tagging newTagging = new Tagging(toRemove, name, false);	
		allTaggings.add(newTagging);
	}
	
	public void clear() {
		allTaggings.clear();
	}
	
	
}
