import java.util.ArrayList;

public class JuegoOca {

    // Clase Casillas
    public static class Casilla {
        private int numero;
        private String tipo;
        private int efecto;
        private int avance;
        private boolean esOca;

        // Constructor para casillas normales
        public Casilla(int numero) {
            this.numero = numero;
            this.tipo = "";
            this.efecto = 0;
            this.avance = 0;
            this.esOca = false;
        }

        // Constructor para casillas especiales
        public Casilla(int numero, String tipo, int efecto, boolean esOca) {
            this.numero = numero;
            this.tipo = tipo;
            this.efecto = efecto;
            this.avance = 0;
            this.esOca = esOca;
        }
        
        // Constructor para casillas con avance específico
        public Casilla(int numero, String tipo, int efecto, int avance, boolean esOca) {
            this.numero = numero;
            this.tipo = tipo;
            this.efecto = efecto;
            this.avance = avance;
            this.esOca = esOca;
        }
        
        // Constructor para casillas con retroceso
        public Casilla(int numero, String tipo, int efecto, int avance) {
            this.numero = numero;
            this.tipo = tipo;
            this.efecto = efecto;
            this.avance = avance;
            this.esOca = false;
        }

        // Getters y Setters
        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public int getEfecto() {
            return efecto;
        }

        public void setEfecto(int efecto) {
            this.efecto = efecto;
        }

        public int getAvance() {
            return avance;
        }

        public void setAvance(int avance) {
            this.avance = avance;
        }

        public boolean isEsOca() {
            return esOca;
        }

        public void setEsOca(boolean esOca) {
            this.esOca = esOca;
        }
    }

    // Clase Jugador
    public static class Jugador {
        private int id;
        private int posicion;

        public Jugador(int id) {
            this.id = id;
            this.posicion = 0;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPosicion() {
            return posicion;
        }

        public void setPosicion(int posicion) {
            this.posicion = posicion;
        }
    }

    // Clase TableroOca
    public static class TableroOca {
        private final int CAS_FINAL = 63;
        private ArrayList<Casilla> casillas;
        private Jugador jugador;
        
        // Constructor
        TableroOca() {
            jugador = new Jugador(1); // Solo un jugador con ID 1
            casillas = new ArrayList<>();
            crearCasillas();
        }
        
        // Métodos
        
        private int calcularSaltoCasillaDados(int n) {
            int var1 = n / 10; 
            int var2 = var1 * 10; 
            int res1 = n - var2; 
            return (var1 + res1);
        }
        
        public int tirarDado() {
            return (int) (Math.random() * 6) + 1;
        }
        
        private void crearCasillas() {
            for (int i = 0; i < CAS_FINAL; i++) {
                casillas.add(new Casilla(i + 1));
            }
            casillas.set(0, new Casilla(1, "Salida", 0, false));
            casillas.set(4, new Casilla(5, "Oca", 0, 4, true));
            casillas.set(8, new Casilla(9, "Oca", 0, 5, true));
            casillas.set(13, new Casilla(14, "Oca", 0, 4, true));
            casillas.set(17, new Casilla(18, "Oca", 0, 5, true));
            casillas.set(22, new Casilla(23, "Oca", 0, 4, true));
            casillas.set(26, new Casilla(27, "Oca", 0, 5, true));
            casillas.set(31, new Casilla(32, "Oca", 0, 4, true));
            casillas.set(35, new Casilla(36, "Oca", 0, 5, true));
            casillas.set(40, new Casilla(41, "Oca", 0, 4, true));
            casillas.set(44, new Casilla(45, "Oca", 0, 5, true));
            casillas.set(49, new Casilla(50, "Oca", 0, 4, true));
            casillas.set(53, new Casilla(54, "Oca", 0, 5, true));
            casillas.set(58, new Casilla(59, "Oca", 0, 0, true));
            casillas.set(5, new Casilla(6, "Puente", 1, 13, false));
            casillas.set(11, new Casilla(12, "Puente", 1, 7, false));
            casillas.set(18, new Casilla(19, "Posada", 1, false));
            casillas.set(30, new Casilla(31, "Pozo", 9999, false));
            casillas.set(41, new Casilla(42, "Laberinto", 0, -12, false));
            casillas.set(55, new Casilla(56, "Carcel", 2, false));
            casillas.set(25, new Casilla(26, "Dados", 0, calcularSaltoCasillaDados(26), false));
            casillas.set(52, new Casilla(53, "Dados", 0, calcularSaltoCasillaDados(53), false));
            casillas.set(57, new Casilla(58, "Calavera", 0, -57, false));
            casillas.set(62, new Casilla(63, "Casilla Final", 0, false));
        }
        
        // Getters y Setters
        public ArrayList<Casilla> getCasillas() {
            return casillas;
        }
        
        public void setCasillas(ArrayList<Casilla> casillas) {
            this.casillas = casillas;
        }
        
        public Jugador getJugador() {
            return jugador;
        }
        
        public void setJugador(Jugador jugador) {
            this.jugador = jugador;
        }
    }

    // Clase Main
    public static void main(String[] args) {
        TableroOca juego = new TableroOca();
        
        // Ejemplo de cómo podrías usar las clases
        System.out.println("Número de casillas: " + juego.getCasillas().size());
        System.out.println("Posición inicial del jugador: " + juego.getJugador().getPosicion());
        
        // Simula el lanzamiento de un dado
        int dado = juego.tirarDado();
        System.out.println("Resultado del dado: " + dado);
        
        // Movimiento del jugador
        int nuevaPosicion = juego.getJugador().getPosicion() + dado;
        if (nuevaPosicion >= 63) {
            nuevaPosicion = 63; // Casilla final
        }
        juego.getJugador().setPosicion(nuevaPosicion);
        
        // Muestra la nueva posición del jugador
        System.out.println("Nueva posición del jugador: " + juego.getJugador().getPosicion());
        
        // Muestra el tipo de casilla en la nueva posición
        Casilla casillaActual = juego.getCasillas().get(juego.getJugador().getPosicion() - 1);
        System.out.println("Tipo de casilla actual: " + casillaActual.getTipo());
    }
}
