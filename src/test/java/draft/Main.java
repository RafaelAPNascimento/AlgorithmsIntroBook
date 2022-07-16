package draft;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.util.Objects.isNull;

public class Main {

	// fazer
	// https://www.simplilearn.com/tutorials/java-tutorial/java-interview-questions
	public static void main(String args[]) throws JsonProcessingException {
		m1();
	}


	public static void m1() throws JsonProcessingException {

		String json = "{\"name\":\"rafael\", \"id\":8563, \"dateTime\":\"25/06/1984 16:25:51\"}";

		ObjectMapper mapper = new ObjectMapper();
		Dto dto = mapper.readValue(json, Dto.class);

		System.out.println(dto.toString());
	}

	static class Dto {
		private String name;
		private Long id;
		private LocalDateTime dateTime;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDateTime getDateTime() {
			return dateTime;
		}

		public void setDateTime(LocalDateTime dateTime) {
			this.dateTime = dateTime;
		}

		@Override
		public String toString() {
			return "Dto{" +
					"name='" + name + '\'' +
					", id=" + id +
					", dateTime=" + dateTime +
					'}';
		}
	}
}
