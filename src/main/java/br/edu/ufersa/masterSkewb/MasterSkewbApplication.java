package br.edu.ufersa.masterSkewb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MasterSkewbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterSkewbApplication.class, args);}

	@Component
	public static class Runner implements ApplicationRunner {
		@Value("${var1: valor default na classe MasterSkewbApplication}")
		String teste;
		public void run(ApplicationArguments args) throws Exception{
			System.out.println("Rodou corretamente! com " +teste);
		}
	}
}

