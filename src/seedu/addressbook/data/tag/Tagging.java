package seedu.addressbook.data.tag;

public class Tagging {
	private String name;
	private Tag tag;
	private boolean isAddingTag;
	public Tagging(Tag tag , String name, boolean isAddingTag) {
		this.tag = tag;
		this.name = name;
		this.isAddingTag = isAddingTag;
	}
	public String getName() {
		return name;
	}
	public Tag getTag() {
		return tag;
	}
	public String getSignForTagging() {
		return isAddingTag? "+" : "-";
	}
}
