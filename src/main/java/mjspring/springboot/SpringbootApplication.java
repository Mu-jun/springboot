package mjspring.springboot;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionEvaluationReport;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringbootApplication {
	private final JdbcTemplate jdbcTemplate;

	public SpringbootApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@PostConstruct
	void init() {
		jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	// 자동 구성 확인
	@Bean
	ApplicationRunner run(ConditionEvaluationReport report) {
		return args -> {
			System.out.println(report.getConditionAndOutcomesBySource().entrySet().stream()
					.filter(co -> co.getValue().isFullMatch())	// 성공한 것만
					.filter(co -> co.getKey().indexOf("Jmx") < 0) // Jmx빼고 검색
					.map(co->{
						System.out.println(co.getKey());
						co.getValue().forEach(c -> {
							System.out.println("\t" + c.getOutcome()); // 어떤 조건을 통과했는가를 알 수 있음.
						});
						System.out.println();
						return co;
					}).count());
		};
	}
}
