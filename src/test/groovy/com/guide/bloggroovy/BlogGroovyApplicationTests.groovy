package com.guide.bloggroovy

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.RequiredArgsConstructor
import lombok.Setter
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BlogGroovyApplicationTests {

	@Test
	void contextLoads() {
		Mem mem = new Mem("A", "b")
		println mem.getName()
	}

	@Setter @Getter
	class Mem {
		private String name
		private String date

		String getName() {
			return name
		}

		void setName(String name) {
			this.name = name
		}

		String getDate() {
			return date
		}

		void setDate(String date) {
			this.date = date
		}

		Mem(String name, String date) {
			this.name = name
			this.date = date
		}
	}
}
