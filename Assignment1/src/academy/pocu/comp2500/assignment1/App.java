package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerPostAdder("Foo", "bar");
        registry.registerBlogCreator("Blog");
        registry.registerTagFilterSetter("Blog", "setPostsFilteredTags");
        registry.registerAuthorFilterSetter("Blog", "setPostsFilteredUser");
        registry.registerPostOrderSetter("Blog", "getPostListSorted");
        registry.registerPostListGetter("Blog", "getPostList");
        registry.registerPostAdder("Blog", "addPost");
        registry.registerPostTitleUpdater("Post", "setTitle");
        registry.registerPostBodyUpdater("Post", "setText");
        registry.registerPostTagAdder("Post", "addTag");
        registry.registerCommentAdder("Post", "addComment");
        registry.registerSubcommentAdder("Comment", "addSubComment");
        registry.registerCommentUpdater("Comment", "setText");
        registry.registerSubcommentUpdater("Comment", "setText");
        registry.registerReactionAdder("Post", "setReaction");
        registry.registerReactionRemover("Post", "removeReaction");
        registry.registerCommentUpvoter("Comment", "upVote");
        registry.registerCommentDownvoter("Comment", "downVote");
        registry.registerCommentListGetter("Post", "getCommentList");
        registry.registerSubcommentListGetter("Comment", "getSubcommentsRecursive");
        registry.registerSubcommentUpvoter("Comment", "upVote");
        registry.registerSubcommentDownvoter("Comment", "downVote");
    }
}
