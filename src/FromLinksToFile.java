import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class FromLinksToFile {

    private String urlAdress= "";
    private String filePuth = "";
    String links = "";
    public FromLinksToFile(String urlAdress, String filePuth) {
        this.urlAdress = urlAdress;
        this.filePuth = filePuth;
    }
    public void getLinks(){
        StringBuilder stringBuilder = new StringBuilder();
        String buffer = "";
        String subBuffer = "";

        try {
            URL url = new URL(urlAdress);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            for (;(buffer = reader.readLine())!=null;){
                if (buffer.indexOf("<a ")>0 && buffer.indexOf("</a>")>0&& buffer.contains("http")){
                    subBuffer = buffer.substring(buffer.indexOf("<a "), buffer.indexOf("</a>")+3);
                    stringBuilder.append(subBuffer).append(System.lineSeparator());
                }
            }
            toFile();
        }catch (IOException e){
            e.printStackTrace();
        }
        links = stringBuilder.toString();
        System.out.println(links);
    }
    private void toFile(){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePuth))){
            outputStream.writeObject(links);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
