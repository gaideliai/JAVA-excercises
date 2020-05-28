public static void main(String[] args) {
    String s = null;
    List l = new ArrayList();
    try (
        FileInputStream fis = new FileInputStream("c.txt");
        Reader r = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(r); //skaito po eilute
    ) {
        while ((s = br.readLine()) != null) {
            String[] parts = s.split(" ");
            for (String part : parts) {
                l.add(part);
            }
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    Comparator c = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Integer i1 = ((String)o1).length();
            Integer i2 = ((String)o2).length();
            return i2 - i1;
        }
    };
    l.sort(c);

    try (
        FileOutputStream fos = new FileOutputStream("f.txt");
        Writer w = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(w);
    ) {
        for (int i = 0; i < l.size(); i++) {
            String ss = (String)l.get(i);
            bw.write(ss);
            bw.newLine();
        }            
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
