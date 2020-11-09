package br.com.hubspot.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import br.com.hubspot.dto.contact.AllContactsOutput;
import br.com.hubspot.dto.contact.Contact;
import br.com.hubspot.entity.ContactEntity;

public interface ContactService {
	List<AllContactsOutput> getAll() throws ClientProtocolException, IOException;
	Contact getById(Long id) throws ClientProtocolException, IOException;
	void save(ContactEntity contactEntity);
}
