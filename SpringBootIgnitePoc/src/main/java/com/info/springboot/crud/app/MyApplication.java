package com.info.springboot.crud.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.info")
public class MyApplication implements CommandLineRunner {

	

	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	public void run(String... arg0) throws Exception {
		if (arg0.length > 0 && arg0[0].equals("exitcode")) {
			throw new ExitException();
		}
		
	}

	public static void main(String[] args) throws Exception {
	  
    try {         
      new SpringApplication(MyApplication.class).run(args);
    }catch(Throwable e){
      System.exit(-1);
    }
	}


	class ExitException extends RuntimeException implements ExitCodeGenerator {
		/* (non-Javadoc)
		 * @see org.springframework.boot.ExitCodeGenerator#getExitCode()
		 */
		public int getExitCode() {
			// TODO Auto-generated method stub
			return 10;
		}

		private static final long serialVersionUID = 1L;

	}

}
