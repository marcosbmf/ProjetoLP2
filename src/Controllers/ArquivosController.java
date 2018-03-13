package Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author Marcos Barros
 *
 */
public class ArquivosController {
	/**
	 * Metodo responsavel salvar um objeto em arquivo.
	 * 
	 *  @param nomeArquivo 
	 *  	- O nome do arquivo que será criado para salvar o objeto
	 *  @param objeto
	 *  	- O objeto a ser salvo no arquivo
	 */
	public void salvaObjeto(String nomeArquivo, Object objeto) throws IOException {
		File file = new File(nomeArquivo);
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(objeto);
			oos.close();
		} catch (Exception e) {
			throw new IOException();
		}
	}
	/**
	 * Metodo responsavel por recuperar um objeto salvo.
	 * 
	 *  @param nomeArquivo 
	 *  	- O nome do arquivo que será carregado
	 *
	 */
	public Object carregaObjeto(String nomeArquivo) throws IOException {
		File file = new File(nomeArquivo);
		FileInputStream fis;
		ObjectInputStream ois;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			ois.close();
			return obj;
		} catch(Exception e) {
			throw new IOException();
		}
	}
}
