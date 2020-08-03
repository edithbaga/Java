/**
// * Proyecto: Sugo - Modulo de respuesta a oficios 
 *
 * Archivo:ConectorFtp.java
 *
 * Creado: 30/06/2011
 *
 * Derechos Reservados de Copia (c) - BBVA Bancomer
 */

package com.bancomer.conector.ftp.services;

import java.io.ByteArrayInputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bancomer.conector.ftp.errors.InfraestructuraFtpException;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:applicationContext-ftp.xml"
})

/**
 * Clase utilizada para probar la conexion ftp para subir y obtener
 * archivos.
 * 
 * @author Susana Edith Barrientos
 * @author Sergio Mena.
 *
 */

public class ConectorFtpTest {
	
	/**
	 * Bean para el servicio de ftp.
	 */
    @Autowired
    private ConectorFtp conectorFtp;
	
    /**
     * Metodo utilizado probar el upload de un archivo via ftp.
     * @throws InfraestructuraFtpException
     */
	@Test
	public void subirArchivoTest() throws InfraestructuraFtpException{
		
		boolean estaAlmacenado = conectorFtp.subirArchivo("okas4.xml", 
				new ByteArrayInputStream("<aja>Bien ahi!!</aja>".getBytes()));
		assertTrue(estaAlmacenado);
	}
}
