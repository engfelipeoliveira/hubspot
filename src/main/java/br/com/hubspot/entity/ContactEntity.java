package br.com.hubspot.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
@Entity
public class ContactEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	@Column(name = "createdate")
	private Date createDate;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "hs_lead_status")
	private String hsLeadStatus;

	@Column(name = "produto")
	private String produto;

	@Column(name = "hubspot_owner_id")
	private Long hubspotOwnerId;

	@Column(name = "notes_last_updated")
	private Date notesLastUpdated;

	@Column(name = "valor_real_emprestimo")
	private BigDecimal valorRealEmprestimo;

	@Column(name = "valor_da_garantia_2")
	private BigDecimal valorDaGarantia2;

	@Column(name = "num_notes")
	private String numNotes;

	@Column(name = "lifecyclestage")
	private String lifecycleStage;

	@Column(name = "tag_origem")
	private String tagOrigem;

	@Column(name = "estado_imovel_cgi")
	private String estadoImovelCgi;

	@Column(name = "cidade_imovel_cgi")
	private String cidadeImovelCgi;

	@Column(name = "situacao_profissional")
	private String situacaoProfissional;

	@Column(name = "valor_emprestimo_cgv")
	private BigDecimal valorEmprestimoCgv;

	@Column(name = "valor_veiculo_cgv")
	private BigDecimal valorVeiculoCgv;

	@Column(name = "objetivo_do_emprestimo_cgv")
	private String objetivoDoEmprestimoCgv;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;
}

