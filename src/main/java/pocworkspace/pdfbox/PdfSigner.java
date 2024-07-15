package pocworkspace.pdfbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureInterface;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureOptions;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.bouncycastle.cert.jcajce.JcaCertStore;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.bouncycastle.cms.jcajce.JcaSignerInfoGeneratorBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;
import org.bouncycastle.util.Store;

public class PdfSigner {

  public static void main(String[] args) {
    Security.addProvider(new BouncyCastleProvider());

    String keystorePath = "src/test/resources/pdf/testcert.p12";
    String keystorePassword = "111111";
    String filePath = "src/test/resources/pdf/金鼎文具收貨確認表_1個簽.pdf";
    String outputPath = "src/test/resources/pdf/signed_output.pdf";

    try (PDDocument document = Loader.loadPDF(new File(filePath))) {
      signPDF(document, keystorePath, keystorePassword, outputPath);
      System.out.println("PDF 文件已成功簽名。");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void signPDF(PDDocument document, String keystorePath, String keystorePassword, String outputPath)
      throws Exception {
    KeyStore keystore = KeyStore.getInstance("PKCS12");
    try (FileInputStream keystoreStream = new FileInputStream(keystorePath)) {
      keystore.load(keystoreStream, keystorePassword.toCharArray());
    }

    String alias = keystore.aliases()
        .nextElement();
    PrivateKey privateKey = (PrivateKey) keystore.getKey(alias, keystorePassword.toCharArray());
    Certificate[] certificateChain = keystore.getCertificateChain(alias);
    X509Certificate cert = (X509Certificate) certificateChain[0];

    prepareAcroForm(document);
    document.getDocumentCatalog().getAcroForm().getFields().forEach(field -> System.out.println("簽名欄位: " + field.getFullyQualifiedName()));
    PDSignature signature = createSignature(cert);
    signDocument(document, privateKey, certificateChain, signature, outputPath);
  }

  private static void prepareAcroForm(PDDocument document) {
    PDAcroForm acroForm = document.getDocumentCatalog()
        .getAcroForm();
    if (acroForm == null) {
      acroForm = new PDAcroForm(document);
      document.getDocumentCatalog()
          .setAcroForm(acroForm);
    }

    PDSignatureField signatureField = new PDSignatureField(acroForm);
    signatureField.setPartialName("AJIOFAOAFJIOM");
    acroForm.getFields()
        .add(signatureField);

    //TODO 好像沒用
//    PDTextField textField = new PDTextField(acroForm);
//    textField.setPartialName("YYYYYYY");
//    acroForm.getFields()
//        .add(textField);
  }

  private static PDSignature createSignature(X509Certificate cert) {
    PDSignature signature = new PDSignature();
    signature.setFilter(PDSignature.FILTER_ADOBE_PPKLITE);  // Adobe Reader相容性過濾器
    signature.setSubFilter(PDSignature.SUBFILTER_ADBE_PKCS7_DETACHED); // 簽名類型
    signature.setName(cert.getSubjectDN()
                          .getName());
    signature.setLocation("Taiwan");
    signature.setReason("Approval");
    signature.setSignDate(Calendar.getInstance());
    return signature;
  }

  private static void signDocument(PDDocument document, PrivateKey privateKey, Certificate[] certificateChain,
      PDSignature signature, String outputPath) throws Exception {
    SignatureInterface signatureInterface = content -> {
      try {
        return signContent(content, privateKey, certificateChain);
      } catch (CMSException | CertificateEncodingException | OperatorCreationException e) {
        throw new RuntimeException(e);
      }
    };
    SignatureOptions signatureOptions = new SignatureOptions();
    signatureOptions.setPreferredSignatureSize(SignatureOptions.DEFAULT_SIGNATURE_SIZE);
    document.addSignature(signature, signatureInterface, signatureOptions);

    try (FileOutputStream fos = new FileOutputStream(outputPath)) {
      document.saveIncremental(fos);
    }
  }

  private static byte[] signContent(InputStream content, PrivateKey privateKey, Certificate[] certificateChain)
      throws CMSException, CertificateEncodingException, OperatorCreationException, IOException {
    CMSSignedDataGenerator generator = new CMSSignedDataGenerator();
    JcaContentSignerBuilder builder = new JcaContentSignerBuilder("SHA256withRSA").setProvider("BC");
    generator.addSignerInfoGenerator(
        new JcaSignerInfoGeneratorBuilder(new JcaDigestCalculatorProviderBuilder().setProvider("BC")
                                              .build())
            .build(builder.build(privateKey), new JcaX509CertificateHolder((X509Certificate) certificateChain[0])));
    List<Certificate> certList = Arrays.asList(certificateChain);
    Store<?> certs = new JcaCertStore(certList);
    generator.addCertificates(certs);

    CMSSignedData signedData = generator.generate(new CMSProcessableByteArray(content.readAllBytes()), false);
    return signedData.getEncoded();
  }

}
