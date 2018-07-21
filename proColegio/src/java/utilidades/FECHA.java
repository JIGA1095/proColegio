/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author desarrollo
 */
public class FECHA {

    private static final String ORIGINAL
            = "ÁáÉéÍíÓóÚúÑñÜü";
    private static final String REPLACEMENT
            = "AaEeIiOoUuNnUu";

    public static String minFecha(Date fecha) {
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(fecha);
    }
    
    public static String SQLString(Object string) {
        return string == null || string.toString().trim().length() == 0 ? "null" : "'" + SQLNormal((String) string).trim() + "'";
    }

    public static String SQLNormal(String string) {
        return stripAccents(string.replace("\\", "\\\\").replace("'", "''"));
    }

    public static int getDiaDeSemana(Timestamp d) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(d);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static String getYear() {
        Calendar c = Calendar.getInstance();
        return Integer.toString(c.get(Calendar.YEAR));
    }

    public static String getYear(Timestamp timestamp) {
        DateFormat format = new SimpleDateFormat("yyyy");
        Date hora = new Date(timestamp.getTime());
        return format.format(hora);
    }

    public static String getMonth(Timestamp timestamp) {
        DateFormat format = new SimpleDateFormat("MMM");
        Date hora = new Date(timestamp.getTime());
        return format.format(hora);
    }
    public static String getDay(Timestamp timestamp) {
        DateFormat format = new SimpleDateFormat("dd");
        Date hora = new Date(timestamp.getTime());
        return format.format(hora);
    }

    public static String getTime(Timestamp timestamp) {
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date hora = new Date(timestamp.getTime());
        return format.format(hora);
    }

    public static String getTimeFecha(Timestamp timestamp) {
        DateFormat format = new SimpleDateFormat("dd.MM.yyy");
        Date hora = new Date(timestamp.getTime());
        return format.format(hora);
    }

    public static String getTimeFechaJunta(Timestamp timestamp) {
        DateFormat format = new SimpleDateFormat("HH:mm_dd-MM-yyyy");
        Date hora = new Date(timestamp.getTime());
        return format.format(hora);
    }

    public static Date getTime(String horaS) throws ParseException {
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
//        Date hora = new Date(horaS);
        return format.parse(horaS);
    }

    public static String stripAccents(String str) {
        if (str == null) {
            return null;
        }
        char[] array = str.toCharArray();
        for (int index = 0; index < array.length; index++) {
            int pos = ORIGINAL.indexOf(array[index]);
            if (pos > -1) {
                array[index] = REPLACEMENT.charAt(pos);
            }
        }
        return new String(array);
    }

    /**
     * Metodo retorna la fecha en formato dd/MM/yyyy HH:mm:ss
     *
     * @param fecha Date
     * @return String
     */
    public static String formatFull(Date fecha) {
        String f = null;
        Locale locale = new Locale("es_CL");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return format.format(fecha);
    }

    /**
     * Metodo retorna la fecha en formato dd/MM/yyyy
     *
     * @param fecha Date
     * @return String
     */
    public static String formatFullS(Date fecha) {
        return formatFullS(fecha, "/");
    }

    public static String formatFullSnew(Date fecha) {
        return formatFullSnew(fecha, "-");
    }

    public static String formatFullSnew(Date fecha, String sep) {
        String f = null;
        Locale locale = new Locale("es_CL");
        DateFormat format = new SimpleDateFormat("yyyy" + sep + "MM" + sep + "dd");

        return format.format(fecha);
    }

    /**
     * Metodo retorna la fecha en formato dd/MM/yyyy
     *
     * @param fecha Date
     * @return String
     */
    public static String formatFullS(Date fecha, String sep) {
        String f = null;
        Locale locale = new Locale("es_CL");
        DateFormat format = new SimpleDateFormat("dd" + sep + "MM" + sep + "yyyy");

        return format.format(fecha);
    }

    /**
     * Metodo que transforma un String en formato dd/mm/yyyy a Date
     *
     * @param fecha Date
     * @return String
     */
    public static Date toDate(String fecha) {
        fecha = normal(fecha);

        Locale locale = new Locale("es_CL");
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", locale);

        try {

            return format.parse(fecha);
        } catch (ParseException ex) {

            Logger.getLogger(FECHA.class.getName()).log(Level.SEVERE, "Problemas al transformar el string " + fecha, ex);
            return null;
        }
    }

    public static Date toDateFullString(String fecha) {
        Locale locale = new Locale("es_CL");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);

        try {

            return format.parse(fecha);
        } catch (ParseException ex) {

            Logger.getLogger(FECHA.class.getName()).log(Level.SEVERE, "Problemas al transformar el string " + fecha, ex);
            return null;
        }
    }

    /**
     * Metodo devuelve la fecha en formato dd/mm/aaaa
     *
     * @param fecha String
     * @return String
     */
    public static String normal(String fecha) {
        fecha = fecha.replace("-", "/");
        String[] a = fecha.split("/");
        if (a[0].length() == 4) {
            fecha = a[2] + "/" + a[1] + "/" + a[0];
        } else {
            fecha = a[0] + "/" + a[1] + "/" + a[2];
        }
        return fecha;
    }

    /**
     * Metodo que transforma un String en formato dd/mm/yyyy a Date
     *
     * @param fecha Timestamp
     * @return Date
     */
    public static Date toDate(Timestamp fecha) {

        return new Date(fecha.getTime());

    }

    /**
     *
     * @param fecha Date
     * @return String
     */
    public static String toString(Date fecha) {

        return toString(fecha, "/");
    }

    /**
     * Metodo que adiciona dias a una fecha dada, si la cantidad de dias es
     * negativo estos seran restados
     *
     * @param fecha Date
     * @param dias int
     * @return Date
     */
    public static Date sumarRestarDiasFecha(Date fecha, int dias) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(fecha); // Configuramos la fecha que se recibe

        calendar.add(Calendar.DAY_OF_YEAR, dias); // numero de días a añadir, o restar en caso de días<0

        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos

    }

    /**
     * Metodo que adiciona meses a una fecha dada, si la cantidad de meses es
     * negativo estos seran restados
     *
     * @param fecha Date
     * @param meses int
     * @return Date
     */
    public static Date sumarRestarMesFecha(Date fecha, int meses) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(fecha); // Configuramos la fecha que se recibe

        calendar.add(Calendar.MONTH, meses); // numero de días a añadir, o restar en caso de días<0

        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos

    }

    /**
     * Comparamos las Fechas. Si las fechas son iguales retorna 0, si retorna -1
     * Fecha Date2 es menor, si retorna 1 fecha Date1 menor
     *
     * @param Date1 Date
     * @param Date2 Date
     * @return int
     */
    public static int compararFechasConDate(Date Date1, Date Date2) {

        Date1 = toDate(toSQLDate(Date1));
        Date2 = toDate(toSQLDate(Date2));

        int resultado = 0;

        if (Date1.before(Date2)) {
            //2 mayor
            resultado = 1;
        } else if (Date2.before(Date1)) {
            //1 mayor
            resultado = -1;
        } else {
            //iguales
            resultado = 0;
        }

        return resultado;
    }

    /**
     * Metodo que calcula la diferencia en dias entre dos fechas
     *
     * @param Date1 Date
     * @param Date2 Date
     * @return
     */
    public static long diferenciaFechasConDate(Date Date1, Date Date2) {

        Date1 = toDate(toSQLDate(Date1));
        Date2 = toDate(toSQLDate(Date2));

        long resultado = 0;

        long milis1 = Date1.getTime();
        long milis2 = Date2.getTime();
        // calcular la diferencia en milisengundos
        long diff = milis2 - milis1;
        // calcular la diferencia en segundos
//        long diffSeconds = diff / 1000;
//        // calcular la diferencia en minutos
//        long diffMinutes = diff / (60 * 1000);
//        // calcular la diferencia en horas
//        long diffHours = diff / (60 * 60 * 1000);
        // calcular la diferencia en dias

        resultado = diff / (24 * 60 * 60 * 1000);

        return resultado;
    }

    /**
     * Metodo que calcula la diferencia en horas entre dos fechas
     *
     * @param Date1 Date
     * @param Date2 Date
     * @return Long
     */
    public static String diferenciaFechasConDateHoras(Date Date1, Date Date2) {

        long lantes = Date1.getTime();
        long lahora = Date2.getTime();
        long diferencia = (lahora - lantes);

        return new java.text.SimpleDateFormat("mm").format(new Date(diferencia));

    }

    /**
     * Metodo toma un string y lo transforma en fecha
     *
     * @param fecha Date
     * @param sep String
     * @return String
     */
    public static String toString(Date fecha, String sep) {

        try {
            Locale locale = new Locale("es_CL");
            DateFormat format = new SimpleDateFormat("dd" + sep + "MM" + sep + "yyyy", locale);
            return format.format(fecha);
        } catch (Exception e) {

            return "";
        }
    }

    /**
     * Metodo formate un Date a un String con separador /
     *
     * @param fecha Date
     * @return String
     */
    public static String toSQLDate(Date fecha) {
        return toSQLDate(fecha, "-");
    }

    /**
     * Metodo que formatea un Date en tipo yyyy-MM-dd donde en sep se envia el
     * caracter con el se separa
     *
     * @param fecha
     * @param sep
     * @return
     */
    public static String toSQLDate(Date fecha, String sep) {
        Locale locale = new Locale("es_CL");
        DateFormat format = new SimpleDateFormat("yyyy" + sep + "MM" + sep + "dd", locale);
        return format.format(fecha);
    }

    /**
     * Metodo que formatea un date en formato completo SQL
     *
     * @param fecha Date
     * @return String
     */
    public static String toSQLDateFull(Date fecha) {
        return toSQLDateFull(fecha, "-");
    }

    /**
     * Metodo que formatea un date en formato completo SQL con el separador
     * enviado
     *
     * @param fecha Date
     * @param sep String
     * @return String
     */
    public static String toSQLDateFull(Date fecha, String sep) {
        Locale locale = new Locale("es_CL");
        DateFormat format = new SimpleDateFormat("yyyy" + sep + "MM" + sep + "dd HH:mm:ss", locale);
        return format.format(fecha);
    }

    public static String dateReverse(String fecha) {
        String[] aux = fecha.replace("-", "/").split("/");
        fecha = aux[2] + "/" + aux[1] + "/" + aux[0];
        return fecha;
    }

    public static synchronized Timestamp getTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    public static Timestamp toTimeStamp(Date fecha) {
        try {
            long milliseconds = fecha.getTime();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(milliseconds);
            return timestamp;

        } catch (Exception ex) {
            Logger.getLogger(FECHA.class
                    .getName()).log(Level.SEVERE, "Problemas al transformar Date " + fecha, ex);
            return null;
        }

    }

    public static Timestamp toTimeStamp(String fechas) {
        try {
            fechas = fechas.replace('T', ' ').replace('Z', ' ');
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

            Date fecha = dateFormat.parse(fechas);
            long milliseconds = fecha.getTime();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(milliseconds);
            return timestamp;
        } catch (Exception ex) {

            return null;
        }

    }

    public static Date toDateSeparado(String fechas, String hora) {
        try {
            String datetime = fechas + " " + hora;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date fecha = dateFormat.parse(datetime);

            return fecha;

        } catch (Exception ex) {
//            System.out.println("CAE");
            return null;
        }

    }

    public static Date toDateCompleto(String fechasHora) {
        try {
//            String datetime = fechasHora;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date fecha = dateFormat.parse(fechasHora);

            return fecha;

        } catch (Exception ex) {
//            System.out.println("CAE");
            return null;
        }
    }

    public static Date toDateCompletoMin(String fechasHora) {
        try {
//            String datetime = fechasHora;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date fecha = dateFormat.parse(fechasHora);

            return fecha;

        } catch (Exception ex) {
//            System.out.println("CAE");
            return null;
        }
    }

    public static String toDateCompleto2(String fechasHora) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date fecha = dateFormat.parse(fechasHora);

            return dateFormat.format(fecha);

        } catch (Exception ex) {
            return null;
        }
    }

    public static String horaSimple(String fechasHora) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
            Date fecha = dateFormat.parse(fechasHora);

            return dateFormat.format(fecha);

        } catch (Exception ex) {
            return null;
        }
    }

    public static String toFechaDetalle(Date fecha) {
        Locale locale = new Locale("es");
        DateFormat format = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy", locale);

        return format.format(fecha);
    }

    public static String toFechaDetalleFull(Date fecha) {
        Locale locale = new Locale("es");
        DateFormat format = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy 'a las' HH':'mm", locale);

        return format.format(fecha);
    }

    public static String toFechaDetalleFull2(Date fecha) {
        Locale locale = new Locale("es");
        DateFormat format = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy 'desde las' HH':'mm", locale);

        return format.format(fecha);
    }

    public static String cambioDeHora(Date antigua, Date nueva) {
        Locale locale = new Locale("es");
        DateFormat format = new SimpleDateFormat("'Del' dd 'de' MMMM 'del' yyyy 'desde las' HH':'mm", locale);

        String cambio = format.format(antigua);
        format = new SimpleDateFormat(" 'al' dd 'de' MMMM 'del' yyyy 'desde las' HH':'mm", locale);
        cambio += format.format(nueva);

        return cambio;
    }

    public static void main(String[] args) {
//        System.out.println(FECHA.toFechaDetalleFull(FECHA.getTimestamp()));

    }

}
