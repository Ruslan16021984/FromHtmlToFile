public class Main {
    public static void main(String[] args) {
        String urlAdress = "https://prog.kiev.ua/forum/index.php?topic=2681.120";
        String filePuth = "index.txt";
        FromLinksToFile fromLinksToFile = new FromLinksToFile(urlAdress, filePuth);
        fromLinksToFile.getLinks();

    }
}
