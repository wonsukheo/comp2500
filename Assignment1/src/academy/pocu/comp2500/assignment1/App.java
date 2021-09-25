package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerPostAdder("Foo", "bar");
        registry.registerBlogCreator("User");
        registry.registerTagFilterSetter("Blog", "getArticleListTagFiltered");
        registry.registerAuthorFilterSetter("Blog", "getArticleListArthurFiltered");
        registry.registerPostOrderSetter("Blog", "getArticleListOrNull");
        registry.registerPostListGetter("Blog", "getArticleListOrNull");
        registry.registerPostAdder("User", "createArticle");
        registry.registerPostTitleUpdater("Article", "setTitle");
        registry.registerPostBodyUpdater("Article", "setText");
        registry.registerPostTagAdder("Article", "addTag");
        registry.registerCommentAdder("Article", "addComment");
        registry.registerSubcommentAdder("Comment", "addSubComment");
        registry.registerCommentUpdater("Comment", "setComment");
        registry.registerSubcommentUpdater("Comment", "setComment");
        registry.registerReactionAdder("Article", "setReaction");
        registry.registerReactionRemover("Article", "setReaction");
        registry.registerCommentUpvoter("Comment", "upVote");
        registry.registerCommentDownvoter("Comment", "downVote");
        registry.registerCommentListGetter("Article", "getCommentList");
        registry.registerSubcommentListGetter("Article", "getCommentList");
        registry.registerSubcommentUpvoter("Comment", "upVote");
        registry.registerSubcommentDownvoter("Comment", "downVote");
    }
}
