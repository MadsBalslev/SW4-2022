import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class FileConvert {

    public static String MDToHTML(StringBuilder markdownFormat) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdownFormat.toString());
        HtmlRenderer htmlRenderer = HtmlRenderer.builder().build();
        return htmlRenderer.render(document);
    }

    public static void HTMLToPDF(String htmlText)
            throws IOException, DocumentException {
        Document document = new Document();
        InputStream html = new ByteArrayInputStream(htmlText.getBytes());
        PdfWriter writer = PdfWriter.getInstance(document,
                new FileOutputStream("../output/output.pdf"));
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, html);
        document.close();
    }
}
