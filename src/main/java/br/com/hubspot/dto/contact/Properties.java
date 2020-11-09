package br.com.hubspot.dto.contact;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

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
public class Properties implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SerializedName("firstname")
	private FirstName firstName;
	
	@SerializedName("lastname")
	private LastName lastName;
	
	@SerializedName("createdate")
	private CreateDate createdate;
	
	@SerializedName("hs_lead_status")
	private HsLeadStatus hsLeadStatus;
	
	@SerializedName("produto")
	private Produto produto;
	
	@SerializedName("hubspot_owner_id")
	private HubspotOwnerId hubspotOwnerId;
	
	@SerializedName("notes_last_updated")
	private NotesLastUpdated notesLastUpdated;
	
	@SerializedName("valor_real_emprestimo")
	private ValorRealEmprestimo valorRealEmprestimo;
	
	@SerializedName("valor_da_garantia_2")
	private ValorDaGarantia2 valorDaGarantia2;
	
	@SerializedName("num_notes")
	private NumNotes numNotes;
	
	@SerializedName("lifecyclestage")
	private LifecycleStage lifecycleStage;
	
	@SerializedName("tag_origem")
	private TagOrigem tagOrigem;
	
	@SerializedName("estado_imovel_cgi")
	private EstadoImovelCgi estadoImovelCgi;
	
	@SerializedName("cidade_imovel_cgi")
	private CidadeImovelCgi cidadeImovelCgi;
	
	@SerializedName("situacao_profissional")
	private SituacaoProfissional situacaoProfissional;

	@SerializedName("valor_emprestimo_cgv")
	private ValorEmprestimoCgv valorEmprestimoCgv;

	@SerializedName("valor_veiculo_cgv")
	private ValorVeiculoCgv valorVeiculoCgv;
	
	@SerializedName("objetivo_do_emprestimo_cgv")
	private ObjetivoDoEmprestimoCgv objetivoDoEmprestimoCgv;
	
	@SerializedName("city")
	private City city;
	
	@SerializedName("state")
	private State state;
	
}
