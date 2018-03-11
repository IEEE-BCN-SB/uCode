package edu.upc.ieee.adidasnow.feature.fragments.dummy;

import java.util.ArrayList;
import java.util.List;

import edu.upc.ieee.adidasnow.feature.models.Comment;
import edu.upc.ieee.adidasnow.feature.models.Product;

/**
 * Created by melvintg on 11/03/2018.
 */

public class DummyProduct {

    public static final List<Comment> COMMENTS = new ArrayList<Comment>();


    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyComment(i));
        }
    }

    private static void addItem(Comment comment) {
        COMMENTS.add(comment);
    }

    private static Comment createDummyComment(int position) {
        Comment comment = new Comment();
        comment.setTitle("Comment number " + String.valueOf(position));
        comment.setDescription("Some Description");
        comment.setUser("UserName");
        return comment;
    }

}
