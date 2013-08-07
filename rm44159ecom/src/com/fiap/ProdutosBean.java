/**
 * 
 */
package com.fiap;

import javax.faces.bean.ManagedBean;

/**
 * @author RM44159
 *
 */
@ManagedBean(name="p")
public class ProdutosBean {

	private int codProduto;
	private String descricao;
	private String foto;
	
	/**
	 * Método de pesquisa de produtos
	 * @return String página de retorno
	 */
	public String btnPesquisar() {
		
		if (getCodProduto() == 1) {
			setDescricao("Calça");
			setFoto("Calca.jpg");
		} else if (getCodProduto() == 2) {
			setDescricao("Blusa");
			setFoto("Blusa.jpg");
		} else if (getCodProduto() == 3) {
			setDescricao("Jaqueta");
			setFoto("Jaqueta.jpg");
		} else {
			setFoto("sem_foto.gif");
		}
		
		return "";
	}

	/**
	 * @return the codProduto
	 */
	public int getCodProduto() {
		return codProduto;
	}

	/**
	 * @param codProduto the codProduto to set
	 */
	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the foto
	 */
	public String getFoto() {
		return foto;
	}

	/**
	 * @param foto the foto to set
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
}
