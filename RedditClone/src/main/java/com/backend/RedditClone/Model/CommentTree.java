package com.backend.RedditClone.Model;

import com.backend.RedditClone.Entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentTree {
    private List<CommentTree> commentTrees;
    private CommentWithUsername comment;

    public CommentTree(CommentWithUsername comment) {
        this.comment = comment;
        this.commentTrees = new ArrayList<>();
    }

    public void addComment(CommentWithUsername comment) {
        this.commentTrees.add(new CommentTree(comment));
    }

    public void addCommentTree(CommentTree commentTree) {
        this.commentTrees.add(commentTree);
    }
}
