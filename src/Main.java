public class Main {
    public static void main(String[] args) {
        String urlAdress = "https://prog.kiev.ua/forum/index.php/topic,3841.0.html";
        String filePuth = "index.txt";
        FromLinksToFile fromLinksToFile = new FromLinksToFile(urlAdress, filePuth);
        fromLinksToFile.getLinks();

    }
}
