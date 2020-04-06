package org.biometric.provider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;

import io.mosip.kernel.core.bioapi.exception.BiometricException;
import io.mosip.kernel.core.bioapi.model.CompositeScore;
import io.mosip.kernel.core.bioapi.model.Score;
import io.mosip.kernel.core.bioapi.spi.IBioApi;
import io.mosip.kernel.core.cbeffutil.entity.BDBInfo;
import io.mosip.kernel.core.cbeffutil.entity.BIR;
import io.mosip.kernel.core.cbeffutil.entity.BIR.BIRBuilder;
import io.mosip.kernel.core.cbeffutil.jaxbclasses.SingleType;

public class IdentySDKTester {

	@Autowired
	@Qualifier("face")
	IBioApi ibioApi;

	@GetMapping("/testFingerSdk")
	public void testFingerPrint() throws IOException {
		BIR[] capturedBir = new BIR[1];
		String fingerString = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") +"\\files\\MockMDS\\finger1.txt")));
		byte[] bytes = Base64.getUrlDecoder().decode(fingerString);
		capturedBir[0] = new BIRBuilder().withBdb(bytes)
				.withBdbInfo(
						new BDBInfo.BDBInfoBuilder().withType(Collections.singletonList(SingleType.FINGER)).build())
				.build();
		try {
			CompositeScore compositeScore = ibioApi.compositeMatch(capturedBir, capturedBir, null);
			Score[] scores = compositeScore.getIndividualScores();
			for (Score score : scores) {
				System.out.println("Internal Score:  "+score.getInternalScore());
				System.out.println("Scaled Score: "+score.getScaleScore());
			}
		} catch (BiometricException exception) {

		}
	}

	
	@GetMapping("/testFingerFailSdk")
	public void testFingerPrintFailure() throws IOException {
		BIR[] capturedBir = new BIR[1];
		String fingerString = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") +"\\files\\MockMDS\\finger1.txt")));
		byte[] bytes = Base64.getUrlDecoder().decode(fingerString);
		
		BIR[] registeredBir = new BIR[1];
		String fingerString2 = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") +"\\files\\MockMDS\\finger2.txt")));
		byte[] bytes2 = Base64.getUrlDecoder().decode(fingerString2);

		capturedBir[0] = new BIRBuilder().withBdb(bytes)
				.withBdbInfo(
						new BDBInfo.BDBInfoBuilder().withType(Collections.singletonList(SingleType.FINGER)).build())
				.build();
		
		registeredBir[0] = new BIRBuilder().withBdb(bytes2)
				.withBdbInfo(
						new BDBInfo.BDBInfoBuilder().withType(Collections.singletonList(SingleType.FINGER)).build())
				.build();

		try {
			CompositeScore compositeScore = ibioApi.compositeMatch(capturedBir, registeredBir, null);
			Score[] scores = compositeScore.getIndividualScores();
			for (Score score : scores) {
				System.out.println("Internal Score:  "+score.getInternalScore());
				System.out.println("Scaled Score: "+score.getScaleScore());
			}
		} catch (BiometricException exception) {

		}
	}

	
	@GetMapping("/testFace")
	public void testFace() throws IOException {
		BIR[] capturedBir = new BIR[1];
		String fingerString = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") +"\\files\\MockMDS\\Face1.txt")));
		byte[] bytes = Base64.getUrlDecoder().decode(fingerString);
		capturedBir[0] = new BIRBuilder().withBdb(bytes)
				.withBdbInfo(
						new BDBInfo.BDBInfoBuilder().withType(Collections.singletonList(SingleType.FACE)).build())
				.build();
		try {
			CompositeScore compositeScore = ibioApi.compositeMatch(capturedBir, capturedBir, null);
			Score[] scores = compositeScore.getIndividualScores();
			for (Score score : scores) {
				System.out.println("Internal Score:  "+score.getInternalScore());
				System.out.println("Scaled Score: "+score.getScaleScore());
			}
		} catch (BiometricException exception) {

		}
	}
	
	@GetMapping("/testFaceFail")
	public void testFaceFail() throws IOException {
		BIR[] capturedBir = new BIR[1];
		String fingerString = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") +"\\files\\MockMDS\\Face1.txt")));
		byte[] bytes = Base64.getUrlDecoder().decode(fingerString);
		
		BIR[] registeredBir = new BIR[1];
		String fingerString2 = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") +"\\files\\MockMDS\\Face2.txt")));
		byte[] bytes2 = Base64.getUrlDecoder().decode(fingerString2);

		capturedBir[0] = new BIRBuilder().withBdb(bytes)
				.withBdbInfo(
						new BDBInfo.BDBInfoBuilder().withType(Collections.singletonList(SingleType.FACE)).build())
				.build();
		
		registeredBir[0] = new BIRBuilder().withBdb(bytes2)
				.withBdbInfo(
						new BDBInfo.BDBInfoBuilder().withType(Collections.singletonList(SingleType.FACE)).build())
				.build();

		try {
			CompositeScore compositeScore = ibioApi.compositeMatch(capturedBir, registeredBir, null);
			Score[] scores = compositeScore.getIndividualScores();
			for (Score score : scores) {
				System.out.println("Internal Score:  "+score.getInternalScore());
				System.out.println("Scaled Score: "+score.getScaleScore());
			}
		} catch (BiometricException exception) {

		}
	}
	
	@GetMapping("/testIris")
	public void testIris() throws IOException {
		BIR[] capturedBir = new BIR[1];
		String fingerString = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") +"\\files\\MockMDS\\iris1.txt")));
		byte[] bytes = Base64.getDecoder().decode(fingerString);
		capturedBir[0] = new BIRBuilder().withBdb(bytes)
				.withBdbInfo(
						new BDBInfo.BDBInfoBuilder().withType(Collections.singletonList(SingleType.IRIS)).build())
				.build();
		try {
			CompositeScore compositeScore = ibioApi.compositeMatch(capturedBir, capturedBir, null);
			Score[] scores = compositeScore.getIndividualScores();
			for (Score score : scores) {
				System.out.println("Internal Score:  "+score.getInternalScore());
				System.out.println("Scaled Score: "+score.getScaleScore());
			}
		} catch (BiometricException exception) {

		}
	}

}
