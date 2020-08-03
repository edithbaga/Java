/**
 * Proyecto: Sugo - Modulo de respuesta a oficios 
 *
 * Archivo:ConectorFtp.java
 *
 * Creado: 30/06/2011
 *
 * Derechos Reservados de Copia (c) - BBVA Bancomer
 */

package com.bancomer.conector.ftp.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancomer.conector.ftp.errors.InfraestructuraFtpException;
import com.bancomer.conector.ftp.services.ConectorFtp;

/**
 * Clase encargar de implementar los metodo se 
 * @author Susana Edith Barrientos Galicia
 * @author Sergio Mena
 *
 */
@Service
public class ConectorFtpImpl implements ConectorFtp {
	
	/**
	 * Log.
	 */
	private static final Logger log = Logger.getLogger(ConectorFtp.class);
	
	/**
	 * Bean para la clase ftpClient.
	 */
	@Autowired
	private FTPClient ftpClient;
	
	/**
	 * Bean para el nombre del host.
	 */
	@Autowired
	private String host;
	
	/**
	 * Bean para el username.
	 */
	@Autowired
	private String username;
	
	@Autowired
	private String passwd;
	
	/**
	 * 
	 * @see com.bancomer.conector.ftp.services.ConectorFtp#subirArchivo()
	 */
	public boolean subirArchivo(String nombreArchivo, InputStream inputStream) 
		throws InfraestructuraFtpException {
		
		if (log.isDebugEnabled()) {
			log.debug(">> Entrando  a ConectorFtpImpl.subirArchivo() <<");
		}
		
		boolean estaAlmacenado = false;

		try {
			
			ftpClient.connect(host);
			ftpClient.login(username, passwd);
			estaAlmacenado = ftpClient.storeFile(nombreArchivo, inputStream);

			
		} catch (SocketException e) {
			log.error(e);
			throw new InfraestructuraFtpException(
					"Error al tratar de crear la conexion ftp, mensaje:[ " + 
					e.getMessage() + " ]");
		} catch (IOException e) {
			log.error(e);
			throw new InfraestructuraFtpException("Error I/O ftp, mensaje:[ " +
					e.getMessage() + " ]");
		} finally {
			try {
			
				if (inputStream != null) {
					inputStream.close();
				}
					ftpClient.disconnect();
				} catch (IOException e) {
					log.error(e);
				}	
		}
		
		if (log.isDebugEnabled()) {
			log.debug("<< Saliendo de ConectorFtpImpl.subirArchivo() >>");
		}
		
		return estaAlmacenado;

	}

}
