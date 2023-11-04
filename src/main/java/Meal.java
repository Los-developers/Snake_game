public class Meal {
    //La comida que debe negerarse aleatoriamente segun el mapa
    public int suma (int x, int y){
        return  x+y;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10 ; i++) {
            for (int j = 0; j < 10 ; j++) {
                for (int k = 0; k <10 ; k++) {
                    for (int l = 0; l < 10 ; l++) {
                        for (int m = 0; m < 10; m++) {
                            for (int n = 0; n < 10 ; n++) {
                                System.out.println(j);
                                System.out.print(i);
                                System.out.print(k);
                                System.out.print(l);
                                System.out.print(m);
                                System.out.print(n);
                            }
                        }
                    }
                }
            }
        }
    }
}
