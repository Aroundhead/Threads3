public class Main {

    public static void main(String[] args) {

        int meta = 70;
        int retrasoEnMilisegundos = 1000;

        Corredor liebre = new Liebre(meta);
        Corredor tortuga = new Tortuga(meta);

        Runnable carreraLiebre = new Carrera(liebre, retrasoEnMilisegundos);
        Runnable carreraTortuga = new Carrera(tortuga, retrasoEnMilisegundos);

        new Thread(carreraLiebre).start();
        new Thread(carreraTortuga).start();

    }

}
