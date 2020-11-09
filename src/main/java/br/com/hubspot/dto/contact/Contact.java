package br.com.hubspot.dto.contact;

import static java.lang.Long.parseLong;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;

import com.google.gson.annotations.SerializedName;

import br.com.hubspot.entity.ContactEntity;
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
public class Contact implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = getLogger(Contact.class);
	
	@SerializedName("vid")
	private Long vid;
	
	@SerializedName("properties")
	private Properties properties;
	
	public ContactEntity toEntity() {
		ContactEntity contactEntity = null;
		try {
			contactEntity = ContactEntity.builder()
					.id(vid)
					.createDate(properties.getCreatedate() != null && isNotBlank(properties.getCreatedate().getValue()) ? new Date(parseLong(properties.getCreatedate().getValue())) : null)
					.firstName(properties.getFirstName() != null ? properties.getFirstName().getValue() : "")
					.lastName(properties.getLastName() != null  ? properties.getLastName().getValue() : "")
					.hsLeadStatus(properties.getHsLeadStatus() != null ? properties.getHsLeadStatus().getValue() : "")
					.produto(properties.getProduto() != null ? properties.getProduto().getValue() : "")
					.hubspotOwnerId(properties.getHubspotOwnerId() != null && isNotBlank(properties.getHubspotOwnerId().getValue()) ? parseLong(properties.getHubspotOwnerId().getValue()) : null)
					.notesLastUpdated(properties.getNotesLastUpdated() != null && isNotBlank(properties.getNotesLastUpdated().getValue()) ? new Date(parseLong(properties.getNotesLastUpdated().getValue())) : null)
					.valorRealEmprestimo(properties.getValorRealEmprestimo() != null && isNotBlank(properties.getValorRealEmprestimo().getValue()) ? new BigDecimal(properties.getValorRealEmprestimo().getValue()) : null)
					.valorDaGarantia2(properties.getValorDaGarantia2() != null && isNotBlank(properties.getValorDaGarantia2().getValue()) ? new BigDecimal(properties.getValorDaGarantia2().getValue()) : null)
					.numNotes(properties.getNumNotes() != null ? properties.getNumNotes().getValue() : "")
					.lifecycleStage(properties.getLifecycleStage() != null ? properties.getLifecycleStage().getValue() : "")
					.tagOrigem(properties.getTagOrigem() != null ? properties.getTagOrigem().getValue() : "")
					.estadoImovelCgi(properties.getEstadoImovelCgi() != null ? properties.getEstadoImovelCgi().getValue() : "")
					.cidadeImovelCgi(properties.getCidadeImovelCgi() != null ? properties.getCidadeImovelCgi().getValue() : "")
					.situacaoProfissional(properties.getSituacaoProfissional() != null ? properties.getSituacaoProfissional().getValue() : "")
					.valorEmprestimoCgv(properties.getValorEmprestimoCgv() != null && isNotBlank(properties.getValorEmprestimoCgv().getValue()) ? new BigDecimal(properties.getValorEmprestimoCgv().getValue()) : null)
					.valorVeiculoCgv(properties.getValorVeiculoCgv() != null && isNotBlank(properties.getValorVeiculoCgv().getValue()) ? new BigDecimal(properties.getValorVeiculoCgv().getValue()) : null)
					.objetivoDoEmprestimoCgv(properties.getObjetivoDoEmprestimoCgv() != null ? properties.getObjetivoDoEmprestimoCgv().getValue() : "")
					.city(properties.getCity() != null ? properties.getCity().getValue() : "")
					.state(properties.getState() != null ? properties.getState().getValue() : "")
					.build();
		} catch (Exception e) {
			LOG.error("Error on parsing " + properties);
			LOG.error("Details " + e);
		}
		return contactEntity;
	}
	
}
