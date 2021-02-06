package ChapterStreamApi.sectionGrouping;

class BlogPost {
    String title;
    String author;
    BlogPostType type;
    int likes;
}

enum BlogPostType {
    NEWS,
    REVIEW,
    GUIDE
}
