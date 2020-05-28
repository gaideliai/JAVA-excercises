public static void copyfile(String[] args) throws FileNotFoundException, IOException {
    List l = new ArrayList();
    int b = 0;
    try (FileInputStream fis = new FileInputStream("c.txt")) {
        while ((b = fis.read()) != -1) {
            l.add(b);   
        }            
    }
    try (FileOutputStream fos = new FileOutputStream("d.txt")) {   
            for (int i = 0; i < l.size(); i++) {
                int a = (int) l.get(i);
                fos.write(a);                    
            }
            fos.flush();
    }
}
