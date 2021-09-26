package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerPostAdder("Foo", "bar");
        registry.registerBlogCreator("User");
        registry.registerTagFilterSetter("Blog", "getArticleListTagListFilteredOrNull");
        registry.registerAuthorFilterSetter("Blog", "getArticleListArthurFiltered");
        registry.registerPostOrderSetter("Blog", "getSortedArticleListOrNull");
        registry.registerPostListGetter("Blog", "getSortedArticleListOrNull");
        registry.registerPostAdder("Blog", "createArticle");
        registry.registerPostTitleUpdater("Article", "setTitle");
        registry.registerPostBodyUpdater("Article", "setText");
        registry.registerPostTagAdder("Article", "addTag");
        registry.registerCommentAdder("Article", "addComment");
        registry.registerSubcommentAdder("Comment", "addSubComment");
        registry.registerCommentUpdater("Comment", "setText");
        registry.registerSubcommentUpdater("Comment", "setText");
        registry.registerReactionAdder("Article", "addReaction");
        registry.registerReactionRemover("Article", "removeReaction");
        registry.registerCommentUpvoter("Comment", "upVote");
        registry.registerCommentDownvoter("Comment", "downVote");
        registry.registerCommentListGetter("Article", "getCommentListSortByVoteOrNull");
        registry.registerSubcommentListGetter("Article", "getCommentListSortByVoteOrNull");
        registry.registerSubcommentUpvoter("Comment", "upVote");
        registry.registerSubcommentDownvoter("Comment", "downVote");
    }
}
