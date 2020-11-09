package br.com.hubspot.dto.contact;

import java.io.Serializable;
import java.util.List;

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
public class AllContactsOutput implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SerializedName("contacts")
	private List<Contacts> contacts;
	
	@SerializedName("has-more")
	private boolean hasMore;
	
	@SerializedName("vid-offset")
	private Long vidOffset;
	
}
