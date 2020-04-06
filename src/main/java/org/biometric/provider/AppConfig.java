package org.biometric.provider;

import java.io.File;
import java.lang.reflect.Constructor;
import java.security.NoSuchAlgorithmException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.mosip.kernel.core.bioapi.spi.IBioApi;



@Configuration
public class AppConfig {

//	@Bean("face")
//	public IBioApi faceApi()
//			throws NoSuchAlgorithmException, InstantiationException, IllegalAccessException, ClassNotFoundException {
//		IBioApi iBioApi = null;
//		try {
//			String dllPath = new File(new File(System.getProperty("user.dir")).getAbsolutePath()+"./files/sdkDependeny").getAbsolutePath();
//
//			Constructor<IBioApi> constructor =
//					(Constructor<IBioApi>) Class.forName("com.identy.IdentyBioSDK").getConstructor(new Class[]{String.class, String.class,String.class});
//			iBioApi = constructor.newInstance(dllPath+"\\dlls", new File(dllPath+"\\iris-extractor.lic").getAbsolutePath(), new File(dllPath+"\\iris-matcher.lic").getAbsolutePath());
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return iBioApi;
//	}

}
