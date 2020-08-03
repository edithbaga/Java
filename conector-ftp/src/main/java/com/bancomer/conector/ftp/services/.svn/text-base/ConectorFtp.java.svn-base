/**
 * Proyecto: Sugo - Modulo de respuesta a oficios 
 *
 * Archivo:ConectorFtp.java
 *
 * Creado: 30/06/2011
 *
 * Derechos Reservados de Copia (c) - BBVA Bancomer
 */

package com.bancomer.conector.ftp.services;

import java.io.InputStream;

import com.bancomer.conector.ftp.errors.InfraestructuraFtpException;

/**
 * Clase utilizada para generar la respuesta de algun oficio en pdf.
 * 
 * @author Susana Edith Barrientos
 *
 */
public interface ConectorFtp {
	/**
	 * Metodo utilizado para subir un archivo a un servidor ftp
	 * @throws InfraestructuraFtpException excepcion lanzada.
	 */
	boolean subirArchivo(String nombreArchivo, InputStream inputStream) throws InfraestructuraFtpException;
}
