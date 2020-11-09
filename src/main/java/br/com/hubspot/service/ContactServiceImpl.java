package br.com.hubspot.service;

import static java.lang.String.format;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.hubspot.dto.contact.AllContactsOutput;
import br.com.hubspot.dto.contact.Contact;
import br.com.hubspot.entity.ContactEntity;
import br.com.hubspot.repository.ContactRepository;



@Service
public class ContactServiceImpl implements ContactService {
	
	private final ContactRepository contactRepository;
	
	@Value("${hubspot.api_key}")
	private String HUBSPOT_API_KEY;
	
	@Value("${hubspot.url.get_all_contacts}")
	private String HUBSPOT_URL_GET_ALL_CONTACTS;
	
	@Value("${hubspot.url.get_contacts_by_id}")
	private String HUBSPOT_URL_GET_CONTACT_BY_ID;
	
	private static final Logger LOG = getLogger(ContactServiceImpl.class);
	
	public ContactServiceImpl(ContactRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}

	@Override
	public List<AllContactsOutput> getAll() throws ClientProtocolException, IOException {
		boolean hasMore = true;
		Long vidOffset = 0L;
		List<AllContactsOutput> allContactsOutput = new ArrayList<AllContactsOutput>();
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			while(hasMore) {
				HttpGet httpGet = new HttpGet(format(HUBSPOT_URL_GET_ALL_CONTACTS, HUBSPOT_API_KEY, vidOffset));
				CloseableHttpResponse response = httpClient.execute(httpGet);

				if (response.getStatusLine().getStatusCode() == 200) {
					AllContactsOutput result = new Gson().fromJson(EntityUtils.toString(response.getEntity()), AllContactsOutput.class);
					allContactsOutput.add(result);
					vidOffset = result.getVidOffset();
					hasMore = result.isHasMore();
				} else {
					hasMore = false;
					LOG.error("Error getting all contacts");
					LOG.error(response.toString());
				}
			}
		} finally {
			httpClient.close();
		}
		
		return allContactsOutput;
	}

	@Override
	public Contact getById(Long id) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		Contact result = null;
		try {
			HttpGet httpGet = new HttpGet(format(HUBSPOT_URL_GET_CONTACT_BY_ID, id, HUBSPOT_API_KEY));
			CloseableHttpResponse response = httpClient.execute(httpGet);

			if (response.getStatusLine().getStatusCode() == 200) {
				result = new Gson().fromJson(EntityUtils.toString(response.getEntity()), Contact.class);
			} else {
				LOG.error("Error getting contact by id " + id);
				LOG.error(response.toString());
			}
		} finally {
			httpClient.close();
		}
		return result;
	}

	@Override
	public void save(ContactEntity contactEntity) {
		this.contactRepository.save(contactEntity);
	}
	
}
