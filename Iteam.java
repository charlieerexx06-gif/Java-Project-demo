abstract class Item {

    private String name;
    private String category;
    private String description;
    private String contact;

    public Item(String name, String category, String description, String contact) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.contact = contact;
    }

    // Encapsulation (getters)
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getContact() {
        return contact;
    }

    // Abstraction
    abstract String[] getRowData();
}

// Inheritance + Polymorphism
class FoundItem extends Item {

    public FoundItem(String name, String category, String description, String contact) {
        super(name, category, description, contact);
    }

    @Override
    String[] getRowData() {
        return new String[]{
            getName(),
            getCategory(),
            getDescription(),
            getContact()
        };
    }
}
