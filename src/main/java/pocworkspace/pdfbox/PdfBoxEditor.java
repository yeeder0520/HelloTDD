package pocworkspace.pdfbox;

import java.awt.Rectangle;
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
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class PdfBoxEditor {

  private static final Log log = LogFactory.getLog(PdfBoxEditor.class);
  public static final int X = 1;
  public static final int FONT_SIZE = 9999;

  public static void main(String[] args) {
    String pdfName = "一般工程_工程承攬變更同意書(僅需乙方用印).pdf";
    String src = "src/test/resources/pdf/" + pdfName; // 替換為你的 PDF 檔案路徑
    String dest = "src/test/resources/pdf/簽名完成-" + pdfName;
    // 替換為圖片的路徑

    try {
      modifyPdf(src, dest);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void modifyPdf(String src, String dest) throws IOException {
    Path pdfPath = Paths.get(src);
    byte[] pdfData = Files.readAllBytes(pdfPath);
    try (PDDocument document = Loader.loadPDF(pdfData)) {

      PDPage firstPage = document.getPage(0); // 修改第一頁，根據需要修改頁面索引

      showPdfInformation(document);

      // 插入文本
      try (PDPageContentStream contentStream = new PDPageContentStream(document,
                                                                       firstPage,
                                                                       AppendMode.APPEND,
                                                                       true)) {

        String fontPath = "src/test/resources/pdf/NotoSansTC-VariableFont_wght.ttf"; // 字體文件路徑
        PDType0Font font = PDType0Font.load(document, new File(fontPath));

        int baseY = 440; // 起始 Y 軸位置
        int i = 23; // 行距
        writeContentToPdfFile(contentStream, font, X, baseY, "關貿網路股份有限公司");
        writeContentToPdfFile(contentStream, font, X, baseY- i, "張陸生");
        writeContentToPdfFile(contentStream, font, X, baseY- i *2, "97162640");
        writeContentToPdfFile(contentStream, font, X, baseY- i *3, "台北市南港區三重路19-13號6樓");
      }
      document.save(dest);
      System.out.println("PDF 修改完成，文件路徑：" + dest);
    }
  }

  private static void writeContentToPdfFile(
      PDPageContentStream contentStream,
      PDType0Font font,
      int X,
      int Y,
      String showText) throws IOException {
    contentStream.beginText();
    contentStream.setFont(font, FONT_SIZE); // 減小字體大小以適應頁面
    contentStream.newLineAtOffset(X, Y); // 調整文字起始位置在頁面內
    contentStream.showText(showText);
    contentStream.endText();
  }

  private static void showPdfInformation(PDDocument document) {
    PDDocumentInformation documentInformation = document.getDocumentInformation();
    log.info("PDF 作者：" + documentInformation.getAuthor());
    log.info("PDF 創建日期：" + documentInformation.getCreationDate());
    log.info("PDF 修改日期：" + documentInformation.getModificationDate());
    log.info("PDF 標題：" + documentInformation.getTitle());
    log.info("PDF 主題：" + documentInformation.getSubject());
    log.info("PDF 關鍵字：" + documentInformation.getKeywords());
    log.info("PDF 創建工具：" + documentInformation.getCreator());
    log.info("PDF 生產工具：" + documentInformation.getProducer());
  }

  private static void extractTextFromPdf(String src) throws IOException {
    try (PDDocument document = Loader.loadPDF(new File(src))) {
      PDFTextStripperByArea stripper = new PDFTextStripperByArea();
      stripper.setSortByPosition(true);

      PDPage page = document.getPage(0); // 假設表格在第一頁

      // 這裡設置預估的格子位置和大小
      // 需要根據實際PDF文件中格子的位置和大小進行調整
      Rectangle[] cells = {
          new Rectangle(50, 100, 100, 50),
          new Rectangle(150, 100, 100, 50),
          new Rectangle(250, 100, 100, 50),
          new Rectangle(50, 150, 100, 50),
          new Rectangle(150, 150, 100, 50),
          new Rectangle(250, 150, 100, 50)
          // 根據需要添加更多的格子
      };

      for (int i = 0; i < cells.length; i++) {
        stripper.addRegion("cell" + i, cells[i]);
      }

      stripper.extractRegions(page);

      for (int i = 0; i < cells.length; i++) {
        String text = stripper.getTextForRegion("cell" + i);
        System.out.println("Text in cell" + i + ": " + text);
        System.out.println("Position of cell" + i + ": " + cells[i]);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
