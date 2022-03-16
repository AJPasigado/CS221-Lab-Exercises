import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class Main {
      public static void main(String[] argv) throws Exception {
          
            //kani tong gina-add sa url
            String data = "api_key=a49fd004d58aeebf7b9a3c1185ab9ac0a71e5f26262cff17039c7871a99c2920&student_id=123092";
            
            //conect daw sa site?
            URL link = new URL("http://attend.yancyparedes.net/check/");
            URLConnection linkConnection = link.openConnection();
            linkConnection.setDoOutput(true);
            
            //save ang output or form-like
            OutputStream form = linkConnection.getOutputStream();
            
            //sending sa string sa site
            OutputStreamWriter wr = new OutputStreamWriter(form);
            wr.write(data);
            wr.flush();
            
            //read ang feedback sa site
            InputStream feed = linkConnection.getInputStream();
            InputStreamReader output = new InputStreamReader(feed);
            
            BufferedReader rd = new BufferedReader(output);
            
            String line;
                while ((line = rd.readLine()) != null) {
                  System.out.println(line);
                }
               
            wr.close();
            rd.close();
      }
}