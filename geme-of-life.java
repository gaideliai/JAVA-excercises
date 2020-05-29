public static void main(String[] args) {
    int dydis = 20;
    int iteracijuKiekis = 50;
    char[][] laukas = new char[dydis][dydis];
    // Sugeneruojam pradini lauka
    for (int y = 0; y < dydis; y++) {
        for (int x = 0; x < dydis; x++) {
            if (Math.random() < 0.22) {
                laukas[y][x] = 'X';
            } else {
                laukas[y][x] = '.';
            }
        }
    }
     //Spausdinam esama lauka
    for (int y = 0; y < dydis; y++) {
        for (int x = 0; x < dydis; x++) {
            System.out.print(laukas[y][x]);
        }
        System.out.println();
    }

    char[][][] istorija = new char [iteracijuKiekis][dydis][dydis];

    for (int gc = 0; gc < iteracijuKiekis; gc++) {
        //padedam esama itaracija i istorija
        istorija[gc] = laukas;

        // sukuriam nauja iteracija
        char[][] naujas = new char [dydis][dydis];
        for (int y = 0; y < dydis; y++) {
            for (int x = 0; x < dydis; x++) {
            //skaiciuojam kaimynu kieki
            int k = 0;
                if (y != 0) {
                    k += (x != 0 && laukas[y-1][x-1] == 'X') ? 1 : 0;
                    k += (laukas[y-1][x] == 'X') ? 1 : 0;
                    k += (x < dydis-1 && laukas[y-1][x+1] == 'X') ? 1 : 0;
                }
                k += (x != 0 && laukas[y][x-1] == 'X') ? 1 : 0;
                k += (x < dydis-1 && laukas[y][x+1] == 'X') ? 1 : 0;
                if (y < dydis-1) {
                    k += (x != 0 && laukas[y+1][x-1] == 'X') ? 1 : 0;
                    k += (laukas[y+1][x] == 'X') ? 1 : 0;
                    k += (x < dydis-1 && laukas[y+1][x+1] == 'X') ? 1 : 0;
                }
            //turim, kiek yra kaimynu

            //nusprendziam, ar naujam lauke bus gyventojas ar ne
                if (laukas[y][x] == 'X' && (k == 2 || k == 3)){
                    naujas[y][x] = 'X';
                }else if (laukas[y][x] != 'X' && k == 3){
                    naujas[y][x] = 'X';
                } else {
                    naujas[y][x] = '.';
                }
            }
        }
        //turim uzpildyta nauja iteracija

        //tikrinam ar nauja iteracija vienoda su pries tai buvusia
//            boolean vienodi = true;
//            for (int y = 0; vienodi && y < dydis; y++) {
//                for (int x = 0; vienodi && x < dydis; x++) {
//                    if (laukas[y][x] != naujas[y][x]){
//                        vienodi = false;
//                    }
//                }                
//            }
//            
//            if (vienodi){
//                System.out.println("Iteracija kartojasi");
//                break;
//            }

        //einam per istorija ir ieskom, ar buvo pasikartojimu
        int i = gc;
        for (; i >= 0; i--) { 
            boolean vienodi = true;
            for (int y = 0; vienodi && y < dydis; y++) {
                for (int x = 0; vienodi && x < dydis; x++) {
                    if (istorija[i][y][x] != naujas[y][x]){
                        vienodi = false;
                    }
                }                
            }
            if (vienodi){
                break;
            }
        }
        //(jei nevienodi, ivykdomas paskutinis i--, kuris lygu -1)
        //jei i nera neigiamas, tai saugo iteracijos numeri, kurioje kartojasi            
        if (i >= 0){
            System.out.println("Iteracija pasikartojo"+i);
            break;
        }

        System.out.println(gc+1+"---------------------------");
        //spausdinam nauja lauka
        for (int y = 0; y < dydis; y++) {
            for (int x = 0; x < dydis; x++) {
                System.out.print(laukas[y][x]);
            }
            System.out.println();
        }
        laukas = naujas;
    }        
}
