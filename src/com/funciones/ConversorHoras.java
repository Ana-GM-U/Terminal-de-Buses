package funciones ;

public class ConversorHoras {
    
    public static int convertirHoraAMinutos(String hora) {
        String[] partes = hora.split(":");
        int horas = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);
        return horas * 60 + minutos;
    }

    public static String convertirMinutosAHora(int minutosTotales) {
        int horas = minutosTotales / 60;
        int minutos = minutosTotales % 60;
        return String.format("%02d:%02d", horas, minutos);
    }
}
