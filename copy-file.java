public static void copyFile(String[] args) throws FileNotFoundException, IOException {
    try (
            FileInputStream fis = new FileInputStream("c.txt");
            FileOutputStream fos = new FileOutputStream("d.txt");
        ) {
        int b = 0;
        while ((b = fis.read()) != -1) {
            fos.write(b);   
        }
        fos.flush();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
