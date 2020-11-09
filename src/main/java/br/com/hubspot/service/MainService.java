package br.com.hubspot.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface MainService {
	void execute() throws ClientProtocolException, IOException;
}
