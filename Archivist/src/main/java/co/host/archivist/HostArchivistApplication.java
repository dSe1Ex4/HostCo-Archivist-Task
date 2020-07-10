package co.host.archivist;

import co.host.archivist.soap.UserClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.hostco.reguser.types.GetUserResponse;

@SpringBootApplication
public class HostArchivistApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HostArchivistApplication.class, args);

		UserClient userClient = context.getBean(UserClient.class);

		GetUserResponse response = userClient.getUserBySnils("28752377117");
		System.out.println(response.getLogin().getMiddlename());
	}

}
