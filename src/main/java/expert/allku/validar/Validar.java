/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expert.allku.validar;

import expert.allku.documento.Ruc;
import expert.allku.documento.Ci;

/**
 *
 * @author jorgequiguango
 */
public class Validar {

    /**
     * Valida el documento Ecuatoriano
     * @param documento el número de Cédula, RUC o Consumidor Final
     * @param tipoDocumento si el tipo de documento  es Cédula, RUC o Consumidor Final
     * @return Verdadero si es un documento válido
     */    
    public Boolean validaDocumento(String documento, String tipoDocumento) {

        if (tipoDocumento.equals("RUC")) {
            Ruc ruc = new Ruc(documento);
            if (!ruc.validar()) {
                return false;
            }
        } else if (tipoDocumento.equals("Cédula")) {
            Ci ci = new Ci(documento);
            if (!ci.validar()) {
                return false;
            }
        } else if (tipoDocumento.equals("Consumidor Final")) {
            if (!documento.equals("9999999999999")) {
                return false;
            }
        }
        return true;
    }

    /**
     * Valida que una cadena no sea solo espacios o vacía
     * @param cadena cadena de caracters
     * @return Verdadero si tiene contenido que no sea espacios o no sea vacía
     */
    public Boolean validaVacio(String cadena) {
        String cadenaSinEspacios = cadena.replaceAll("\\s+", "");
        if (cadenaSinEspacios.isEmpty()) {
            return false;
        }
        return true;
    }
}
