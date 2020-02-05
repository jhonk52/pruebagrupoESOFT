import java.util.Random;

public class RespuestaPrueba {

    public RespuestaPrueba() {
    }

    public static int funcion (final int N ,final int M){
        Random random = new Random();
        final int tamanoMatriz = N*M;

        boolean[] validador = new boolean[tamanoMatriz+1];
        for (int l = 0; l < validador.length; l++) {
            validador[l] = false;
        }

        if (N > 2 && M > 2) {
            int[][] matriz = new int[N][M];

            //--------------- creo la matriz con los numeros aleatorios-----------------

            for (int i = 0; i < N; i++) {

                for (int j = 0; j < M; j++) {

                    int numeroAleatorio = random.nextInt(tamanoMatriz) + 1;

                    while (true) {

                        if (!validador[numeroAleatorio]) {
                            matriz[i][j] = numeroAleatorio;
                            validador[numeroAleatorio] = true;
                            break;
                        } else {
                            numeroAleatorio = random.nextInt(tamanoMatriz) + 1;
                        }
                    }
                }
            }

            //----------- saco los total_columna de las columnas ----------------

            int[] totalesDeColumnas = new int[M];
            int sumatoriaDeColumna = 0;

            for (int a = 0; a < M; a++) {

                for (int b = 0; b < N; b++) {

                    sumatoriaDeColumna += matriz[b][a];
                }

                totalesDeColumnas[a] = sumatoriaDeColumna;
                sumatoriaDeColumna = 0;
            }

            // ------------- saco el promedio de los totales de todas las columnas par ---------

            int sumatoriaColumnasPar = 0;
            float promedioTotalesColumnasPar = 0;
            int cantidadDeColumnasPar = 0;

            for (int c = 0 ; c < totalesDeColumnas.length ; c += 2) {
                sumatoriaColumnasPar += totalesDeColumnas[c];
                cantidadDeColumnasPar++;
            }
            promedioTotalesColumnasPar = sumatoriaColumnasPar / cantidadDeColumnasPar;


            // ---- saco cuantos total_columna estan por encima del promedio de totales de columna par ------

            int respuesta = 0;

            for (int d = 0; d < totalesDeColumnas.length; d++) {
                if (totalesDeColumnas[d] > promedioTotalesColumnasPar ){
                    respuesta ++;
                }
            }

            return respuesta;

        }else{

            return -1;
        }
    }
}