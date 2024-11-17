package org.example.decorator;

public class CachedDocument extends AbstractDecorator {

    public CachedDocument(Document wrappedDocument) {
        super(wrappedDocument);
    }

    @Override
    public String parse() {
        DBConnection connection = DBConnection.getInstance();
        String cachedDocument = connection.getCachedDocument(getPath());

        if (cachedDocument == null) {
            String document = wrappedDocument.parse();
            connection.cacheDocument(getPath(), document);
            return document;
        } else {
            return cachedDocument;
        }
    }

    @Override
    public String getPath() {
        return wrappedDocument.getPath();
    }

}
