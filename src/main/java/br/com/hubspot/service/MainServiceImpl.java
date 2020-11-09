package br.com.hubspot.service;

import static org.slf4j.LoggerFactory.getLogger;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import br.com.hubspot.dto.contact.AllContactsOutput;
import br.com.hubspot.dto.contact.Contact;
import br.com.hubspot.entity.ContactEntity;



@Service
public class MainServiceImpl implements MainService {
	
	private static final Logger LOG = getLogger(MainServiceImpl.class);
	
	private final ContactService contactService;
	
	public MainServiceImpl(ContactService contactService) {
		super();
		this.contactService = contactService;
	}

	@Override
	public void execute() throws ClientProtocolException, IOException {
		List<AllContactsOutput> allContactsOutput = contactService.getAll();
		allContactsOutput.stream().forEach(allContact -> {
			allContact.getContacts().stream().forEach(contacts -> {
				try {
					Contact contact = contactService.getById(contacts.getVid());
					if(contact != null) {
						ContactEntity contactEntity = contact.toEntity();
						if(contactEntity != null) {
							contactService.save(contactEntity);
							LOG.info(contactEntity.toString());							
						}
					}
				} catch (ClientProtocolException e) {
					LOG.error("Error on save " + allContact);
					LOG.error("Details " + e);
				} catch (IOException e) {
					LOG.error("Error on save " + allContact);
					LOG.error("Details " + e);
				}
			});
		});
	}
	
}
