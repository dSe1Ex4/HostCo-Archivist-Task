package co.host.archivist;

import co.host.archivist.soap.UserClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import ru.hostco.reguser.types.GetUserResponse;

@EnableFeignClients
@SpringBootApplication
public class HostArchivistApplication {
	public static void main(String[] args) {
		SpringApplication.run(HostArchivistApplication.class, args);
	}
}
