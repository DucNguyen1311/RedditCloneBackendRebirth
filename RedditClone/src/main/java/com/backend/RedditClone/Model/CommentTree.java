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
    private Comment comment;

    public CommentTree(Comment comment) {
        this.comment = comment;
        this.commentTrees = new ArrayList<>();
    }

    public void addComment(Comment comment) {
        this.commentTrees.add(new CommentTree(comment));
    }

    public void addCommentTree(CommentTree commentTree) {
        this.commentTrees.add(commentTree);
    }
}
