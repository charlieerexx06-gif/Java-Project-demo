class PostManager {

    LostItem postList[] = new LostItem[100];
    int count = 0;

    // Create
    void addPost(LostItem p) {
        postList[count] = p;
        count++;
    }

    // Read
    String showAllPost() {
        String s = "";

        if (count == 0) {
            return "No post available";
        }

        for (int i = 0; i < count; i++) {
            s = s + i + ". " + postList[i].showPost() + "\n";
        }

        return s;
    }

    // Search
    String searchPost(String item) {
        String s = "";
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (postList[i].itemName.equalsIgnoreCase(item)) {
                s = s + i + ". " + postList[i].showPost() + "\n";
                found = true;
            }
        }

        if (found == false) {
            return "Item not found";
        }

        return s;
    }

    // Update
    boolean updatePost(int index, String itemName, String category, String location,
                       String description, String contact, String finderName, String loginId) {

        if (index >= 0 && index < count) {
            if (postList[index].postedById.equals(loginId)) {
                postList[index].itemName = itemName;
                postList[index].category = category;
                postList[index].location = location;
                postList[index].setDescription(description);
                postList[index].setFinderContact(contact);
                postList[index].finderName = finderName;
                return true;
            }
        }

        return false;
    }

    // Delete
    boolean deletePost(int index, String loginId) {
        if (index >= 0 && index < count) {
            if (postList[index].postedById.equals(loginId)) {
                for (int i = index; i < count - 1; i++) {
                    postList[i] = postList[i + 1];
                }

                postList[count - 1] = null;
                count--;
                return true;
            }
        }

        return false;
    }
}