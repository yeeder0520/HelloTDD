package pocworkspace.pdfbox;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;

public class PdfSignatureChecker {

  public static void main(String[] args) {
    String filePath = "src/test/resources/pdf/金鼎文具收貨確認表_1個簽.pdf";

    try {
      // 读取PDF文件
      PDDocument document = Loader.loadPDF(new File(filePath));

      document.getDocumentCatalog().getAcroForm().getFields().forEach(field -> {
        System.out.println("簽名欄位: " + field.getFullyQualifiedName());
      });

      // 获取签名列表
      List<PDSignature> signatures = document.getSignatureDictionaries();
      for (PDSignature signature : signatures) {
        System.out.println("签名者: " + signature.getName());
        System.out.println("签名日期: " + signature.getSignDate().getTime());
        System.out.println("签名联系信息: " + signature.getContactInfo());
        System.out.println("签名原因: " + signature.getReason());
        System.out.println("签名位置: " + signature.getLocation());
      }

      document.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

