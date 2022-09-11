public class Main {

    public static int pokerCards(String[] cards) {
        // allCards este o matrice unde linia reprezinta numarul cartii si coloana este culoarea
        // de exemplu , daca avem cartea "2S" se va incrementa elementul allCards[1][0]
        int[][] allCards = new int[14][4];

        int min = 0;

        for (int i = 0; i < cards.length; i++) {

            int card = 0;
            int color = 0; // default pt SPADE


            if (cards[i].charAt(0) == '2' || cards[i].charAt(0) == '3' || cards[i].charAt(0) == '4' || cards[i].charAt(0) == '5'
            || cards[i].charAt(0) == '6' || cards[i].charAt(0) == '7' || cards[i].charAt(0) == '8' || cards[i].charAt(0) == '9') {
                 card = Integer.parseInt(String.valueOf(cards[i].charAt(0)));

            }

            if (cards[i].charAt(0) == 'T') {
                card = 10;
            } else if (cards[i].charAt(0) == 'J') {
                card = 12;
            } else if (cards[i].charAt(0) == 'Q') {
                card = 13;
            } else if (cards[i].charAt(0) == 'K') {
                card = 14;
            } else if (cards[i].charAt(0) == 'A') {
                card = 1;
            }

            if (cards[i].charAt(1) == 'D') {
                color = 1;
            } else if (cards[i].charAt(1) == 'H') {
                color = 2;
            } else if (cards[i].charAt(1) == 'C') {
                color = 3;
            }

            if ( card == 1 ) {
                // ace este considerat si 1 si 11
                allCards[0][color]++;
                allCards[10][color]++;
            } else allCards[card - 1][color]++;


            // pt a calcula numarul de pachet , tot ce trebuie sa facem
            //este sa gasim minimul din matrice
            min = allCards[0][0];

            for (int j = 0; j < 14; j++) {
                for(int k = 0; k < 4; k++) {
                    if (min > allCards[j][k]) {
                        min = allCards[j][k];
                    }
                }

            }
        }

        return min;
    }
    public static void main(String[] args) {

        String[] cards = {"2S","2C","2D","2H","3S","3C","3D","3H","4S","4C","4D", "4H", "5S", "5C", "5D", "5H", "6S", "6C", "6D",
                "6H", "7S", "7C", "7D", "7H", "8S", "8C", "8D", "8H", "9S", "9C", "9D", "9H", "TS", "TC", "TD", "TH", "JS", "JC", "JD",
                "JH", "QS", "QC", "QD", "QH", "KS", "KC", "KD", "KH", "AS", "AC", "AD", "2S", "2C", "2D", "2H", "3S", "3C", "3D", "3H",
                "4S", "4C", "4D", "4H", "5S", "5C", "5D", "5H", "6S", "6C", "6D", "6H", "7S", "7C", "7D", "7H", "8S", "8C", "8D", "8H", "9S",
                "9C", "9D", "9H", "TS", "TC", "TD", "TH", "JS", "JC", "JD", "JH", "QS", "QC", "QD", "QH", "KS", "KC", "KD", "KH", "AS", "AC",
                "AD", "AH", "AH"};
        System.out.println(pokerCards(cards));

        

    }
}
