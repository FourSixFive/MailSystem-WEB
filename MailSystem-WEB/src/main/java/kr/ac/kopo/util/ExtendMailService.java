package kr.ac.kopo.util;

import kr.ac.kopo.service.MailService;
import kr.ac.kopo.service.MailService2;
import kr.ac.kopo.service.MailServiceFactory;
import kr.ac.kopo.service.MailServiceFactory2;

public class ExtendMailService {

	protected MailService service;
	protected MailService2 service2;
	
	public ExtendMailService() {
		service = MailServiceFactory.getInstance();
		service2 = MailServiceFactory2.getInstance();
	}
	
	
}
