package pocworkspace.pdfbox;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public class PdfBoxEditor {

  private static final Log log = LogFactory.getLog(PdfBoxEditor.class);

  public static void main(String[] args) {
    String src = "src/test/resources/pdf/超級大火雞.pdf"; // 替換為你的 PDF 檔案路徑
    String dest = "src/test/resources/pdf/output.pdf";
    String text = "超級老鷹";
    // 替換為圖片的路徑

    try {
      modifyPdf(src, dest, text);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void modifyPdf(String src, String dest, String text) throws IOException {
    Path pdfPath = Paths.get(src);
    byte[] pdfData = Files.readAllBytes(pdfPath);
    try (PDDocument document = Loader.loadPDF(pdfData)) {

      PDPage firstPage = document.getPage(0); // 修改第一頁，根據需要修改頁面索引

      PDDocumentInformation documentInformation = document.getDocumentInformation();
      log.info("PDF 作者：" + documentInformation.getAuthor());
      log.info("PDF 創建日期：" + documentInformation.getCreationDate());
      log.info("PDF 修改日期：" + documentInformation.getModificationDate());
      log.info("PDF 標題：" + documentInformation.getTitle());
      log.info("PDF 主題：" + documentInformation.getSubject());
      log.info("PDF 關鍵字：" + documentInformation.getKeywords());
      log.info("PDF 創建工具：" + documentInformation.getCreator());
      log.info("PDF 生產工具：" + documentInformation.getProducer());

      // 插入文本
      try (PDPageContentStream contentStream = new PDPageContentStream(document,
                                                                       firstPage,
                                                                       AppendMode.APPEND,
                                                                       true)) {
        String fontPath = "src/test/resources/NotoSansTC-VariableFont_wght.ttf"; // 字體文件路徑
        PDType0Font load = PDType0Font.load(document, new File(fontPath));
        contentStream.beginText();
        contentStream.setFont(load, 50);
        contentStream.newLineAtOffset(100, 150); // 設定文字起始位置
        contentStream.showText(text);
        contentStream.endText();

        // 插入圖片
//        PDImageXObject pdImage = PDImageXObject.createFromFile(imagePath, document);
//        contentStream.drawImage(pdImage, 100, 400);
      }
      document.save(dest);
      System.out.println("PDF 修改完成，文件路徑：" + dest);
    }
  }
}