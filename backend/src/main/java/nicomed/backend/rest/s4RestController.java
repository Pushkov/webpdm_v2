package nicomed.backend.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.JwtException;
import nicomed.backend.forms.DocS4;
import org.springframework.http.*;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RestController
@RequestMapping("/pdm/api/s4")
public class s4RestController {

    @GetMapping(value = "/{des}",  produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<?> findFileByDesignation(@PathVariable("des") String des){
        try {
            final String uri = "http://localhost:8083/s4/api/find/" + des;

            RestTemplate template = new RestTemplate();
            HttpEntity<byte[]> resp = template.getForEntity(uri,byte[].class);

            ByteArrayInputStream byteStream1 = new ByteArrayInputStream(resp.getBody());
//            ObjectInputStream objectInputStream = new ObjectInputStream(byteStream1);
//            DocS4 d =

            System.out.println("resp - " +   new String(resp.getBody(), "UTF-8"));

            FileInputStream fs = new FileInputStream("e:\\1\\test1.txt"  );
            String fName = new File("e:\\1\\test1.txt").getName();
            System.out.println("fileName - " + fName);

            ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
                    .filename(fName)
                    .build();

            DocS4 doc = DocS4.builder()
                    .docID(11)
                    .Designation(des)
                    .fileName(fName)
                    .fileBody(fs.readAllBytes())
//                    .fileBody(resp.getBody())
                    .build();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(contentDisposition);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

            System.out.println("java des - " + des);

            return new ResponseEntity<>( new  ObjectMapper().writeValueAsBytes(doc) ,headers,  HttpStatus.OK);
//            return new ResponseEntity<DocS4>( fs.readAllBytes(),headers,  HttpStatus.OK);
        } catch (JwtException | IllegalArgumentException | FileNotFoundException e) {
             return new ResponseEntity<>("Illegal arg", HttpStatus.FORBIDDEN);
        } catch (IOException e) {
            return new ResponseEntity<>("IOexception", HttpStatus.FORBIDDEN);
        }
//        catch (ClassNotFoundException e) {
//            return new ResponseEntity<>("ClassNotFoundException", HttpStatus.FORBIDDEN);
//        }
    }
}
/*
@GetMapping(
  value = "/get-file",
  produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
)
public @ResponseBody byte[] getFile() throws IOException {
    InputStream in = getClass()
      .getResourceAsStream("/com/baeldung/produceimage/data.txt");
    return IOUtils.toByteArray(in);
}
 */


/* c#
X509Store certStore = new X509Store(StoreLocation.CurrentUser);
            certStore.Open(OpenFlags.ReadOnly);
            var cert = certStore.Certificates.Find(X509FindType.FindBySubjectName, "MyCompanySSL", false)[0];

            byte[] fileData = File.ReadAllBytes(@"D:\test.xml");

            const string url = "https://int223.zakupki.gov.ru/223/integration/integration/upload";
            string boundary = $"-----------------------------{DateTime.Now.Ticks.ToString("x")}";
            byte[] data;

            using (Stream formDataStream = new MemoryStream())
            {
                string login = $"{boundary}\r\nContent-Disposition: form-data; name=\"login\"\r\n\r\n{"MyLogin"}";
                formDataStream.Write(Encoding.ASCII.GetBytes(login), 0, Encoding.ASCII.GetBytes(login).Length);

                string password = $"{boundary}\r\nContent-Disposition: form-data; name=\"password\"\r\n\r\n{"MyPassword"}";
                formDataStream.Write(Encoding.ASCII.GetBytes(password), 0, Encoding.ASCII.GetBytes(password).Length);

                string fileHeader = $"{boundary}\r\nContent-Disposition: form-data; name=\"{"document"}\"; filename=\"{"test.xml"}\"\r\nContent-Type: text/xml\r\n\r\n";
                formDataStream.Write(Encoding.ASCII.GetBytes(fileHeader), 0, Encoding.ASCII.GetBytes(fileHeader).Length);
                formDataStream.Write(fileData, 0, fileData.Length);
                string fileFooter = "\r\n" + boundary + "\r\n";
                formDataStream.Write(Encoding.ASCII.GetBytes(fileFooter), 0, Encoding.ASCII.GetByteCount(fileFooter));

                formDataStream.Position = 0;
                data = new byte[formDataStream.Length];
                formDataStream.Read(data, 0, data.Length);
            }

            WebRequest request = WebRequest.Create(url);

            ((HttpWebRequest)request).ClientCertificates.Add(cert);
            ((HttpWebRequest)request).CachePolicy= new System.Net.Cache.HttpRequestCachePolicy(System.Net.Cache.HttpRequestCacheLevel.NoCacheNoStore);

            request.Method = "POST";
            request.ContentType = $"multipart/form-data; boundary={boundary}";
            request.ContentLength = data.Length;

            using (Stream requestStream = request.GetRequestStream())
            {
                requestStream.Write(data, 0, data.Length);
                requestStream.Close();
            }

            var response = request.GetResponse() as HttpWebResponse;
 */