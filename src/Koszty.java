public class Koszty  {
    static double  cena_za_km=24.20;  //cena kursu autobusu za km

    public static double zwiekszCene() {   //zmiana ceny o 0.25 zl powoduje zmiane ilosci pasazerow o 1
        return cena_za_km+0.25;            //max 40 pasazerow
    }
    public static double zmniejszCene() {
        return cena_za_km-0.25;
    }
}