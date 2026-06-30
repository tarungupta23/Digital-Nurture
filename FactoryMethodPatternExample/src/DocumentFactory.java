// DocumentFactory.java
public abstract class DocumentFactory {
    // The Factory Method
    public abstract Document createDocument();

    // An optional helper method that demonstrates operation on the product
    public void manageDocument() {
        Document doc = createDocument();
        doc.open();
        // Perform operations here...
        doc.close();
    }
}