package com.learn.messenger.model;

import lombok.*;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "messages")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Size(min=2,message = "message should be atleast 5 characters long")
	@Column(name = "message")
	private String message;
	@Past(message = "Message Cannot be in the Future/Past")
	@Column(name = "create_dt")
	private Date created;
	@Column(name = "author")
	private String author;
}
