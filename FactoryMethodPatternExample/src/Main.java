// Main.java
public class Main {
    public static void main(String[] args) {
        // Create a Word Document using the Word Factory
        DocumentFactory wordFactory = new WordDocumentFactory();
        System.out.println("--- Testing Word Factory ---");
        wordFactory.manageDocument();

        // Create a PDF Document using the PDF Factory
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        System.out.println("\n--- Testing PDF Factory ---");
        pdfFactory.manageDocument();

        // Create an Excel Document using the Excel Factory
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        System.out.println("\n--- Testing Excel Factory ---");
        excelFactory.manageDocument();
    }
}