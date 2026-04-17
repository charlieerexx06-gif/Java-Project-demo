class LostItem extends Post {

    public String itemName;
    public String category;
    public String location;
    private String description;
    private String finderContact;
    public String finderName;
    public String postedById;

    LostItem(String itemName, String category, String location, String description,
             String finderContact, String finderName, String postedById) {
        this.itemName = itemName;
        this.category = category;
        this.location = location;
        this.description = description;
        this.finderContact = finderContact;
        this.finderName = finderName;
        this.postedById = postedById;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setFinderContact(String finderContact) {
        this.finderContact = finderContact;
    }

    public String getFinderContact() {
        return finderContact;
    }

    String showPost() {
        return "Item Name: " + itemName +
               ", Category: " + category +
               ", Location: " + location +
               ", Description: " + description +
               ", Finder Name: " + finderName +
               ", Contact: " + finderContact;
    }
}