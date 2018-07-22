/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.util.logging.Logger;

/**
 *
 * @author JIGA
 */
public class DEF {


    public static enum ESTADO {
        ACTIVO(1),
        INACTIVO(0),
        ERROR(2),
        PASSRESET(3),
        USERERROR(99);

        int value = 0;

        ESTADO(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    public static enum SESSION {

        USUARIO,
        ESTADO;

        SESSION() {
        }
    }

    public static enum PAGINAS {
        LOGIN("/login"),
        PRINCIPAL("/view/principal"),
        RESET("/view/reset"),
        NEWPASS("/view/newPass"),
        MANCURSO("/view/mantenedores/man_curso"),
        MANPROFESORES("/view/mantenedores/man_profesores"),
        ERROR_404("/error/404"),
        ERROR_500("/error/500");
        String value = null;
        PAGINAS(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }



}
